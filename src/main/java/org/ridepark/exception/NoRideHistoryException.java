package org.ridepark.exception;


/**
 * *******************************************************
 * Package: org.ridepark.exception
 * File: NoRideHistoryException.java
 * Author: Ochwada
 * Date: Monday, 05.May.2025, 4:05 PM
 * Description: Thrown to indicate that there is no ride history available when such data is expected.
 * Objective:
 * *******************************************************
 */

public class NoRideHistoryException extends RuntimeException {
    /**
     * Constructs a NoRideHistoryException with a custom message.
     *
     * @param message the detail message explaining the exception
     */
    public NoRideHistoryException(String message) {
        super(message);
    }
}
