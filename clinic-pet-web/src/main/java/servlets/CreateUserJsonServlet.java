package servlets;



import form.UserForm;
import form.UserPojo;
import models.User;

import store.JdbcStorage;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateUserJsonServlet extends HttpServlet {

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
        StringBuilder builder = new StringBuilder();
        String a = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream(), "UTF-8"))){
            while ((a = reader.readLine())!=null){
                builder.append(a);
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();
        UserPojo pojo = objectMapper.readValue(builder.toString(),UserPojo.class);

    }

    /*
        User user = new User();
        jdbcStorage.add(user);
        resp.getOutputStream().write("('result' : 'true')".getBytes());*/
}


