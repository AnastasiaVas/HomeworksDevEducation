package servlet;

import data_resource.UsersList;
import models.User;

import java.io.IOException;
import java.io.PrintWriter;
import org.apache.log4j.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {


    private static final Logger log = Logger.getLogger(LoginServlet.class);

    UsersList usersList = new UsersList();

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        User user = new User(login, pwd);

        log.info(usersList.authorization(user));
        log.info(login + " " + pwd);
    if (usersList.authorization(user)) {
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        response.setStatus(HttpServletResponse.SC_OK);
        response.sendRedirect("LoginSuccess.jsp");
    } else {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
        PrintWriter out = response.getWriter();
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        out.println("<font color=red>Either user name or password is wrong.</font>");
        rd.include(request, response);
    }
}

}