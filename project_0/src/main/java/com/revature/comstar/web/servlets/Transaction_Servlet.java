package com.revature.comstar.web.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.comstar.models.Financials;
import com.revature.comstar.models.Transactions;
import com.revature.comstar.models.UserInformation;
import com.revature.comstar.services.TransactionServices;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Transaction_Servlet extends HttpServlet {

    private final TransactionServices transactionServices;
    private final ObjectMapper mapper;

    public Transaction_Servlet(TransactionServices transactionServices, ObjectMapper mapper) {
        this.transactionServices = transactionServices;
        this.mapper = mapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            List<Transactions> users = transactionServices.findAll();

            String payload = mapper.writeValueAsString(users);

            resp.getWriter().write(payload);
        } catch (Exception e) {

            e.printStackTrace();

        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Transactions transactions = mapper.readValue(req.getInputStream(), Transactions.class);
        Transactions persistedTuser = transactionServices.create(transactions);

        String payload = mapper.writeValueAsString(persistedTuser);

        resp.getWriter().write("The following transaction information has been added.\n");
        resp.getWriter().write(payload);
        resp.setStatus(201);

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Transactions reqTuser = mapper.readValue(req.getInputStream(), Transactions.class);


        boolean updatedTransactions = transactionServices.update(reqTuser);

        String payload = mapper.writeValueAsString(updatedTransactions);
        resp.getWriter().write(payload);
        resp.getWriter().write("Transactions have been updated.");
        resp.setStatus(201);
    }

}
