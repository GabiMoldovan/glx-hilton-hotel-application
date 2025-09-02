package org.example.menu;

public class RoomMenu implements Menu {
    public void printMenu() {
        System.out.println("===== Room Menu =====\n");
        System.out.println("0. Select the Hotel");
        System.out.println("1. Create Room");
        System.out.println("2. Print Room");
        System.out.println("3. Update Room");
        System.out.println("4. Delete Room");
        System.out.println("5. Print All Rooms");
        System.out.println("6. Exit to Main Menu\n");
    }
}
