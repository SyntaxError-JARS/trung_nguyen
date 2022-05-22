package com.revature.comstar.web.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.comstar.models.UserInformation;
import com.revature.comstar.services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class User_Servlet extends HttpServlet{

        private final UserServices userServices;
        private final ObjectMapper mapper;

        public User_Servlet(UserServices userServices, ObjectMapper mapper) {
            this.userServices = userServices;
            this.mapper = mapper;
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            try {
                List<UserInformation> users = userServices.findAll();

                String payload = mapper.writeValueAsString(users);

                resp.getWriter().write(payload);
            } catch (Exception e){

                e.printStackTrace();

            }



        }


}
