package com.yaremax.notifierbot.api;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/events")
@AllArgsConstructor
public class TestController {

    private final EventService eventService;

    @PostMapping(consumes = "application/x-www-form-urlencoded")
    public String handleRegion(@RequestBody String body) {

        log.info("Received POST request on /api/v1/events with body " + body);

        // body is in the format: region={{region}}
        String region = body.split("=")[1];

        eventService.handleEvent(region);

        return "Received region: " + region;
    }

}