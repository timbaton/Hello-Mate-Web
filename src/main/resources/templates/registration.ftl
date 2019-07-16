<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Registration</title>

<#--style-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">

    <link rel="stylesheet" href="/css/registration.css">
</head>
<body>
<#include "navbar.ftl" />

<div class="container">

    <br>
    <br>
    <div class="card bg-light" id="win">
        <article class="card-body mx-auto" style="max-width: 400px;">
            <h4 class="card-title mt-3 text-center">Create Account</h4>
            <p class="text-center">Get started with your free account</p>

            <div class="form-group input-group" align="center">
                <button class="btn btn-twitter" onclick="registrateVk(this)"><i class="fab fa-vk"></i>  Login
                    via
                    vk
                </button>
            </div> <!-- form-group// -->

            <p class="divider-text">
                <span class="bg-light">OR</span>
            </p>
            <form method="post" id="wins">
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <input id="login" name="login" class="form-control" placeholder="Login" type="text" required>
                </div> <!-- form-group// -->

                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <input id="name" name="name" class="form-control" placeholder="Name" type="text" required>
                </div> <!-- form-group// -->

                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <input name="surname" class="form-control" placeholder="Surname" type="text" required>
                </div> <!-- form-group// -->

                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
                    </div>
                    <input name="mail" class="form-control" placeholder="Email address" type="email" required>
                </div> <!-- form-group// -->

                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-phone"></i> </span>
                    </div>
                    <select class="custom-select" style="max-width: 120px;">
                        <option value="3">+7</option>
                    </select>
                    <input name="phone" class="form-control" placeholder="Phone number" type="text" required>
                </div> <!-- form-group// -->

                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                    </div>
                    <input name="password" class="form-control" placeholder="Create password" type="password" required>
                </div> <!-- form-group// -->

                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                    </div>
                    <input name="repeatPassword" class="form-control" placeholder="Repeat password" type="password"
                           required>
                </div> <!-- form-group// -->

                <#if errors??>
                    <div class="alert alert-danger" role="alert">
                        <strong>Oh snap!</strong> ${errors}
                    </div> <!-- errors -->
                </#if>

                <div id="myModal" class="modal">

                    <!-- Modal content -->
                    <div class="modal-content">
                        <span class="close" id="closeBtn">&times;</span>
                        <p>Some text in the Modal..</p>
                    </div>

                </div>

                <br>

                <button type="submit" class="btn btn-primary btn-block"> Create Account</button>

                <p class="text-center">Have an account? <a href="/login">Log In</a></p>
            </form>
        </article>
    </div> <!-- card.// -->

    <br>
    <br>

</div>
<!--container end.//-->

<#--js-->
<script src="/js/jQuery.js"></script>

<#--Bootstrap-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

<script src="/js/registration.js"></script>
</body>
</html>
