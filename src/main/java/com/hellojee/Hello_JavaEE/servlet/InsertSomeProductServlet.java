package com.hellojee.Hello_JavaEE.servlet;

import com.mycommerce.dao.DaoFactory;
import com.mycommerce.model.Product;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InsertSomeProductServlet", value = "/auth/basicinsert")
public class InsertSomeProductServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {

        Product mp = new Product();
        mp.setContent("Some OtherProduct");
        mp.setName("OtherProduct A");
        mp.setPrice(10f);
        DaoFactory.getProductDao().addProduct(mp);
        res.sendRedirect(req.getContextPath()+"/welcome");

    }
}
