package com.game.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "QuestionServlet", value = "/pageAnswer")
public class QuestionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String answer = getSelectedAnswer(req);
        PlayerInfo playerInfo = (PlayerInfo) req.getSession().getAttribute("playerInfo");

        // Перенаправление запроса на страницу в зависимости от ответа
        switch (answer) {
            case "yes1":
                playerInfo.setGoodAnswer(1);
                req.getRequestDispatcher("/question2.jsp").forward(req, resp);
                break;
            case "yes2":
                playerInfo.setGoodAnswer(playerInfo.getGoodAnswer() + 1);
                req.getRequestDispatcher("/question3.jsp").forward(req, resp);
                break;
            case "yes3":
                playerInfo.setGoodAnswer(playerInfo.getGoodAnswer() + 1);
                playerInfo.setCountGames(playerInfo.getCountGames() + 1);
                playerInfo.setCountWins(playerInfo.getCountWins() + 1);
                req.getRequestDispatcher("/win.jsp").forward(req, resp);
                break;
            case "no":
                playerInfo.setCountGames(playerInfo.getCountGames() + 1);
                req.getRequestDispatcher("/loss.jsp").forward(req, resp);
                break;
            default:
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
                break;
        }
    }

    private String getSelectedAnswer(HttpServletRequest request) {
        String answer = request.getParameter("answer");
        return answer;
    }
}
