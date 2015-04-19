<?php

// a
print("<br> -------------- Opdracht a --------------<br>");

function langsteWoord($woorden) {
    $langste = 0; // hierin wordt de index van het langste woord onthouden
    for ($i = 1; $i < count($woorden); $i++) {
        if (strlen($woorden[$i]) > strlen($woorden[$langste])) {
            $langste = $i;
        }
    }
    return($woorden[$langste]);
}

// alternatief (het kan altijd op verschillende manieren...)
function langsteWoord_2($woorden) {
    $langsteWoord = $woorden[0]; // dit is het langste woord "tot nu toe"
    $lengte = strlen($langsteWoord); // nu wordt ook de lengte van het langste woord onthouden
    for ($i = 1; $i < count($woorden); $i++) {
        $lengteNieuw = strlen($woorden[$i]);
        if ($lengteNieuw > $lengte) {
            $langsteWoord = $woorden[$i];
            $lengte = $lengteNieuw;
        }
    }
    return($langsteWoord);
}

$woorden = array("aap", "noot", "mies");
$langsteWoord = langsteWoord($woorden);
print($langsteWoord);
print("<br>");

// b
// Aanpak: controleer steeds of een getal in de array groter is dan het volgende ($i+1).
// Zodra dat het geval is, is de reks getallen niet oplopend en wordt false geretourneerd.
// Als je aan het einde van de while komt kan je concluderen dat alle getallen in orde
// waren (steeds groter of gelijk) en wordt er dus true geretourneerd.
print("<br>-------------- Opdracht b --------------<br>");

function isOplopend($getallen) {
    $i = 0;
    while ($i < count($getallen) - 1) {
        if ($getallen[$i] > $getallen[$i + 1]) {
            return false; // bedenk dat de functie nu ook direct helemaal stopt!
        }
        $i++;
    }
    return true;
}

$getallen = array(1, 4, 5, 7);
$oplopend = isOplopend($getallen);
print("oplopend=" . $oplopend . "<br>");

$getallen = array(3, 4, 4, 4, 5);
$oplopend = isOplopend($getallen);
print("oplopend=" . $oplopend . "<br>");

$getallen = array(1, 2, 3, 0, 2, 3);
$oplopend = isOplopend($getallen);
print("oplopend=" . $oplopend . "<br>");

// c
print("<br>-------------- Opdracht c --------------<br>");

function hoogsteVanTwee($array1, $array2) {
    $resultaat = array();
    for ($i = 0; $i < count($array1); $i++) {
        if ($array1[$i] > $array2[$i]) {
            $resultaat[$i] = $array1[$i];
        } else {
            $resultaat[$i] = $array2[$i];
        }
    }
    return ($resultaat);
}

$a1 = array(1, 2, 3, 4);
$a2 = array(7, 6, 2, 1);
$hoogste = hoogsteVanTwee($a1, $a2);
print_r($hoogste);
print("<br>");

$a1 = array(5, 5, 5);
$a2 = array(3, 5, 9);
$hoogste = hoogsteVanTwee($a1, $a2);
print_r($hoogste);

// d
print("<br>-------------- Opdracht d --------------<br>");

// aanpak: bepaal eerst welke array het langst is. Deze array is
// de basis van het antwoord dat geretourneerd wordt.
// Nu wordt de kortste array doorlopen en de waarden daarin vergeleken
// met die in de langste. Als dat nodig is wordt de waarde in de langste
// array vervangen door die uit de kortste

function hoogsteVanTweeOngelijk($array1, $array2) {
    if (count($array1) > count($array2)) {
        $langste = $array1;
        $kortste = $array2;
    } else {
        $langste = $array2;
        $kortste = $array1;
    }

    for ($i = 0; $i < count($kortste); $i++) {
        if ($kortste[$i] > $langste[$i]) {
            $langste[$i] = $kortste[$i];
        }
    }
    return ($langste);
}

