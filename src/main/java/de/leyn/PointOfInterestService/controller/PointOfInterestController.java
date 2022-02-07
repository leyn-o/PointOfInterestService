package de.leyn.PointOfInterestService.controller;

import de.leyn.PointOfInterestService.data.CustomPointOfInterestRepositoryImpl;
import de.leyn.PointOfInterestService.data.dto.PointOfInterestDto;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PointOfInterestController {

    private CustomPointOfInterestRepositoryImpl customRepository;

    public PointOfInterestController(CustomPointOfInterestRepositoryImpl customRepository) {
        this.customRepository = customRepository;
    }

    @GetMapping("/pois/nearby")
    public List<PointOfInterestDto> getPoisNearby(@Param("lat") double lat, @Param("lng") double lng, @Param("range") double range) {
        return customRepository.getPoiNearby(lat, lng, range);
    }
}
