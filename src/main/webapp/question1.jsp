<%@ page import="com.game.controller.PlayerInfo" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
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
            color: white;
            font-size: 20px;
            border: 1px solid white;
        }
    </style>
</head>


<body>
<div class="header">
    <h1>
    Ты потерял память. Очнулся в неизвестном месте. <br>
    Перед тобой стоят инопланетяне и предлагают пройти с ними.
    </h1>
</div>
<hr>
<div class="questionForm">
<form action="pageAnswer" method="POST">
    Примишь предложение инопланетян?
    <br><br>
    <div class="answerForm">
        <input type="radio" name="answer" value="yes1" checked />Согласиться
        <br>
        <input type="radio" name="answer" value="no" />Отказаться
        <br>
        <input type="submit" value="Ответить" />
    </div>
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
</form>
</div>


</body>
</html>
