package com.hellojee.Hello_JavaEE.servlet;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "WelcomeLogged", value = "/auth/welcomelogged")
public class WelcomeLogged extends HttpServlet {

    protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        RequestDispatcher rd = req.getRequestDispatcher("/Vues/WelcomeLogged.jsp");
        rd.forward(req, res);
    }

}