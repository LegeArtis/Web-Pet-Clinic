package servlets;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import store.UserCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.Assert.*;

public class UserViewServletTest extends Mockito {
        UserCache cache = UserCache.getInstance();

    @Test
    public void createTest() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);


        when(request.getRequestDispatcher("/views/user/UserView.jsp")).thenReturn(dispatcher);

        UserViewServlet userViewServlet = new UserViewServlet();
        userViewServlet.doGet(request,response);

        verify(request, atLeast(1)).getRequestDispatcher("/views/user/UserView.jsp");

    }


}