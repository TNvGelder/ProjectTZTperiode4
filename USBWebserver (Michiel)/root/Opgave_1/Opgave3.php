<?php

$getallen = array(12, -6, -3, 3, -1);
foreach ($getallen as $getal) {
    if ($getal < 0) {
        $getal = ($getal * -1);
    }
}
print_r($getallen);
