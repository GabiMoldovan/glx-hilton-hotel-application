package org.example.entity;

public class Guest {
    private Integer guest_id;
    private String name;
    private String email;
    private String phone;
    private Integer hotel_id;

    public Guest(Integer guest_id, String name, String email, String phone, Integer hotel_id) {
        this.guest_id = guest_id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.hotel_id = hotel_id;
    }

    public Guest() {}

    public Integer getGuest_id() {
        return guest_id;
    }

    public void setGuest_id(Integer guest_id) {
        this.guest_id = guest_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Integer hotel_id) {
        this.hotel_id = hotel_id;
    }
}
