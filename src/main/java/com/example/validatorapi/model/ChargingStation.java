package com.example.validatorapi.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.util.List;

public class ChargingStation {
    @NotNull(message = "Identifier cannot be null")
    @Positive(message = "Identifier must be positive")
    private Long id;

    @NotBlank(message = "Title is required for public stations", groups = PublicStation.class)
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters", groups = PublicStation.class)
    private String title;

    @NotBlank(message = "Description is required for public stations", groups = PublicStation.class)
    @Size(min = 10, max = 500, message = "Description must be between 10 and 500 characters", groups = PublicStation.class)
    private String description;

    @NotBlank(message = "Address is required for public stations", groups = PublicStation.class)
    @Size(min = 10, max = 200, message = "Address must be between 10 and 200 characters", groups = PublicStation.class)
    private String address;

    @NotNull(message = "Geo-coordinates are required for public stations", groups = PublicStation.class)
    @Valid
    private GeoCoordinates geoCoordinates;

    @NotNull(message = "Public status must be specified")
    private Boolean isPublic;

    @Size(min = 1, max = 8, message = "Station must have 1 to 8 connectors")
    @NotEmpty(message = "Connector list cannot be empty")
    @Valid
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

    public Boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    public List<Connector> getConnectors() {
        return connectors;
    }

    public void setConnectors(List<Connector> connectors) {
        this.connectors = connectors;
    }

    public interface PublicStation {}
}