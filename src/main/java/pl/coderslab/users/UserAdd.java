package pl.coderslab.users;

import pl.coderslab.constant.Constant;
import pl.coderslab.utils.User;
import pl.coderslab.utils.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (urlPatterns = "/user/add")
public class UserAdd extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/users/add.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String email = req.getParameter(Constant.EMAIL);
        String pass = req.getParameter(Constant.PASSWORD);

        UserDao userDao = new UserDao();
        User user = new User();
        user.setUsername(userName);
        user.setEmail(email);
        user.setPassword(userDao.hashPassword(pass));
        userDao.create(user);

        resp.sendRedirect(Constant.MAIN_PAGE_WITH_USERS_LIST);
    }
}
