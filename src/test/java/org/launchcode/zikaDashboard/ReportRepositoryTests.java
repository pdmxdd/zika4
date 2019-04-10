package org.launchcode.zikaDashboard;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.launchcode.zikaDashboard.data.ReportRepository;
import org.launchcode.zikaDashboard.models.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.Assert.assertEquals;


import java.util.List;

@RunWith(SpringRunner.class)
@IntegrationTestConfig
public class ReportRepositoryTests {

    @Autowired
    private ReportRepository reportRepository;

    @Test
    public void testGetAllReports() throws Exception {
        List<Report> reportList = reportRepository.findAll();
        assertEquals(reportList.size(), 254);
    }
}
