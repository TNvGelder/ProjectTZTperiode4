<!DOCTYPE html>
<?php

function toonVolledigBericht($bericht) {
    print("<h1>" . $bericht["titel"] . "</h1>");
    print("<img src=\"" . $bericht["afbeelding"] . "\"/>");
    print("<div>" . $bericht["tekst"] . "</div>");
}

// Voor het "lees meer" linkje heb je in deze functie ook het nummer
// van het bericht nodig
function toonHeadline($bericht, $nummer) {
    print ("<h1>" . $bericht["titel"] . "</h1>");
    print (substr($bericht["tekst"], 0, 40));
    print ("... ");
    print("<a href=\"7_nieuwsberichten.php?nummer=" . $nummer . "\">lees meer</a>");
}

$bericht1 = array("titel" => "Grote brand",
    "tekst" => "De grote brand die vanmiddag woedde in een bovenwoning tussen Madamme Tussauds en Forever 21 is onder controle. Rond 3 uur gaf de brandweer het sein meester.",
    "afbeelding" => "https://pbs.twimg.com/media/Bx0JNy1IYAA-jEb.jpg:small");
$bericht2 = array("titel" => "Kans op warmste jaar ooit",
    "tekst" => "De komende dagen verlopen nat, maar doordat de nachtelijke temperaturen hoog uitvallen blijft de daggemiddelde temperatuur flink boven normaal. Om het record mis te lopen moeten het einde van oktober, november en december samen kouder dan normaal verlopen volgens de meteorologen van weeronline.nl.",
    "afbeelding" => "http://www.knack.be/medias/623/319399.jpg");
$bericht3 = array("titel" => "Grote opkomst Sinterklaasfeest",
    "tekst" => "Op woensdag 27 november 2013 waren Sinterklaas en zijn Pieten op bezoek in Ouddorp. Meer dan 200 kinderen waren aanwezig op dit gezellige feest in de Dorpstienden, georganiseerd door Sportvereniging De Kriekel en AH De Berg uit Ouddorp. Er was deze middag van alles te doen. Zo was er een apenkooi opgezet, de kinderen konden turnen op de tumblingbaan, meedoen met badminton, volleybal, judo en streetdance en er kon geknutseld worden en geschminkt.",
    "afbeelding" => "http://petities.nl/system/uploads/864/original/sinterklaas.jpg?1305972068");
$nieuwsberichten = array($bericht1, $bericht2, $bericht3);

// De default waarde voor het geselcteerde bericht is -1.
// Omdat dit nooit een bericht nummer kan zijn (want dat zijn de index waarden vanaf 0),
// krijg je in eerste instantie van alle berichten alleen de headline te zien.
$geselecteerd = -1;
if (isset($_GET["nummer"])) {
    $geselecteerd = $_GET["nummer"];
}
?>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
        <style>
            img {width: 200px;}
        </style>
    </head>
    <body>
        <?php
        // Toon alle berichten. Het geselecteerde bericht wordt volledig getoond
        foreach ($nieuwsberichten as $nummer => $bericht) {
            if ($nummer == $geselecteerd) {
                toonVolledigBericht($bericht);
            } else {
                toonHeadline($bericht, $nummer);
            }
        }
        ?>
    </body>
</html>
