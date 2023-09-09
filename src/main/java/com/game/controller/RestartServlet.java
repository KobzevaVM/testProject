package com.game.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RestartServlet", value = "/restartPage")
public class RestartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PlayerInfo playerInfo = (PlayerInfo) req.getSession().getAttribute("playerInfo");
        playerInfo.setGoodAnswer(0);
        req.getRequestDispatcher("/question1.jsp").forward(req, resp);
    }
}
