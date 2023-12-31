package com.example.TurboMaxRecuperacao.controller;

import com.example.TurboMaxRecuperacao.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Controller {

    @Autowired
    private CarRepository carRepository;
    private List<Car> cars = new ArrayList<>();
    private int id = 0;

    public Car addCar(String cname, String brand, String gasMC, String alcMC, Boolean flex) {
        Car car = new Car();
        car.setName(cname);
        car.setBrand(brand);
        car.setGasMC(gasMC);
        car.setAlcMC(alcMC);
        car.setFlex(flex);
        id++;
        car.setId(id);
        carRepository.save(car);
        return car;
    }

    public Car findCar(String cname, String brand, String gasIN) {
        List<Car> cars = (List<Car>) carRepository.findAll();
        for (Car car : cars) {
            if (car.getName().equals(cname) && car.getBrand().equals(brand)) {
                return car;
            }
        }

        return null;
    }

    public Car editCar(String cname, String brand, String gasIN) {
        Car car = findCar(cname, brand, gasIN);
        car.setBrand(brand);
        carRepository.save(car);
        return car;
    }

    public void deleteCar(String cname, String brand, String gasIN) {
        Car car = findCar(cname, brand, gasIN);
        carRepository.delete(car);
    }

    public List<Car> listAll() {
        return (List<Car>) carRepository.findAll();
    }


}
