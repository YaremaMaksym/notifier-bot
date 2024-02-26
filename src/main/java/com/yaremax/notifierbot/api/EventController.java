package com.yaremax.notifierbot.api;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/event")
@AllArgsConstructor
public class EventController {

    private final EventService eventService;

    @PostMapping
    public ResponseEntity<String> handleEvent() {
//        log.info("Received webhook event for region: {}", regionRequest.region());
//        if (!isValidRegion(regionRequest.region())) {
//            log.info("Invalid region: {}", regionRequest.region());
////            return ResponseEntity.badRequest().body("Invalid region");
//        }
        log.info("Received POST request on /api/v1/event");

        eventService.handleEvent();

        return ResponseEntity.ok("Event processed successfully");
    }

    private boolean isValidRegion(String region) {
        return region.equals("us-central") || region.equals("europe-west") ||
                region.equals("asia-east") || region.equals("asia-west");
    }
}
