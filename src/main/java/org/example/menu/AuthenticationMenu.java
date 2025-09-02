package org.example.menu;

public class AuthenticationMenu implements MenuInterface {
    @Override
    public void printMenu() {
        System.out.println("===== Authentication Menu =====\n");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit\n");
    }
}
