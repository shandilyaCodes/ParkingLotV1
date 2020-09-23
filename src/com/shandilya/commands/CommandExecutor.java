package com.shandilya.commands;

import com.shandilya.model.Command;
import com.shandilya.service.ParkingLotService;
import com.shandilya.utils.OutputPrinter;

public abstract class CommandExecutor {

    protected ParkingLotService parkingLotService;
    protected OutputPrinter outputPrinter;

    public CommandExecutor(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        this.parkingLotService = parkingLotService;
        this.outputPrinter = outputPrinter;
    }

    public abstract boolean validate(Command command);
    public abstract void execute(Command command);
}