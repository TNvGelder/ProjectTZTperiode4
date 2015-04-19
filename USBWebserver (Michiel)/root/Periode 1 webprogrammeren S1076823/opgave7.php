<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Opgave 7</title>
        <link rel="stylesheet" type="text/css" href="opgave1.css">
        <meta charset="UTF-8">
    </head>
    <body>
        <p>OPGAVE 7<p>
        <p>Hemelobjecten die bij de zon horen:</p>
        <table>
            <?php
            $link = mysqli_connect("localhost", "root", "usbw", "ruimtereisbureau", 3307);
            $query = "SELECT objectnaam, afstand FROM hemelobject WHERE satellietVan = 'ZON'";
            $result = mysqli_query($link, $query);
            $rij = mysqli_fetch_assoc($result);
            while ($rij) {
                print("<tr><td>" . $rij["objectnaam"] . "</td><td>" . $rij["afstand"] . "</td></tr><br>");
                $rij = mysqli_fetch_assoc($result);
            }
            mysqli_free_result($result);
            mysqli_close($link);
            ?>
        </table>
        <p><a href="opgave1.html">Terug</a></p>
    </body>
</html>
