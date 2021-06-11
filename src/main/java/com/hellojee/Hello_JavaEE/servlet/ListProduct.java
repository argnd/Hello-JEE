package com.hellojee.Hello_JavaEE.servlet;

import com.hellojee.Hello_JavaEE.dao.OtherDaoFactory;
import com.hellojee.Hello_JavaEE.entity.OtherProduct;
import com.mycommerce.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListProduct", value = "/auth/listproduct")
public class ListProduct extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        OtherProduct p = new OtherProduct();
        List<OtherProduct> l = (List<OtherProduct>) OtherDaoFactory.getMyJpaEntityDao().findAll(p);
        req.setAttribute("listprod",l);
        RequestDispatcher rd = req.getRequestDispatcher("/Vues/ListProduct.jsp");
        rd.forward(req, res);
    }
}
