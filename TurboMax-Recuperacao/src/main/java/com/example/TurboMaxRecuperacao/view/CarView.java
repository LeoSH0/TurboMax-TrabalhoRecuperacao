package com.example.TurboMaxRecuperacao.view;

import com.example.TurboMaxRecuperacao.controller.Controller;
import com.example.TurboMaxRecuperacao.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CarView {

    @Autowired
    Controller controller;
    @GetMapping("/car")
    public Car findCar(@PathParam("name") String cname){
        return controller.findCar(cname);
    }


    @DeleteMapping("/car")
    public String deleteCar(@PathParam("name") String cname, @PathParam("marca") String brand){
        controller.removeCar(cname);

        return "O carro: " + cname + " da marca: " +brand+ " foi deletado";
    }

    @PostMapping("/car")
    public Car addCar(@PathParam("name") String cname, @PathParam("marca") String brand){
        return controller.addCar(cname, brand);
    }

    @PutMapping("/car")
    public Car updateCar(@PathParam("name") String cname, @PathParam("marca") String brand){
        return controller.editCar(cname, brand);
    }

    @GetMapping("/all")
    public List<Car> listAll(){
        return controller.listAll();
    }
}
