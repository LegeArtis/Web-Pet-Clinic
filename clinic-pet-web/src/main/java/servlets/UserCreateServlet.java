package servlets;

import PetClinic.Pet;
import models.User;
import store.UserCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author JS
 * @since 02.09.2018
 */

public class UserCreateServlet extends HttpServlet {

    private final AtomicInteger ids = new AtomicInteger();
    private final UserCache cache = UserCache.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Pet pet = new Pet(req.getParameter("pet_name"), req.getParameter("pet_type"));
        User user = new User(this.ids.incrementAndGet(),req.getParameter("login"), req.getParameter("email"),pet,req.getParameter("phone"),"NaN","NaN","false");
        this.cache.add(user);
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/user/view"));
    }
}
