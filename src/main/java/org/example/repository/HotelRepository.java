package org.example.repository;

import org.example.database.PostgreSQLDatabase;
import org.example.entity.Hotel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelRepository {
    private final PostgreSQLDatabase database = PostgreSQLDatabase.getInstance();

    public void addHotel(Hotel hotel) throws SQLException {
        String sql = "INSERT INTO hotel (name, location) VALUES (?, ?)";
        try (Connection conn = database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, hotel.getName());
            stmt.setString(2, hotel.getLocation());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    hotel.setHotel_id(rs.getInt(1));
                }
            }
        }
    }

    public Hotel getHotelById(int id) throws SQLException {
        String sql = "SELECT * FROM hotel WHERE hotel_id = ?";
        try (Connection conn = database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToHotel(rs);
                }
            }
        }
        return null;
    }

    public List<Hotel> getAllHotels() throws SQLException {
        List<Hotel> hotels = new ArrayList<>();
        String sql = "SELECT * FROM hotel";
        try (Connection conn = database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                hotels.add(mapResultSetToHotel(rs));
            }
        }
        return hotels;
    }

    public boolean updateHotel(Hotel hotel) throws SQLException {
        String sql = "UPDATE hotel SET name = ?, location = ? WHERE hotel_id = ?";
        try (Connection conn = database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, hotel.getName());
            stmt.setString(2, hotel.getLocation());
            stmt.setInt(3, hotel.getHotel_id());

            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deleteHotel(int id) throws SQLException {
        String sql = "DELETE FROM hotel WHERE hotel_id = ?";
        try (Connection conn = database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }

    private Hotel mapResultSetToHotel(ResultSet rs) throws SQLException {
        Hotel hotel = new Hotel();
        hotel.setHotel_id(rs.getInt("hotel_id"));
        hotel.setName(rs.getString("name"));
        hotel.setLocation(rs.getString("location"));
        return hotel;
    }
}
