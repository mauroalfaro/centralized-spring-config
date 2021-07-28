package com.alfarosoft.centralizedconfig.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CentralizedConfigVersionController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(CentralizedConfigVersionController.class);

    @Value("${projectVersion}")
    private String projectVersion;

    @Value("${projectArtifactId}")
    private String projectArtifactId;

    @GetMapping("api/version")
    public String configServerVersion(){
        LOGGER.info("Fetching current version of Config Server");
        LOGGER.debug("Processing the request to get [{}] version of Config Server", projectVersion);
        return projectVersion;
    }
}
