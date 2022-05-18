package com.revature.comstar.services;

import com.revature.comstar.daos.TransactionDAO;
import com.revature.comstar.models.Transactions;

import java.util.List;

public class TransactionServices {

    TransactionDAO transactionDAO = new TransactionDAO();

    public Transactions create(Transactions newTransaction) {

        return transactionDAO.create(newTransaction);

    }

    public List<Transactions> findAll() {

        return transactionDAO.findAll();

    }

    public boolean update(Transactions updateTransaction) {

        return transactionDAO.update(updateTransaction);

    }

    public boolean delete(String id) {

        return transactionDAO.delete(id);

    }

}
