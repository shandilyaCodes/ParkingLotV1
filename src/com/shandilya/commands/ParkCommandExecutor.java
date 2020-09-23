package com.shandilya.commands;

import com.shandilya.exception.NoFreeSlotAvailableException;
import com.shandilya.model.Car;
import com.shandilya.model.Command;
import com.shandilya.service.ParkingLotService;
import com.shandilya.utils.IntegerValidator;
import com.shandilya.utils.OutputPrinter;

public class ParkCommandExecutor extends CommandExecutor {

    public static final String COMMAND_NAME = "park";

    public ParkCommandExecutor(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().size() == 2;
    }

    @Override
    public void execute(Command command) {
        final Car car = new Car(command.getParams().get(0), command.getParams().get(1));
        try {
            final Integer slot = parkingLotService.park(car);
            outputPrinter.printWithNewLine("Allocated slot number : " + slot);
        } catch (NoFreeSlotAvailableException exception) {
            outputPrinter.parkingLotFull();
        }
    }
}
