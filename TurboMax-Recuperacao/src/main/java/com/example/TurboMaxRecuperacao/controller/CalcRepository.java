package com.example.TurboMaxRecuperacao.controller;

import com.example.TurboMaxRecuperacao.model.Car;
import com.example.TurboMaxRecuperacao.model.GasCar;
import org.springframework.data.repository.CrudRepository;

public interface CalcRepository extends CrudRepository<GasCar, Integer> {
}
