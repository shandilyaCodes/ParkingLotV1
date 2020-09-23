package com.shandilya.commands;

import com.shandilya.model.Command;
import com.shandilya.model.ParkingLot;
import com.shandilya.model.parking.NaturalOrderingParkingStrategy;
import com.shandilya.service.ParkingLotService;
import com.shandilya.utils.IntegerValidator;
import com.shandilya.utils.OutputPrinter;
import java.util.List;

public class CreateParkingLotCommandExecutor extends CommandExecutor {

    public static final String COMMAND_NAME = "create_parking_lot";

    public CreateParkingLotCommandExecutor(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    @Override
    public boolean validate(Command command) {
        final List<String> params = command.getParams();
        if (params.size() != 1) {
            return false;
        }
        return IntegerValidator.isInteger(params.get(0));
    }

    @Override
    public void execute(Command command) {
        final int parkingLotCapacity = Integer.parseInt(command.getParams().get(0));
        final ParkingLot parkingLot = new ParkingLot(parkingLotCapacity);
        parkingLotService.createParkingLot(parkingLot, new NaturalOrderingParkingStrategy());
        outputPrinter.printWithNewLine("Created a parking Lot with " + parkingLot.getCapacity() + " slots");
    }
}