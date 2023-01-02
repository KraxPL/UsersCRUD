package pl.coderslab.users;

import pl.coderslab.utils.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user/list")
public class UserList extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        PrintWriter out = response.getWriter();

        userDao.CreateDatabase(); //creating database in case it does not exist yet WIP
        getServletContext().getRequestDispatcher("/users/list.jsp")
                .forward(request, response);

    }

}
