package org.example;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ShoppingCart {
    public static void main(String[] args) {
        // Prompt user to select a language
        System.out.println("Select a language: ");
        System.out.println("1. English");
        System.out.println("2. Finnish");
        System.out.println("3. Japanese");
        System.out.println("4. Swedish");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        // Set the locale based on user's choice
        Locale locale;
        switch (choice) {
            case 1:
                locale = new Locale("en", "US");
                break;
            case 2:
                locale = new Locale("fi", "FI");
                break;
            case 3:
                locale = new Locale("ja", "JP");
                break;
            case 4:
                locale = new Locale("sv", "SE");
                break;
            default:
                System.out.println("Invalid choice. Defaulting to English.");
                locale = new Locale("en", "US");
                break;
        }

        // Load the resource bundle for the selected locale
        ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);

        System.out.print(messages.getString("numberOfItems"));
        int numItems = scanner.nextInt();

        double totalCartCost = 0;

        for (int i = 0; i < numItems; i++) {
            System.out.println("\nItem " + (i + 1) + ":");

            System.out.print(messages.getString("price"));
            double price = scanner.nextDouble();

            System.out.print(messages.getString("quantity"));
            int quantity = scanner.nextInt();

            double itemTotal = price * quantity;
            totalCartCost += itemTotal;
        }

        // Display the localized greeting message
        System.out.println(messages.getString("total") + totalCartCost);

        scanner.close();
    }


}
