<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="Opgave_1_css.css">
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <h1>Opgave 5</h1><br>
        <?php
        if (isset($_GET[submit]) || isset($_GET[van]) || isset($_GET[naar])) {
            print("Je reist van ");
            print($_GET[van]);
            print(" naar ");
            print($_GET[naar]);
        }
        ?>
    </body>
</html>
