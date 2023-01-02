package pl.coderslab.users;

import pl.coderslab.utils.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/user/show")
public class UserShow extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strId = req.getParameter("id");
        int intID = -1;
        try {
            intID = Integer.parseInt(strId);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        UserDao userDao = new UserDao();
        ArrayList<String> userData = userDao.read(intID);
        req.setAttribute("email", userData.get(0));
        req.setAttribute("username", userData.get(1));
        req.setAttribute("id", userData.get(3));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/users/show.jsp");
        dispatcher.forward(req, resp);
    }
}
