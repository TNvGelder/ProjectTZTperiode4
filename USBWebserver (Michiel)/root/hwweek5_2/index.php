<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <p style="font-size:50px;">Scoreboard</p>
        <form method="get" action="verwerk.php">
            <?php
            print("Thuis: ");
            print("<input type='text' name='thuisscore'>");
            print("<input type='submit' value='Verhogen Thuisscore'><br>");
            print("Uit:   ");
            print("<input type='text' name='uitscore'>");
            print("<input type='submit' value='Verhogen Uitscore'><br>");
            ?>
        </form>
    </body>
</html>
