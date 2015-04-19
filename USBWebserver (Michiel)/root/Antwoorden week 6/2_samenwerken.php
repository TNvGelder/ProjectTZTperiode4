<?php

$leerlingen = array("tobias", "hasna", "aukje", "fred", "sep", "koen", "wahed", "anna", "jackie", "rashida", "winston", "sammy", "manon", "ben", "karim", "bart", "lisa", "lieke");

// a
function maakGroepjes($leerlingen) {
    shuffle($leerlingen);
    for ($i = 0; $i < count($leerlingen) - 1; $i+=2) {
        print($leerlingen[$i] . " en " . $leerlingen[$i + 1] . "<br>");
    }
}

maakGroepjes($leerlingen);
print("<br>");

// b
function maakGroepjes_b($leerlingen) {
    shuffle($leerlingen);
    $aantal = count($leerlingen);
    for ($i = 0; $i < $aantal - 1; $i+=2) {
        print($leerlingen[$i] . " en " . $leerlingen[$i + 1] . "<br>");
    }
    if ($aantal % 2 == 1) { // test of het aantal oneven is
        print($leerlingen[$aantal - 1] . " blijft over");
    }
}

array_pop($leerlingen); // deze functie verwijdert het laatste element uit een array
maakGroepjes_b($leerlingen);
?>
