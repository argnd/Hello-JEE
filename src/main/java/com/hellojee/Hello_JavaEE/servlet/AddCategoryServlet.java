package com.hellojee.Hello_JavaEE.servlet;


import com.hellojee.Hello_JavaEE.dao.OtherDaoFactory;
import com.hellojee.Hello_JavaEE.entity.Category;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addcatservlet", value = "/auth/addCategory")
public class AddCategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Category c = new Category();
        c.setName("ssss");
        c.setId(14L);
        System.out.println(((Category)OtherDaoFactory.getMyJpaEntityDao().findById(c)).getName());
        resp.sendRedirect(req.getContextPath()+"/welcome");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Category c = new Category();
        c.setName("test");
        OtherDaoFactory.getMyJpaEntityDao().create(c);
        resp.sendRedirect(req.getContextPath()+"/welcome");
    }
}
