package org.example.menu.guestMenues;

import org.example.menu.MenuInterface;

public class GuestMenu implements MenuInterface {
    @Override
    public void printMenu() {
        System.out.println("===== Guest Menu =====\n");
        System.out.println("1. View Hotel Menu");
        System.out.println("2. View Reservation Menu");
        System.out.println("3. Exit Guest account\n");
    }
}
