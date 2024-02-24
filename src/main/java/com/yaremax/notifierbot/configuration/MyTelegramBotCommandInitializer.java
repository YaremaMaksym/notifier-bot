package com.yaremax.notifierbot.configuration;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.ICommandRegistry;

@Component
public class MyTelegramBotCommandInitializer implements InitializingBean {
    private final ICommandRegistry iCommandRegistry;
    private final IBotCommand[] iBotCommands;

    public MyTelegramBotCommandInitializer(ICommandRegistry iCommandRegistry, IBotCommand[] iBotCommands) {
        this.iCommandRegistry = iCommandRegistry;
        this.iBotCommands = iBotCommands;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        iCommandRegistry.registerAll(iBotCommands);
    }
}
