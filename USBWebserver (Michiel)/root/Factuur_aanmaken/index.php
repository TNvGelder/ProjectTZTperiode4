<!DOCTYPE html>
<!--
Factuur aanmaken door Michiel van de VSN01-swaggers
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <form method="post", action="werkzaamheid1_verwerken.php">
            <table>
                <tr>
                    <td>Werkzaamheid 1:</td>
                </tr>
                <tr>
                    <td>Naam:</td>
                    <td><input type="text" name="naam_werkzaamheid1" value="Yolo"></td>
                </tr>
                <tr>
                    <td>Prijs:</td>
                    <td><input type="text" name="prijs_werkzaamheid1" value="Swag"</td>
                </tr>
                <tr>
                    <td><input type="submit" name="toevoegen" value="Toevoegen"</td>
                </tr>
            </table>
        </form>
        <br /><br /><hr>







        <form method="post", action="klantgegevens.php">
            <table>
                <tr>
                    <td>Klantgegevens:</td>
                </tr>
                <tr>
                    <td>Naam:</td>
                    <td colspan=2><input type="text" name="klant_naam" value="360 Noscope"></td>
                </tr>
                <tr>
                    <td>Straatnaam:</td>
                    <td colspan=3><input type="text" name="klant_straat" value="Filee-eters"></td>
                </tr>
                <tr>
                    <td>Huisnummer:</td>
                    <td><input type="text" name="klant_huisnummer" value="montage parodies"></td>
                    <td>Postcode:</td>
                    <td><input type="text" name="klant_postcode" value="pcmstrrce"></td>
                </tr>
                <tr>
                    <td>Woonplaats</td>
                    <td colspan=3><input type="text" name="klant_woonplaats" value="Steffen kan niet spellen"</td>
                </tr>
                <tr>
                    <td>Bedrijf:</td>
                    <td colspan=3><input type="text" name="klant_bedrijf" value="420 Blaze It"></td>
                </tr>
                <tr>
                    <td><input type="submit" name="opslaan_en_versturen" value="Opslaan & Versturen">
                </tr>
            </table>
        </form>
        <?php
        // put your code here
        ?>

    </body>
</html>
