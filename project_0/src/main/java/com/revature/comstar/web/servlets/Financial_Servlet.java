package com.revature.comstar.web.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.comstar.models.Financials;
import com.revature.comstar.models.UserInformation;
import com.revature.comstar.services.FinancialServices;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Financial_Servlet extends HttpServlet {

    private final FinancialServices financialServices;
    private final ObjectMapper mapper;

    public Financial_Servlet(FinancialServices financialServices, ObjectMapper mapper) {
        this.financialServices = financialServices;
        this.mapper = mapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            List<Financials> users = financialServices.findAll();

            String payload = mapper.writeValueAsString(users);

            resp.getWriter().write(payload);
        } catch (Exception e){

            e.printStackTrace();

        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Financials financials = mapper.readValue(req.getInputStream(), Financials.class);
            Financials persistedFuser = financialServices.create(financials);

            String payload = mapper.writeValueAsString(persistedFuser);

            resp.getWriter().write("The following financial information has been added.\n");
            resp.getWriter().write(payload);
            resp.setStatus(201);
        } catch(Exception e) {
            resp.getWriter().write("Financial information has already been entered.");
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Financials reqFuser = mapper.readValue(req.getInputStream(), Financials.class);


        boolean updatedFinancials = financialServices.update(reqFuser);

        String payload = mapper.writeValueAsString(updatedFinancials);
        resp.getWriter().write(payload);
        resp.getWriter().write("Finances have been updated.");
        resp.setStatus(201);
    }

}


