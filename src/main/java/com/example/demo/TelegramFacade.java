package com.example.demo;


import lombok.AccessLevel;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TelegramFacade {


    TelegramBotConfig telegramBotConfig;


    public TelegramFacade(TelegramBotConfig telegramBotConfig) {

        this.telegramBotConfig = telegramBotConfig;
    }


    @SneakyThrows
    public BotApiMethod<?> handleUpdate(Update update) {

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId());
        sendMessage.setText(update.getMessage().getText());
        return sendMessage;
    }


}

