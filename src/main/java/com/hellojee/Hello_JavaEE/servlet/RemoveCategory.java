package com.hellojee.Hello_JavaEE.servlet;

import com.hellojee.Hello_JavaEE.dao.OtherDaoFactory;
import com.hellojee.Hello_JavaEE.entity.Category;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "removecat", value = "/auth/removecategory")
public class RemoveCategory extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        Category p = new Category();
        p.setId(id);
        OtherDaoFactory.getMyJpaEntityDao().remove(p);

        res.sendRedirect(req.getContextPath()+"/auth/listcategory");
    }
}