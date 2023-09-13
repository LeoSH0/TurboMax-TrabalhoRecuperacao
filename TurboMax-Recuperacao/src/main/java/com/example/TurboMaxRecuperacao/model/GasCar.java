package com.example.TurboMaxRecuperacao.model;

import javax.persistence.*;
import java.util.Date;

public class GasCar {


    @Id
    @Column(name = "carro")
    private Long numCar;
    private Double gas;
    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @Column(name = "type")
    private GasUsed gasUsed;

    @Transient
    private static String error;

    public GasUsed getGasUsed() {
        return gasUsed;
    }

    public static void setGasUsed(GasUsed gasUsed) {
        gasUsed = gasUsed;
    }

    public static String getError() {
        return error;
    }

    public static void setError(String error) {
        error = error;
    }

    public Car getCar() {
        return car;
    }

    public static void setCar(Car car) {
        car = car;
    }


    public static void setNumCar(Long numCar) {
        numCar = numCar;
    }


    public Double getGas() {
        return gas;
    }

    public void setGas(Double gas) {
        this.gas = gas;
    }


}
