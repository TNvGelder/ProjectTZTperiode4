<!DOCTYPE html>
<!--
S1076823 Michiel Janssen
Opgave 3
-->
<html>
    <head>
        <title>Opgave 3</title>
        <meta charset="UTF-8">
    </head>
    <body>
        <p>OPGAVE 3<p><br>
            <?php
            $geboortejaar = array();
            $geboortejaar["Ron"] = 1985;
            $geboortejaar["Bruno"] = 1992;
            $geboortejaar["Jasper"] = 1989;
            $geboortejaar["Nigel"] = 1984;
            $geboortejaar["Arjen"] = 1984;
            $geboortejaar["Stefan"] = 1992;
            $jaren = array_count_values($geboortejaar);

            foreach ($jaren as $jaar => $hoeveelheid) {
                if ($hoeveelheid > 1) {
                    print("In jaar " . $jaar . " zijn er meer dan 1 spelers geboren<br>");
                }
            }
            ?>
        <p><a href="opgave1.html">Terug</a></p>
    </body>
</html>
