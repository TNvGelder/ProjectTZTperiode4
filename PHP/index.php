<?php
ini_set('display_errors', 1);
error_reporting(E_ALL);
include 'connection/connection.php';
session_start();

if (isset($_GET["error"])) {
	$errorlogin = 'U moet eerst inloggen!';
}else{
        $errorlogin = '';
    }

if (isset($_POST["verstuur"])) {

    //encrypting password
    $password = sha1($_POST["password"]);
    $emailadres = $_POST["emailadres"];
    $sth = $dbh->prepare("SELECT * FROM stakeholder WHERE emailadres =:email AND wachtwoord =:password");
    $bindings = array(
        "email" => $emailadres,
        "password" => $password,
    );
    $sth->execute($bindings);
    $user = $sth->fetch(PDO::FETCH_ASSOC);

   
    if (isset($_SESSION["blockDate"])) {
        if ($_SESSION["blockDate"] > date("Y-m-d H:i:s")) {                                   //Check of blockdatum al bereikt is, zoja zet pogingen en blockdate op 0
            $_SESSION["pogingen"] = 0;
            $_SESSION["blockDate"] = 0;
        }
    }
    if (isset($_SESSION["pogingen"])) {
        if ($_SESSION["pogingen"] > 4) {        //als pogingen hoger dan 4 ( dus na 5 pogingen)
            $date = date("Y-m-d H:i:s");       //huidige datum
            $currentDate = strtotime($date);      //string to date zodat tijd toegevoegd kan worden
            $futureDate = $currentDate + (60 * 5);       //5 minuten toevoegen (5x 60 seconden)
            $formatDate = date("Y-m-d H:i:s", $futureDate);                          //weer omzetten in een string
            $_SESSION["blockDate"] = $formatDate;                                           //opslaan in session
            $errorlogin = 'U heeft te vaak proberen in te loggen, u kunt 5 minuten niet inloggen';
        }
    } elseif (!$user) {
        $errorlogin = "uw gebruikersnaam of wachtwoord is onjuist";
        $_SESSION["pogingen"] ++;
    }
    if ($user && $_SESSION["pogingen"] < 5) {
        $_SESSION["login"] = 1;
        $_SESSION["naam"] = $user["naam"] . " " . $user["achternaam"];
        header('Location:user.php');
    }
}

if (!filter_input(INPUT_GET, "error", FILTER_VALIDATE_INT)) {
    $error = 'U moet inloggen om deze pagina te bezoeken';
} else {
    $error = "";
}
?>
<!DOCTYPE HTML>
<html>
    <head>
        <title>TZT | Public Blended Shipping</title>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <meta name="description" content="geheim" />
        <meta name="keywords" content="geheim" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->


        <link rel="stylesheet" href="/ResponsiveSlides/responsiveslides.css">
        <link rel="stylesheet" href="/ResponsiveSlides/slider1/themes/themes.css">


        <link rel="stylesheet" href="css/skel.css" />
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/home.css" />
        <link rel="stylesheet" href="css/style-wide.css" />
        <link href="/css/featherlight.css" type="text/css" rel="stylesheet" title="Featherlight Styles" />



        <script src="//code.jquery.com/jquery-latest.js"></script>
        <script src="//cdn.rawgit.com/noelboss/featherlight/1.2.0/release/featherlight.min.js" type="text/javascript" charset="utf-8"></script>

        <script src="/ResponsiveSlides/responsiveslides.min.js"></script>
        <script>
            // You can also use "$(window).load(function() {"
            $(function () {

                // Slideshow 1
                $("#slider1").responsiveSlides({
                    auto: true,
                    pager: true,
                    nav: true,
                    speed: 500,
                    maxwidth: 1000,
                    namespace: "centered-btns"
                });

                // Slideshow 2
                $("#slider2").responsiveSlides({
                    auto: false,
                    pager: true,
                    nav: true,
                    speed: 500,
                    maxwidth: 800,
                    namespace: "transparent-btns"
                });

                // Slideshow 3
                $("#slider3").responsiveSlides({
                    auto: false,
                    pager: false,
                    nav: true,
                    speed: 500,
                    maxwidth: 800,
                    namespace: "large-btns"
                });

            });
        </script>
    </head>
    <body class="homebody">



        <div class="nav">
            <img id="homelogo"  src="css/images/logosmall.png"></img>
	<p id="error"> <?php if (isset($errorlogin)) { echo $errorlogin; } ?> </p>
            <a href="login.php" data-featherlight="login.php">Login</a>
            <a href="register.php" data-featherlight="register.php">Register</a>
        </div>


        <!-- Header -->
        <div id="home">
            <div id="homecontent">

                <!-- Slideshow 1 -->
                <div class="rslides_container">
                    <ul class="rslides" id="slider1">
                        <li><img src="/ResponsiveSlides/slider1/images/1.jpg" alt=""></li>
                        <li><img src="/ResponsiveSlides/slider1/images/2.jpg" alt=""></li>
                    </ul>
                </div>

                <!-- content -->
                <div class="row 50%">
                    <div class="6u"><img class="homeimg" src="css/images/pie_chart.png"></img> 
                    </div>
                    <div class="6u"><img class="homeimg" src="css/images/bar_chart.png"></img> 
                    </div>
                </div>
                <p font-size="10px">Kijk op deze grafiek, zoveel taart verdien je met treinkoerieren, kijk hier op deze grafiek, zo gekleurd als deze balken zijn is jouw pakket snel verstuurd!</p>
            </div>
        </div>


        <!-- Footer -->
        <div id="homefooter">

            <!-- Copyright -->
            <ul class="copyright">
                <li><span class="copyright">Copyright <?php echo date("Y"); ?> &copy; Kmp01 Groep 2 Windesheim ICT</span></li>
            </ul>

        </div>

    </body>
</html>