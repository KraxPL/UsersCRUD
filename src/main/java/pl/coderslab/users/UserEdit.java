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
        int intID = Constant.getIntID(req);

        UserDao userDao = new UserDao();
        ArrayList<String> userData = userDao.read(intID);
        req.setAttribute(Constant.USERNAME, userData.get(1));
        req.setAttribute(Constant.EMAIL, userData.get(0));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/users/edit.jsp");
        dispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter(Constant.USER_NAME);
        String email = req.getParameter(Constant.EMAIL);
        String pass = req.getParameter(Constant.PASSWORD);
        int intID = Constant.getIntID(req);


        UserDao userDao = new UserDao();
        User user = new User();
        user.setId(intID);
        user.setUsername(userName);
        user.setEmail(email);
        user.setPassword(pass);
        userDao.update(user);

        resp.sendRedirect(Constant.MAIN_PAGE_WITH_USERS_LIST);
    }
}
