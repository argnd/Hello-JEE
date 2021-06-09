package com.hellojee.Hello_JavaEE.servlet;


import com.mycommerce.dao.DaoFactory;
import com.mycommerce.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "ShowProductServlet", value = "/auth/showproduct")
public class ShowProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String p = req.getParameterValues("ID")[0]; // getelementbyid return array
        Product tmp = DaoFactory.getProductDao().findProductById((long) Integer.parseInt(p));

        HttpSession curUser = req.getSession();
        curUser.setAttribute("product", tmp);//
        RequestDispatcher rd = req.getRequestDispatcher("/Vues/ShowProduct.jsp");
        rd.forward(req, resp);
    }
}
