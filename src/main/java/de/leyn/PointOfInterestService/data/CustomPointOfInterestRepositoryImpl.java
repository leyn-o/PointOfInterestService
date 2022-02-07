package de.leyn.PointOfInterestService.data;

import de.leyn.PointOfInterestService.data.dto.PointOfInterestDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CustomPointOfInterestRepositoryImpl implements CustomPointOfInterestRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PointOfInterestDto> getPoiNearby(double lat, double lng, double range) {
        Double latMin = lat - range;
        Double latMax = lat + range;
        Double lngMin = lng - range;
        Double lngMax = lng + range;

        TypedQuery<PointOfInterestDto> query = entityManager.createQuery("SELECT p FROM PointOfInterestDto p WHERE p.lat BETWEEN ?1 AND ?2 AND p.lng BETWEEN ?3 AND ?4", PointOfInterestDto.class);
        query.setParameter(1, latMin);
        query.setParameter(2, latMax);
        query.setParameter(3, lngMin);
        query.setParameter(4, lngMax);

        return query.getResultList();
    }
}
