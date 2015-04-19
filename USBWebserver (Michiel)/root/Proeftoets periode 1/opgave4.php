<!DOCTYPE html>
<!--
S1076823 Michiel Janssen
Opgave 4
-->
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="stijl.css">
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <h1>Opgave 4</h1><br>
        <?php
        $aantalkeer = rand(1, 10);
        for ($k = 0; $k < $aantalkeer; $k++) {
            $getal = rand(1, 10);
            for ($j = 0; $j < 10; $j++) {
                print($getal . " ");
                $getal = $getal * 2;
            }
            print("<br>");
        }
        ?>
    </body>
</html>
