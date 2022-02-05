package de.leyn.PointOfInterestService.domain.usecases;

import de.leyn.PointOfInterestService.data.PointOfInterestRepository;
import de.leyn.PointOfInterestService.domain.data.PointOfInterest;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class AddPointOfInterestUseCase {
    @NonNull
    private final PointOfInterestRepository repository;

    public AddPointOfInterestUseCase(@NonNull PointOfInterestRepository repository) {
        this.repository = repository;
    }

    public void savePoi(PointOfInterest poi) {
        repository.save(poi.asPoiDto());
    }
}
