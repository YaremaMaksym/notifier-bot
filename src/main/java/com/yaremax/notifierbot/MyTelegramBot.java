package com.yaremax.notifierbot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
@Component
public class MyTelegramBot extends TelegramLongPollingBot {
    private final String botUsername;
    private final String primaryChatId;

    public MyTelegramBot(@Value("${bot.token}") String botToken,
                         @Value("${bot.username}") String username,
                         @Value("${bot.temp-chat-id}") String primaryChatId) {
        super(botToken);
        this.botUsername = username;
        this.primaryChatId = primaryChatId;
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    public void sendMessageToPrimaryChat(String text) {
        sendMessage(primaryChatId, text);
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String receivedText = update.getMessage().getText();
            String senderChatId = update.getMessage().getChatId().toString();
            log.info("Received message from {}: {}", senderChatId, receivedText);

            sendMessage(senderChatId, "You said: " + receivedText);
        }
    }

    private void sendMessage(String chatId, String text) {
        SendMessage message = SendMessage.builder()
                .chatId(chatId)
                .text(text)
                .build();
        try {
            execute(message);
        } catch (TelegramApiException e) {
            log.error("Failed to send message to {}: {}", chatId, text, e);
        }
    }
}
