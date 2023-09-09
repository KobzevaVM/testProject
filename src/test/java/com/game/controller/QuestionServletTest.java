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

public class QuestionServletTest {
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;
    @Mock
    private RequestDispatcher requestDispatcher;
    @Mock PlayerInfo player;
    private QuestionServlet questionServlet;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        questionServlet = new QuestionServlet();
    }

    @Test
    public void testGetSelectedAnswer() throws ServletException, IOException {
        when(request.getSession()).thenReturn(session);
        when(request.getSession().getAttribute("playerInfo")).thenReturn(player);
        when(request.getRequestDispatcher("/question2.jsp")).thenReturn(requestDispatcher);
        when(request.getRequestDispatcher("/question3.jsp")).thenReturn(requestDispatcher);
        when(request.getRequestDispatcher("/loss.jsp")).thenReturn(requestDispatcher);
        when(request.getRequestDispatcher("/win.jsp")).thenReturn(requestDispatcher);
        when(request.getRequestDispatcher("/index.jsp")).thenReturn(requestDispatcher);
        when(request.getParameter("answer")).thenReturn("testAnswer");

        questionServlet.doPost(request, response);

        verify(request).getParameter("answer");
    }

    @Test
    public void testFirstAnswer() throws ServletException, IOException {
        when(request.getSession()).thenReturn(session);
        when(request.getSession().getAttribute("playerInfo")).thenReturn(player);
        when(request.getParameter("answer")).thenReturn("yes1");
        when(request.getRequestDispatcher("/question2.jsp")).thenReturn(requestDispatcher);

        questionServlet.doPost(request, response);

        verify(player).setGoodAnswer(1);
        verify(request).getParameter("answer");
        verify(requestDispatcher).forward(request, response);
    }

    @Test
    public void testSecondAnswer() throws ServletException, IOException {
        when(request.getSession()).thenReturn(session);
        when(request.getSession().getAttribute("playerInfo")).thenReturn(player);
        when(request.getParameter("answer")).thenReturn("yes2");
        when(request.getRequestDispatcher("/question3.jsp")).thenReturn(requestDispatcher);
        when(player.getGoodAnswer()).thenReturn(1);

        questionServlet.doPost(request, response);

        verify(player).setGoodAnswer(2);
        verify(request).getParameter("answer");
        verify(requestDispatcher).forward(request, response);
    }

    @Test
    public void testThirdGoodAnswer() throws ServletException, IOException {
        when(request.getSession()).thenReturn(session);
        when(request.getSession().getAttribute("playerInfo")).thenReturn(player);
        when(request.getParameter("answer")).thenReturn("yes3");
        when(request.getRequestDispatcher("/win.jsp")).thenReturn(requestDispatcher);
        when(player.getGoodAnswer()).thenReturn(2);
        when(player.getCountGames()).thenReturn(7);
        when(player.getCountWins()).thenReturn(5);

        questionServlet.doPost(request, response);

        verify(player).setGoodAnswer(3);
        verify(player).setCountWins(6);
        verify(player).setCountGames(8);
        verify(request).getParameter("answer");
        verify(requestDispatcher).forward(request, response);
    }
    @Test
    public void testThirdBadAnswer() throws ServletException, IOException {
        when(request.getSession()).thenReturn(session);
        when(request.getSession().getAttribute("playerInfo")).thenReturn(player);
        when(request.getParameter("answer")).thenReturn("no");
        when(request.getRequestDispatcher("/loss.jsp")).thenReturn(requestDispatcher);
        when(player.getCountGames()).thenReturn(7);

        questionServlet.doPost(request, response);

        verify(player).setCountGames(8);
        verify(request).getParameter("answer");
        verify(requestDispatcher).forward(request, response);
    }
}
