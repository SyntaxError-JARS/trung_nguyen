package com.revature.comstar.services;

import com.revature.comstar.daos.FinancialDAO;
import com.revature.comstar.models.Financials;

import java.util.List;

public class FinancialServices {

    private final FinancialDAO financialDAO;

    public FinancialServices(FinancialDAO financialDAO) {

        this.financialDAO = financialDAO;

    }

    public Financials create(Financials userBalance) {

        return financialDAO.create(userBalance);

    }

    public List<Financials> findAll(){

        return financialDAO.findAll();

    }

    public boolean update(Financials newBalance) {

        return financialDAO.update(newBalance);

    }

    public boolean delete(String id) {

        return financialDAO.delete(id);

    }


}
