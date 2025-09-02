package org.example.menu.administratorMenues;

import org.example.menu.MenuInterface;

public class AdminReservationMenu implements MenuInterface {
    @Override
    public void printMenu() {
        System.out.println("===== Admin Reservation Menu =====\n");
        System.out.println("1. Create a Reservation for a user");
        System.out.println("2. Delete a Reservation from a user");
        System.out.println("3. Update a Reservation for a user");
        System.out.println("4. View all Reservations in a hotel");
        System.out.println("5. View the details for a Reservation in a hotel");
        System.out.println("6. Exit menu\n");
    }
}
