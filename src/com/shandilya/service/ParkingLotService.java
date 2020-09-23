package com.shandilya.service;

import com.shandilya.exception.ParkingLotException;
import com.shandilya.model.Car;
import com.shandilya.model.ParkingLot;
import com.shandilya.model.Slot;
import com.shandilya.model.parking.ParkingStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParkingLotService {

    private ParkingLot parkingLot;
    private ParkingStrategy parkingStrategy;

    public void createParkingLot(ParkingLot parkingLot, ParkingStrategy parkingStrategy) {
        if (this.parkingLot != null) {
            throw new ParkingLotException("Parking Lot Already Exists!");
        }
        this.parkingLot = parkingLot;
        this.parkingStrategy = parkingStrategy;
        for (int i = 1 ; i <= parkingLot.getCapacity() ; i++) {
            parkingStrategy.addSlot(i);
        }
    }

    public Integer park(Car car) {
        validateParkingLotExists();
        Integer nextFreeSlot = parkingStrategy.getNextSlot();
        parkingLot.park(car, nextFreeSlot);
        parkingStrategy.removeSlot(nextFreeSlot);
        return nextFreeSlot;
    }

    public void makeSlotFree(Integer slotNumber) {
        validateParkingLotExists();
        parkingLot.freeSlot(slotNumber);
        parkingStrategy.addSlot(slotNumber);
    }

    public List<Slot> getOccupiedSlots() {
        validateParkingLotExists();
        List<Slot> occupiedSlotsList = new ArrayList<>();
        Map<Integer, Slot> allSlots = parkingLot.getSlots();

        for (int i = 0 ; i <= parkingLot.getCapacity() ; i++) {
            if (allSlots.containsKey(i)) {
                Slot slot = allSlots.get(i);
                if (!slot.isSlotFree()) {
                    occupiedSlotsList.add(slot);
                }
            }
        }
        return occupiedSlotsList;
    }

    public List<Slot> getSlotsForColor(String color) {
        final List<Slot> occupiedSlots = getOccupiedSlots();
        return occupiedSlots.stream()
                .filter(slot -> slot.getParkedCar().getColor().equalsIgnoreCase(color))
                .collect(Collectors.toList());
    }

    private void validateParkingLotExists() {
        if (parkingLot == null) throw new ParkingLotException("Parking Lot Doesn't exist to Park!");
    }
}