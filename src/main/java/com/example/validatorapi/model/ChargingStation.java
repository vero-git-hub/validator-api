package com.example.validatorapi.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class ChargingStation {
    @NotNull(message = "Identifier cannot be null")
    private Long id;

    @NotBlank(message = "Title is required for public stations", groups = PublicStation.class)
    private String title;

    @NotBlank(message = "Description is required for public stations", groups = PublicStation.class)
    private String description;

    @NotBlank(message = "Address is required for public stations", groups = PublicStation.class)
    private String address;

    @NotNull(message = "Geo-coordinates are required for public stations", groups = PublicStation.class)
    private GeoCoordinates geoCoordinates;

    @NotNull(message = "Public status must be specified")
    private Boolean isPublic;

    @Size(min = 1, max = 8, message = "Station must have 1 to 8 connectors")
    @NotEmpty(message = "Connector list cannot be empty")
    private List<Connector> connectors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public GeoCoordinates getGeoCoordinates() {
        return geoCoordinates;
    }

    public void setGeoCoordinates(GeoCoordinates geoCoordinates) {
        this.geoCoordinates = geoCoordinates;
    }

    public Boolean getPublic() {
        return isPublic;
    }

    public void setPublic(Boolean aPublic) {
        isPublic = aPublic;
    }

    public List<Connector> getConnectors() {
        return connectors;
    }

    public void setConnectors(List<Connector> connectors) {
        this.connectors = connectors;
    }

    public interface PublicStation {}
}