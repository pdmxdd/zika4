package org.launchcode.zikaDashboard.models.es;

import org.launchcode.zikaDashboard.models.Report;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Document(indexName = "#{esConfig.indexName}", type="reports")
public class ReportDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /*
    this.dateString=dateString;
        this.locationString=locationString;
        this.locationType=locationType;
        this.dataField=dataField;
        this.dataFieldCode=dataFieldCode;
        this.timePeriod=timePeriod;
        this.timePeriodType=timePeriodType;
        this.value=value;
        this.unit=unit;
     */
    private String dateString;
    private String locationString;
    private String locationType;
    private String dataField;
    private String dataFieldCode;
    private String timePeriod;
    private String timePeriodType;
    private Double value;
    private String unit;

    public ReportDocument() {}

    public ReportDocument(Report report) {
        this.dateString = report.getDateString();
        this.locationString = report.getLocationString();
        this.locationType = report.getLocationType();
        this.dataField = report.getDataField();
        this.dataFieldCode = report.getDataFieldCode();
        this.timePeriod = report.getTimePeriod();
        this.timePeriodType = report.getTimePeriodType();
        this.value = report.getValue();
        this.unit = report.getUnit();
    }

    public String getId() {
        return id;
    }

    public String getDateString() {
        return dateString;
    }

    public String getLocationString() {
        return locationString;
    }

    public String getLocationType() {
        return locationType;
    }

    public String getDataField() {
        return dataField;
    }

    public String getDataFieldCode() {
        return dataFieldCode;
    }

    public String getTimePeriod() {
        return timePeriod;
    }

    public String getTimePeriodType() {
        return timePeriodType;
    }

    public Double getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }
}
