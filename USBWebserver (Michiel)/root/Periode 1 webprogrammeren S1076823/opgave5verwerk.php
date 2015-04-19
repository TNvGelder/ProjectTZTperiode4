<!DOCTYPE html>
<!--
S1076823 Michiel Janssen
Opgave 5 verwerk
-->
<html>
    <head>
        <title>Opgave 5 verwerk</title>
        <meta charset="UTF-8">
    </head>
    <body>
        <?php
        $getal = $_GET["getal"];
        while ($getal > 0) {
            print($getal . " ");
            $getal = $getal - 1;
        }
        print($getal);
        ?>
        <p><a href="opgave5.php">Terug naar opgave 5</a></p>
    </body>
</html>
