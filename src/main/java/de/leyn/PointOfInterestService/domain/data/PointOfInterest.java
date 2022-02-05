package de.leyn.PointOfInterestService.domain.data;

import de.leyn.PointOfInterestService.data.dto.PointOfInterestDto;
import lombok.Data;
import lombok.NonNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public @Data
class PointOfInterest {
    private long id;
    @NonNull private String title;
    @NonNull private String shortDescription;
    @NonNull private String description;
    @NonNull private int year;
    @NonNull private Category category;
    @NonNull private List<String> images;
    @NonNull private District district;
    @NonNull private Location location;

    public PointOfInterest() {}

    public PointOfInterest fromPoiDto(PointOfInterestDto poiDto) {
        this.id = poiDto.getId();
        this.title = poiDto.getTitle();
        this.shortDescription = poiDto.getShortDescription();
        this.year = poiDto.getYr();
        this.location = new Location(poiDto.getLat(), poiDto.getLng());
        this.description = poiDto.getDescript();
        this.category = Category.valueOf(poiDto.getCategory());
        this.district = District.valueOf(poiDto.getDistrict());
        this.images = Arrays.stream(poiDto.getImages().split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        return this;
    }

    public PointOfInterestDto asPoiDto() {
        return new PointOfInterestDto(
                id,
                title,
                shortDescription,
                description,
                year,
                location.getLat(),
                location.getLng(),
                category.getValue(),
                district.getValue(),
                images.toString().replace("[", "").replace("]", "")
        );
    }
}
