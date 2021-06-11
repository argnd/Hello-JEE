package com.hellojee.Hello_JavaEE.servlet;

import com.hellojee.Hello_JavaEE.dao.OtherDaoFactory;
import com.hellojee.Hello_JavaEE.entity.Category;
import com.hellojee.Hello_JavaEE.entity.OtherProduct;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddProduct", value = "/auth/addproduct")
public class AddProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        Category c = new Category();
        List<Category> l = (List<Category>)OtherDaoFactory.getMyJpaEntityDao().findAll(c);
        req.setAttribute("listcat",l);

        RequestDispatcher rd = req.getRequestDispatcher("/Vues/AddProduct.jsp");
        rd.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        OtherProduct p = new OtherProduct();
        p.setName(req.getParameter("name"));
        p.setContent(req.getParameter("Content"));
        String sCategoryId =  req.getParameter("CategorySelect");
        Long lCategoryId = Long.parseLong(sCategoryId);
        Category c = new Category();
        c.setId(lCategoryId);
        p.setCat((Category) OtherDaoFactory.getMyJpaEntityDao().findById(c));
        OtherDaoFactory.getMyJpaEntityDao().create(p);

        resp.sendRedirect(req.getContextPath()+"/auth/listproduct");
    }
}
