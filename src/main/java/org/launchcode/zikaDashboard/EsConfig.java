package org.launchcode.zikaDashboard;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EsConfig {

    @Value("${es.index-name}")
    private String indexName;

    public String getIndexName() {
        return this.indexName;
    }

    public String setIndexName() {
        return this.indexName;
    }
}
