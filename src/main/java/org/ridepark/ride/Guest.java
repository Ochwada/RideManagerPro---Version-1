package org.ridepark.ride;


import java.util.Objects;

/**
 * *******************************************************
 * Package: org.ridepark.ride
 * File: Guest.java
 * Author: Ochwada
 * Date: Monday, 05.May.2025, 2:18 PM
 * Description: The {@code Guest} class represents a guest with a unique ID and name.
 *               It provides methods to access guest information, and overrides
 *               {@code toString()}, {@code equals()}, and {@code hashCode()} for proper object comparison.
 * Objective:
 * *******************************************************
 */

public class Guest {

    private final int id; // The unique identifier for the guest.
    private final String name; // The name of the guest.


    /**
     * Constructs a new {@code Guest} with the specified ID and name.
     *
     * @param id   the unique identifier of the guest
     * @param name the name of the guest
     */
    public Guest(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Returns the unique ID of the guest.
     *
     * @return the guest's ID
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the name of the guest.
     *
     * @return the guest's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a string representation of the guest.
     *
     * @return a string containing the guest's ID and name
     */
    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * Indicates whether this guest is equal to another object.
     * Two guests are considered equal if they have the same ID and name.
     *
     * @param obj the object to compare with
     * @return {@code true} if the objects are equal, {@code false} otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        Guest guest = (Guest) obj;
        return getId() == guest.getId() && Objects.equals(getName(), guest.getName());
    }


    /**
     * Returns a hash code value for the guest, based on ID and name.
     *
     * @return a hash code value for this guest
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
