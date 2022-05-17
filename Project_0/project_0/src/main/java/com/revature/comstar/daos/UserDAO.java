package com.revature.comstar.daos;

import com.revature.comstar.models.*;
import com.revature.comstar.util.DBConnection;
import org.postgresql.util.PSQLException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements CRUD<UserInformation> {


    @Override
    public UserInformation create(UserInformation newUser) {
        System.out.println(newUser);
        try(Connection conn = DBConnection.getInstance().getConnection()) {
            //double quotes are String Literals
            String sql = "insert into user_information (first_name, last_name, user_name, pass_word, email) values (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, newUser.getFname());
            preparedStatement.setString(2, newUser.getLname());
            preparedStatement.setString(3, newUser.getUname());
            preparedStatement.setString(4, newUser.getPassword());
            preparedStatement.setString(5, newUser.getEmail());

            int check = preparedStatement.executeUpdate();
            if(check == 0){
                throw new RuntimeException("Something went wrong with Create. Oops");
            }
            return newUser;


        }catch (SQLException p){

            p.printStackTrace();
            return null;
        }

    }

    @Override
    public List<UserInformation> findAll(){
        List<UserInformation> users = new ArrayList<>();
        System.out.println("Hello");
        //users.add();
        return users;
    }

    @Override
    public boolean update(UserInformation updatedObj) {
        System.out.println("Nice, you got this working");
        return false;
    }

    @Override
    public boolean delete(String id) {
        System.out.println("Great, UserDAO did all its things.");
        return false;
    }
}
