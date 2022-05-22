package com.revature.comstar.web.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.comstar.daos.FinancialDAO;
import com.revature.comstar.daos.TransactionDAO;
import com.revature.comstar.services.FinancialServices;
import com.revature.comstar.services.TransactionServices;
import com.revature.comstar.services.UserServices;
import com.revature.comstar.web.servlets.Financial_Servlet;
import com.revature.comstar.web.servlets.Transaction_Servlet;
import com.revature.comstar.web.servlets.User_Servlet;
import com.revature.comstar.daos.UserDAO;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ObjectMapper mapper = new ObjectMapper();

        UserDAO userDao = new UserDAO();
        UserServices userServices = new UserServices(userDao);

        FinancialDAO financialDAO = new FinancialDAO();
        FinancialServices financialServices = new FinancialServices(financialDAO);

        TransactionDAO transactionDAO = new TransactionDAO();
        TransactionServices transactionServices = new TransactionServices(transactionDAO);

        //AuthServlet authServlet = new AuthServlet(userServices, mapper);
        User_Servlet userServlet = new User_Servlet(userServices, mapper);
        Financial_Servlet financialServlet = new Financial_Servlet(financialServices, mapper);
        Transaction_Servlet transactionServlet = new Transaction_Servlet(transactionServices, mapper);

        ServletContext context = sce.getServletContext();
        //context.addServlet("AuthServlet", authServlet).addMapping("/auth");
        context.addServlet("User_Servlet", userServlet).addMapping("/users/*");
        context.addServlet("Financial_Servlet", financialServlet).addMapping("/fusers/*");
        context.addServlet("Transaction_Servlet", transactionServlet).addMapping("/tusers/*");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }
}