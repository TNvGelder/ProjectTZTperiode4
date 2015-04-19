<!DOCTYPE html>
<!--
S1076823 Michiel Janssen
Opgave 7
-->
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="stijl.css">
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <h1>Opgave 7a</h1>
        <?php
        $link = mysqli_connect("localhost", "root", "usbw", "cursus", 3307);
        // "cursus veranderen naar database die nodig is
        //if ($link) {
        //print("Verbinding is gemaakt");
        //} else {
        //print("Kan helaas geen verbinding maken");
        //print(mysqli_connect_error());
        //}
        $query = "SELECT mnr, naam, functie FROM medewerker";
        $result = mysqli_query($link, $query);
        $rij = mysqli_fetch_assoc($result);
        while ($rij) {
            if ($rij["functie"] == "TRAINER") {//hoofdletters omdat het zo in de database staat
                $istrainer = "is trainer";
            } else {
                $istrainer = "is geen trainer";
            }
            print($rij["mnr"] . " " . $rij["naam"] . " " . $istrainer . "<br>");
            $rij = mysqli_fetch_assoc($result);
        }
        mysqli_free_result($result);
        ?>
        <h1>Opgave 7b</h1>
        Welke functie wil je zien?
        <form method="GET" action="opgave7.php">
            <input type="text" name="functie">
            <input type="submit" value="Zoek!">
        </form>
        <?php
        if (isset($_GET["functie"])) {
            $functie = $_GET["functie"];
            $query = "SELECT mnr, naam FROM medewerker WHERE functie = '$functie'";
            $result = mysqli_query($link, $query);
            $aantalrijen = mysqli_num_rows($result);
            if ($aantalrijen == 0) {
                print("Deze functie bestaat niet!");
            } else {
                print("De volgende $aantalrijen medewerkers hebben de functie $functie: <br>");
            }
            $row = mysqli_fetch_assoc($result);
            while ($row) {
                print($row["mnr"] . " " . $row["naam"] . "<br>");
                $row = mysqli_fetch_assoc($result);
            }
            mysqli_free_result($result);
        }
        mysqli_close($link);
        ?>
    </body>
</html>
