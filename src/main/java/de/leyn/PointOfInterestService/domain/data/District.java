package de.leyn.PointOfInterestService.domain.data;

public enum District {
    UNDEFINED("UNDEFINED"),
    BURGEBRACH("BURGEBRACH"),
    GRASMANNSDORF("GRASMANNSDORF");

    private final String value;

    District(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
