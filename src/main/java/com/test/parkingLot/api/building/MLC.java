package com.test.parkingLot.api.building;

import com.test.parkingLot.api.vehicle.Vehicle;
import com.test.parkingLot.api.vehicle.VehicleType;

import java.util.List;
import java.util.Map;

public interface MLC {
    public List<Floor> getFloors();

    public Slot findSlot(Vehicle vehicle);

    public Map<VehicleType, Long> getDistribution(Integer floorNumber);
}
