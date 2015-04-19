<!DOCTYPE html>
<!--
S1076823 Michiel Janssen
Opgave 2
-->
<html>
    <head>
        <title>Opgave 2</title>
        <meta charset="UTF-8">
    </head>
    <body>
        <p>OPGAVE 2<p><br>
            <?php
            $getal1 = rand(1, 10);
            $getal2 = rand(1, 10);
            print("Getal 1 is $getal1 <br>");
            print("Getal 2 is $getal2 <br>");
            if ($getal1 < $getal2) {
                if ($getal1 == $getal2 - 1) {
                    print("Er is maar een verschil van 1");
                } else {
                    $waarde = $getal2 - $getal1;
                    print("De waarde is $waarde gestegen.");
                }
            } elseif ($getal1 > $getal2) {
                if ($getal1 == $getal2 + 1) {
                    print("Er is maar een verschil van 1");
                } else {
                    $waarde = $getal1 - $getal2;
                    print("De waarde is $waarde gedaald.");
                }
            } else {
                print("De getallen zijn gelijk");
            }
            ?>
        <p><a href="opgave1.html">Terug</a></p>
    </body>
</html>
