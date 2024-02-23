package com.yaremax.berealnotifierbot.bot.command;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;


public abstract class BaseTextCommand implements IBotCommand {
    private final String textCommandIdentified;
    private final String description;

    public BaseTextCommand(String textCommandIdentified, String description) {
        this.textCommandIdentified = textCommandIdentified;
        this.description = description;
    }

    @Override
    public String getCommandIdentifier() {
        return textCommandIdentified;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
