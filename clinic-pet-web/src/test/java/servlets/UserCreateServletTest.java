package servlets;

import org.junit.Test;
import org.mockito.Mockito;
import store.UserCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author JS
 * @since 05.09.2018
 */

public class UserCreateServletTest extends Mockito {

    final UserCache cache = UserCache.getInstance();

    @Test
    public void createTest() throws ServletException, IOException {

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("login")).thenReturn("test");
        when(request.getParameter("email")).thenReturn("test");
        when(request.getParameter("phone")).thenReturn("test");
        when(request.getParameter("pet_name")).thenReturn("test");
        when(request.getParameter("pet_type")).thenReturn("test");

        assertTrue(cache.values().isEmpty());

        new UserCreateServlet().doPost(request,response);

        verify(request, atLeast(1)).getParameter("login");
        verify(request, atLeast(1)).getParameter("email");
        verify(request, atLeast(1)).getParameter("phone");
        verify(request, atLeast(1)).getParameter("pet_name");
        verify(request, atLeast(1)).getParameter("pet_type");

        cache.delete(cache.findByLogin("test").getId());
    }
}