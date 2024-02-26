package com.yaremax.notifierbot.api;

import com.yaremax.notifierbot.bot.MyTelegramBot;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventService {

    private final MyTelegramBot myTelegramBot;

    public void handleEvent(String region) {
        myTelegramBot.sendMessage(
                ("Time to be real! With region: " + region)
        );
    }
}
