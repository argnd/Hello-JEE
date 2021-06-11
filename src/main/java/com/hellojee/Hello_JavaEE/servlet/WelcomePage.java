package com.hellojee.Hello_JavaEE.servlet;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "WelcomePage", value = "/welcome")
public class WelcomePage extends HttpServlet {

    protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        RequestDispatcher rd = req.getRequestDispatcher("/Vues/Welcome.jsp");
        rd.forward(req, res);
    }

}