package org.example.menu;

public class HotelMenu implements Menu {
    @Override
    public void printMenu() {
        System.out.println("===== Hotel Menu =====\n");
        System.out.println("1. Create Hotel");
        System.out.println("2. Print Hotel");
        System.out.println("3. Update Hotel");
        System.out.println("4. Delete Hotel");
        System.out.println("5. Print All Hotels");
        System.out.println("6. Exit to Main Menu\n");
    }
}
