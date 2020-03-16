package com.rubikx.rubikxworld.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriUtils;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "/sample")
public class GenericController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping(path = "/")
    public ResponseEntity handleSamplePost(HttpServletRequest request, @RequestBody String samplePayload) {
        logIncomingRequest(request.getMethod(), request.getRequestURI(), samplePayload);
        return ResponseEntity.ok("{\"message\" : \"Success\"}");
    }


    @GetMapping(path = "/")
    public ResponseEntity<String> handleSampleGet(HttpServletRequest request) {
        logIncomingRequest(request.getMethod(), request.getRequestURL().toString(), request.getQueryString());
        return ResponseEntity.ok("{\"message\" : \"Success\"}");
    }

    private void logIncomingRequest(String methodType, String uri, String data) {
        if(!StringUtils.isEmpty(data)) {
            data = UriUtils.decode(data, "UTF-8");
        }
        logger.info("Incoming request : Method : {} -> URI {} -> Data : {}", methodType, uri, data);
    }
}
