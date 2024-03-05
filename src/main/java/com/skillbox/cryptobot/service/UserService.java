package com.skillbox.cryptobot.service;


import com.skillbox.cryptobot.model.Users;
import com.skillbox.cryptobot.utils.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {

    private UserDao usersDao = new UserDao();

    public void getUser(String uuid, int idUser) {

        List<Users> userList = usersDao.findAll();
        int j = 0;

        for (Users user : userList) {
            if (user.getUuid().equals(uuid) && user.getIdUser() == idUser)
                j++;
        }
        if (j == 0) {
            Users users = new Users();
            users.setUuid(uuid);
            users.setIdUser(idUser);
            usersDao.save(users);
        }
    }
}
