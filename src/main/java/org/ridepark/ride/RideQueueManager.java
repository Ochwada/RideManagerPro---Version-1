package org.ridepark.ride;


import org.ridepark.exception.EmptyQueueException;

import java.util.*;

/**
 * *******************************************************
 * Package: org.ridepark.ride
 * File: RideQueueManager.java
 * Author: Ochwada
 * Date: Monday, 05.May.2025, 2:31 PM
 * Description:
 * Objective:  Manages a queue of guests waiting for a ride using FIFO (First-In-First-Out) ordering.
 * Provides methods to add guests to the queue and manage ride operations.
 * *******************************************************
 */

public class RideQueueManager {
    /**
     * The queue that holds guests in the order they arrive.
     */
    private final Queue<Guest> guestQueue;


    /**
     * Constructs a new {@code RideQueueManager} with an empty guest queue.
     */
    public RideQueueManager() {
        this.guestQueue = new LinkedList<>();
    }


    /**
     * Adds a guest to the end of the queue.
     *
     * @param guest the {@code Guest} object to be added to the ride queue
     */
    public void addGuest(Guest guest) {
        this.guestQueue.offer(guest);
    }

    /**
     * Starts a ride by removing up to {@code rideCapacity} guests from the queue.
     * <p>
     * Guests are removed in FIFO order. If the queue is empty when this method is called,
     * an {@code EmptyQueueException} is thrown to signal that no ride can start.
     *
     * @param rideCapacity the maximum number of guests allowed on the ride
     * @return a list of guests who were removed from the queue for the ride
     * @throws EmptyQueueException if the queue is empty when the ride starts
     */
    public List<Guest> startRide(int rideCapacity) throws EmptyQueueException {
        if (guestQueue.isEmpty()) {
            throw new EmptyQueueException("Cannot start ride: guest queue is empty.");
        }

        List<Guest> ridingGuests = new ArrayList<>();

        while (ridingGuests.size() < rideCapacity && !guestQueue.isEmpty()) {
            Guest guest = guestQueue.poll();

            System.out.println("Guest boarded: " + guest.getName() + " (ID: " + guest.getId() + ")");
            ridingGuests.add(guest);
        }

        return ridingGuests;
    }


    /**
     * Returns the number of guests currently waiting in the queue.
     *
     * @return the size of the guest queue
     */
    public int getQueueSize() {
        return guestQueue.size();
    }

    /**
     * OPTIONAL METHOD
     * Removes all guests from the guest queue.
     * <p>
     * This method clears the current waiting list of guests.
     * It is typically used for resetting the ride queue, such as during testing or ride shutdown.
     */
    public void clearGuestQueue() {
        guestQueue.clear();
    }



}