$a1 = array(1, 2, 3, 4);
$a2 = array(7, 6, 2, 1);
$hoogste = hoogsteVanTweeOngelijk($a1, $a2);
print_r($hoogste);
print("<br>");

$a1 = array(3, 4, 5);
$a2 = array(6, 5, 4, 3, 2, 1);
$hoogste = hoogsteVanTweeOngelijk($a1, $a2);
print_r($hoogste);

// e
print("<br>-------------- Opdracht e --------------<br>");

function verschilWaarden($getallen) {
    $resultaat = array();
    for ($i = 0; $i < count($getallen) - 1; $i++) {
        $resultaat[$i] = $getallen[$i + 1] - $getallen[$i];
    }
    return $resultaat;
}

$getallen = array(2, 4, 8, 11);
$verschilArray = verschilWaarden($getallen);
print_r($verschilArray);
print("<br>");
$getallen = array(1, 1, 2, 0, 4);
$verschilArray = verschilWaarden($getallen);
print_r($verschilArray);


// f
print("<br>-------------- Opdracht f --------------<br>");

function zoekHerhaaldeWoorden($woorden) {
    $resultaat = array();
    $aantallen = array_count_values($woorden);
    foreach ($aantallen as $woord => $aantal) {
        if ($aantal > 1) {
            // toevoegen aan het einde van de array
            $resultaat[] = $woord;
            // kan ook met
            // array_push($resultaat, $woord);
        }
    }
    return($resultaat);
}

$woorden = array("aap", "noot", "aap", "mies", "aap", "noot");
$herhaald = zoekHerhaaldeWoorden($woorden);
print_r($herhaald);

// g
print("<br>-------------- Opdracht g --------------<br>");

function zoekHerhaaldeWoordenMetAantal($woorden, $zoekAantal) {
    $resultaat = array();
    $aantallen = array_count_values($woorden);
    foreach ($aantallen as $woord => $aantal) {
        if ($aantal == $zoekAantal) {
            $resultaat[] = $woord;
        }
    }
    return($resultaat);
}

$woorden = array("aap", "noot", "aap", "mies", "aap", "noot");
$herhaald = zoekHerhaaldeWoordenMetAantal($woorden, 1);
print_r($herhaald);
print("<br>");
$herhaald = zoekHerhaaldeWoordenMetAantal($woorden, 2);
print_r($herhaald);

// h
print("<br>-------------- Opdracht h --------------<br>");

function woordenHerhalen($aantallen, $woorden) {
    $resultaat = array();
    for ($i = 0; $i < count($aantallen); $i++) {
        $aantal = $aantallen[$i];
        for ($j = 0; $j < $aantal; $j++) {
            $resultaat[] = $woorden[$i];
        }
    }
    return $resultaat;
}

$aantallen = array(1, 2, 3);
$woorden = array("boter", "kaas", "eieren");
$herhaaldeWoorden = woordenHerhalen($aantallen, $woorden);
print_r($herhaaldeWoorden);

// i
print("<br>-------------- Opdracht i --------------<br>");

function isSpiegelArray($array) {
    $arrayOmgekeerd = array_reverse($array);
    for ($i = 0; $i < count($array); $i++) {
        if ($array[$i] != $arrayOmgekeerd[$i]) {
            return false;
        }
    }
    return true;
}

$testArray = array(2, 4, 6, 8, 6, 4, 2);
$spiegel = isSpiegelArray($testArray);
print("is gespiegeld = " . $spiegel . "<br>");
$testArray = array(1, 9, 5, 9, 1);
$spiegel = isSpiegelArray($testArray);
print("is gespiegeld = " . $spiegel . "<br>");
$testArray = array(7);
$spiegel = isSpiegelArray($testArray);
print("is gespiegeld = " . $spiegel . "<br>");
$testArray = array(1, 9, 5);
$spiegel = isSpiegelArray($testArray);
print("is gespiegeld = " . $spiegel . "<br>");
$testArray = array(1, 11, 111);
$spiegel = isSpiegelArray($testArray);
print("is gespiegeld = " . $spiegel . "<br>");
?>
