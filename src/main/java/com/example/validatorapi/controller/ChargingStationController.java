package com.example.validatorapi.controller;

import com.example.validatorapi.model.ChargingStation;
import jakarta.validation.ConstraintViolation;

import jakarta.validation.groups.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Validator;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/charging-stations")
public class ChargingStationController {

    @Autowired
    private Validator validator;

    @PostMapping
    public ResponseEntity<?> createChargingStation(@RequestBody ChargingStation chargingStation) {
        Set<ConstraintViolation<ChargingStation>> violations;

        if (Boolean.TRUE.equals(chargingStation.getIsPublic())) {
            violations = validator.validate(chargingStation, ChargingStation.PublicStation.class, Default.class);
        } else {
            violations = validator.validate(chargingStation, Default.class);
        }

        if (!violations.isEmpty()) {
            List<String> errors = violations.stream()
                    .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
                    .collect(Collectors.toList());
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(chargingStation, HttpStatus.CREATED);
    }
}
