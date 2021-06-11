package com.hellojee.Hello_JavaEE.servlet;

import com.hellojee.Hello_JavaEE.dao.OtherDaoFactory;
import com.hellojee.Hello_JavaEE.entity.OtherProduct;
import com.mycommerce.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "removeprot", value = "/auth/removeproduct")
public class RemoveProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        OtherProduct p = new OtherProduct();
        p.setId(id);
        OtherDaoFactory.getMyJpaEntityDao().remove(p);

        res.sendRedirect(req.getContextPath()+"/auth/listproduct");
    }
}