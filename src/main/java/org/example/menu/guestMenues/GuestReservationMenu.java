package org.example.menu.guestMenues;

import org.example.menu.MenuInterface;

public class GuestReservationMenu implements MenuInterface {
    @Override
    public void printMenu() {
        System.out.println("===== Reservation Menu =====\n");
        System.out.println("1. Create a Reservation");
        System.out.println("2. View your Reservations");
        System.out.println("3. Delete a Reservation\n");
    }
}
