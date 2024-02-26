package com.example.validatorapi.model;

import jakarta.validation.constraints.NotNull;

public class Connector {

    @NotNull(message = "Identifier cannot be null")
    private Long id;

    @NotNull(message = "Type is required")
    private ConnectorType type;

    @NotNull(message = "Maximum power in kW must be specified")
    private Integer maxPower;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ConnectorType getType() {
        return type;
    }

    public void setType(ConnectorType type) {
        this.type = type;
    }

    public Integer getMaxPower() {
        return maxPower;
    }

    public void setMaxPower(Integer maxPower) {
        this.maxPower = maxPower;
    }
}