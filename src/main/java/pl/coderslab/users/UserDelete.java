package pl.coderslab.users;

import pl.coderslab.constant.Constant;
import pl.coderslab.utils.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/user/delete")
public class UserDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Constant.getIntID(req);
        UserDao userDao = new UserDao();

        userDao.delete(userId);
        resp.sendRedirect(Constant.MAIN_PAGE_WITH_USERS_LIST);
    }
}
