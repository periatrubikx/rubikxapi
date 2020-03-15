package com.rubikx.rubikxworld.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        logIncomingRequest(request.getMethod(), request.getRequestURI(), null);
        return ResponseEntity.ok("{\"message\" : \"Success\"}");
    }

    private void logIncomingRequest(String methodType, String uri, String data) {
        logger.info("Incoming request : Method : {} -> URI {} -> Data : {}", methodType, uri, data);
    }
}
