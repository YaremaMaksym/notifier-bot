package com.yaremax.notifierbot.api;

import com.yaremax.notifierbot.MyTelegramBot;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventService {

    private final MyTelegramBot myTelegramBot;

    public void handleEvent() {
        myTelegramBot.sendMessageToPrimaryChat("⏰Ахтунх! Час бути ріл⏰");
    }
}
