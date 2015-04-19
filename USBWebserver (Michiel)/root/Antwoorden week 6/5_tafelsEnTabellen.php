<!DOCTYPE html>
<?php

function tafels_a() {
    print("<table>");
    for ($i = 1; $i <= 10; $i++) {
        print("<tr>");
        for ($j = 1; $j <= 10; $j++) {
            print("<td>" . ($i * $j) . "</td>");
        }
        print("</tr>");
    }
    print("</table>");
}

function tafels_b() {
    print("<table>");
    for ($i = 1; $i <= 10; $i++) {
        print("<tr>");
        for ($j = 1; $j <= 10; $j++) {
            if ($i == 1 || $j == 1) { // als dit de eerste rij of eerste kolom is wordt het vet
                print("<td class=\"vet\">" . ($i * $j) . "</td>");
            } else {
                print("<td>" . ($i * $j) . "</td>");
            }
        }
        print("</tr>");
    }
    print("</table>");
}

function tafels_c($van, $tot) {
    print("<table>");
    // print de eerste rij:
    print("<tr>");
    // eerst een lege cel met een spatie (&nbsp; = spatie)
    print("<td>&nbsp;</td>");
    // dan de getallen waarmee vermenigvuldigd gaat worden, allemaal vet
    for ($i = $van; $i <= $tot; $i++) {
        print("<td class=\"vet\">" . $i . "</td>");
    }
    print("</tr>");

    // print volgende rijen met de vermenigvuldigingen, in de eerste cel komt
    // eerst nog het vetgedrukte getal van die rij
    for ($i = $van; $i <= $tot; $i++) {
        print("<tr>");
        print("<td class=\"vet\">" . $i . "</td>");
        for ($j = $van; $j <= $tot; $j++) {
            print("<td>" . ($i * $j) . "</td>");
        }
        print("</tr>");
    }
    print("</table>");
}
?>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
        <style>
            td {text-align: right}
            .vet {font-weight: bold }
        </style>
    </head>
    <body>
        <h1>opgave a</h1>
        <?php
        tafels_a();
        ?>

        <h1>opgave b</h1>
        <?php
        tafels_b();
        ?>

        <h1>opgave c</h1>
        <?php
        $van = 1; // de standaard waarde voor als er geen waarde in $_GET zit
        if (isset($_GET["van"])) {
            $van = $_GET["van"];
        }
        $tot = 10;
        if (isset($_GET["tot"])) {
            $tot = $_GET["tot"];
        }
        tafels_c($van, $tot);
        ?>

    </body>
</html>
