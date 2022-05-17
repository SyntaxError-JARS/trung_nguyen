package com.revature.comstar;

import com.revature.comstar.models.Financials;
import com.revature.comstar.models.Transactions;
import com.revature.comstar.models.UserInformation;
import com.revature.comstar.services.FinancialServices;
import com.revature.comstar.services.TransactionServices;
import com.revature.comstar.services.UserServices;

import java.io.*;

public class MainDriver {

    public static void main(String[] args) {

        UserServices userServices = new UserServices();
        UserInformation newUser = new UserInformation("John", "Smith", "JSmith", "password", "JSmith@mail.com");
        userServices.create(newUser);

        userServices.findAll();

        UserInformation updatedUser = new UserInformation("Alice", "Smith", "ASmith", "password2", "AS@mail.com");
        userServices.update(updatedUser);

        UserInformation userInfo = new UserInformation("John","Smith", "JSmith", "password3", "JSmith@mail.com");
        userServices.delete(String.valueOf(userInfo));

        FinancialServices financialServices = new FinancialServices();
        Financials userBalance = new Financials("JSmith", "some balance", "another balance");
        financialServices.create(userBalance);

        financialServices.findAll();

        Financials newBalance = new Financials("JSmith", "10,000", "placeholder");
        financialServices.update(newBalance);

        Financials userFinances = new Financials("JSmith", "where", "money?");
        financialServices.delete(String.valueOf(userFinances));

        TransactionServices transactionServices = new TransactionServices();
        Transactions newTransaction = new Transactions("JSmith", "May 20 3052", "$20,000", 1);
        transactionServices.create(newTransaction);

        transactionServices.findAll();

        Transactions updatedTransaction = new Transactions("JSmith", "May 4 2022", "$3.50", 1);
        transactionServices.update(updatedTransaction);

        Transactions rmvTransactions = new Transactions("ASmith", "Oct 10 2010", "$60.00", 2);
        transactionServices.delete(String.valueOf(rmvTransactions));



    }

}