package com.hellojee.Hello_JavaEE;

import com.mycommerce.dao.DaoFactory;
import com.mycommerce.dao.ProductDao;
import com.mycommerce.model.Product;
import org.apache.taglibs.standard.lang.jstl.test.beans.Factory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "InsertSomeProductServlet", value = "/auth/basicinsert")
public class InsertSomeProductServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Product mp = new Product();
        mp.setContent("A THINGY THING");
        mp.setName("Product A");
        mp.setPrice(10f);
        DaoFactory.getProductDao().addProduct(mp);



        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1> Inserted "+ mp.getId()+" </h1>" );
        out.println("</body></html>");
    }
}
