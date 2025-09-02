package org.example.menu.administratorMenues;

import org.example.menu.MenuInterface;

public class AdminMenu implements MenuInterface {
    @Override
    public void printMenu() {
        System.out.println("===== Admin Menu =====\n");
        System.out.println("1. View Admin Hotel Menu");
        System.out.println("2. View Admin Reservation Menu");
        System.out.println("3. View Admin Room Menu\n");
        System.out.println("4. Exit Admin account\n");
    }
}
