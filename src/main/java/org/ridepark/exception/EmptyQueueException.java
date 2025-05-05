package org.ridepark.exception;


/**
 * *******************************************************
 * Package: org.ridepark.exception
 * File: EmptyQueueException.java
 * Author: Ochwada
 * Date: Monday, 05.May.2025, 2:42 PM
 * Description:
 * Objective:
 * *******************************************************
 */

public class EmptyQueueException extends RuntimeException {
    public EmptyQueueException(String message) {
        super(message);
    }
}
