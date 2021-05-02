package com.test.parkingLot.impl.building;

import com.test.parkingLot.api.building.Floor;
import com.test.parkingLot.api.building.MLC;
import com.test.parkingLot.api.building.Slot;
import com.test.parkingLot.api.vehicle.Vehicle;
import com.test.parkingLot.api.vehicle.VehicleType;

import java.util.*;

import static com.test.parkingLot.api.vehicle.VehicleType.BIKE;
import static com.test.parkingLot.api.vehicle.VehicleType.CAR;

public class MLCImpl implements MLC {
    private final Floor[] floors;

    public MLCImpl(int floorNums) {
        this.floors = new Floor[floorNums];
        for (int i = 0; i < floorNums; i++) {
            this.floors[i] = new FloorImpl(i);
        }
    }

    @Override
    public List<Floor> getFloors() {
        return Arrays.asList(floors);
    }

    @Override
    public Slot findSlot(Vehicle vehicle) {
        for (Floor floor : floors) {
            Optional<Slot> optionalSlot = floor.getAvailableSlot(vehicle);
            if (optionalSlot.isPresent()) {
                return optionalSlot.get();
            }
        }
        throw new RuntimeException("No available slots on this floor");
    }

    @Override
    public Map<VehicleType, Long> getDistribution(Integer floorNumber) {
        if (floorNumber >= floors.length) {
            throw new RuntimeException("Invalid Floor " + floorNumber);
        }
        Floor floor = floors[floorNumber];
        Map<VehicleType, Long> result = new HashMap<>();
        long bikeCount = 0;
        long carCount = 0;
        for (Slot slot : floor.getSlots()) {
            Map<VehicleType, Long> distribution = slot.getDistribution();
            if (distribution.containsKey(BIKE)) {
                bikeCount = bikeCount + distribution.get(BIKE);
            }
            if (distribution.containsKey(CAR)) {
                carCount = carCount + distribution.get(CAR);
            }
        }

        result.put(CAR, carCount);
        result.put(BIKE, bikeCount);
        return result;
    }
}