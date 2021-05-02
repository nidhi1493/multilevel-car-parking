package com.test.parkingLot.impl.building;

import com.test.parkingLot.api.building.Slot;
import com.test.parkingLot.api.vehicle.Vehicle;
import com.test.parkingLot.api.vehicle.VehicleType;

import java.util.*;
import java.util.stream.Collectors;

import static com.test.parkingLot.api.vehicle.VehicleType.BIKE;

public class SlotImpl implements Slot {
    private final int slotNumber;
    private final Map<Integer, List<Vehicle>> map = new HashMap<>();

    public SlotImpl(int slotNumber) {
        this.slotNumber = slotNumber;
        map.put(0, new LinkedList<>());
        map.put(1, new LinkedList<>());
    }

    @Override
    public int getSlotNumber() {
        return this.slotNumber;
    }

    @Override
    public Optional<List<Vehicle>> getUpper() {
        return Optional.ofNullable(map.get(0));
    }

    @Override
    public Optional<List<Vehicle>> getLower() {
        return Optional.ofNullable(map.get(1));
    }

    @Override
    public Optional<Slot> assignSlotFor(Vehicle vehicle) {
        switch (vehicle.getVehicleType()) {

            case BIKE:
                for (int slotNumber = 0; slotNumber < 2; slotNumber++) {
                    List<Vehicle> vehiclesParked = map.get(slotNumber);
                    if (vehiclesParked.isEmpty()) {
                        map.get(slotNumber).add(vehicle);
                        return Optional.of(this);
                    }

                    if (vehiclesParked.get(0).getVehicleType().equals(BIKE)) {
                        if (slotNumber == 0 && vehiclesParked.size() + 1 < 3) {
                            map.get(slotNumber).add(vehicle);
                            return Optional.of(this);
                        } else if (slotNumber == 1 && vehiclesParked.size() + 1 < 4) {
                            map.get(slotNumber).add(vehicle);
                            return Optional.of(this);
                        }
                    }
                }
                break;

            case CAR:
                for (int slotNumber = 0; slotNumber < 2; slotNumber++) {
                    List<Vehicle> vehiclesParked = map.get(slotNumber);
                    if (vehiclesParked.isEmpty()) {
                        map.get(slotNumber).add(vehicle);
                        return Optional.of(this);
                    }
                }
                break;

            default:
                throw new RuntimeException("Invalid vehicle " + vehicle.getVehicleType());

        }
        return Optional.empty();
    }

    @Override
    public Long vacateSlotFor(Vehicle vehicle) {
        Slot slot = vehicle.getSlot().orElseThrow(() -> new RuntimeException("Vehicle doesn't have any slot assigned"));
        if (map.get(0).contains(vehicle)) {
            map.get(0).remove(vehicle);
        } else if (map.get(1).contains(vehicle)) {
            map.get(1).remove(vehicle);
        } else {
            throw new RuntimeException(vehicle.getVehicleName() + " not found in slot " + slot.getSlotNumber());
        }
        return System.currentTimeMillis();
    }

    @Override
    public Map<VehicleType, Long> getDistribution() {
        return map.entrySet().stream()
                .map(Map.Entry::getValue).flatMap(Collection::stream)
                .collect(Collectors.groupingBy(Vehicle::getVehicleType, Collectors.counting()));
    }

    @Override
    public String toString() {
        return " [slotNumber=" + slotNumber + "]";
    }
}