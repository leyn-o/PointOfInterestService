package de.leyn.PointOfInterestService.domain.usecases;

import org.springframework.stereotype.Service;

@Service
public class PointOfInterestUseCases {

    public final AddPointOfInterestUseCase addPointOfInterestUseCase;

    public PointOfInterestUseCases(AddPointOfInterestUseCase addPointOfInterestUseCase) {
        this.addPointOfInterestUseCase = addPointOfInterestUseCase;
    }
}
