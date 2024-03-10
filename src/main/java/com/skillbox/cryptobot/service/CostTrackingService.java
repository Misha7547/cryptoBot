package com.skillbox.cryptobot.service;

import com.skillbox.cryptobot.bot.CryptoBot;
import com.skillbox.cryptobot.model.Users;
import com.skillbox.cryptobot.utils.TextUtil;
import com.skillbox.cryptobot.utils.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


import java.io.IOException;
import java.util.List;
@Async
@Service
@EnableScheduling
public class CostTrackingService {

    @Autowired
    private CryptoBot cryptoBot;
    @Autowired
    private CryptoCurrencyService service;
    private UserDao usersDao = new UserDao();

    @Scheduled(fixedDelay = 200000)
    public void checkingSubscription() throws IOException {
        List<Users> userList = usersDao.findAll();

        for (Users user : userList) {
            if (user.getPriceUser() > service.getBitcoinPrice()) {
                answer(user.getIdUser());
            }
        }
    }

    public void answer(int idSuer) throws IOException {

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId((long) idSuer);
        sendMessage.setText("Пора покупать, стоимость биткоина " + TextUtil.toString(service.getBitcoinPrice()) + " USD");

        try {
            cryptoBot.execute(sendMessage);
            Thread.sleep(10000);
        } catch (TelegramApiException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
