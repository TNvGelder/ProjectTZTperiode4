<!DOCTYPE html>
<!--
S1076823 Michiel Janssen
Opgave 6
-->
<html>
    <head>
        <title>Opgave 6</title>
        <meta charset="UTF-8">
    </head>
    <body>
        <p>OPGAVE 6<p><br>
            <?php
            $teams = array("Nederland", "Brazilie", "Duitsland", "Belgie", "Polen", "Frankrijk");

            function loting($arr) {
                shuffle($arr);
                print("$arr[0] tegen $arr[1] <br>");
                print("$arr[2] tegen $arr[3] <br>");
                print("$arr[4] tegen $arr[5] <br>");
            }

            loting($teams);
            ?>
        <p><a href="opgave1.html">Terug</a></p>
    </body>
</html>
