import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        SendMessage message = new SendMessage();
        Schedule schedule = new Schedule();
        //message.setText(update.getMessage().getText());
        message.setText(schedule.Schedule());
        message.setChatId(update.getMessage().getChatId());
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getBotUsername() {
        return "miu_timetable_bot";
    }

    @Override
    public String getBotToken() {
        return "703879629:AAHG_8cd7B0j3cUomvjnrFJzHiyXKHgrWJE";
    }
}
