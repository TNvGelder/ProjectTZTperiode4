
<?php

function berekenAantalTegels($breedte, $hoogte) {
    $aantalVierkanteMeters = $breedte * $hoogte;
    $vierkanteMeterPerTegel = 0.15 * 0.15;
    $aantalTegels = $aantalVierkanteMeters / $vierkanteMeterPerTegel;
    // a
    // return $aantalTegels;
    //b
    $aantalTegels = ceil($aantalTegels);
    return $aantalTegels;
}

$aantal = berekenAantalTegels(5, 2.6);
print("voor deze muur zijn " . $aantal . " tegels nodig.<br>");

// c
function berekenAantalDozen($breedte, $hoogte) {
    $aantalTegels = berekenAantalTegels($breedte, $hoogte);
    $aantalDozen = $aantalTegels / 20;
    $aantalDozen = ceil($aantalDozen);
    return $aantalDozen;
}

$aantalDozen = berekenAantalDozen(5, 2.6);
print("voor deze muur moet je " . $aantalDozen . " dozen kopen.<br>");

// d
function berekenAantalTegels_d($breedte, $hoogte, $lengteTegel, $breedteTegel) {
    $aantalVierkanteMeters = $breedte * $hoogte;
    $vierkanteMeterPerTegel = $lengteTegel * $breedteTegel;
    $aantalTegels = $aantalVierkanteMeters / $vierkanteMeterPerTegel;
    return ceil($aantalTegels);
}

$aantal = berekenAantalTegels_d(5, 2.6, 0.15, 0.15);
print("voor deze muur zijn " . $aantal . " tegels nodig.<br>");

// e
function berekenAantalDozen_e($breedte, $hoogte, $lengteTegel, $breedteTegel) {
    $aantalTegels = berekenAantalTegels_d($breedte, $hoogte, $lengteTegel, $breedteTegel);
    $aantalDozen = $aantalTegels / 20;
    $aantalDozen = ceil($aantalDozen);
    return $aantalDozen;
}

$aantalDozen = berekenAantalDozen_e(5, 2.6, 0.15, 0.15);
print("voor deze muur moet je " . $aantalDozen . " dozen kopen.<br>");

// f
function berekenAantalDozen_f($breedte, $hoogte, $lengteTegel, $breedteTegel, $aantalPerDoos) {
    $aantalTegels = berekenAantalTegels_d($breedte, $hoogte, $lengteTegel, $breedteTegel);
    $aantalDozen = $aantalTegels / $aantalPerDoos;
    $aantalDozen = ceil($aantalDozen);
    return $aantalDozen;
}

$aantalDozen = berekenAantalDozen_f(5, 2.6, 0.15, 0.15, 20);
print("voor deze muur moet je " . $aantalDozen . " dozen kopen.<br>");
?>
