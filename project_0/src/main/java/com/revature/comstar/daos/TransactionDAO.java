package com.revature.comstar.daos;

import com.revature.comstar.models.Financials;
import com.revature.comstar.models.Transactions;
import com.revature.comstar.models.UserInformation;
import com.revature.comstar.util.DBConnection;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO implements CRUD<Transactions> {


    @Override
    public Transactions create(Transactions newObject) {

        try(Connection conn = DBConnection.getInstance().getConnection()) {

            String sql = "insert into transaction_history (date_posted, amount, financials_id) values (?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, newObject.getDatePosted());
            preparedStatement.setString(2, newObject.getAmount());
            preparedStatement.setInt(3, newObject.getFinancialsId());

            int check = preparedStatement.executeUpdate();
            if(check == 0){
                throw new RuntimeException("Something went wrong with Create. Oops");
            }

        }catch(SQLException p) {
            p.printStackTrace();
        }

        System.out.println(newObject);
        return null;
    }

    @Override
    public List<Transactions> findAll() {
        List<Transactions> users = new ArrayList<>();
        System.out.println("Oh, you're still here");

        try(Connection conn = DBConnection.getInstance().getConnection()) {

            String sql = "select * from transaction_history";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {

                Transactions user = new Transactions();
                user.setDatePosted(rs.getString("date_posted"));
                user.setAmount(rs.getString("amount"));
                user.setFinancialsId(rs.getInt("financials_id"));

                users.add(user);

            }

        }catch (SQLException p){

            p.printStackTrace();
            return null;

        }

        return users;
    }

    @Override
    public boolean update(Transactions updatedObj) {
        System.out.println("The movie is over");

        try(Connection conn = DBConnection.getInstance().getConnection()) {
            String sql = "update transaction_history set date_posted=?, amount=? where financials_id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, updatedObj.getDatePosted());
            preparedStatement.setString(2, updatedObj.getAmount());
            preparedStatement.setInt(3, updatedObj.getFinancialsId());


            int check = preparedStatement.executeUpdate();
            if(check == 0){
                throw new RuntimeException("Something went wrong with Transactions Update. Oops");
            }
            return true;
        }catch(SQLException p) {

            p.printStackTrace();

        }

        return false;
    }

    @Override
    public boolean delete(String id) {
        System.out.println("Go home, the DAO is done");
        return false;
    }
}
