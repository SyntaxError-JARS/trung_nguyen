package com.revature.comstar.web.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.comstar.models.Transactions;
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

}
