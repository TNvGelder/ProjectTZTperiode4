<?php

// a
print("<br> -------------- Opdracht a --------------<br>");

function isSpiegelwoord($woord) {
    $omgekeerd = strrev($woord);
    if ($omgekeerd == $woord) {
        return true;
    } else {
        return FALSE;
    }
}

function testSpiegelwoord($woord) {
    if (isSpiegelwoord($woord)) {
        print($woord . " is een spiegelwoord<br>");
    } else {
        print($woord . " is geen spiegelwoord<br>");
    }
}

testSpiegelwoord("lepel");
testSpiegelwoord("vork");

// b
print("<br> -------------- Opdracht b --------------<br>");

function zoekSpiegelwoorden($woorden) {
    $spiegelwoorden = array();
    foreach ($woorden as $woord) {
        if (isSpiegelwoord($woord)) {
            // toevoegen aan het einde van de array
            $spiegelwoorden[] = $woord;
            // kan ook met
            // array_push($spiegelwoorden, $woord);
        }
    }
    return $spiegelwoorden;
}

function testZoekSpiegelWoorden($woorden) {
    $spiegelwoorden = zoekSpiegelwoorden($woorden);
    print("De volgende woorden zijn spiegelwoorden:<br>");
    foreach ($spiegelwoorden as $spiegelwoord) {
        print($spiegelwoord . "<br>");
    }
}

$woorden = array("lepel", "vork", "negen", "tien");
testZoekSpiegelwoorden($woorden);

// c
print("<br> -------------- Opdracht c --------------<br>");

// aanpak: wanneer de variabele $spiegel true is zoeken we de spiegelwoorden,
// dus dan moet ook de functie isSPiegelwoord als antwoord true geven. Als
//  spiegel false is moet de functie isSpiegelwoord ook het antwoord false geven.
// Ze moeten dus altijd dezelfde waarde hebben. In de if conditie wordt getest
// of ze allebei true zijn, in de elseif juist of ze allebei false zijn.
// Omdat je een woord alleen in het antwoord zet wanneer beide waarden hetzelfde zijn
// kan het ook korter. Je controleert dan gewoon of de twee waarden gelijk zijn aan elkaar.
function zoekSpiegelwoorden_c($woorden, $spiegel) {
    $spiegelwoorden = array();
    foreach ($woorden as $woord) {
        if ($spiegel && isSpiegelwoord($woord)) {
            $spiegelwoorden[] = $woord;
        } elseif (!$spiegel && !isSpiegelwoord($woord)) {
            $spiegelwoorden[] = $woord;
        }
//        korter kan dus ook (zonder de else):
//        if ($spiegel == isSpiegelwoord($woord)) {
//            $spiegelwoorden[] = $woord;
//        }
    }
    return $spiegelwoorden;
}

function testZoekSpiegelWoorden_c($woorden, $spiegel) {
    $resultaat = zoekSpiegelwoorden_c($woorden, $spiegel);
    if ($spiegel) {
        print("De volgende woorden zijn spiegelwoorden:<br>");
    } else {
        print("De volgende woorden zijn juist geen spiegelwoorden:<br>");
    }
    foreach ($resultaat as $woord) {
        print($woord . "<br>");
    }
}

testZoekSpiegelwoorden_c($woorden, true);
testZoekSpiegelwoorden_c($woorden, false);

// d
print("<br> -------------- Opdracht d --------------<br>");

function keerNietSpiegelwoordenOm($woorden) {
    $nietSpiegelWoorden = zoekSpiegelwoorden_c($woorden, false);
    $omgekeerd = array();
    foreach ($nietSpiegelWoorden as $woord) {
        $omgekeerd[$woord] = strrev($woord);
    }
    return $omgekeerd;
}

function testKeerNietSpiegelwoordenOm($woorden) {
    $omgekeerdeWoorden = keerNietSpiegelwoordenOm($woorden);
    print("Dit zijn de woorden die niet hetzelfde zijn als hun spiegelbeeld:<br>");
    foreach ($omgekeerdeWoorden as $woord => $omgekeerd) {
        print($woord . " is omgekeerd " . $omgekeerd . "<br>");
    }
}

testKeerNietSpiegelwoordenOm($woorden);

// e
print("<br> -------------- Opdracht e --------------<br>");

function testSpiegelWoordenOverzicht($woorden) {

    testZoekSpiegelWoorden_c($woorden, true);
    testZoekSpiegelWoorden_c($woorden, false);
    testKeerNietSpiegelwoordenOm($woorden);
}

testSpiegelWoordenOverzicht($woorden);
?>
