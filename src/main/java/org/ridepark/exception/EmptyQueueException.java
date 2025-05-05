package org.ridepark.exception;


/**
 * *******************************************************
 * Package: org.ridepark.exception
 * File: EmptyQueueException.java
 * Author: Ochwada
 * Date: Monday, 05.May.2025, 2:42 PM
 * Description: Thrown to indicate that an operation requiring a non-empty queue or stack was attempted on an empty structure.
 * Objective:
 * *******************************************************
 */

public class EmptyQueueException extends RuntimeException {
    /**
     * Constructs an EmptyQueueException with a custom message.
     *
     * @param message the detail message explaining the exception
     */

    public EmptyQueueException(String message) {
        super(message);
    }
}
