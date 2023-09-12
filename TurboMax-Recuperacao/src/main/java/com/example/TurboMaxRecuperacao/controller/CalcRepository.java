package com.example.TurboMaxRecuperacao.controller;

import com.example.TurboMaxRecuperacao.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CalcRepository extends CrudRepository<Car, Integer> {
}
