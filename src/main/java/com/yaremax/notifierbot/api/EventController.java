package com.yaremax.notifierbot.api;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/events")
@AllArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping
    public String getHello() {
        return "Hello";
    }

    @PostMapping
    public String handleEvent() {
        log.info("Received POST request on /api/v1/events");

        eventService.handleEvent();

        return "Received POST request";
    }

//    @PostMapping(consumes = "application/x-www-form-urlencoded")
//    public String handleEvent(@RequestBody String body) {
//        log.info("Received POST request on /api/v1/events with body " + body);
//
//        // body is in the format: region={{region}}
//        String region = body.split("=")[1];
//
//        eventService.handleEvent();
//
//        return "Received region: " + region;
//    }
}
