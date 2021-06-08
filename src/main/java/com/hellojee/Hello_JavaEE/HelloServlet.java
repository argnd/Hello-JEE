package com.hellojee.Hello_JavaEE;

import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "helloServlet", value = "/auth/hello")
public class HelloServlet extends HttpServlet {

    private String message;

    public void init() {
        message = "Hello JEE!";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<br>");
        out.println("Hello JEE");
        out.println("</body></html>");
    }

    public void destroy() {

    }

}