package de.leyn.PointOfInterestService.domain.data;

import lombok.Data;

public @Data
class Location {
    private double lat;
    private double lng;

    public Location() {
    }

    public Location(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }
}
