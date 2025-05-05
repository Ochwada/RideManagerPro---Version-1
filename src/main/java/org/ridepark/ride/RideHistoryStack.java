package org.ridepark.ride;


import org.ridepark.exception.EmptyQueueException;

import java.util.*;

/**
 * *******************************************************
 * Package: org.ridepark.ride
 * File: RideHistoryStack.java
 * Author: Ochwada
 * Date: Monday, 05.May.2025, 3:17 PM
 * Description: Manages the history of guests who have taken rides using a LIFO stack.
 * <p>
 * Guests from the most recent ride are pushed onto the stack so that they can be reviewed in reverse order later
 * (last boarded = top of stack).
 * Objective:
 * *******************************************************
 */

public class RideHistoryStack {
    private Stack<Guest> rideHistory;

    /**
     * Constructs an empty ride history stack.
     */
    public RideHistoryStack() {
        this.rideHistory = new Stack<>();
    }

    /**
     * Saves each guest from a ride individually onto the ride history stack.
     * <p>
     * This method pushes each {@link Guest} onto the stack in the order provided,
     * allowing for individual tracking of guests in LIFO (last-in-first-out) order.
     * It does not preserve ride groupings, meaning guests from the same ride are not stored as a batch.
     *
     * @param guests the list of guests who participated in the ride; must not be {@code null}
     * @throws IllegalArgumentException if the {@code guests} list is {@code null}
     */
    public void saveRide(List<Guest> guests) {
        if (guests == null) {
            throw new IllegalArgumentException("Guest List can't be Null");
        }

        for (Guest guest : guests) {
            rideHistory.push(guest);  // Individual push
        }
    }

    /**
     * Returns the most recent guest who boarded a ride, without removing them from the stack.
     *
     * @return the last guest added to the ride history
     * @throws EmptyQueueException if the history stack is empty
     */
    public Guest viewLastRide() throws EmptyQueueException {
        if (rideHistory.isEmpty()) {
            throw new EmptyQueueException("You are trying to view an empty stack.");
        }
        return rideHistory.peek();
    }


    /**
     * Removes and returns the most recent guest from the ride history.
     *
     * @return the last guest added to the ride history
     * @throws EmptyQueueException if the history stack is empty
     */
    public Guest popLastGuest() throws EmptyQueueException {
        if (rideHistory.isEmpty()) {
            throw new EmptyQueueException("You are trying to pop from an empty stack.");
        }
        return rideHistory.pop();
    }

    /**
     * Returns the entire stack of guests.
     * Useful for inspection or debugging purposes.
     *
     * @return the full ride history stack (LIFO order)
     */
    public Stack<Guest> getRideHistoryStack() {
        return this.rideHistory;
    }

}
