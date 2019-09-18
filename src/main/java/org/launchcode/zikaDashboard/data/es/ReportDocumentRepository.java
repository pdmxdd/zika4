package org.launchcode.zikaDashboard.data.es;

import org.elasticsearch.index.query.QueryBuilder;
import org.launchcode.zikaDashboard.models.es.ReportDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Iterator;
import java.util.List;

public interface ReportDocumentRepository extends ElasticsearchRepository<ReportDocument, String> {

    Iterable<ReportDocument> search(QueryBuilder queryBuilder);

    @Query("{\"fuzzy\": {\"locationString\": \"?0\"}}}")
    Page<ReportDocument> manualFuzzySearchOnLocationString(String locationString, Pageable pageable);

    @Query("{\"bool\": {\"must\": [{\"match\": {\"dateString\": \"?1\"}},{\"fuzzy\": {\"locationString\": \"?0\"}}]}}")
    Page<ReportDocument> manualFuzzySearchOnLocationStringMustMatchDate(String locationString, String dateString, Pageable pageable);

    @Query("{\"bool\": {\"must\": [{\"match\": {\"dateString\": \"?0\"}},{\"fuzzy\": {\"locationString\": \"?1\"}}]}}")
    List<ReportDocument> manuaFuzzySearchOnLocationStringMustMatchDateList(String dateString, String locationString);
}
