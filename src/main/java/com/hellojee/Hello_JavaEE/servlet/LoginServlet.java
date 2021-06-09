package com.hellojee.Hello_JavaEE.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "LoginServlet", value = "/loginsubmit")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession curUser = req.getSession();
        curUser.setAttribute("user",req.getParameter("username"));//
        resp.sendRedirect(req.getContextPath()+"/Vues/Welcome.jsp");
    }
}
