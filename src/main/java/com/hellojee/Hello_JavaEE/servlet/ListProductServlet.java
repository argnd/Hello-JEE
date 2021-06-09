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
import java.util.List;

@WebServlet(name = "ListProductServlet", value = "/auth/listproduct")
public class ListProductServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        List<Product>  ml = DaoFactory.getProductDao().getAllProducts();

        HttpSession curUser = req.getSession();
        curUser.setAttribute("liste",ml);//
        RequestDispatcher rd = req.getRequestDispatcher("/Vues/ListProduct.jsp");
        rd.forward(req, resp);
    }
}
