package com.example.TurboMaxRecuperacao.model;

public abstract class Gas {

    private Long numCar;

    private Double gas;

    public Long getNumCar() {
        return numCar;
    }

    public void setNumCar(Long numCar) {
        this.numCar = numCar;
    }


    public Double getGas() {
        return gas;
    }

    public void setGas(Double gas) {
        this.gas = gas;
    }
}

