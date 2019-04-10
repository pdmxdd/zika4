package org.launchcode.zikaDashboard;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@IntegrationTestConfig
public class ReportControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getReports() throws Exception {
        this.mockMvc.perform(get("/report"))
                .andExpect(status().isOk())
                .andExpect(jsonPath(("$.features"), hasSize(207)));
    }
}
