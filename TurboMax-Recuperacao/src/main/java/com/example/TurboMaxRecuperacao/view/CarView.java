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
    public Car findCar(@PathParam("name") String cname, @PathParam("brand") String brand, @PathParam("fuel") String gasIN){
        return controller.findCar(cname, brand, gasIN);
    }


    @DeleteMapping("/car")
    public String deleteCar(@PathParam("name") String cname, @PathParam("marca") String brand, @PathParam("fuel") String gasIN){
        controller.deleteCar(cname, brand, gasIN);

        return "O carro: " + cname + " da marca: " +brand+ " foi deletado";
    }

    @PostMapping("/car")
    public Car addCar(@PathParam("name") String cname, @PathParam("marca") String brand, @PathParam("gastoGasolinaMEDIA") String gasMC, @PathParam("gastoAlcoolMEDIA") String alcMC, @PathParam("flex") Boolean flex){
        return controller.addCar(cname, brand, gasMC, alcMC, flex);
    }

    @PutMapping("/car")
    public Car updateCar(@PathParam("name") String cname, @PathParam("marca") String brand, @PathParam("fuel") String gasIN){
        return controller.editCar(cname, brand, gasIN);
    }

    @GetMapping("/all")
    public List<Car> listAll(){
        return controller.listAll();
    }
}
