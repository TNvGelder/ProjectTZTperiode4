<!DOCTYPE html>
<?php

function printSpreadsheet_a($getallen) {
    print("<table>");
    foreach ($getallen as $rij) {
        print ("<tr>");
        foreach ($rij as $waarde) {
            print("<td>" . $waarde . "</td>");
        }
        print ("</tr>");
    }
    print("</table>");
}

function printSpreadsheet_b($getallen) {
    print("<table>");
    foreach ($getallen as $rij) {
        print ("<tr>");
        foreach ($rij as $waarde) {
            print("<td");
            if ($waarde > 0) {
                print(" class=\"groen\"");
            } elseif ($waarde < 0) {
                print(" class=\"rood\"");
            }
            print(">" . $waarde . "</td>");
        }
        print ("</tr>");
    }
    print("</table>");
}

function printSpreadsheet_c($getallen, $middelwaarde) {
    print("<table>");
    foreach ($getallen as $rij) {
        print ("<tr>");
        foreach ($rij as $waarde) {
            print("<td");
            if ($waarde > $middelwaarde) {
                print(" class=\"groen\"");
            } elseif ($waarde < $middelwaarde) {
                print(" class=\"rood\"");
            }
            print(">" . $waarde . "</td>");
        }
        print ("</tr>");
    }
    print("</table>");
}
?>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
        <meta charset="UTF-8">
        <title></title>
        <style>
            td {text-align: right; border: solid 1px;}
            .rood {background-color: red }
            .groen {background-color: green }
        </style>
    </head>
    <body>
        <?php
        print("<h1>Opgave a</h1>");
        $getallen = array(array(1, -2, 3, 0), array(4, 2, -5, 1), array(-4, -1, 0, 8));
        printSpreadsheet_a($getallen);

        print("<h1>Opgave b</h1>");
        printSpreadsheet_b($getallen);

        print("<h1>Opgave c</h1>");
        printSpreadsheet_c($getallen, 2);

        print("<h1>Opgave d</h1>");
        $middelwaarde = 0; // defaultwaarde voor als er nog geen waarde is ingevoerd in het formulier
        if (isset($_GET["okKnop"])) {
            $middelwaarde = $_GET["middelwaarde"];
        }
        ?>
        <form action="6_spreadsheet.php" method="get">
            middelwaarde: <input type="text" name="middelwaarde" value="<?php print($middelwaarde); ?>"><br>
            <input type ="submit" name="okKnop" value="ok">
        </form>
        <?php
        printSpreadsheet_c($getallen, $middelwaarde);
        ?>
    </body>
</html>
