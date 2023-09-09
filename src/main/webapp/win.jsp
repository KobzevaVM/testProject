<%@ page import="com.game.controller.PlayerInfo" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        body {
            background-image: url("images/background2.jpeg");
            background-repeat:no-repeat;
            background-size:cover;
        }
        .header {
            text-align: center;
            color: white;
        }
        .questionForm {
            display: flex;
            justify-content: center;
            color: white;
            font-size: 30px;
        }
        .answerForm {
            text-align: left;
            color: white;
            font-size: 20px;
        }
        .statisticTable {
            text-align: left;
            color: white;
            font-size: 20px;
            border: 1px solid white;
        }
    </style>
</head>

<body>
    <div class="header">
        <h1>
            Тебя вернули домой.
            <br><br>
            <b>ПОБЕДА!</b>
        </h1>
    </div>
    <hr>
    <div class="questionForm">
        <div class="answerForm">
            <form action="restartPage" method="GET">
                Хотите сыграть еще раз или продолжить как другой игрок?
                <br><br>
                <input style="width: 85px; text-align: left" type="submit" value="Новая игра" />
            </form>
            <form action="newGame" method="GET">
                <input style="width: 85px; text-align: left" type="submit" value="Новый игрок" />
            </form>
            <br>
            <div class="statistic">
                <table class="statisticTable">
                    <thead>
                    <tr>
                        <th>Статистика</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>Имя в игре: <%= ((PlayerInfo) request.getSession().getAttribute("playerInfo")).getName()%></td>
                    </tr>
                    <tr>
                        <td>IP address: <%= ((PlayerInfo) request.getSession().getAttribute("playerInfo")).getIp() %></td>
                    </tr>
                    <tr>
                        <td>Количество игр: <%= ((PlayerInfo) request.getSession().getAttribute("playerInfo")).getCountGames() %></td>
                    </tr>
                    <tr>
                        <td>Количество побед: <%= ((PlayerInfo) request.getSession().getAttribute("playerInfo")).getCountWins() %></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
