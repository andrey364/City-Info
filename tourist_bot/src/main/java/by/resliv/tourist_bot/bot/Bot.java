package by.resliv.tourist_bot.bot;

import by.resliv.tourist_bot.service.CityInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@Slf4j
public class Bot extends TelegramLongPollingBot {
    @Value("${bot.name}")
    private String botUsername;

    @Value("${bot.token}")
    private String botToken;

    private final CityInfoService cityInfoService;

    public Bot(CityInfoService cityInfoService) {
        this.cityInfoService = cityInfoService;
    }

    public void sendMsq(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(text);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpdateReceived(Update update) {

        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            sendMsq(message, cityInfoService.getCityInfo(update.getMessage().getText()));
        }
    }

    public String getBotUsername() {
        return botUsername;
    }

    public String getBotToken() {
        return botToken;
    }
}
