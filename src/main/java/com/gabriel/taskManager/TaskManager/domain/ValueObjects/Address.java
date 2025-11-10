package com.gabriel.taskManager.TaskManager.domain.ValueObjects;

public record Address(String street, String complementaryAddress, String floor) {
    private static final int STREET_MIN_LENGTH = 5;
    private static final int STREET_MAX_LENGTH = 100;
    private static final int COMPLEMENTARY_MAX_LENGTH = 100;
    private static final int FLOOR_MAX_LENGTH = 20;

    public Address(String street, String complementaryAddress, String floor) {
        // Rule: The street is a mandatory field.
        if (street == null || street.trim().isEmpty()) {
            throw new IllegalArgumentException("Street cannot be null or empty.");
        }
        if (street.length() < STREET_MIN_LENGTH) {
            throw new IllegalArgumentException("Street must be at least " + STREET_MIN_LENGTH + " characters long.");
        }
        if (street.length() > STREET_MAX_LENGTH) {
            throw new IllegalArgumentException("Street must be at most " + STREET_MAX_LENGTH + " characters long.");
        }

        // Rule: Optional fields should not exceed their max length if provided.
        if (complementaryAddress != null && complementaryAddress.length() > COMPLEMENTARY_MAX_LENGTH) {
            throw new IllegalArgumentException("Complementary address must be at most " + COMPLEMENTARY_MAX_LENGTH + " characters long.");
        }

        if (floor != null && floor.length() > FLOOR_MAX_LENGTH) {
            throw new IllegalArgumentException("Floor must be at most " + FLOOR_MAX_LENGTH + " characters long.");
        }
        this.street = street;
        this.complementaryAddress = complementaryAddress;
        this.floor = floor;
    }
}
