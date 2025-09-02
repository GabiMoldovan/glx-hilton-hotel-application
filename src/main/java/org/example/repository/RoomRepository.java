package org.example.repository;

import org.example.database.PostgreSQLDatabase;
import org.example.entity.Room;
import org.example.entity.enums.RoomTypes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomRepository {
    private final PostgreSQLDatabase database = PostgreSQLDatabase.getInstance();

    public void addRoom(Room room) throws SQLException {
        String sql = "INSERT INTO rooms (room_number, type, available, hotel_id) VALUES (?, ?::room_type, ?, ?)";
        try (Connection conn = database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, Integer.parseInt(room.getRoom_number())); // conversie string -> int
            stmt.setString(2, room.getType().name());
            stmt.setBoolean(3, room.isIs_available());
            stmt.setInt(4, room.getHotel_id());

            stmt.executeUpdate();
        }
    }

    public Room getRoomByNumber(String roomNumber, int hotelId) throws SQLException {
        String sql = "SELECT * FROM rooms WHERE room_number = ? AND hotel_id = ?";
        try (Connection conn = database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, Integer.parseInt(roomNumber));
            stmt.setInt(2, hotelId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToRoom(rs);
                }
            }
        }
        return null;
    }

    public List<Room> getRoomsByHotel(int hotelId) throws SQLException {
        List<Room> rooms = new ArrayList<>();
        String sql = "SELECT * FROM rooms WHERE hotel_id = ?";
        try (Connection conn = database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, hotelId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    rooms.add(mapResultSetToRoom(rs));
                }
            }
        }
        return rooms;
    }

    public boolean updateRoom(Room room) throws SQLException {
        String sql = "UPDATE rooms SET type = ?::room_type, available = ? WHERE room_number = ? AND hotel_id = ?";
        try (Connection conn = database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, room.getType().name());
            stmt.setBoolean(2, room.isIs_available());
            stmt.setInt(3, Integer.parseInt(room.getRoom_number()));
            stmt.setInt(4, room.getHotel_id());

            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deleteRoom(String roomNumber, int hotelId) throws SQLException {
        String sql = "DELETE FROM rooms WHERE room_number = ? AND hotel_id = ?";
        try (Connection conn = database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, Integer.parseInt(roomNumber));
            stmt.setInt(2, hotelId);

            return stmt.executeUpdate() > 0;
        }
    }

    private Room mapResultSetToRoom(ResultSet rs) throws SQLException {
        Room room = new Room();
        room.setRoom_number(String.valueOf(rs.getInt("room_number")));
        room.setType(RoomTypes.valueOf(rs.getString("type")));
        room.setIs_available(rs.getBoolean("available"));
        room.setHotel_id(rs.getInt("hotel_id"));
        return room;
    }
}
