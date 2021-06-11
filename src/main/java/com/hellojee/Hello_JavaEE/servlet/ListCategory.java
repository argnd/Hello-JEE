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
import java.util.List;

@WebServlet(name = "sds", value = "/auth/listcategory")
public class ListCategory extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        Category c = new Category();
        List<Category> l = (List<Category>)OtherDaoFactory.getMyJpaEntityDao().findAll(c);
        req.setAttribute("listcat",l);
        RequestDispatcher rd = req.getRequestDispatcher("/Vues/ListCategory.jsp");
        rd.forward(req, res);
    }
}
