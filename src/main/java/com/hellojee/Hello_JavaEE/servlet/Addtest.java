package com.hellojee.Hello_JavaEE.servlet;


import com.hellojee.Hello_JavaEE.dao.OtherDaoFactory;
import com.hellojee.Hello_JavaEE.entity.Category;
import com.hellojee.Hello_JavaEE.entity.OtherProduct;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addcatservlet", value = "/add")
public class Addtest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Category c = new Category();
        c.setName("updated");
        c.setId(1L);
        OtherDaoFactory.getMyJpaEntityDao().update(c);
        resp.sendRedirect(req.getContextPath()+"/welcome");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        OtherProduct p = new OtherProduct();
        Category c = new Category();
        c.setName("test");
        OtherDaoFactory.getMyJpaEntityDao().create(c);
        p.setCat((Category) OtherDaoFactory.getMyJpaEntityDao().findById(c));
        p.setName("hello");
        p.setContent("world");
        p.setPrice(37L);
        OtherDaoFactory.getMyJpaEntityDao().create(p);
        resp.sendRedirect(req.getContextPath()+"/welcome");
    }
}
