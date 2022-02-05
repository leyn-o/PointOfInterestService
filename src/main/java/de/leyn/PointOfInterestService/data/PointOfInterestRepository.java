package de.leyn.PointOfInterestService.data;

import de.leyn.PointOfInterestService.data.dto.PointOfInterestDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RepositoryRestResource(path = "pois")
public interface PointOfInterestRepository extends JpaRepository<PointOfInterestDto, Long> {

    PointOfInterestDto findById(@PathVariable long id);

    // accessible via /pois/search/findByCategory?category=
    List<PointOfInterestDto> findByCategory(@Param("category") String category);

    // accessible via /pois/search/findByDistrict?district=
    List<PointOfInterestDto> findByDistrict(@Param("district") String district);

}
