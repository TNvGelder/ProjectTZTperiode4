<!DOCTYPE html>
<!--
S1076823 Michiel Janssen
Opgave 2
-->
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="stijl.css">
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <h1>Opgave 2</h1>
        <?php
        $aantalherten = 8;
        $aantaljagers = 8;

        if ($aantalherten == $aantaljagers) {
            print ("Voor iedere jager een hert!");
        } elseif ($aantaljagers > $aantalherten) {
            print("Je hebt " . ($aantaljagers - $aantalherten) . " jagers meer dan herten");
        } else {
            print("Een jager moet gemiddeld " . ($aantalherten / $aantaljagers) . " herten schieten");
        }
        print("<br>");

        for ($i = 0; $i < $aantalherten; $i++) {
            print("<img src='hert.jpg' alt='hert'>");
        }
        ?>
    </body>
</html>
