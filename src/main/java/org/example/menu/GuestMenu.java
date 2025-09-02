package org.example.menu;

public class GuestMenu implements Menu {
    @Override
    public void printMenu() {
        System.out.println("===== Guest Menu =====\n");
        System.out.println("0. Select the Hotel");
        System.out.println("1. Create Guest");
        System.out.println("2. Print Guest");
        System.out.println("3. Update Guest");
        System.out.println("4. Delete Guest");
        System.out.println("5. Print All Guests");
        System.out.println("6. Exit to Main Menu\n");
    }
}
