package org.example.menu.administratorMenues;

import org.example.menu.MenuInterface;

public class AdminHotelMenu implements MenuInterface {
    @Override
    public void printMenu() {
        System.out.println("===== Admin Hotel Menu =====\n");
        System.out.println("1. Add Hotel");
        System.out.println("2. Remove Hotel");
        System.out.println("3. Modify Hotel");
        System.out.println("4. View all Hotels");
        System.out.println("5. View Hotel Details");
        System.out.println("6. Exit menu\n");
    }
}
