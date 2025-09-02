package org.example.menu.administratorMenues;

import org.example.menu.MenuInterface;

public class AdminRoomMenu implements MenuInterface {
    @Override
    public void printMenu() {
        System.out.println("===== Admin Room Menu =====\n");
        System.out.println("1. Create a Room for a hotel");
        System.out.println("2. Delete a Room from a hotel");
        System.out.println("3. Update a Room for a hotel");
        System.out.println("4. View all Rooms in a hotel");
        System.out.println("5. View the details for a Room in a hotel");
        System.out.println("6. Exit menu\n");
    }
}
