package com.example.validatorapi.controller;

import com.example.validatorapi.model.ChargingStation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/charging-stations")
public class ChargingStationController {

    @PostMapping
    public ResponseEntity<ChargingStation> createChargingStation(@Valid @RequestBody ChargingStation chargingStation) {
        return new ResponseEntity<>(chargingStation, HttpStatus.CREATED);
    }
}
