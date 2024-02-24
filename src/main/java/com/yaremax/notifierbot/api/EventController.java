package com.yaremax.notifierbot.api;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/event")
@AllArgsConstructor
public class EventController {

    private final EventService eventService;

    @PostMapping
    public ResponseEntity<String> handleEvent(@RequestParam("region") String region) {
        log.info("Received webhook event for region: {}", region);

        if (!isValidRegion(region)) {
            log.info("Invalid region: {}", region);
//            return ResponseEntity.badRequest().body("Invalid region");
        }

        eventService.handleEvent();

        log.info("Webhook event processed successfully");
        return ResponseEntity.ok("Event processed successfully");
    }

    private boolean isValidRegion(String region) {
        return region.equals("us-central") || region.equals("europe-west") ||
                region.equals("asia-east") || region.equals("asia-west");
    }
}
