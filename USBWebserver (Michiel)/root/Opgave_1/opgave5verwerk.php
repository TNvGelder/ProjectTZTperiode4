<?php

if (isset($_GET[submit]) || isset($_GET[van]) || isset($_GET[naar])) {
    print("Je reist van ");
    print($_GET[van]);
    print(" naar ");
    print($_GET[naar]);
}
