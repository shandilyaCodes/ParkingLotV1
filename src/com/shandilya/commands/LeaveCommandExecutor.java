package com.shandilya.commands;

import com.shandilya.model.Command;
import com.shandilya.service.ParkingLotService;
import com.shandilya.utils.IntegerValidator;
import com.shandilya.utils.OutputPrinter;

import java.util.List;

public class LeaveCommandExecutor extends CommandExecutor {

    public static final String COMMAND_NAME = "leave";

    public LeaveCommandExecutor(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
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
        final int slotNumber = Integer.parseInt(command.getParams().get(0));
        parkingLotService.makeSlotFree(slotNumber);
        outputPrinter.printWithNewLine("Slot Number " + slotNumber + " is free now");
    }
}
