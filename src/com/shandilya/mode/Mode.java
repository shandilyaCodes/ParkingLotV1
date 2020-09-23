package com.shandilya.mode;

import com.shandilya.commands.CommandExecutor;
import com.shandilya.commands.CommandExecutorFactory;
import com.shandilya.exception.InvalidCommandException;
import com.shandilya.model.Command;
import com.shandilya.utils.OutputPrinter;

import java.io.IOException;

public abstract class Mode {

    private CommandExecutorFactory commandExecutorFactory;
    protected OutputPrinter outputPrinter;

    public Mode(CommandExecutorFactory commandExecutorFactory, OutputPrinter outputPrinter) {
        this.commandExecutorFactory = commandExecutorFactory;
        this.outputPrinter = outputPrinter;
    }

    protected void processCommand(final Command command) {
        final CommandExecutor commandExecutor = commandExecutorFactory.getCommandExecutor(command);
        if (commandExecutor.validate(command)) {
            commandExecutor.execute(command);
        } else {
            throw new InvalidCommandException();
        }
    }

    public abstract void process() throws IOException;
}