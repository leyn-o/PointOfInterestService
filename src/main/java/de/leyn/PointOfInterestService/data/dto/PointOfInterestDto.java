package de.leyn.PointOfInterestService.data.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "poi")
@Getter
@Setter
public class PointOfInterestDto {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String title;
    @Column
    private String shortDescription;
    @Column
    private String descript;
    @Column
    private int yr;
    @Column
    private double lat;
    @Column
    private double lng;
    @Column
    private String category;
    @Column
    private String district;
    @Column
    private String images;

    public PointOfInterestDto() {
    }

    public PointOfInterestDto(long id,
                              String title,
                              String shortDescription,
                              String descript,
                              int year,
                              double lat,
                              double lng,
                              String category,
                              String district,
                              String images) {
        this.id = id;
        this.title = title;
        this.shortDescription = shortDescription;
        this.descript = descript;
        this.yr = year;
        this.lat = lat;
        this.lng = lng;
        this.category = category;
        this.district = district;
        this.images = images;
    }
}
