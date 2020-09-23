package com.shandilya.commands;

import com.shandilya.model.Command;
import com.shandilya.model.Slot;
import com.shandilya.service.ParkingLotService;
import com.shandilya.utils.OutputPrinter;

import java.util.List;
import java.util.Optional;

public class SlotForRegNumberCommandExecutor extends CommandExecutor {

    public static final String COMMAND_NAME = "slot_number_for_registration_number";

    public SlotForRegNumberCommandExecutor(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().size() == 1;
    }

    @Override
    public void execute(Command command) {
        final List<Slot> occupiedSlots = parkingLotService.getOccupiedSlots();
        final String regNumberToFind = command.getParams().get(0);
        final Optional<Slot> foundSlot = occupiedSlots.stream()
                .filter(slot -> slot.getParkedCar().getRegistrationNumber().equalsIgnoreCase(regNumberToFind))
                .findFirst();
        if (foundSlot.isPresent()) {
            outputPrinter.printWithNewLine(foundSlot.get().getSlotNumber().toString());
        } else {
            outputPrinter.notFound();
        }
    }
}