package org.example.entity;

import org.example.entity.enums.RoomTypes;

public class Room {
    private String room_number;
    private RoomTypes type;
    private boolean is_available;
    private Integer hotel_id;

    public Room(String room_number, RoomTypes type, boolean is_available, Integer hotel_id) {
        this.room_number = room_number;
        this.type = type;
        this.is_available = is_available;
        this.hotel_id = hotel_id;
    }

    public Room() {}

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
    }

    public RoomTypes getType() {
        return type;
    }

    public void setType(RoomTypes type) {
        this.type = type;
    }

    public boolean isIs_available() {
        return is_available;
    }

    public void setIs_available(boolean is_available) {
        this.is_available = is_available;
    }

    public Integer getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Integer hotel_id) {
        this.hotel_id = hotel_id;
    }
}
