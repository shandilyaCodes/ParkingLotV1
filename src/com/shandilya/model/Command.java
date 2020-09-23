package com.shandilya.model;

import com.shandilya.exception.InvalidCommandException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Command {

    private static final String SPACE = " ";
    private String commandName;
    private List<String> params;

    public String getCommandName() {
        return commandName;
    }

    public List<String> getParams() {
        return params;
    }

    public Command(String inputLine) {
        List<String> tokenList = Arrays.stream(inputLine.trim().split(SPACE))
                .map(String::trim)
                .filter(token -> (token.length() > 0))
                .collect(Collectors.toList());

        if (tokenList.size() == 0) {
            throw new InvalidCommandException();
        }

        commandName = tokenList.get(0).toLowerCase();
        tokenList.remove(0);
        params = tokenList;
    }
}
