package com.shandilya;

import com.shandilya.commands.CommandExecutorFactory;
import com.shandilya.exception.InvalidModeException;
import com.shandilya.mode.FileMode;
import com.shandilya.mode.InteractiveMode;
import com.shandilya.service.ParkingLotService;
import com.shandilya.utils.OutputPrinter;

import java.io.IOException;

public class Runner {

    public static void main(String[] args) throws IOException {
        final OutputPrinter outputPrinter = new OutputPrinter();
        final ParkingLotService parkingLotService = new ParkingLotService();
        final CommandExecutorFactory commandExecutorFactory = new CommandExecutorFactory(parkingLotService);

        if (isInteractiveMode(args)) {
            new InteractiveMode(commandExecutorFactory, outputPrinter).process();
        } else if (isFileInputMode(args)) {
            new FileMode(commandExecutorFactory, outputPrinter, args[0]).process();
        } else {
            throw new InvalidModeException();
        }
    }

    private static boolean isFileInputMode(final String[] args) {
        return args.length == 1;
    }

    private static boolean isInteractiveMode(final String[] args) {
        return args.length == 0;
    }
}
