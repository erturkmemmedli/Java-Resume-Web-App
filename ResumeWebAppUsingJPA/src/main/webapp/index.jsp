<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Resume Application Main Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="assets/css/login.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <style>
        body,h1 {font-family: "Raleway", sans-serif}
        body, html {height: 100%}
        .bgimg {
            background-image: url('https://www.w3schools.com/w3images/forestbridge.jpg');
            min-height: 100%;
            background-position: center;
            background-size: cover;
        }
    </style>
</head>
<body>
<div class="bgimg w3-display-container w3-animate-opacity w3-text-white">
    <div class="w3-display-topleft w3-padding-large w3-xlarge">
        by Arturk Mammadli
    </div>
    <div class="w3-display-middle">
        <h1 class="w3-jumbo w3-animate-top">RESUME APPLICATION</h1><br/>
        <div style='float:left; margin-left: 120px'>
            <form action="login">
                <button class="log">Login</button>
            </form>
        </div>
        <div style='float:right; margin-right: 120px'>
            <form action="register">
                <button class="reg">Register</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
