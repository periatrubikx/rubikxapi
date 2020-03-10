package com.rubikx.rubikxworld.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sample")
public class GenericController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public void handleSamplePost(@RequestBody Object samplePayload) {
        logger.info(samplePayload.toString());
    }
}