package servlets;



import form.UserForm;
import form.UserPojo;
import models.User;

import store.HibernateStorage;
import store.JdbcStorage;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateUserJsonServlet extends HttpServlet {

     private HibernateStorage storage = new HibernateStorage();



    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "application/json; charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        ArrayList<User> list = storage.values();
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        ArrayList<UserPojo> userPojo = new ArrayList<>();
        for (User user : list) {
           userPojo.add(user.toUserPojo());
        }
        writer.print(mapper.writeValueAsString(userPojo));
        writer.flush();
        writer.close();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "application/json; charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        UserForm form = objectMapper.readValue(req.getInputStream(),UserForm.class);
        storage.add(form.toUser());
        resp.getOutputStream().write("('result' : 'true')".getBytes());
    }
}


