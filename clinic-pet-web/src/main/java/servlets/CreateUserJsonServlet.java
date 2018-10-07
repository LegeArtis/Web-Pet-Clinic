package servlets;

import PetClinic.Pet;
import form.UserForm;
import models.User;
import org.codehaus.jackson.map.ObjectMapper;
import store.JdbcStorage;
import store.UserCache;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class CreateUserJsonServlet extends HttpServlet {

  //  private UserCache cache = UserCache.getInstance();
    private JdbcStorage jdbcStorage = new JdbcStorage();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "application/json; charset=utf-8");
        final ServletOutputStream out = resp.getOutputStream();
        out.print(new ObjectMapper().writeValueAsString(jdbcStorage.values()));
        out.flush();

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "application/json; charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.readValue(req.getInputStream(), UserForm.class);
        final UserForm form = objectMapper.readValue(req.getInputStream(), UserForm.class);
      //  jdbcStorage.add(new User(form.getLogin(),form.getEmail(), new Pet(form.getPetName(),form.getPetType()),form.getPhone(),form.getSex(),form.getCity(),form.agree()));
        resp.getOutputStream().write("('result' : 'true')".getBytes());
    }
}
