package com.hellojee.Hello_JavaEE;

import com.mycommerce.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "helloServlet", value = "/index.jsp")
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.sendRedirect(req.getContextPath()+"/Vues/Welcome.jsp");
    }

}