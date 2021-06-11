package com.hellojee.Hello_JavaEE.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowCategory {
    @WebServlet(name = "ShowProduct", value = "/auth/showproduct")
    public class ShowProduct extends HttpServlet {

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            RequestDispatcher rd = req.getRequestDispatcher("/Vues/ShowCategory.jsp");
            rd.forward(req, resp);
        }
    }
}
