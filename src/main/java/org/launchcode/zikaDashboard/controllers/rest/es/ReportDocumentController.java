package org.launchcode.zikaDashboard.controllers.rest.es;

import org.elasticsearch.index.query.FuzzyQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.launchcode.zikaDashboard.data.es.ReportDocumentRepository;
import org.launchcode.zikaDashboard.models.Report;
import org.launchcode.zikaDashboard.models.es.ReportDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping(value = "/api/es/")
public class ReportDocumentController {

    @Autowired
    ReportDocumentRepository reportDocumentRepository;

    @GetMapping("/search")
    public List<ReportDocument> search(@RequestParam("q") String q) {
        FuzzyQueryBuilder fuzzyQueryBuilder = QueryBuilders.fuzzyQuery("locationString", q);
        List<ReportDocument> reports = new ArrayList<>();
        Iterator<ReportDocument> iterator = reportDocumentRepository.search(fuzzyQueryBuilder).iterator();
        while(iterator.hasNext()) {
            reports.add(iterator.next());
        }
        System.out.println("Docs hit: " + reports.size());
        return reports;
    }

    @GetMapping("/search/fuzzy")
    public List<ReportDocument> searchQuery(@RequestParam("q") String q) {
        List<ReportDocument> reports = new ArrayList<>();
        Page<ReportDocument> pages = reportDocumentRepository.manualFuzzySearchOnLocationString(q, PageRequest.of(0, 250000));

        for(ReportDocument reportDocumet : pages) {
            reports.add(reportDocumet);
        }

        return reports;
    }

    @GetMapping("/search/fuzzy/date")
    public List<ReportDocument> searchFuzzyDate(@RequestParam("q") String q, @RequestParam("d") String d) {
        List<ReportDocument> reports = new ArrayList<>();
        Iterator<ReportDocument> iterator = reportDocumentRepository.manuaFuzzySearchOnLocationStringMustMatchDateList(d, q).iterator();
        while (iterator.hasNext()) {
            reports.add(iterator.next());
        }
        System.out.println("size: " + reports.size());
        return reports;
    }
    /*
    @GetMapping("/search/fuzzy/date")
    public List<ReportDocument> searchFuzzyDate(@RequestParam("q") String q, @RequestParam("d") String d) {
        List<ReportDocument> reports = new ArrayList<>();
        Page<ReportDocument> pages = reportDocumentRepository.manualFuzzySearchOnLocationStringMustMatchDate(q, d, PageRequest.of(0, 250000));
        for(ReportDocument reportDocument : pages) {
            reports.add(reportDocument);
        }
        return reports;
    }
     */
}
