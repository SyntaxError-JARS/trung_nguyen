package com.revature.comstar.services;

import com.revature.comstar.daos.UserDAO;
import com.revature.comstar.models.UserInformation;

import java.util.List;

public class UserServices {

    private final UserDAO userDAO;

    public UserServices(UserDAO userDao) {

        this.userDAO = userDao;

    }

    public UserInformation create(UserInformation newUser) {

        return userDAO.create(newUser);


    }

    public List<UserInformation> findAll() {
        return userDAO.findAll();
    }

    public boolean update(UserInformation updatedUser) {

        return userDAO.update(updatedUser);

    }

    public boolean delete(String id) {
        return userDAO.delete(id);
    }



}
