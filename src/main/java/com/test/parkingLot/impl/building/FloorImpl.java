package com.test.parkingLot.impl.building;

import com.test.parkingLot.api.building.Floor;
import com.test.parkingLot.api.building.Slot;
import com.test.parkingLot.api.vehicle.Vehicle;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FloorImpl implements Floor {
    private int floorNumber;
    private Slot[] slots;

    private int count = 0;

    public FloorImpl(int floorNumber) {
        this.floorNumber = floorNumber;
        slots = new Slot[20];

        for (int i = 0; i < 20; i++) {
            this.slots[i] = new SlotImpl(i);
        }
    }

    @Override
    public List<Slot> getSlots() {
        return Arrays.asList(this.slots);
    }

    @Override
    public int getCurrentCapacity() {
        return this.count;
    }

    @Override
    public void updateCapacity() {
    }

    @Override
    public Optional<Slot> getAvailableSlot(Vehicle vehicle) {
        System.out.println("Vehicle " + vehicle.getVehicleName());
        for (Slot slot : slots) {
            Optional<Slot> optionalSlot = slot.assignSlotFor(vehicle);
            if (optionalSlot.isPresent()) {
                return optionalSlot;
            }
        }
        return Optional.empty();
    }

}
