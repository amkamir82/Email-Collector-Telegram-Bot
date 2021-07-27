import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Dictionary;
import java.util.HashMap;

public class Bot extends TelegramLongPollingBot {
    private HashMap<String, String> email = new HashMap<String, String>();
    SendMessage messageSender = new SendMessage();

    @Override
    public String getBotUsername() {
        return "Dutchman_Email_Collector_Bot";
    }

    @Override
    public String getBotToken() {
        return "1931377396:AAG3c7ZnbXCcbi3oPeppT_St6zaFVvlQQw0";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.getMessage().getText().equals("/AddEmail")) {
            messageSender.setChatId(update.getMessage().getChatId().toString());
            messageSender.setText("send your email");
            try {
                execute(messageSender);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

        }
    }
}
