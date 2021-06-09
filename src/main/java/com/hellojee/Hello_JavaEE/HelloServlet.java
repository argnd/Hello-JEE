package com.hellojee.Hello_JavaEE;

import com.mycommerce.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "helloServlet", value = "/auth/hello")
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        List<Product> l = new ArrayList<>();
        l.add(new Product(1L,"Hello","world",10f));
        l.add(new Product(2L,"I am a","Servlet",19f));
        l.add(new Product(3L,"Bye bye","world",140f));

        HttpSession curUser = req.getSession();
        curUser.setAttribute("liste",l);//
        RequestDispatcher rd = req.getRequestDispatcher("/Vues/ListProduct.jsp");
        rd.forward(req, res);
    }

}