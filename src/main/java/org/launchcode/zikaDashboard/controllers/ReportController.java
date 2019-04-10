package org.launchcode.zikaDashboard.controllers;

import org.launchcode.zikaDashboard.data.ReportRepository;
import org.launchcode.zikaDashboard.features.Feature;
import org.launchcode.zikaDashboard.features.FeatureCollection;
import org.launchcode.zikaDashboard.models.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.Null;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "/report")
public class ReportController {
    @Autowired
    private ReportRepository reportRepository;

    @GetMapping
    @ResponseBody
    public FeatureCollection getReports() {
        List<Report> reports = reportRepository.findAll();
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
            if(report.getLocation() != null) {
                featureCollection.addFeature(new Feature(report.getLocation(), properties));
            }
        }
        return featureCollection;
    }
}
