<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <form method="post" action="factuur_maken.php">
            <p>Werkzaamheid 1:<p><br />
            <p>Naam: </p><input type="text" name="naam_werkzaamheid1" value="nog wijzigen"><br />
            <p>Prijs: </p><input type="text" name="prijs_werkzaamheid1" value="nog wijzigen"><br />
            <input type="submit" name="toevoegen_werkzaamheid1" value="Toevoegen"><br />
        </form>

        <hr>

        <form method="post" action="klantgegevens.php">
            <!--
            Misschien moet dit ook naar factuur_maken en/of misschien moet het
            allemaal in 1 form(ulier)
            -->
            <p>Klantgegevens:</p><br />
            <p>Naam: </p><input type="text" name="naam_klant" value="nog wijzigen"><br />
            <p>Straatnaam: </p><input type="text" name="straat_klant" value="nog wijzigen"><br />
            <p>Huisnummer: </p><input type="text" name="huisnummer_klant" value="nog wijzigen">
            <p>Postcode: </p><input type="text" name="postcode_klant" value="nog wijzigen"><br />
            <p>Woonplaats: </p><input type="text" name="woonplaats_klant" value="nog wijzigen"><br />
            <p>Bedrijf: </p><input type="text" name="bedrijf_klant" value="nog_wijzigen"><br />
            <input type="submit" value="Opslaan & Versturen">
        </form>
    </body>
</html>
