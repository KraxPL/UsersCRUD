package pl.coderslab.users;

import pl.coderslab.constant.Constant;
import pl.coderslab.utils.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(Constant.MAIN_PAGE_WITH_USERS_LIST)
public class UserList extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();

        userDao.CreateUsersTable(); // creating Users Table in case it does not exist yet
        request.setAttribute("users", userDao.findAll());
        getServletContext().getRequestDispatcher("/users/list.jsp")
                .forward(request, response);

    }

}
