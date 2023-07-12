package com.spring.dashboard.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/dashboard")
public class DashboardController {

    @GetMapping("/slow-service")
    public ResponseEntity<?> getSlowService() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(1000l);
        return new ResponseEntity<String>("slow-service-ok", HttpStatus.OK);
    }

    @GetMapping("/too-slow-service")
    public ResponseEntity<?> getVerySlowService() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(2000l);
        return new ResponseEntity<String>("too-slow-service-ok", HttpStatus.OK);
    }

    @GetMapping("/normal-service")
    public ResponseEntity<?> getNormalService() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        return new ResponseEntity<String>("normal-service-ok", HttpStatus.OK);
    }
}
