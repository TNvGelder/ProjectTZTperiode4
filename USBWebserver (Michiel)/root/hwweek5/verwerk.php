<?php

if ($_GET["feedback"] < 1 || $_GET["feedback"] > 5) {
    print("error");
} else {
    if ($_GET["feedback"] >= 1) {
        print("*");
    }

    if ($_GET["feedback"] >= 2) {
        print("*");
    } else {
        print("");
    }

    if ($_GET["feedback"] >= 3) {
        print("*");
    } else {
        print("");
    }

    if ($_GET["feedback"] >= 4) {
        print("*");
    } else {
        print("");
    }

    if ($_GET["feedback"] == 5) {
        print("*");
    } else {
        print("");
    }
}
?>