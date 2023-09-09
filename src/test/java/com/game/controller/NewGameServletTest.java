package com.game.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

import static org.mockito.Mockito.*;

public class NewGameServletTest {
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;
    @Mock
    private RequestDispatcher requestDispatcher;

    private NewGameServlet newGameServlet;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        newGameServlet = new NewGameServlet();
    }

    @Test
    public void testForwardStart() throws ServletException, IOException {
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher("/index.jsp")).thenReturn(requestDispatcher);

        newGameServlet.doGet(request, response);

        verify(requestDispatcher).forward(request, response);
    }
}
