<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<?php
$link = mysqli_connect("localhost", "root", "usbw", "student", 3307);

if (isset($_POST["toevoegen"]) && isset($_POST["studentnummer"]) && $_POST["studentnummer"]) {
    $snr = $_POST["studentnummer"];
    $vnm = $_POST["voornaam"];
    $anm = $_POST["achternaam"];
    $adr = $_POST["adres"];
    $wpl = $_POST["woonplaats"];

    mysqli_stmt_execute($stmt);
    mysqli_stmt_bind_result($stmt, $studentnummer, $voornaam, $achternaam, $adres, $woonplaats);
}
?>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <form method="POST" action="index.php">
            <input type="text" name="vak1" value="">
            <input type="submit" name="Toevoegen" value="toevoegen">
        </form>

        <?php
        $query = "SELECT * FROM student";
        $stmt = mysqli_prepare($link, $query);
        mysqli_stmt_execute($stmt);
        mysqli_stmt_bind_result($stmt, $studentnummer, $voornaam, $achternaam, $adres, $woonplaats);

        print("<table>");
        print("<tr><th>Studentnummer</th>");
        print("<th>Voornaam</th>");
        print("<th>Achternaam</th>");
        print("<th>Adres</th>");
        print("<th>Woonplaats</th></tr>");

        while (mysqli_stmt_fetch($stmt)) {
            print("<tr><td>" . $studentnummer . "</td><td>" . $voornaam . "</td><td>" . $achternaam . "</td><td>" . $adres . "</td><td>" . $woonplaats . "</tr><br>");
        }

        print("</table>");
        mysqli_stmt_free_result($stmt);
        mysqli_close($link);
        ?>
    </body>
</html>
