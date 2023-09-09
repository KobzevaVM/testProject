package com.game.controller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StartServletTest {

    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;
    @Mock
    private RequestDispatcher requestDispatcher;
    @Mock PlayerInfo player;

    private StartServlet startServlet;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        startServlet = new StartServlet();
    }

    @Test
    public void testGetSelectedName() throws ServletException, IOException {
        when(request.getRequestDispatcher("/question1.jsp")).thenReturn(requestDispatcher);
        when(request.getRequestDispatcher("/indexError.jsp")).thenReturn(requestDispatcher);
        try {
            startServlet.doPost(request, response);
        }
        catch (Exception e) {
            verify(request).getParameter("userName");
        }
        verify(request).getParameter("userName");
    }
    @Test
    public void testGetIp() throws ServletException, IOException {
        when(request.getRequestDispatcher("/question1.jsp")).thenReturn(requestDispatcher);
        when(request.getRequestDispatcher("/indexError.jsp")).thenReturn(requestDispatcher);
        try {
            startServlet.doPost(request, response);
        }
        catch (Exception e) {
            verify(request).getRemoteAddr();
        }
        verify(request).getRemoteAddr();
    }

    @ParameterizedTest
    @ValueSource(strings = { "", "", "\t", "  ", "  ", "   ", "    ", "\n"})
    void userNameBlankEmptyError(String argument) throws ServletException, IOException{
        when(request.getRequestDispatcher("/indexError.jsp")).thenReturn(requestDispatcher);
        try {
            startServlet.forwardPage(argument, "0.0.0.0.0.1", request, response);
        }
        catch(Exception e) {
            assertEquals("Name cannot be null.", e.getMessage());
            verify(requestDispatcher).forward(request, response);
        }
    }
    @Test
    void userNameNotBlankEmpty() throws ServletException, IOException{
        when(request.getRequestDispatcher("/question1.jsp")).thenReturn(requestDispatcher);
        when(request.getSession()).thenReturn(session);
        Mockito.doNothing().when(session).setAttribute("playerInfo", player);
        startServlet.forwardPage("TestName", "0.0.0.0.0.1", request, response);
        verify(requestDispatcher).forward(request, response);
    }

}