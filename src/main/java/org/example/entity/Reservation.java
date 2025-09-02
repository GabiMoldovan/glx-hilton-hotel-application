package org.example.entity;

import org.example.entity.enums.ReservationStatus;

import java.time.LocalDate;

public class Reservation {
    private Integer reservation_id;
    private Integer guest_id;
    private String room_number;
    private ReservationStatus reservation_status;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Integer hotel_id;

    public Reservation(Integer reservation_id, Integer guest_id, String room_number, ReservationStatus reservation_status, LocalDate checkInDate, LocalDate checkOutDate, Integer hotel_id) {
        this.reservation_id = reservation_id;
        this.guest_id = guest_id;
        this.room_number = room_number;
        this.reservation_status = reservation_status;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.hotel_id = hotel_id;
    }

    public Reservation() {}

    public Integer getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(Integer reservation_id) {
        this.reservation_id = reservation_id;
    }

    public Integer getGuest_id() {
        return guest_id;
    }

    public void setGuest_id(Integer guest_id) {
        this.guest_id = guest_id;
    }

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
    }

    public ReservationStatus getReservation_status() {
        return reservation_status;
    }

    public void setReservation_status(ReservationStatus reservation_status) {
        this.reservation_status = reservation_status;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Integer getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Integer hotel_id) {
        this.hotel_id = hotel_id;
    }
}
