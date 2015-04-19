<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <form input="get" action="verwerk.php">
            <?php

            function print_r_mooi($array) {
                print("<table");
                foreach ($a as $index => waarde) {
                    print("<tr><td>$index</td><td>$waarde</td></tr>");
                }
                print("</table>");
            }

            $lijstje = array();
            $lijstje[0] = 5;
            $lijstje[1] = 2;
            $lijstje[2] = 6;
            $lijstje[3] = 1;

            print_r_mooi($lijstje)
            ?>
        </form>
    </body>
</html>
