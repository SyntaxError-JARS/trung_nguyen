package com.revature.comstar.daos;

import com.revature.comstar.models.Financials;
import com.revature.comstar.models.UserInformation;
import com.revature.comstar.util.DBConnection;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FinancialDAO implements CRUD<Financials> {


    @Override
    public Financials create(Financials newObject) {
        System.out.println(newObject);
        try(Connection conn = DBConnection.getInstance().getConnection()) {

            String sql = "insert into financials (user_name, checkings_balance, savings_balance) values (?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, newObject.getUserName());
            preparedStatement.setString(2, newObject.getChecking());
            preparedStatement.setString(3, newObject.getSavings());


            int check = preparedStatement.executeUpdate();
            if(check == 0){
                throw new RuntimeException("Something went wrong with Create. Oops");
            }

            return newObject;

        }catch (SQLException p){
            p.printStackTrace();
            return null;
        }

    }

    @Override
    public List<Financials> findAll() {
        List<Financials> users = new ArrayList<>();
        System.out.println("Neat, this works");

        try(Connection conn = DBConnection.getInstance().getConnection()) {

            String sql = "select * from financials";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {

                Financials user = new Financials();
                user.setUserName(rs.getString("user_name"));
                user.setChecking(rs.getString("checkings_balance"));
                user.setSavings(rs.getString("savings_balance"));

                users.add(user);

            }

        }catch (SQLException p) {

            p.printStackTrace();
            return null;
        }

        return users;
    }

    @Override
    public boolean update(Financials updatedObj) {
        System.out.println("Keep it up");

        try(Connection conn = DBConnection.getInstance().getConnection()) {
            String sql = "update financials set checkings_balance=?, savings_balance=? where user_name=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, updatedObj.getUserName());
            preparedStatement.setString(2, updatedObj.getChecking());
            preparedStatement.setString(3, updatedObj.getSavings());


            int check = preparedStatement.executeUpdate();
            if(check == 0){
                throw new RuntimeException("Something went wrong with the Financial Update. Oops");
            }
            return true;
        }catch(SQLException p) {

            p.printStackTrace();

        }

        return false;
    }

    @Override
    public boolean delete(String id) {
        System.out.println("FinancialDAO has made bank");
        return false;
    }
}



