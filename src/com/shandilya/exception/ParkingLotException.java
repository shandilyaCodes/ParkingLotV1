package com.shandilya.exception;

public class ParkingLotException extends RuntimeException {

    public ParkingLotException() {}

    public ParkingLotException(String s) {
        super(s);
    }
}