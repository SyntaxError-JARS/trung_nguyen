package com.revature.comstar.daos;

import com.revature.comstar.models.*;
import com.revature.comstar.util.DBConnection;
import org.postgresql.util.PSQLException;

import java.io.IOException;
import java.sql.*;
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

        try(Connection conn = DBConnection.getInstance().getConnection()) {

            String sql = "select * from user_information";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {

                UserInformation user = new UserInformation();
                user.setFname(rs.getString("first_name"));
                user.setLname(rs.getString("last_name"));
                user.setUname(rs.getString("user_name"));
                user.setPassword(rs.getString("pass_word"));
                user.setEmail(rs.getString("email"));

                users.add(user);

            }

        }catch (SQLException p){

            p.printStackTrace();
            return null;

        }

        return users;
    }

    @Override
    public boolean update(UserInformation updatedObj) {
        System.out.println("Nice, you got this working");

        try(Connection conn = DBConnection.getInstance().getConnection()) {
            String sql = "update user_information set first_name=?, last_name=?, pass_word=?, email=? where user_name=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, updatedObj.getFname());
            preparedStatement.setString(2, updatedObj.getLname());
            preparedStatement.setString(3, updatedObj.getPassword());
            preparedStatement.setString(4, updatedObj.getEmail());
            preparedStatement.setString(5, updatedObj.getUname());


            int check = preparedStatement.executeUpdate();
            if(check == 0){
                throw new RuntimeException("Something went wrong with User Information Update. Oops");
            } else {
                System.out.println("Records updated");
            }
            return true;
            }catch(SQLException p) {

            p.printStackTrace();

            }

        return false;
    }

    @Override
    public boolean delete(String id) {
        System.out.println("Great, UserDAO did all its things.");

        try (Connection conn = DBConnection.getInstance().getConnection()) {

            String sql = "delete from user_information where user_name = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, id);

            int check = preparedStatement.executeUpdate();
            if (check == 0) {
                throw new RuntimeException("Something went wrong with deleting User Information. Oops");

            } else {
                System.out.println("User Information deletion successful");
            }
            return true;

        } catch (SQLException p) {

            p.printStackTrace();

        }
        return false;
    }


}
