package com.microservices.limitsservice.Controllers;

import com.microservices.limitsservice.Beans.Limits;
import com.microservices.limitsservice.Configuration.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class limitsController {

    @Autowired
    private Config config;

    @GetMapping("/limits")
    public Limits getLimits(){

        return new Limits(config.getMin(),config.getMax());
    }
}
