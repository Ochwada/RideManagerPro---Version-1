package org.ridepark.main;


import org.ridepark.exception.*;
import org.ridepark.ride.*;

import java.util.*;

/**
 * *******************************************************
 * Package: org.ridepark.main
 * File: RideManagerApp.java
 * Author: Ochwada
 * Date: Monday, 05.May.2025, 4:25 PM
 * Description:
 * Objective:
 * *******************************************************
 */

public class RideManagerApp {
    /**
     * The main queue that stores incoming Guests in FIFO order.
     */
    private static final RideQueueManager queueManager = new RideQueueManager();

    /**
     * The stack that stores ride history  in LIFO order.
     */
    private static final RideHistoryStack rideHistory = new RideHistoryStack();

    /**
     * A simple counter used to assign unique IDs to new guests.
     */
    private static int guestIdCounter = 1;


    /**
     * Prints the available menu options to the console.
     * This is the CLI interface for interacting with the system.
     */
    private static void printMenu() {
        System.out.println("\n=== Ride Manager App  ===");
        System.out.println("1. Add Guest");
        System.out.println("2. Start Ride (FIFO)");
        System.out.println("3. View Last Rider (LIFO)");
        System.out.println("4. Remove Last Rider (LIFO)");
        System.out.println("5. Exit");
    }


    /**
     * Prompts the user to enter a new guest name and adds it to the queue.
     *
     * @param scanner a {@code Scanner} instance used to read user input
     */
    private static void addNewGuest(Scanner scanner) {
        System.out.println("Enter Guest's Name: ");

        String names = scanner.nextLine();
        Guest guest = new Guest(guestIdCounter++, names);
        queueManager.addGuest(guest);
        System.out.println("Guest added to queue: ID " + guest.getId() + " - " + guest.getName());
    }

    private static void startingRide(Scanner scanner) {
        System.out.print("Enter ride capacity: ");
        int capacity = Integer.parseInt(scanner.nextLine());

        try {
            List<Guest> ridingGuests = queueManager.startRide(capacity);
            System.out.println("Ride started with the following guests:");

            for (Guest guest : ridingGuests) {
                System.out.println(" - " + guest.getName() + " (ID: " + guest.getId() + ")");
            }
            rideHistory.saveRide(ridingGuests);  // Save to LIFO history

        } catch (EmptyQueueException e) {
            System.out.println("❗ " + e.getMessage());
        }
    }

    private static void viewingLastRider(){
        try {
            Guest last = rideHistory.viewLastRide();
            System.out.println("👀 Last rider (LIFO): " + last.getName() + " (ID: " + last.getId() + ")");
        } catch (EmptyQueueException e) {
            System.out.println("❗ " + e.getMessage());
        }
    }

    private static void removeLastRider(){
        try {
            Guest removed = rideHistory.popLastGuest();
            System.out.println("🗑️ Removed last rider (LIFO): " + removed.getName() + " (ID: " + removed.getId() + ")");
        } catch (EmptyQueueException e) {
            System.out.println("❗ " + e.getMessage());
        }
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("🎫 Welcome to RideManagerPro System");
        System.out.println("Demonstrating  FIFO (Queue) and LIFO (Stack)");

        while (!exit) {
            printMenu();

            System.out.print("Select an option: ");
            String input = scanner.nextLine();


            switch (input) {
                case "1" -> addNewGuest(scanner);
                case "2" -> startingRide(scanner);
                case "3" -> viewingLastRider();
                case "4" -> removeLastRider();
                case "5" -> {
                    exit = true;
                    System.out.println("👋 Exiting RideManagerPro. Goodbye!");
                }
                default -> System.out.println("❗ Invalid option, please try again.");
            }
        }


    }

}
