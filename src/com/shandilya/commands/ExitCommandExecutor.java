package com.shandilya.commands;

import com.shandilya.model.Command;
import com.shandilya.service.ParkingLotService;
import com.shandilya.utils.OutputPrinter;

public class ExitCommandExecutor extends CommandExecutor {

    public static final String COMMAND_NAME = "exit";

    public ExitCommandExecutor(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().isEmpty();
    }

    @Override
    public void execute(Command command) {
        outputPrinter.end();
    }
}
