<?php
session_start();
include 'connection/connection.php';
error_reporting(0);
if(isset($_SESSION["login"]) && $_SESSION["login"] != 1)
{
	header( 'Location: ../index.php?error=1' );
}else{
?>
<!DOCTYPE HTML>
<html>
	<head>
		<title>TZT | Public Blended Shipping</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="geheim" />
		<meta name="keywords" content="geheim" />
		<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
		<script src="js/jquery.min.js"></script>
		<script src="js/jquery.scrolly.min.js"></script>
		<script src="js/jquery.scrollzer.min.js"></script>
		<script src="js/skel.min.js"></script>
		<script src="js/skel-layers.min.js"></script>
		<script src="js/init.js"></script>
		<noscript>
			<link rel="stylesheet" href="css/skel.css" />
			<link rel="stylesheet" href="css/style.css" />
			<link rel="stylesheet" href="css/style-wide.css" />
            <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
<link rel="icon" href="/favicon.ico" type="image/x-icon">
		</noscript>
		<!--[if lte IE 9]><link rel="stylesheet" href="css/ie/v9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
	</head>
	<body>

		<!-- Header -->
			<div id="header" class="skel-layers-fixed">

				<div class="top">

					<!-- Logo -->
						<div id="logo">
							<ul>
                                <li>
                                    <nav>
                                    <a href="" id="top-link" class="skel-layers-ignoreHref"><img src="css/images/logosmall.png"></img></a>
                                </li>
                            </ul>
                            </nav>
						</div>
						<div id="user">
							<h1 id="title"><?=$_SESSION["naam"]?></h1>
							<p>Geverifieerd Acount</p>
					<a id="log" href="signout.php" >Uitloggen</a>
						</div>

					<!-- Nav -->
						<nav id="nav">
							<!--
							
Prologue's nav expects links in one of two formats:
								
1. Hash link (scrolls to a different section within the page)
								
<li><a href="#foobar" id="foobar-link" class="icon fa-whatever-icon-you-want skel-layers-ignoreHref"><span class="label">Foobar</span></a></li>

2. Standard link (sends the user to another page/site)

<li><a href="http://foobar.tld" id="foobar-link" class="icon fa-whatever-icon-you-want"><span class="label">Foobar</span></a></li>
							
							-->
							<ul>

                                <li><a href="#dashboard" id="dashboard-link" class="skel-layers-ignoreHref"><span class="icon fa-th">Dashboard</span></a></li>
								<li><a href="#pakketversturen" id="pakketversturen-link" class="skel-layers-ignoreHref"><span class="icon fa-archive">Pakket Versturen</span></a></li>
								<li><a href="#mijnpakketten" id="mijnpakketten-link" class="skel-layers-ignoreHref"><span class="icon fa-user">Mijn Pakketten</span></a></li>
								<li><a href="#saldo" id="saldo-link" class="skel-layers-ignoreHref"><span class="icon fa-eur">Saldo</span></a></li>
								<li><a href="#treinreizen" id="treinreizen-link" class="skel-layers-ignoreHref"><span class="icon fa-train">Mijn Treinreizen</span></a></li>
								<li><a href="#probleem" id="probleem-link" class="skel-layers-ignoreHref"><span class="icon fa-exclamation-circle">Probleem Melden</span></a></li>
								<li><a href="#instellingen" id="instellingen-link" class="skel-layers-ignoreHref"><span class="icon fa-gear">Instellingen</span></a></li>							
							</ul>
						</nav>
						
				</div>
				
				<div class="bottom">

				</div>
			
			</div>

		<!-- Main -->
			<div id="main">
					<section id="dashboard" class="one dark cover">

						<div class="container">
<ul class="buttons">
<a href="#pakketversturen" class="button scrolly"><li><span class="icon fa-archive">&nbsp;&nbsp;Pakket Versturen</span></li></a>
<a href="#mijnpakketten" class="button scrolly"><li><span class="icon fa-user">&nbsp;&nbsp;Mijn Pakketten</span></li></a>
<a href="#saldo" class="button scrolly"><li><span class="icon fa-eur">&nbsp;&nbsp;Saldo</span></li></a>
<a href="#treinreizen" class="button scrolly"><li><span class="icon fa-train">&nbsp;&nbsp;Mijn Treinreizen</span></li></a>
<a href="#probleem" class="button scrolly"><li><span class="icon fa-exclamation-circle">&nbsp;&nbsp;Probleem Melden</span></li></a>
<a href="#instellingen" class="button scrolly"><li><span class="icon fa-gear">&nbsp;&nbsp;Instellingen</span></li></a>
</ul></div>
									
					</section>					
				<!-- Portfolio -->
					<section id="pakketversturen" class="two">
						<div class="container">
					
							<header>
								<h2>Pakket Versturen</h2>
							</header>
							
							<p>Alsde gij hier komt kunde gij pakketen versturen keeltsie.</p>
						
									<article class="item">
										<?php 

if(isset($_POST['submit'])){ 
    /*     * ***************************** 
     * Connect to the database here! 
     * ***************************** */ 
    // search the database to see if the user name has been taken or not 
    $sql = $db->prepare("SELECT * FROM users WHERE user_name = ? LIMIT 1"); 
    $sql->bindValue(1, $_POST['user_name']); 

    $row = $sql->fetch($sql); 
    //check too see what fields have been left empty, and if the passwords match 
    if( 
            $row || 
            empty($_POST['user_name']) || 
            empty($_POST['fname']) || 
            empty($_POST['lname']) || 
            empty($_POST['email']) || 
            empty($_POST['password']) || 
            empty($_POST['re_password']) || 
            $_POST['password'] != $_POST['re_password'] 
    ){ 
        // if a field is empty, or the passwords don't match make a message 
        $error = '<p>'; 
        if(empty($_POST['user_name'])){ 
            $error .= 'User Name can\'t be empty<br>'; 
        } 
        if(empty($_POST['fname'])){ 
            $error .= 'First Name can\'t be empty<br>'; 
        } 
        if(empty($_POST['lname'])){ 
            $error .= 'Last Name can\'t be empty<br>'; 
        } 
        if(empty($_POST['email'])){ 
            $error .= 'Email can\'t be empty<br>'; 
        } 
        if(empty($_POST['password'])){ 
            $error .= 'Password can\'t be empty<br>'; 
        } 
        if(empty($_POST['re_password'])){ 
            $error .= 'You must re-type your password<br>'; 
        } 
        if($_POST['password'] != $_POST['re_password']){ 
            $error .= 'Passwords don\'t match<br>'; 
        } 
        if($row){ 
            $error .= 'User Name already exists<br>'; 
        } 
        $error .= '</p>'; 
    }else{ 
        // If all fields are not empty, and the passwords match, 
        // create a session, and session variables, 
        $sql = $db->prepare("INSERT INTO users_table 
            (`user_name`,`f_name`,`l_name`,`email`,`password`) 
            VALUES 
            (?,?,?,?,MD5(?))"); 

        $sql->bindValue(1, $_POST['user_name']); 
        $sql->bindValue(2, $_POST['fname']); 
        $sql->bindValue(3, $_POST['lname']); 
        $sql->bindValue(4, $_POST['email']); 
        $sql->bindValue(5, $_POST['password']); 

        $sql->execute(); 

        // Redirect the user to a login page 
        header("Location: login.php"); 
        exit; 
    } 
} 
// echo out each variable that was set from above, 
// then destroy the variable. 
if(isset($error)){ 
    echo $error; 
    unset($error); 
} 
?> 
<!-- Start your HTML/CSS/JavaScript here -->
<form action=" <? echo $_SERVER['PHP_SELF']; ?> " method="post">
    <div class="row 50%">
									<div class="6u"><p>User Name:<br /><input type="text" name="user_name" <?php echo (!$row) ? 'value="' . $_POST['user_name'] . '"' : "";?> /></p></div>
									<div class="6u"><p>First Name:<br /><input type="text" name="fname" <?php echo 'value="' . $_POST['fname'] . '"';?> /></p></div>
	</div>
    
    <p>Last Name:<br /><input type="text" name="lname" <?php echo 'value="' . $_POST['lname'] . '"';?> /></p>
    <p>Email:<br /><input type="text" name="email" <?php echo 'value="' . $_POST['email'] . '"';?> /></p>
    <p>Password:<br /><input type="password" name="password" /></p>
    <p>Re-Type Password:<br /><input type="password" name="re_password" /></p>
    <p><input type="submit" name="submit" value="Sign Up" /></p>
</form>
									</article>
						</div>
					</section>

				<!-- About Me -->
					<section id="mijnpakketten" class="three">
						<div class="container">

							<header>
								<h2>Mijn pakketten</h2>
							</header>

							<a href="#" class="image featured"><img src="images/pic08.jpg" alt="" /></a>
							
							<p>hier staat tekst</p>

						</div>
					</section>
			
				<!-- Contact -->
					<section id="saldo" class="four">
						<div class="container">

							<header>
								<h2>Saldo</h2>
							</header>

							<p>Alsde gij wilt contacten moette gij dat hier doen jong.</p>
							
							<form method="post" action="#">
								<div class="row 50%">
									<div class="6u"><input type="text" name="name" placeholder="Name" /></div>
									<div class="6u"><input type="text" name="email" placeholder="Email" /></div>
								</div>
								<div class="row 50%">
									<div class="12u">
										<textarea name="message" placeholder="Message"></textarea>
									</div>
								</div>
								<div class="row">
									<div class="12u">
										<input type="submit" value="Send Message" />
									</div>
								</div>
							</form>

						</div>
					</section>

					<section id="treinreizen" class="five">
					<div class="container">
                         <header>
								<h2>Mijn treinreizen</h2>
							</header>
					<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

					</section>

					<section id="probleem" class="six">
					<div class="container">
                        <header>
								<h2>Probleem melden</h2>
							</header>
                    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
					</div>
					</section>

					<section id="instellingen" class="seven">
					<div class="container">
					<header>
								<h2>Instellingen</h2>
							</header>
                        <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
					</div>
					</section>
			
			</div>

		<!-- Footer -->
			<div id="footer">
				
				<!-- Copyright -->
					<ul class="copyright">
						<li><span class="copyright">Copyright &copy; <?php echo date("Y"); ?> Kmp01 Groep 2 wijzijncool. Opgezet door <a href="http://www.karsbarendrecht.nl" >Kars Barendrecht</a></span></li>
					</ul>
				
			</div>

	</body>
</html>
<? } ?>