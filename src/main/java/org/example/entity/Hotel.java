package org.example.entity;

import java.util.List;

public class Hotel {
    private Integer hotel_id;
    private String name;
    private String location;
    private List<Room> rooms;
    private List<Guest> guests;
    private List<Reservation> reservations;
}
