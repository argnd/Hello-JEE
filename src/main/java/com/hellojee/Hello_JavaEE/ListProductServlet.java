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
import java.util.List;

@WebServlet(name = "ListProductServlet", value = "/auth/listproduct")
public class ListProductServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        List<Product>  ml = DaoFactory.getProductDao().getAllProducts();

        // Hello
        PrintWriter out = resp.getWriter();

        for (int i = 0; i < ml.size(); i++) {
            out.println("<html><body>");
            out.println("<h1>Hello JEE " + ml.get(i).getContent()  + " Bye JEE</h1>");
            out.println("</body></html>");
        }
    }
}
