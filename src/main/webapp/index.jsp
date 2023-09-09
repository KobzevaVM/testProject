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
        .flex-container {
            display: flex;
            justify-content: center;
        }
        .flex-container-1 {
            display: flex;
            font-size: 30px;
            color: white;
            text-align: center
        }
        .nameForm {
            text-align: center;
            margin-bottom: 100px;
        }
        .errorText {
            display: flex;
            text-align: left;
        }
    </style>
</head>

<body>
<div class="header">
    <h1>Пролог</h1>
</div>
<hr>
<div class="flex-container">
    <div class="flex-container-1">
        Ты стоишь в космическом порту и готов подняться на борт своего коробля. <br>
        Разве ты не об этом мечтал? <br>
        Стать капитаном галактического судна с экипажем, <br>
        который будет совершать подвиги под твоим командованием. <br>
        Так что вперед!
    </div>
</div>

<div class="header">
    <h1>Знакомство с экипажем</h1>
</div>
<hr>
 <div class="flex-container">
    <div class="flex-container-1">
        Когда ты поднялся на борт корабля, тебя поприветствовала девушка с черной папкой в руках:<br>
        - Здравствуйте, командир! Я Рина - ваша помошница. <br>
        Видите? Там в углу пьет кофе наш ученый - Ковальски,<br>
        рядом с ним наш новобранец - Рядовой, а фотографирует их Рико - наш подрывник.<br>
        А как обращаться к вам?<br>
    </div>
</div>

<div class="flex-container">
    <form action="start" method="POST" class="nameForm">
        <input type="text" name="userName" style="border-bottom-color: gray"/>
        <input type="submit" value="Представиться" />
    </form>
</div>
</body>

</html>
