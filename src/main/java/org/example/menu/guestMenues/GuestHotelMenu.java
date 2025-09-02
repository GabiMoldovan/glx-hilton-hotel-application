package org.example.menu.guestMenues;

import org.example.menu.MenuInterface;

public class GuestHotelMenu implements MenuInterface {
    @Override
    public void printMenu() {
        System.out.println("===== Hotel Menu =====\n");
        System.out.println("1. View all Hotels");
        System.out.println("2. View Hotel Details");
    }
}
