<!DOCTYPE html>
<!--
S1076823 Michiel Janssen
Opgave 5 verwerk
-->
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="stijl.css">
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <h1>Opgave 5</h1>
        <?php
        $van = $_GET["van"];
        $naar = $_GET["naar"];
        print("Je reist van " . $van . " naar " . $naar);

        print("<form action='opgave5.php' method='GET'>");
        print("Van: <input type='text' name='naar' value=" . $naar . "><br>");
        print("Naar: <input type='text' name='van' value=" . $van . "><br>");
        print("<input type='submit' name ='planterugreis'value='terugreis'>")
        ?>
    </body>
</html>
