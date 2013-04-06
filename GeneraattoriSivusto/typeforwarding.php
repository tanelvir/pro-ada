<!DOCTYPE html>
<!-- Tämä sivu ohjaa selaimen käyttäjän valitsemaan lomakepohjaan !-->
<html>
    <head>
        <title>BibTeX Generator</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>
            BibTeX Generator
        </h1>
        <?php
        $type = $_POST['type'];

        if (!$type == null) {
            header("Location: " . $type . ".html");
            die();
        }
        ?>
        <p>Oh no, something went wrong! :( Please return to the <a href="index.html">front page</a>.<p>
    </body>
</html>