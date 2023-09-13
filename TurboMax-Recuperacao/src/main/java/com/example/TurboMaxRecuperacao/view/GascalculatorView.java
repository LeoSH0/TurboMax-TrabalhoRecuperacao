package com.example.TurboMaxRecuperacao.view;

import com.example.TurboMaxRecuperacao.controller.CalculatorController;
import com.example.TurboMaxRecuperacao.model.GasCar;
import com.example.TurboMaxRecuperacao.model.GasUsed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.websocket.server.PathParam;

public class GascalculatorView {

    @Autowired
    private CalculatorController calculatorController;

    @PostMapping("/cadastracarro")
    public GasCar cadCar(@PathParam("name") String name, @PathParam("brand") String brand, @PathParam("type") String type) throws Exception {
        return calculatorController.cadCar(name, brand, type);
    }

    @DeleteMapping("/banco")
    public void removeCar(@PathParam("name") String cname){
        calculatorController.delete(cname);
    }

    @GetMapping("/type")
    public String listGasUsed() {
        String text = GasUsed.VEICULO_GASOLINA + ", " + GasUsed.VEICULO_ALCOOL;
        return text;
    }

    @GetMapping("/consultcarro")
    public GasCar consultCar(@PathParam("name") String cname) {
        return calculatorController.consultCar(cname);
    }

    @PutMapping("/calculo")
    public String calcFuel(@PathParam("fuel") String gasIN, @PathParam("kmL") float kmL){

       return calculatorController.calcFuel(gasIN, kmL).toString();
    }


}
