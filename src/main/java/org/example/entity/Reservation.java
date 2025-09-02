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
}
