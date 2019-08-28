package org.launchcode.zikaDashboard.models;

import com.vividsolutions.jts.geom.Geometry;

import javax.persistence.*;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String countryName;
    private String stateName;
    private Geometry geom;

    public Location() {}

    public Location(String countryName, String stateName) {
        this.countryName = countryName;
        this.stateName = stateName;
    }

    public Long getId() {
        return id;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getStateName() {
        return stateName;
    }

    public Geometry getGeom() {
        return geom;
    }

    public void setGeom(Geometry geom) {
        this.geom = geom;
    }
}
