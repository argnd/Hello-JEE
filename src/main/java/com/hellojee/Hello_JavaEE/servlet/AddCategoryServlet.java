package com.hellojee.Hello_JavaEE.servlet;

import com.hellojee.Hello_JavaEE.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addcatservlet", value = "/auth/addCategory")
public class AddCategoryServlet extends HttpServlet {

    private EntityManagerFactory emf = null;

    @Override
    public void init() {
        this.emf = Persistence.createEntityManagerFactory("PU");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        EntityManager em = this.emf.createEntityManager();
        Category c = new Category();
        em.getTransaction().begin();
        em.persist(c);
        c.setName("Hello");
        em.getTransaction().commit();
        em.close();

        resp.sendRedirect(req.getContextPath()+"/Vues/Welcome.jsp");
    }

    @Override
    public void destroy() {
        this.emf.close();
    }
}
