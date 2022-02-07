package de.leyn.PointOfInterestService.data;

import de.leyn.PointOfInterestService.data.dto.PointOfInterestDto;

import java.util.List;

public interface CustomPointOfInterestRepository {

    List<PointOfInterestDto> getPoiNearby(double lat, double lng, double range);

}
