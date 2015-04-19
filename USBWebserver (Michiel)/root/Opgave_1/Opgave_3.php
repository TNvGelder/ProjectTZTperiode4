
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="Opgave_1_css.css">
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <?php
        $getallen = array(12, -6, -3, 3, -1);
        $getalnu = array_sum($getallen);
        $optellen = 0;
        print("<table><tr><td>hallo</td><td>3</td></tr></table>");
        print("<table>");
        foreach ($getallen as $index => $getal) {
            if ($getal < 0) {
                $getal = $getal * -1;
            } $optellen = $getal + $optellen;

            print("<tr><td>" . $index . "</td><td>$getal</td></tr>");
        }
        print("</table>");

        print("De som was " . $getalnu . "<br />");
        print("De som is " . array_sum($getallen) . "<br />");
        print($optellen);
        ?>
    </body>
</html>
