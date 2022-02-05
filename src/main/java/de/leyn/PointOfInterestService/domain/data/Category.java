package de.leyn.PointOfInterestService.domain.data;

public enum Category {
    UNDEFINED("UNDEFINED"),
    BUILDING("BUILDING"),
    PANORAMA("PANORAMA");

    private final String value;

    Category(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
