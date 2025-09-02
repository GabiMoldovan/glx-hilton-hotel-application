package org.example.menu;

public class MainMenu implements Menu {
    @Override
    public void printMenu() {
        System.out.println("===== Main Menu =====\n");
        System.out.println("1. View Hotel Menu");
        System.out.println("2. View Guest Menu");
        System.out.println("3. View Reservation Menu");
        System.out.println("4. View Room Menu");
        System.out.println("5. End Application\n");
    }
}
