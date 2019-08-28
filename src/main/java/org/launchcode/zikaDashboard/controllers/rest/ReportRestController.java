package org.launchcode.zikaDashboard.controllers.rest;

import org.launchcode.zikaDashboard.data.LocationRepository;
import org.launchcode.zikaDashboard.data.ReportRepository;
import org.launchcode.zikaDashboard.features.Feature;
import org.launchcode.zikaDashboard.features.FeatureCollection;
import org.launchcode.zikaDashboard.models.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/report")
public class ReportRestController {

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping(value = "/dates/unique")
    public ResponseEntity getUniqueDates() {
        return new ResponseEntity(reportRepository.allDatesDistinct(), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity getReports(@RequestParam("date") Optional<String> dateString) {

        if (!dateString.isPresent()) {
            //return new ResponseEntity(reportRepository.findAll(), HttpStatus.OK);
            return new ResponseEntity(new ArrayList(), HttpStatus.OK);
        }
        List<Report> reports = reportRepository.findByDateString(dateString.get() + " 00:00:00");
        FeatureCollection featureCollection = new FeatureCollection();
        for(Report report : reports) {
            HashMap<String, Object> properties = new HashMap<>();
            properties.put("date_string", report.getDateString());
            properties.put("location_string", report.getLocationString());
            properties.put("location_type", report.getLocationType());
            properties.put("data_field", report.getDataField());
            properties.put("data_field_code", report.getDataFieldCode());
            properties.put("time_period", report.getTimePeriod());
            properties.put("time_period_type", report.getTimePeriodType());
            properties.put("value", report.getValue());
            properties.put("unit", report.getUnit());

            if(report.getLocationString().split("-").length > 1) {
                String countryName = report.getLocationString().split("-")[0];
                String stateName = report.getLocationString().split("-")[1];
                System.out.println(countryName + " " + stateName);
                if(locationRepository.findByCountryNameAndStateName(countryName, stateName).size() != 0) {
                    featureCollection.addFeature(new Feature(locationRepository.findByCountryNameAndStateName(countryName, stateName).get(0).getGeom(), properties));
                }
            }
        }
        return new ResponseEntity(featureCollection, HttpStatus.MULTI_STATUS.OK);
    }
}
