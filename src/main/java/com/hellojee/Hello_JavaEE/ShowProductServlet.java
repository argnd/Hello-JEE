package com.hellojee.Hello_JavaEE;


import com.mycommerce.dao.DaoFactory;
import com.mycommerce.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ShowProductServlet", value = "/auth/showproduct")
public class ShowProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String p = req.getParameterValues("ID")[0];
        Product tmp =  DaoFactory.getProductDao().findProductById((long)Integer.parseInt(p));
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>ID :" + tmp.getId() + "</h1>");
        out.println("<br>");
        out.println("<h1>NAME :" + tmp.getName()+ "</h1>");
        out.println("<br>");
        out.println("<h1> CONTENT :" + tmp.getContent() + "</h1>");
        out.println("<br>");
        out.println("</body></html>");
    }
}
