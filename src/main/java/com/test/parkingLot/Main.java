package com.test.parkingLot;

import com.test.parkingLot.api.building.MLC;
import com.test.parkingLot.api.building.Slot;
import com.test.parkingLot.api.vehicle.Vehicle;
import com.test.parkingLot.impl.building.MLCImpl;
import com.test.parkingLot.impl.vehicle.Bike;
import com.test.parkingLot.impl.vehicle.Car;

import java.util.Optional;

public class Main {
    private static MLC mlc;

    public static void main(String[] args) {
        mlc = new MLCImpl(1);

        System.out.println(mlc.getFloors().get(0).getCurrentCapacity());

        Vehicle car1 = new Car("Car1");
        park(car1);

        Vehicle car2 = new Car("Car2");
        park(car2);

        Vehicle car3 = new Car("Car3");
        park(car3);

        Vehicle car4 = new Car("Car4");
        park(car4);

        Vehicle car5 = new Car("Car5");
        park(car5);

        Vehicle bike1 = new Bike("Bike1");
        park(bike1);

        Vehicle bike2 = new Bike("Bike2");
        park(bike2);

        Vehicle bike3 = new Bike("Bike3");
        park(bike3);

        Vehicle bike4 = new Bike("Bike4");
        park(bike4);

        Vehicle bike5 = new Bike("Bike5");
        park(bike5);

        Vehicle bike6 = new Bike("Bike6");
        park(bike6);

        unPark(bike1);

        Vehicle bike7 = new Bike("Bike7");
        park(bike7);


        System.out.println(mlc.getDistribution(0));
    }


    //driver code for parking
    private static void park(Vehicle v) {
        try {
            Slot s = mlc.findSlot(v);
            if (s != null) {
                System.out.println("Slot found is " + s.getSlotNumber());
                v.setSlot(Optional.of(s));
                System.out.println("\n");
            }
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
    }


    //driver code for un-parking
    private static void unPark(Vehicle vehicle) {
        try {
            Optional<Slot> optionalSlot = vehicle.getSlot();
            if (optionalSlot.isPresent()) {
                optionalSlot.get().vacateSlotFor(vehicle);
                System.out.println("Vehicle removed from " + optionalSlot.get().getSlotNumber() + "\n");
                vehicle.setSlot(Optional.empty());
            } else {
                throw new RuntimeException("Slot not assigned to vehicle \n");
            }
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }
}
