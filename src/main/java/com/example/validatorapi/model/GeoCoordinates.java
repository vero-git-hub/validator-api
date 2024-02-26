package com.example.validatorapi.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class GeoCoordinates {

    @NotNull(message = "{geo.latitude.notNull}")
    @Min(value = -90, message = "{geo.latitude.min}")
    @Max(value = 90, message = "{geo.latitude.max}")
    private Double latitude;

    @NotNull(message = "{geo.longitude.notNull}")
    @Min(value = -180, message = "{geo.longitude.min}")
    @Max(value = 180, message = "{geo.longitude.max}")
    private Double longitude;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}