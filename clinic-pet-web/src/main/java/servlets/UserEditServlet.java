package servlets;

import PetClinic.Pet;
import models.User;
import store.UserCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author JS
 * @since 02.09.2018
 */

public class UserEditServlet extends HttpServlet {
    private int id = 0;

    private final UserCache USER_CACHE = UserCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", this.USER_CACHE.get(Integer.valueOf(req.getParameter("id"))));
        id = Integer.valueOf(req.getParameter("id"));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/user/EditUser.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Pet pet = new Pet(req.getParameter("pet_name"), req.getParameter("pet_type"));
        User user = new User(id,req.getParameter("login"),req.getParameter("email"),pet, req.getParameter("phone"));

        this.USER_CACHE.edit(user);
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/user/view"));
    }
}
