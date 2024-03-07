package com.skillbox.cryptobot.bot.command;


import com.skillbox.cryptobot.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

@Service
@Slf4j
@AllArgsConstructor
public class GetSubscriptionCommand implements IBotCommand {

    private final UserService userService;

    @Override
    public String getCommandIdentifier() {
        return "get_subscription";
    }

    @Override
    public String getDescription() {
        return "Возвращает текущую подписку";
    }

    @Override
    public void processMessage(AbsSender absSender, Message message, String[] arguments) {

        SendMessage answer = new SendMessage();
        answer.setChatId(message.getChatId());
        Integer prise = userService.subscriptionWithdrawal(Math.toIntExact(message.getFrom().getId()));

        if (prise != null) {
            answer.setText("Вы подписаны на стоимость биткоина " + prise + " USD");
        } else answer.setText("Активные подписки отсутствуют");

        try {
            absSender.execute(answer);
        } catch (Exception e) {
            log.error("Ошибка возникла /subscriptionWithdrawal методе", e);
        }
    }
}