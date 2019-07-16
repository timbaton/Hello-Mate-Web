<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up</title>

<#--bootstrap-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">

    <link rel="stylesheet" href="/css/login.css">
</head>
<body>

<#include "navbar.ftl" />

<div class="container">
    <article class="card-body mx-auto">
        <form method="post" id="login-form">
            <div class="card-body mx-auto" style="max-width: 400px;">
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
                </ul>

                <div class="card-body mx-auto" style="max-width: 200px;">
                    <input style="margin-top: 14px" type="submit" name="signin" id="signin"
                           class="btn btn-primary btn-block"
                           value="Login"/>
                    <br>

                    <button style="width: 100%" id="vk" class="btn btn-twitter"><i class="fab fa-vk"></i></button>
                    <br>
                    <br>

                    <a href="/registration" class="signup-image-link">Create an account</a>
                </div>
            </div>
        </form>

    </article>
</div>

<#--js-->
<script src="/js/jQuery.js"></script>

<#--Bootstrap-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

<script src="/js/login.js"></script>
</body>
</html>
