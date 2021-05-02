package com.test.parkingLot.api.building;

import com.test.parkingLot.api.vehicle.Vehicle;
import com.test.parkingLot.api.vehicle.VehicleType;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface Slot {
    public int getSlotNumber();

    public Optional<List<Vehicle>> getUpper();

    public Optional<List<Vehicle>> getLower();

    default int getDistanceFromExit() {
        return getSlotNumber() % 10;
    }

    public Optional<Slot> assignSlotFor(Vehicle vehicle);

    public Long vacateSlotFor(Vehicle vehicle);

    public Map<VehicleType, Long> getDistribution();
}
