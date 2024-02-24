package com.yaremax.notifierbot.bot.command;

import com.yaremax.notifierbot.bot.constants.TextCommands;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

@Component
public class DemoTextCommand extends BaseTextCommand {

    public DemoTextCommand(
            @Value(TextCommands.DEMO_TEXT_COMMAND) String textCommandIdentified,
            @Value("") String description) {
        super(textCommandIdentified, description);
    }

    @Override
    @SneakyThrows
    public void processMessage(AbsSender absSender, Message message, String[] strings) {
        var sendMessage = SendMessage.builder()
                .text("I'm reply markup response")
                .chatId(message.getChatId())
                .build();
        absSender.execute(sendMessage);
    }
}
