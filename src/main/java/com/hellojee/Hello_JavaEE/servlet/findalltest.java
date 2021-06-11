package com.hellojee.Hello_JavaEE.servlet;


import com.hellojee.Hello_JavaEE.dao.OtherDaoFactory;
import com.hellojee.Hello_JavaEE.entity.Category;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "sds", value = "/list")
public class findalltest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Category c = new Category();
        List<Category> l = (List<Category>)OtherDaoFactory.getMyJpaEntityDao().findAll(c);
        for (Category category : l) {
            System.out.println(category.getName());
        }
        resp.sendRedirect(req.getContextPath()+"/welcome");
    }

}
