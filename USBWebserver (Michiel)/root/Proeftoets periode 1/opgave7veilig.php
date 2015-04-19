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
        <h1>Opgave 7</h1>
        <?php
        $link = mysqli_connect("localhost", "root", "usbw", "cursus", 3307);
        /* "cursus veranderen naar database die nodig is
          if ($link) {
          print("Verbinding is gemaakt");
          } else {
          print("Kan helaas geen verbinding maken");
          print(mysqli_connect_error());
          } */
        $query = "SELECT mnr, naam, functie FROM medewerker";
        $statement = mysqli_prepare($link, $query);
        //eerst parameters binden mocht dat nodig zijn
        mysqli_stmt_execute($statement);
        mysqli_stmt_bind_result($statement, $mnr, $naam, $functie);
        mysqli_store_result($statement);

        while (mysqli_stmt_fetch($statement)) { /* zolang er nog rijen zijn */
            if ($functie == "TRAINER") {
                $istrainer = "is trainer";
            } else {
                $istrainer = "is geen trainer";
            }
            print($mnr . " " . $naam . " " . $istrainer . "<br>");
        }
        mysqli_stmt_free_result($result);
        mysqli_close($link);
        ?>
    </body>
</html>
