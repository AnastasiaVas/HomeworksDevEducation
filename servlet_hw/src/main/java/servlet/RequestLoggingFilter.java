
package servlet;

import data_resource.UsersList;
import models.User;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/RequestLoggingFilter")
public class RequestLoggingFilter implements Filter {

    UsersList usersList = new UsersList();
    private ServletContext context;

    public void init(FilterConfig fConfig) {
        this.context = fConfig.getServletContext();
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        User user = (User) req.getSession().getAttribute("user");

        HttpSession session = req.getSession(false);

        if(session == null || !usersList.authorization(user)){
            res.setStatus(HttpServletResponse.SC_FORBIDDEN);
            res.sendRedirect("login.html");
        }else {
            chain.doFilter(request, response);
        }
    }

}
