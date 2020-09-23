package com.shandilya.model;

import com.shandilya.exception.InvalidSlotException;
import com.shandilya.exception.ParkingLotException;
import com.shandilya.exception.SlotAlreadyOccupiedException;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private int capacity;
    private Map<Integer, Slot> slots;

    public int getCapacity() {
        return capacity;
    }

    public ParkingLot(int capacity) {
        int MAX_CAPACITY = 10000;
        if (capacity > MAX_CAPACITY || capacity <= 0) {
            throw new ParkingLotException("Invalid Capacity given for parking Lot!");
        }
        this.capacity = capacity;
        this.slots = new HashMap<>();
    }

    public Map<Integer, Slot> getSlots() {
        return slots;
    }

    private Slot getSlot(Integer slotNumber) {
        if (slotNumber > getCapacity() || slotNumber <= 0) {
            throw new InvalidSlotException();
        }
        Map<Integer, Slot> allSlots = getSlots();
        if (!allSlots.containsKey(slotNumber)) {
            allSlots.put(slotNumber, new Slot(slotNumber));
        }
        return allSlots.get(slotNumber);
    }

    public Slot park(Car car, Integer slotNumber) {
        Slot slot = getSlot(slotNumber);
        if (!slot.isSlotFree()) {
            throw new SlotAlreadyOccupiedException();
        }
        slot.parkCar(car);
        return slot;
    }

    public Slot freeSlot(Integer slotNumber) {
        Slot slot = getSlot(slotNumber);
        slot.removeCar();
        return slot;
    }
}
