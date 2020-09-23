package com.shandilya.model.parking;

import com.shandilya.exception.NoFreeSlotAvailableException;
import java.util.TreeSet;

public class NaturalOrderingParkingStrategy implements ParkingStrategy {

    TreeSet<Integer> slotTreeSet;

    public NaturalOrderingParkingStrategy() {
        this.slotTreeSet = new TreeSet<>();
    }

    @Override
    public Integer getNextSlot() {
        if (slotTreeSet.isEmpty()) {
            throw new NoFreeSlotAvailableException();
        }
        return slotTreeSet.first();
    }

    @Override
    public void addSlot(Integer slotNumber) {
        slotTreeSet.add(slotNumber);
    }

    @Override
    public void removeSlot(Integer slotNumber) {
        slotTreeSet.remove(slotNumber);
    }
}
