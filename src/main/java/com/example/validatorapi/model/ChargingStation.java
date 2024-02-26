package com.example.validatorapi.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.util.List;

public class ChargingStation {
    @NotNull(message = "{chargingStation.id.notNull}")
    @Positive(message = "{chargingStation.id.positive}")
    private Long id;

    @NotBlank(message = "{chargingStation.title.notBlank}", groups = PublicStation.class)
    @Size(min = 3, max = 100, message = "{chargingStation.title.size}", groups = PublicStation.class)
    private String title;

    @NotBlank(message = "{chargingStation.description.notBlank}", groups = PublicStation.class)
    @Size(min = 10, max = 500, message = "{chargingStation.description.size}", groups = PublicStation.class)
    private String description;

    @NotBlank(message = "{chargingStation.address.notBlank}", groups = PublicStation.class)
    @Size(min = 10, max = 200, message = "{chargingStation.address.size}", groups = PublicStation.class)
    private String address;

    @NotNull(message = "{chargingStation.geoCoordinates.notNull}", groups = PublicStation.class)
    @Valid
    private GeoCoordinates geoCoordinates;

    @NotNull(message = "{chargingStation.isPublic.notNull}")
    private Boolean isPublic;

    @Size(min = 1, max = 8, message = "{chargingStation.connectors.size}")
    @NotEmpty(message = "{chargingStation.connectors.notEmpty}")
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