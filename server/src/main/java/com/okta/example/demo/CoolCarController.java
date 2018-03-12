package com.okta.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class CoolCarController {

    private CarRepository carRepository;

    public CoolCarController(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    @GetMapping("/cool-cars")
    public Collection<Car> coolCars(){
        return carRepository.findAll().stream()
                .filter(this::isCool)
                .collect(Collectors.toList());
    }

    private boolean isCool(Car car){
        return !car.getName().equals("AMC Germlin") &&
                !car.getName().equals("Trimph Stag") &&
                !car.getName().equals("Food Pinto") &&
                !car.getName().equals("Yugo GV");
    }

}
