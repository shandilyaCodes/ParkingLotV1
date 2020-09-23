package com.shandilya.commands;

import com.shandilya.exception.InvalidCommandException;
import com.shandilya.model.Command;
import com.shandilya.service.ParkingLotService;
import com.shandilya.utils.OutputPrinter;
import java.util.HashMap;
import java.util.Map;

public class CommandExecutorFactory {

    private Map<String, CommandExecutor> commands = new HashMap<>();

    public CommandExecutorFactory(final ParkingLotService parkingLotService) {
        final OutputPrinter outputPrinter = new OutputPrinter();
        commands.put(
                CreateParkingLotCommandExecutor.COMMAND_NAME,
                new CreateParkingLotCommandExecutor(parkingLotService, outputPrinter));

        commands.put(
                ParkCommandExecutor.COMMAND_NAME,
                new ParkCommandExecutor(parkingLotService, outputPrinter));

        commands.put(LeaveCommandExecutor.COMMAND_NAME,
                new LeaveCommandExecutor(parkingLotService, outputPrinter));

        commands.put(StatusCommandExecutor.COMMAND_NAME,
                new StatusCommandExecutor(parkingLotService, outputPrinter));

        commands.put(ColoursToRegNumberCommandExecutor.COMMAND_NAME,
                new ColoursToRegNumberCommandExecutor(parkingLotService, outputPrinter));

        commands.put(ColorToSlotNumberCommandExecutor.COMMAND_NAME,
                new ColorToSlotNumberCommandExecutor(parkingLotService, outputPrinter));

        commands.put(SlotForRegNumberCommandExecutor.COMMAND_NAME,
                new SlotForRegNumberCommandExecutor(parkingLotService, outputPrinter));

        commands.put(ExitCommandExecutor.COMMAND_NAME,
                new ExitCommandExecutor(parkingLotService, outputPrinter));
    }

    public CommandExecutor getCommandExecutor(final Command command) {
        final CommandExecutor commandExecutor = commands.get(command.getCommandName());
        if (commandExecutor == null) {
            throw new InvalidCommandException();
        }
        return commandExecutor;
    }
}