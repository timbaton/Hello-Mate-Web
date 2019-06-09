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

    <!-- Main css -->
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>

<#--<!-- Sing in  Form &ndash;&gt;-->
<#--<div class="container">-->
   <#---->

    <#--<form method="post" class="register-form" id="login-form">-->
        <#--<div class="row">-->
            <#--<div class="col-sm-4">-->


            <#--</div>-->
    <#--</form>-->
<#--</div>-->

<form method="post" id="login-form">
    <div class="card" style="width: 18rem;">
        <img class="card-img-top" src="images/login.jpg" alt="Card image cap">
        <div class="card-body">
            <h5 class="card-title">Sign up</h5>
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's
                content.</p>
        </div>
        <ul class="list-group list-group-flush">
            <li class="list-group-item">
                <label for="login"></label>
                <input type="text" name="login" id="login" placeholder="Login"/>
            </li>
            <li class="list-group-item">
                <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
                <input type="password" name="password" id="password" placeholder="Password"/>
            </li>
            <li class="list-group-item">
                <input type="submit" name="signin" id="signin" class="form-submit" value="Log in"/>

                <input type="checkbox" name="remember-me" id="remember-me" class="agree-term"/>
                <label for="remember-me" class="label-agree-term">Remember me</label>
            </li>
        </ul>
        <div class="card-body">
            <a href="/register" class="signup-image-link">Create an account</a>
        </div>
    </div>
</form>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>
