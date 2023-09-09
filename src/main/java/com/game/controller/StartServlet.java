package com.game.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import static java.util.Objects.isNull;

@WebServlet(name = "StartServlet", value = "/start")
public class StartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String name = getSelectedName(req);
        String ip = req.getRemoteAddr();

        forwardPage(name, ip, req, resp);

    }


    public String getSelectedName(HttpServletRequest request) {
        return request.getParameter("userName");
    }

    public void forwardPage(String name, String ip, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        if(isNull(name) || name.isBlank()) {
            req.getRequestDispatcher("/indexError.jsp").forward(req, resp);
            throw new IllegalArgumentException("Name cannot be null.");
        } else {
            // Создание новой сессии
            HttpSession currentSession = req.getSession();
            //Создание игрока
            PlayerInfo player = new PlayerInfo(name, ip);
            // Добавление в сессию параметров игрока (нужно будет для хранения состояния между запросами)
            currentSession.setAttribute("playerInfo", player);
            // Перенаправление запроса на страницу index.jsp через сервер
            req.getRequestDispatcher("/question1.jsp").forward(req, resp);
        }
    }
}

