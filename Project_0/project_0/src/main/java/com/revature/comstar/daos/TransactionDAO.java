package com.revature.comstar.daos;

import com.revature.comstar.models.Financials;
import com.revature.comstar.models.Transactions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO implements CRUD<Transactions> {


    @Override
    public Transactions create(Transactions newObject) {
        System.out.println(newObject);
        return null;
    }

    @Override
    public List<Transactions> findAll() {
        List<Transactions> users = new ArrayList<>();
        System.out.println("Oh, you're still here");
        return users;
    }

    @Override
    public boolean update(Transactions updatedObj) {
        System.out.println("The movie is over");
        return false;
    }

    @Override
    public boolean delete(String id) {
        System.out.println("Go home, the DAO is done");
        return false;
    }
}
