package com.shandilya.mode;

import com.shandilya.commands.CommandExecutorFactory;
import com.shandilya.model.Command;
import com.shandilya.utils.OutputPrinter;

import java.io.*;

public class FileMode extends Mode {

    private String fileName;

    public FileMode(CommandExecutorFactory commandExecutorFactory,
                    OutputPrinter outputPrinter,
                    final String fileName) {
        super(commandExecutorFactory, outputPrinter);
        this.fileName = fileName;
    }

    @Override
    public void process() throws IOException {
        final File file = new File(fileName);
        final BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException fne) {
            outputPrinter.invalidFile();
            return;
        }
        String input = reader.readLine();
        while (null != input) {
            final Command command = new Command(input);
            processCommand(command);
            input = reader.readLine();
        }
    }
}
