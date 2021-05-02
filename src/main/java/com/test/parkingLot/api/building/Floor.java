package com.test.parkingLot.api.building;

import com.test.parkingLot.api.vehicle.Vehicle;

import java.util.List;
import java.util.Optional;

public interface Floor {
    public List<Slot> getSlots();

    public int getCurrentCapacity();

    public void updateCapacity();

    public Optional<Slot> getAvailableSlot(Vehicle vehicle);
}
