package org.launchcode.zikaDashboard.models;

import com.vividsolutions.jts.geom.Geometry;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Report {

    /*
    * report_date,location,location_type,data_field,data_field_code,time_period,time_period_type,value,unit
    * */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dateString;
    private String locationString;
    private String locationType;
    private String dataField;
    private String dataFieldCode;
    private String timePeriod;
    private String timePeriodType;
    private Double value;
    private String unit;

    //private Geometry location;

    // required Hibernate constructor
    public Report() {}

    public Report(
            String dateString,
            String locationString,
            String locationType,
            String dataField,
            String dataFieldCode,
            String timePeriod,
            String timePeriodType,
            Double value,
            String unit
    ) {
        this.dateString=dateString;
        this.locationString=locationString;
        this.locationType=locationType;
        this.dataField=dataField;
        this.dataFieldCode=dataFieldCode;
        this.timePeriod=timePeriod;
        this.timePeriodType=timePeriodType;
        this.value=value;
        this.unit=unit;
    }

    public String getLocationString() {
        return locationString;
    }

    public void setLocationString(String locationString) {
        this.locationString = locationString;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public String getDataField() {
        return dataField;
    }

    public void setDataField(String dataField) {
        this.dataField = dataField;
    }

    public String getDataFieldCode() {
        return dataFieldCode;
    }

    public void setDataFieldCode(String dataFieldCode) {
        this.dataFieldCode = dataFieldCode;
    }

    public String getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(String timePeriod) {
        this.timePeriod = timePeriod;
    }

    public String getTimePeriodType() {
        return timePeriodType;
    }

    public void setTimePeriodType(String timePeriodType) {
        this.timePeriodType = timePeriodType;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

//    public Geometry getLocation() {
//        return location;
//    }
//
//    public void setLocation(Geometry location) {
//        this.location = location;
//    }


    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }


}

