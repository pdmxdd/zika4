package org.launchcode.zikaDashboard.util;

import org.launchcode.zikaDashboard.data.ReportRepository;
import org.launchcode.zikaDashboard.data.es.ReportDocumentRepository;
import org.launchcode.zikaDashboard.models.Report;
import org.launchcode.zikaDashboard.models.es.ReportDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EsUtil {

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private ReportDocumentRepository reportDocumentRepository;

    public void refresh() {
        reportDocumentRepository.deleteAll();
        List<ReportDocument> reportDocuments = new ArrayList<>();
        for(Report report : reportRepository.findAll()) {
            reportDocuments.add(new ReportDocument(report));
            if(reportDocuments.size() == 1000) {
                reportDocumentRepository.saveAll(reportDocuments);
                reportDocuments.clear();
            }
        }
        reportDocumentRepository.saveAll(reportDocuments);
        reportDocuments.clear();
    }
}
