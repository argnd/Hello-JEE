package com.hellojee.Hello_JavaEE.servlet;


import com.hellojee.Hello_JavaEE.dao.OtherDaoFactory;
import com.hellojee.Hello_JavaEE.entity.Category;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addcatservlet", value = "/auth/addcategory")
public class AddCategory extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        RequestDispatcher rd = req.getRequestDispatcher("/Vues/AddCategory.jsp");
        rd.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Category c = new Category();
        c.setName(req.getParameter("name"));
        Boolean created = OtherDaoFactory.getMyJpaEntityDao().create(c);

        resp.sendRedirect(req.getContextPath()+"/auth/listcategory");
    }
}
