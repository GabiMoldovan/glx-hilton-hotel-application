package org.example.menu;

public class ReservationMenu implements Menu {
    @Override
    public void printMenu() {
        System.out.println("===== Reservation Menu =====\n");
        System.out.println("0. Select the Hotel");
        System.out.println("1. Create Reservation");
        System.out.println("2. Print Reservation");
        System.out.println("3. Update Reservation");
        System.out.println("4. Delete Reservation");
        System.out.println("5. Print All Reservations");
        System.out.println("6. Exit to Main Menu\n");
    }
}
