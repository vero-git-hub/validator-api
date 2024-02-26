package com.example.validatorapi.model;

import jakarta.validation.constraints.*;

public class Connector {

    @NotNull(message = "{connector.id.notNull}")
    @Positive(message = "{connector.id.positive}")
    private Long id;

    @NotNull(message = "{connector.type.notNull}")
    @Pattern(regexp = "CCS|CHAdeMO|Type1|Type2", message = "{connector.type.pattern}")
    private String type;

    @NotNull(message = "{connector.maxPower.notNull}")
    @Min(value = 1, message = "{connector.maxPower.min}")
    @Max(value = 1000, message = "{connector.maxPower.max}")
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