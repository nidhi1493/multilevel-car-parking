package com.test.parkingLot.impl.vehicle;

import com.test.parkingLot.api.building.Slot;
import com.test.parkingLot.api.vehicle.Vehicle;
import com.test.parkingLot.api.vehicle.VehicleType;

import java.util.Optional;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public abstract class VehicleImpl implements Vehicle {
    private final String vehicleName;
    private final long inTime;
    private Optional<Slot> slot;
    private boolean isRoyal;

    public VehicleImpl(String vehicleName) {
        this.vehicleName = vehicleName;
        this.inTime = System.currentTimeMillis();
    }

    public VehicleImpl(String vehicleName, boolean isRoyal) {
        this.vehicleName = vehicleName;
        this.inTime = System.currentTimeMillis();
        this.isRoyal = isRoyal;
    }

    @Override
    public String getVehicleName() {
        return this.vehicleName;
    }


    public abstract VehicleType getVehicleType();

    @Override
    public Long getInTime() {
        return this.inTime;
    }

    @Override
    public Optional<Slot> getSlot() {
        return slot;
    }

    public void setSlot(Optional<Slot> slot) {
        this.slot = slot;
    }

    @Override
    public boolean isRoyal() {
        return this.isRoyal;
    }

    @Override
    public String toString() {
        return "VehicleImpl [vehicleName=" + vehicleName + ", inTime=" + inTime + ", slot=" + slot + ", isRoyal="
                + isRoyal + ", vehicleType=" + getVehicleType() + "]";
    }


}
