package com.shandilya.utils;

public class OutputPrinter {

    public void welcome() {
        printWithNewLine("Welcome to My Parking");
    }

    public void end() {
        printWithNewLine("Thank you for using My Parking Service");
    }

    public void notFound() {
        printWithNewLine("Not Found!");
    }

    public void statusHeader() {
        printWithNewLine("Slot No    Registration No    Color");
    }

    public void parkingLotFull() {
        printWithNewLine("Sorry, the parking lot is full");
    }

    public void parkingLotEmpty() {
        printWithNewLine("Parking Lot is empty!");
    }

    public void invalidFile() {
        printWithNewLine("Invalid File supplied");
    }

    public void printWithNewLine(final String message) {
        System.out.println(message);
    }
}
