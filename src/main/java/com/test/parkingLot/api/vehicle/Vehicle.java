package com.test.parkingLot.api.vehicle;

import com.test.parkingLot.api.building.Slot;

import java.util.Optional;

public interface Vehicle {

    public String getVehicleName();

    public VehicleType getVehicleType();

    public Long getInTime();

    default boolean isRoyal() {
        return false;
    }

    public Optional<Slot> getSlot();

    public void setSlot(Optional<Slot> slot);
}
