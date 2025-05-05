package org.ridepark.ride;

import org.junit.jupiter.api.*;
import org.ridepark.exception.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
/**
 * *******************************************************
 * Package: org.ridepark.ride
 * File: RideHistoryStackTest.java
 * Author: Ochwada
 * Date: Monday, 05.May.2025, 4:29 PM
 * Description:
 * Objective:
 * *******************************************************
 */

public class RideHistoryStackTest {
    private RideHistoryStack rideHistoryStack;


    @BeforeAll // JUnit runs this once before any test method in this class.
    static void beforeAllTests() {
        System.out.println("\uD83E\uDDFF Stating Ride Queue Manager Tests...  ");
    }

    @BeforeEach
    void setUp() {
        System.out.println();
        System.out.println("\uD83D\uDD38 New Setup: create a new object.");
        rideHistoryStack = new RideHistoryStack();
    }

    @AfterEach
    void tearDown(TestInfo testInfo) {
        System.out.println("✔\uFE0FTest Passed: \uD83D\uDCC3 " + testInfo.getDisplayName());
    }

    @AfterAll
    static void afterAllTests() {
        System.out.println("✅ Ride Queue Manager ✨ Tests Successfully Done ✨");
    }
    // -----------------------------------------------------
    // TESTS
    // -----------------------------------------------------

    @Test
    @DisplayName("Save Ride and Get Ride History Stack")
    void testSaveRideAndGetRideHistoryStack() {
        Guest g1 = new Guest(1, "Alice");
        Guest g2 = new Guest(2, "Bob");
        List<Guest> guests = Arrays.asList(g1, g2);

        rideHistoryStack.saveRide(guests);
        Stack<Guest> history = rideHistoryStack.getRideHistoryStack();

        assertEquals(2, history.size());
        assertEquals(g2, history.peek()); // LIFO: Bob is on top
    }

    @Test
    @DisplayName("View Last Ride Returns Top Guest")
    void testViewLastRideReturnsTopGuest() {
        Guest g1 = new Guest(1, "Alice");
        Guest g2 = new Guest(2, "Charlie");
        rideHistoryStack.saveRide(Arrays.asList(g1, g2));

        Guest topGuest = rideHistoryStack.viewLastRide();
        assertEquals("Charlie", topGuest.getName());
        assertEquals(2, topGuest.getId());
    }

    @Test
    @DisplayName("Pop Last Guest Removes and Returns Top Guest")
    void testPopLastGuestRemovesAndReturnsTopGuest() {
        Guest g1 = new Guest(1, "Alice");
        Guest g2 = new Guest(2, "Bob");
        rideHistoryStack.saveRide(Arrays.asList(g1, g2));

        Guest popped = rideHistoryStack.popLastGuest();

        assertEquals("Bob", popped.getName());
        assertEquals(1, rideHistoryStack.getRideHistoryStack().size());
        assertEquals("Alice", rideHistoryStack.viewLastRide().getName());
    }

    @Test
    @DisplayName("View Last Ride Throws Exception on Empty Stack")
    void testViewLastRideThrowsExceptionOnEmptyStack() {
        EmptyQueueException ex = assertThrows(EmptyQueueException.class, () -> {
            rideHistoryStack.viewLastRide();
        });
        assertEquals("You are trying to view an empty stack.", ex.getMessage());
    }

    @Test
    @DisplayName("Last Guest Throws Exception On Empty Stack")
    void testPopLastGuestThrowsExceptionOnEmptyStack() {
        EmptyQueueException ex = assertThrows(EmptyQueueException.class, () -> {
            rideHistoryStack.popLastGuest();
        });
        assertEquals("You are trying to pop from an empty stack.", ex.getMessage());
    }

    @Test
    @DisplayName("Save Ride Throws Exception On Null Input")
    void testSaveRideThrowsExceptionOnNullInput() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            rideHistoryStack.saveRide(null);
        });
        assertEquals("Guest List can't be Null", ex.getMessage());
    }
}