package com.revature.comstar.web.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.comstar.models.Financials;
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

}


