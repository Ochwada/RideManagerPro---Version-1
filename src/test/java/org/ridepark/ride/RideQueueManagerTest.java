package org.ridepark.ride;

import org.junit.jupiter.api.*;
import org.ridepark.exception.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * *******************************************************
 * Package: org.ridepark.ride
 * File: RideQueueManagerTest.java
 * Author: Ochwada
 * Date: Monday, 05.May.2025, 2:54 PM
 * Description:
 * Objective:
 * *******************************************************
 */

public class RideQueueManagerTest {

    private RideQueueManager queueManager;

    @BeforeAll // JUnit runs this once before any test method in this class.
    static void beforeAllTests() {
        System.out.println("\uD83E\uDDFF Stating Ride Queue Manager Tests...  ");
    }

    @BeforeEach
    void setUp() {

        System.out.println("\uD83D\uDD38 New Setup: create a new object.");
        queueManager = new RideQueueManager();

        // Add some test guests
        queueManager.addGuest(new Guest(1, "Alice"));
        queueManager.addGuest(new Guest(2, "Phil"));
        queueManager.addGuest(new Guest(3, "Ben"));
    }

    @AfterEach
    void tearDown(TestInfo testInfo) {
        System.out.println("✔\uFE0FTest Passed: (Test Name) " + testInfo.getDisplayName());
    }

    @AfterAll
    static void afterAllTests() {
        System.out.println("✅ Ride Queue Manager ✨ Tests Successfully Done ✨");
    }
    // -----------------------------------------------------
    // TESTS
    // -----------------------------------------------------

    /**
     * Tests that the startRide method correctly dequeues the specified number of guests
     * when there are enough guests in the queue.
     * <p>
     * Expects two guests to be boarded and verifies their names.
     *
     * @throws EmptyQueueException if the guest queue is unexpectedly empty
     */
    @Test
    @DisplayName("Start Ride With Sufficient Guests")
    void testStartRideWithSufficientGuests() throws EmptyQueueException {
     List<Guest> riders = queueManager.startRide(2);

     assertEquals(2, riders.size());
     assertEquals("Alice", riders.get(0).getName());
     assertEquals("Phil", riders.get(1).getName());
    }

    /**
     * Tests that the startRide method returns only available guests
     * when the requested ride capacity exceeds the number of guests in the queue.
     * <p>
     * Ensures that the method gracefully handles this case without throwing an exception.
     *
     * @throws EmptyQueueException if the guest queue is unexpectedly empty
     */
    @Test
    @DisplayName("Start Ride With Fewer Guests Than Capacity")
    void testStartRideWithFewerGuestsThanCapacity() throws EmptyQueueException {
        queueManager.clearGuestQueue();
        queueManager.addGuest(new Guest(4, "Linda"));

        List<Guest> riders = queueManager.startRide(3);

        assertEquals(1, riders.size());
        assertEquals("Linda", riders.getFirst().getName());
    }


    /**
     * Tests that the startRide method throws an EmptyQueueException
     * when called on an empty guest queue.
     * <p>
     * This test verifies proper exception handling for an invalid operation.
     */
    @Test
    @DisplayName("Start Ride With Empty Queue Throws Exception")
    void testStartRideWithEmptyQueueThrowsException() {
        queueManager.clearGuestQueue(); // make queue empty

        assertThrows(EmptyQueueException.class, () -> {
            queueManager.startRide(1);
        });
    }

}
