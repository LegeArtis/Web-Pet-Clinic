package servlets;

import PetClinic.Pet;
import form.UserForm;
import models.User;
import models.UserExtended;
import org.codehaus.jackson.map.ObjectMapper;
import store.UserCache;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class CreateUserJsonServlet extends HttpServlet {

    private UserCache cache = UserCache.getInstance();
    private AtomicInteger id = new AtomicInteger();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "application/json; charset=utf-8");
        final ServletOutputStream out = resp.getOutputStream();
        out.print(new ObjectMapper().writeValueAsString(cache.values()));
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "application/json; charset=utf-8");
        final UserForm form = new ObjectMapper().readValue(req.getInputStream(), UserForm.class);
        cache.add(new UserExtended(id.incrementAndGet(),form.getLogin(),form.getEmail(), new Pet(form.getPetName(),form.getPetType()),form.getPhone(),form.getSex(),form.getCity(),form.isAgree()));
        resp.getOutputStream().write("('result' : 'true')".getBytes());
    }
}
