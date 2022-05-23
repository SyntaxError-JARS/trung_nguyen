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

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            try {
                UserInformation userInformation = mapper.readValue(req.getInputStream(), UserInformation.class);
                UserInformation persistedUser = userServices.create(userInformation);

                String payload = mapper.writeValueAsString(persistedUser);

                resp.getWriter().write("The following user information has been added.\n");
                resp.getWriter().write(payload);
                resp.setStatus(201);
            } catch(Exception e){
                resp.getWriter().write("User has already been registered.");
            }

        }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserInformation reqUser = mapper.readValue(req.getInputStream(), UserInformation.class);

            boolean updatedUser = userServices.update(reqUser);

            String payload = mapper.writeValueAsString(updatedUser);
            resp.getWriter().write(payload);
            resp.getWriter().write("User has been updated.");
            resp.setStatus(201);
        }
}
