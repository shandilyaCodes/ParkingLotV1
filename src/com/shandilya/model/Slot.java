package com.shandilya.model;

public class Slot {

    private Car parkedCar;
    private Integer slotNumber;

    public Slot(Integer slotNumber) {
        this.slotNumber = slotNumber;
    }

    public Car getParkedCar() {
        return parkedCar;
    }

    public Integer getSlotNumber() {
        return slotNumber;
    }

    public boolean isSlotFree() {
        return parkedCar == null;
    }

    public void parkCar(Car car) {
        this.parkedCar = car;
    }

    public void removeCar() {
        this.parkedCar = null;
    }
}
