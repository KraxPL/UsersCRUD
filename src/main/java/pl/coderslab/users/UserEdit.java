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
import java.util.ArrayList;

@WebServlet("/user/edit")
public class UserEdit extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int intID = -1;
        try {
            intID = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        UserDao userDao = new UserDao();
        ArrayList<String> userData = userDao.read(intID);
        req.setAttribute("username", userData.get(1));
        req.setAttribute("email", userData.get(0));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/users/edit.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String email = req.getParameter("email");
        String pass = req.getParameter("password");
        String id = req.getParameter("id");
        int intID = -1;
        try {
            intID = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


        UserDao userDao = new UserDao();
        User user = new User();
        user.setId(intID);
        user.setUsername(userName);
        user.setEmail(email);
        user.setPassword(userDao.hashPassword(pass));
        userDao.update(user);

        resp.sendRedirect(Constant.MAIN_PAGE_WITH_USERS_LIST);
    }
}
