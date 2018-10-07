package servlets;

import PetClinic.Pet;
import models.User;
import org.junit.Test;
import org.mockito.Mockito;
import store.UserCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author JS
 * @since 05.09.2018
 */

public class UserDeleteServletTest extends Mockito {

    private UserCache cache = UserCache.getInstance();

    @Test
    public void createTest() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        assertFalse(isUserExist());

        cache.add(new User(1,"test","test",new Pet("test", "test"),"test","NaN","NaN","false"));

        assertTrue(isUserExist());

        when(request.getParameter("id")).thenReturn("1");

        UserDeleteServlet userDeleteServlet = new UserDeleteServlet();
        userDeleteServlet.doGet(request, response);

        verify(request, atLeast(1)).getParameter("id");

        assertFalse(isUserExist());

    }

    /**
     *
     * @return true if user is exist
     */

    private boolean isUserExist(){
        return cache.findByLogin("test") != null;
    }
}