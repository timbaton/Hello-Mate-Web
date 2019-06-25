<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up Form by Colorlib</title>

<#--bootstrap-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<#include "navbar.ftl" />

<div class="container">
    <article class="card-body mx-auto">
        <form method="post" id="login-form">
            <div class="card" style="width: 18rem;">
                <img class="card-img-top" src="images/login.jpg" alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title">Sign up</h5>
                <#--<p class="card-text">Some quick example text to build on the card title and make up the bulk of the-->
                <#--card's-->
                <#--content.</p>-->
                </div>
                <ul class="list-group list-group-flush">

                    <li class="list-group-item">
                        <label for="login">Login</label>
                        <input type="text" class="form-control" name="login" id="login" placeholder="Login"/>
                    </li>

                    <li class="list-group-item">
                        <label for="your_pass">Password<i class="zmdi zmdi-lock"></i></label>
                        <input type="password" class="form-control" name="password" id="password"
                               placeholder="Password"/>
                    </li>

                    <li class="list-group-item">
                        <input type="submit" name="signin" id="signin" class="btn btn-primary btn-block"
                               value="Login"/>
                        <br>
                        <input type="checkbox" name="remember-me" id="remember-me" class="agree-term"/>
                        <label for="remember-me" class="label-agree-term">Remember me</label>
                    </li>

                </ul>
                <div class="card-body">
                    <a href="/registration" class="signup-image-link">Create an account</a>
                </div>
            </div>
        </form>
    </article>
</div>
</body>
</html>
