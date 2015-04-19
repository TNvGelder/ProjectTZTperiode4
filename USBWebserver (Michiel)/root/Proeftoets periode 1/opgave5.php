<!DOCTYPE html>
<!--
S1076823 Michiel Janssen
Opgave 5
-->
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="stijl.css">
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <h1>Opgave 5</h1><br>
        <?php
        if (isset($_GET['terugreis']) || !isset($_GET['naar'])) {
            print("Hieronder de terugreis:");
            print("<form action='opgave5verwerk.php'>");
            print("Van: <input type='text' name='van'><br>");
            print("Naar: <input type='text' name='naar'><br>");
            print("<input type='submit' value='Plan reis'>");
        } else {
            print("<form action='opgave5verwerk.php'>");
            print("Van: <input type='text' name='van' value=$van><br>");
            print("Naar: <input type='text' name='naar' value=$naar><br>");
            print("<input type='submit' value='Plan reis'>");
        }
        ?>
    </body>
</html>
