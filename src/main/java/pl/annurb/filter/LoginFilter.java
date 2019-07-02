package pl.annurb.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter({"/*"})
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        if (requiresLogin(request)) {
            HttpSession session = request.getSession();
            if (session.getAttribute("loggedUser") == null) {
                response.sendRedirect("/login");
            } else {
                chain.doFilter(request, response);
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    private boolean requiresLogin(HttpServletRequest request) {

        String url = request.getRequestURI();

        if (url.contains("login")) return false;
        if (url.contains("signup")) return false;

        return true;
    }
}