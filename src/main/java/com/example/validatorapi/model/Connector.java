package com.example.validatorapi.model;

import jakarta.validation.constraints.*;

public class Connector {

    @NotNull(message = "Identifier cannot be null")
    @Positive(message = "Identifier must be positive")
    private Long id;

    @NotNull(message = "Type is required")
    @Pattern(regexp = "CCS|CHAdeMO|Type1|Type2", message = "Must be one of the defined connector types")
    private String type;

    @NotNull(message = "Maximum power in kW must be specified")
    @Min(value = 1, message = "Maximum power must be greater than 0")
    @Max(value = 1000, message = "Maximum power must not exceed 1000 kW")
    private Integer maxPower;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getMaxPower() {
        return maxPower;
    }

    public void setMaxPower(Integer maxPower) {
        this.maxPower = maxPower;
    }
}