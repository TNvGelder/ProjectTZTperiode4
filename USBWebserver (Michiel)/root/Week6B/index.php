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
        <?php
        $link = mysqli_connect("localhost", "root", "usbw", "cursus", 3307);
        if ($link) {
            print("Verbinding is gemaakt" . "<br>");
        } else {
            print("Kan helaas geen verbinding maken");
            print(mysqli_connect_error());
        }

        print("<table>");


        $result = mysqli_query($link, "SELECT naam, afd FROM medewerker WHERE afd =" . $_GET["afdeling"]);

        if (!$result) {
            echo "FOUT: " . mysqli_error($link);
        }

        $row = mysqli_fetch_assoc($result);

        while ($row) {
            print("<tr>");
            print("<td>" . $row["naam"] . "</td>");
            print("<td>" . $row["afd"] . "</td>");
            print("</tr>");
            $row = mysqli_fetch_assoc($result); //volgende rij
        }

        print("</table");
        ?>
    </body>
</html>
