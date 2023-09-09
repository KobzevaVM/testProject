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

public class RestartServletTest {
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;
    @Mock
    private RequestDispatcher requestDispatcher;
    @Mock PlayerInfo player;
    private RestartServlet restartServlet;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        restartServlet = new RestartServlet();
    }
    @Test
    public void testResettingGoodAnswer() throws ServletException, IOException {
        when(request.getSession()).thenReturn(session);
        when(request.getSession().getAttribute("playerInfo")).thenReturn(player);
        when(request.getRequestDispatcher("/question1.jsp")).thenReturn(requestDispatcher);

        restartServlet.doGet(request, response);

        verify(player).setGoodAnswer(0);
    }
    @Test
    public void testForwardPage() throws ServletException, IOException {
        when(request.getSession()).thenReturn(session);
        when(request.getSession().getAttribute("playerInfo")).thenReturn(player);
        when(request.getRequestDispatcher("/question1.jsp")).thenReturn(requestDispatcher);

        restartServlet.doGet(request, response);

        verify(requestDispatcher).forward(request, response);
    }
}
