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
        <table>
            <tr>
                <td>Voornaam: </td>
                <td>Achternaam: </td>
                <td>Telefoonnummer: </td>
            </tr>
            <tr>
                <td>Ted</td>
                <td>de Jager</td>
                <td>0728831745</td>
            </tr>
            <tr>
                <td>Bob</td>
                <td>de Bob</td>
                <td>0782819472</td>
            </tr>
            <tr>
                <td>Jan</td>
                <td>van Voorst</td>
                <td>0948655103</td>
            </tr>

            <?php
            print("<h1>De telefoongids</h1>");
            print("<b>Wie: </b>");
            print("<p>persoon of bedrijf op naam");
            print("<form method='get' action='verwerk.php'>");
            print("<input type='text' name='persoonbedrijf'><br>");
            print("Telefoonnummer:<br>");
            print("<input type='text' name='telefoonnummer'><br>");
            print("<input type='submit' value='Zoek:'>");
            print("</form>");
            ?>
        </table>
    </body>
</html>
