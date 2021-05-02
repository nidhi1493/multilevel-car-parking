package com.test.parkingLot.impl.vehicle;

import com.test.parkingLot.api.vehicle.VehicleType;

public class Bike extends VehicleImpl {

    public Bike(String vehicleName, boolean isRoyal) {
        super(vehicleName, isRoyal);
    }

    public Bike(String vehicleName) {
        super(vehicleName);
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.BIKE;
    }

}
