package com.shandilya.model.parking;

public interface ParkingStrategy {
    Integer getNextSlot();
    void addSlot(Integer slotNumber);
    void removeSlot(Integer slotNumber);
}