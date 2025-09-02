package org.example.repository;

import org.example.database.PostgreSQLDatabase;
import org.example.entity.Guest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuestRepository {
    private final PostgreSQLDatabase database = PostgreSQLDatabase.getInstance();

    public void addGuest(Guest guest) throws SQLException {
        String insertCommand = "INSERT INTO guest (email, name, phone, hotel_id) VALUES (?, ?, ?, ?)";

        try(Connection conn = database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(insertCommand, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, guest.getEmail());
            stmt.setString(2, guest.getName());
            stmt.setString(3, guest.getPhone());
            stmt.setInt(4, guest.getHotel_id());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    guest.setGuest_id(rs.getInt(1));
                }
            }
        }
    }

    public Guest getGuestById(int id) throws SQLException {
        String sql = "SELECT * FROM guest WHERE guest_id = ?";
        try (Connection conn = database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToGuest(rs);
                }
            }
        }
        return null;
    }

    public List<Guest> getAllGuests() throws SQLException {
        List<Guest> guests = new ArrayList<>();
        String sql = "SELECT * FROM guest";
        try (Connection conn = database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                guests.add(mapResultSetToGuest(rs));
            }
        }
        return guests;
    }

    public boolean updateGuest(Guest guest) throws SQLException {
        String sql = "UPDATE guest SET email = ?, name = ?, phone = ?, hotel_id = ? WHERE guest_id = ?";
        try (Connection conn = database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, guest.getEmail());
            stmt.setString(2, guest.getName());
            stmt.setString(3, guest.getPhone());
            stmt.setInt(4, guest.getHotel_id());
            stmt.setInt(5, guest.getGuest_id());

            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deleteGuest(int id) throws SQLException {
        String sql = "DELETE FROM guest WHERE guest_id = ?";
        try (Connection conn = database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }

    private Guest mapResultSetToGuest(ResultSet rs) throws SQLException {
        return new Guest(
                rs.getInt("guest_id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("phone"),
                rs.getInt("hotel_id")
        );
    }

}
