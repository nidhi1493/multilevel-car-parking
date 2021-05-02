package com.test.parkingLot.impl.vehicle;

import com.test.parkingLot.api.vehicle.VehicleType;

public class Car extends VehicleImpl {

    public Car(String vehicleName, boolean isRoyal) {
        super(vehicleName, isRoyal);
    }

    public Car(String vehicleName) {
        super(vehicleName);
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.CAR;
    }

}
