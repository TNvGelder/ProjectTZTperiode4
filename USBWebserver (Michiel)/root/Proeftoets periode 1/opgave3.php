<!DOCTYPE html>
<!--
S1076823 Michiel Janssen
Opgave 3
-->
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="stijl.css">
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <h1>Opgave 3</h1>
        <?php
        $getallen = array(12, -6, -3, 3, -1);
        $somvoor = array_sum($getallen);
        $somna = 0;
        print("<table>");
        foreach ($getallen as $index => $getal) {
            if ($getal < 0) {
                $getal = $getal * -1;
            }
            print("<tr><td>$index</td><td>$getal</td></tr>");
            $somna = $somna + $getal;
        }
        print("</table>" . "<br />");
        print("De som was " . $somvoor . "<br>");
        print("De som is nu " . $somna);
        ?>
    </body>
</html>
