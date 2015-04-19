<!DOCTYPE html>
<!--
S1076823 Michiel Janssen
Opgave 6
-->
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="stijl.css">
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <h1>Opgave 6</h1>
        <?php
        $cijfers = array(12, -6, -3, 3, -1);
        $vissen = array("Snoek", "Karper", "Potvis", "Piranha", "Goudvis");

        function getRandomElement($array) {
            $nummer = rand(0, count($array) - 1);
            return $array[$nummer];
        }

        print(getRandomElement($vissen));
        ?>
    </body>
</html>
