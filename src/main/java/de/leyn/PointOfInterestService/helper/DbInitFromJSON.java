package de.leyn.PointOfInterestService.helper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.leyn.PointOfInterestService.domain.data.PointOfInterest;
import de.leyn.PointOfInterestService.domain.usecases.PointOfInterestUseCases;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class DbInitFromJSON {

    private final Logger logger = Logger.getLogger(DbInitFromJSON.class.getName());
    private final ObjectMapper mapper = new ObjectMapper();

    private final PointOfInterestUseCases poiUseCases;

    public DbInitFromJSON(PointOfInterestUseCases poiUseCases) {
        this.poiUseCases = poiUseCases;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        initFirstRealSubsetOfPOI();
    }

    private void initFirstRealSubsetOfPOI() {
        ArrayList<PointOfInterest> poiList = readDataFromJsonFile();
        poiList.forEach(poi -> {
            poiUseCases.addPointOfInterestUseCase.savePoi(poi);
            logger.log(Level.INFO, poi.toString());
        });
    }

    private ArrayList<PointOfInterest> readDataFromJsonFile() {
        String absolutePath = new File("").getAbsolutePath();
        File jsonFile = new File(absolutePath + "/src/main/resources/content/realPoiSubset_noId.json");
        ArrayList<PointOfInterest> poiList = new ArrayList<>();
        try {
            poiList = mapper.readValue(jsonFile, mapper.getTypeFactory().constructCollectionType(List.class, PointOfInterest.class));
        } catch (IOException e) {
            System.out.println("BurgiTown: Error reading JSON POI file");
        }
        return poiList;
    }

}
