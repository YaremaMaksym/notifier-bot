package com.yaremax.berealnotifierbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.telegram.telegrambots.starter.TelegramBotStarterConfiguration;

@SpringBootApplication
@Import(TelegramBotStarterConfiguration.class)
public class BerealNotifierBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(BerealNotifierBotApplication.class, args);
    }

}
