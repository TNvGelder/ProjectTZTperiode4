<!DOCTYPE html>
<!--
S1076823 Michiel Janssen
Opgave 4
-->
<html>
    <head>
        <title>Opgave 4</title>
        <meta charset="UTF-8">
    </head>
    <body>
        <p>OPGAVE 4<p><br>
            <?php
            $getal1 = 56;
            $getal2 = 4;
            $aantalkeer = 0;
            $getal1begin = $getal1;
            while ($getal1 > $getal2) {
                $getal1 = $getal1 - $getal2;
                $aantalkeer++;
            }
            print("$getal1begin gedeeld door $getal2 is $aantalkeer met rest $getal1");
            ?>
        <p><a href="opgave1.html">Terug</a></p>
    </body>
</html>
