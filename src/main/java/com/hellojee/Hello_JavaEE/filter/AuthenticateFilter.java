package com.hellojee.Hello_JavaEE.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(value = "/auth/b/*")
public class AuthenticateFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession sc = request.getSession();
        if (sc.getAttribute("user") !=  null){
            filterChain.doFilter(req, resp);
        } else {
            response.sendRedirect("http://localhost:8080/Hello_JavaEE_war_exploded/");
        }
    }
}
