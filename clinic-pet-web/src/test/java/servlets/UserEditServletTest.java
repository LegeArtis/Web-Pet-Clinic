package servlets;

import PetClinic.Pet;
import models.User;
import org.junit.Test;
import org.mockito.Mockito;
import store.UserCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author JS
 * @since 06.09.2018
 */

public class UserEditServletTest extends Mockito {

    private UserCache cache = UserCache.getInstance();

    @Test
    public void createTest() throws ServletException, IOException {

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        assertTrue(cache.values().isEmpty());

        cache.add(new User(1,"test", "test",new Pet("test","test"),"test","NaN","NaN","false"));

        when(request.getParameter("login")).thenReturn("test");
        when(request.getParameter("id")).thenReturn("1");
        when(request.getParameter("email")).thenReturn("test");
        when(request.getParameter("phone")).thenReturn("test");
        when(request.getParameter("pet_name")).thenReturn("test");
        when(request.getParameter("pet_type")).thenReturn("test");



        when(request.getRequestDispatcher("/views/user/EditUser.jsp")).thenReturn(dispatcher);

        UserEditServlet userEditServlet = new UserEditServlet();
        userEditServlet.doGet(request,response);
        userEditServlet.doPost(request,response);

        verify(request, atLeast(1)).getParameter("login");
        verify(request, atLeast(1)).getParameter("email");
        verify(request, atLeast(1)).getParameter("phone");
        verify(request, atLeast(1)).getParameter("pet_name");
        verify(request, atLeast(1)).getParameter("pet_type");

        cache.delete(cache.findByLogin("test").getId());
    }


}