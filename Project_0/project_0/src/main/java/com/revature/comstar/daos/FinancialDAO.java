package com.revature.comstar.daos;

import com.revature.comstar.models.Financials;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FinancialDAO implements CRUD<Financials> {


    @Override
    public Financials create(Financials newObject) {
        System.out.println(newObject);
        return null;
    }

    @Override
    public List<Financials> findAll() {
        List<Financials> users = new ArrayList<>();
        System.out.println("Neat, this works");
        return users;
    }

    @Override
    public boolean update(Financials updatedObj) {
        System.out.println("Keep it up");
        return false;
    }

    @Override
    public boolean delete(String id) {
        System.out.println("FinancialDAO has made bank");
        return false;
    }
}



