package com.yaremax.notifierbot.api;

import com.yaremax.notifierbot.bot.MyTelegramBot;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventService {

    private final MyTelegramBot myTelegramBot;

    public void handleEvent() {

        myTelegramBot.sendMessage(
                "662129866",
                "Time to be real"
        );
    }
}
