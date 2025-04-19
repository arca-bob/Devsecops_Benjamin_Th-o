package com.example.devsecops;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cars")
class CarController {

    private final List<Carfeature> cars = new ArrayList<>();

    public CarController() {
        cars.add(new Carfeature("Ferrari", 999, "11AA22"));
        cars.add(new Carfeature("Tesla", 120000, "69BB22"));
        // Add more cars here if needed
    }

    @GetMapping("/{plateNumber}")
    public Carfeature getCarByPlateNumber(@PathVariable("plateNumber") String plateNumber) {
        return cars.stream()
                .filter(car -> car.getLicencePlate().equals(plateNumber))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Car not found"));
    }

    @PutMapping("/{plateNumber}")
    public ResponseEntity<String> rentCar(
            @PathVariable String plateNumber,
            @RequestParam boolean rent,
            @RequestBody Rental Rental) {

        // Find the car by plate number
        Carfeature car = cars.stream()
                .filter(c -> c.getLicencePlate().equals(plateNumber))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Car not found"));

        if (rent) {
            // Check if the car is already rented
            if (car.isRented()) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("Car is already rented!");
            }

            car.setRented(true);
            car.setRent_begin(Rental.getBegin());
            car.setRent_end(Rental.getEnd());
            return ResponseEntity.ok("Car rented successfully from " +
                    Rental.getBegin() + " to " + Rental.getEnd());
        } else {
            if (!car.isRented()) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("Car is not currently rented!");
            }
            car.setRented(false);
            car.setRent_begin(null);
            car.setRent_end(null);
            return ResponseEntity.ok("Car returned successfully.");
        }
    }

    @GetMapping
    public List<Carfeature> getAllCars() {
        return cars;
    }


}