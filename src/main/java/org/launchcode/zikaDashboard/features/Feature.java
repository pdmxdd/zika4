package org.launchcode.zikaDashboard.features;

import com.bedatadriven.jackson.datatype.jts.serialization.GeometrySerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Geometry;

import java.util.Map;

public class Feature {
    private final String type = "Feature";

    @JsonSerialize(using = GeometrySerializer.class)
    private Geometry geometry;
    private Map<String, Object> properties;

    public Feature(Geometry geometry, Map<String, Object> properties) {
        this.geometry = geometry;
        this.properties = properties;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public String getType() {
        return type;
    }

    public void getProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

}
