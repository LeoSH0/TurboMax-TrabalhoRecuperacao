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

    public Car findCar(String cname) {
        List<Car> cars = (List<Car>) carRepository.findAll();
        for (Car car : cars) {
            if (car.getName().equals(cname)) {
                return car;
            }
        }

        return null;
    }

    public Car addCar(String cname, String brand) {
        Car car = new Car();
        car.setName(cname);
        car.setBrand(brand);
        id++;
        car.setId(id);
        carRepository.save(car);
        return car;
    }

    public void removeCar(String cname) {
        Car car = findCar(cname);
        carRepository.delete(car);
    }

    public Car editCar(String cname, String brand) {
        Car car = findCar(cname);
        car.setBrand(brand);
        carRepository.save(car);
        return car;
    }

    public List<Car> listAll() {
        return (List<Car>) carRepository.findAll();
    }
}
