package com.example.TurboMaxRecuperacao.model;

public class Car {

    private Integer id;
    private String cname;
    private String brand;
    private String gasMC;
    private String alcMC;
    private Boolean flex;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return cname;
    }

    public void setName(String name) {
        this.cname = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
