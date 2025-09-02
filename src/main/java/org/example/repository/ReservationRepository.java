package org.example.repository;

import org.example.database.PostgreSQLDatabase;
import org.example.entity.Reservation;
import org.example.entity.enums.ReservationStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationRepository {
    private final PostgreSQLDatabase database = PostgreSQLDatabase.getInstance();

    public void addReservation(Reservation reservation) throws SQLException {
        String sql = "INSERT INTO reservation (guest_id, room_id, hotel_id, check_in_date, check_out_date, status) " +
                "VALUES (?, (SELECT room_id FROM rooms WHERE room_number = ? AND hotel_id = ?), ?, ?, ?, ?::reservation_status)";
        try (Connection conn = database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, reservation.getGuest_id());
            stmt.setString(2, reservation.getRoom_number());
            stmt.setInt(3, reservation.getHotel_id());
            stmt.setInt(4, reservation.getHotel_id());
            stmt.setDate(5, Date.valueOf(reservation.getCheckInDate()));
            stmt.setDate(6, Date.valueOf(reservation.getCheckOutDate()));
            stmt.setString(7, reservation.getReservation_status().name());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    reservation.setReservation_id(rs.getInt(1));
                }
            }
        }
    }

    public Reservation getReservationById(int id) throws SQLException {
        String sql = "SELECT r.reservation_id, r.guest_id, rm.room_number, r.status, r.check_in_date, r.check_out_date, r.hotel_id " +
                "FROM reservation r " +
                "JOIN rooms rm ON r.room_id = rm.room_id " +
                "WHERE r.reservation_id = ?";
        try (Connection conn = database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToReservation(rs);
                }
            }
        }
        return null;
    }

    public List<Reservation> getAllReservations() throws SQLException {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT r.reservation_id, r.guest_id, rm.room_number, r.status, r.check_in_date, r.check_out_date, r.hotel_id " +
                "FROM reservation r " +
                "JOIN rooms rm ON r.room_id = rm.room_id";
        try (Connection conn = database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                reservations.add(mapResultSetToReservation(rs));
            }
        }
        return reservations;
    }

    public boolean updateReservation(Reservation reservation) throws SQLException {
        String sql = "UPDATE reservation SET guest_id = ?, room_id = (SELECT room_id FROM rooms WHERE room_number = ? AND hotel_id = ?), " +
                "hotel_id = ?, check_in_date = ?, check_out_date = ?, status = ?::reservation_status WHERE reservation_id = ?";
        try (Connection conn = database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, reservation.getGuest_id());
            stmt.setString(2, reservation.getRoom_number());
            stmt.setInt(3, reservation.getHotel_id());
            stmt.setInt(4, reservation.getHotel_id());
            stmt.setDate(5, Date.valueOf(reservation.getCheckInDate()));
            stmt.setDate(6, Date.valueOf(reservation.getCheckOutDate()));
            stmt.setString(7, reservation.getReservation_status().name());
            stmt.setInt(8, reservation.getReservation_id());

            return stmt.executeUpdate() > 0;
        }
    }

    public boolean deleteReservation(int id) throws SQLException {
        String sql = "DELETE FROM reservation WHERE reservation_id = ?";
        try (Connection conn = database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }

    private Reservation mapResultSetToReservation(ResultSet rs) throws SQLException {
        Reservation reservation = new Reservation();
        reservation.setReservation_id(rs.getInt("reservation_id"));
        reservation.setGuest_id(rs.getInt("guest_id"));
        reservation.setRoom_number(rs.getString("room_number"));
        reservation.setReservation_status(ReservationStatus.valueOf(rs.getString("status")));
        reservation.setCheckInDate(rs.getDate("check_in_date").toLocalDate());
        reservation.setCheckOutDate(rs.getDate("check_out_date").toLocalDate());
        reservation.setHotel_id(rs.getInt("hotel_id"));
        return reservation;
    }
}
