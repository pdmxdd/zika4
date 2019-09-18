package org.launchcode.zikaDashboard.controllers;

import org.launchcode.zikaDashboard.util.EsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/util/es")
public class EsController {

    @Autowired
    private EsUtil esUtil;

    @GetMapping(value = "/refresh")
    public String esRefresh() {
        esUtil.refresh();
        return "success?";
    }
}
