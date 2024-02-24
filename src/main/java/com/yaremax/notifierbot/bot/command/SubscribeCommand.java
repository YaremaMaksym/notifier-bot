package com.yaremax.notifierbot.bot.command;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class SubscribeCommand extends BaseTextCommand {

    public SubscribeCommand(String textCommandIdentified, String description) {
        super(textCommandIdentified, description);
    }

    @Override
    public void processMessage(AbsSender absSender, Message message, String[] strings) {

    }
}
