package com.skilldistillery.caesarcipher;

import java.util.Scanner;

public class CaesarCipherApp {

    public static void main(String[] args) {
        CaesarCipherApp app = new CaesarCipherApp();
        app.run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        CaesarCipher cipher = new CaesarCipher();

        System.out.println("Welcome to the Caesar Cipher Application!");

        boolean running = true;
        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Encrypt a message");
            System.out.println("2. Decrypt a message");
            System.out.println("3. Exit");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Encrypt a message
                    System.out.print("Enter the message to encrypt: ");
                    String messageToEncrypt = scanner.nextLine();
                    System.out.print("Enter the shift amount: ");
                    int shiftEncrypt = scanner.nextInt();
                    System.out.println("Encrypted Message: " + cipher.encrypt(messageToEncrypt, shiftEncrypt));
                    break;
                case 2:
                    // Decrypt a message
                    System.out.print("Enter the message to decrypt: ");
                    String messageToDecrypt = scanner.nextLine();
                    System.out.print("Enter the shift amount: ");
                    int shiftDecrypt = scanner.nextInt();
                    System.out.println("Decrypted Message: " + cipher.decrypt(messageToDecrypt, shiftDecrypt));
                    break;
                case 3:
                    // Exit the application
                    running = false;
                    System.out.println("Thank you for using the Caesar Cipher Application!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}
