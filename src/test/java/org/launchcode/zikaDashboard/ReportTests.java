package org.launchcode.zikaDashboard;

import org.junit.Test;
import org.launchcode.zikaDashboard.models.Report;
import static org.junit.Assert.assertEquals;

public class ReportTests {

    @Test
    public void testReportConstructor() {
        Report reportTest = new Report(
                "2016-04-02",
                "Brazil-Rondonia",
                "state",
                "zika_reported",
                "BR0011",
                "NA",
                "NA",
                618,
                "cases"
                );
        assertEquals(reportTest.getDateString(), "2016-04-02");
        assertEquals(reportTest.getLocationString(), "Brazil-Rondonia");
        assertEquals(reportTest.getLocationType(), "state");
    }
}
