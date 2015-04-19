<?php

$aantaljagers = 5;
$aantalherten = 8;


if ($aantaljagers == $aantalherten) {
    print("Voor iedere jager een hert!");
} elseif ($aantaljagers > $aantalherten) {
    print("Je hebt " . ($aantaljagers - $aantalherten) . " jagers meer dan herten");
} else {
    print("Een jager moet gemiddeld " . ($aantalherten / $aantaljagers) . " herten schieten");
}
foreach ($aantalherten as $hert) {
    print("<img src='http://www.schilderijenshop.com/media/catalog/product/cache/1/image/0f396e8a55728e79b48334e699243c07/e/x/exde191.jpg'</img>");
}
?>