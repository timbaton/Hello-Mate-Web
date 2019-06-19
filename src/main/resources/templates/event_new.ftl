<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up</title>


    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">

<#--style-->
    <link rel="stylesheet" href="/css/event_new.css">
    <link rel="stylesheet" href="/css/style.css">

<#--js-->
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>
    <script src="/js/event_new.js"></script>

</head>
<body>

<div class="container" align="center" style="margin-bottom: 24px">

    <br>
    <br>
    <div class="card bg-light">
        <form method="post">

        <#--forms-->
            <article class="card-body mx-auto" style="max-width: 380px;">
                <h4 class="card-title mt-3 text-center">Create event</h4>
                <#--<p class="text-center">Get started with your free account</p>-->

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

                <br>

                <br>
                <button type="submit" class="btn btn-primary btn-block"> Create Account</button>

                <p class="text-center">Have an account? <a href="/login">Log In</a></p>
            </article>

            <br>
            <div class="container">

                <div class="row col-sm-9" id="row">
                    <div class="col-sm-4 imgUp">
                        <div class="imagePreview"></div>
                        <label class="btn btn-primary">
                            Upload<input type="file" class="uploadFile img" value="Upload Photo"
                                         style="width: 0px;height: 0px;overflow: hidden;">
                        </label>
                    </div><!-- col-2 -->

                    <div class="col-sm-4 imgUp">
                        <div class="imagePreview"></div>
                        <label class="btn btn-primary">
                            Upload<input type="file" class="uploadFile img" value="Upload Photo"
                                         style="width: 0px;height: 0px;overflow: hidden;">
                        </label>
                    </div><!-- col-2 -->


                    <div class="col-sm-4 imgUp">
                        <div class="imagePreview"></div>
                        <label class="btn btn-primary">
                            Upload<input type="file" class="uploadFile img" value="Upload Photo"
                                         style="width: 0px;height: 0px;overflow: hidden;">
                        </label>
                    </div><!-- col-2 -->
                </div><!-- row -->
            </div><!-- container -->


        </form>
    </div> <!-- card.// -->

</div>
<!--container end.//-->

</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>
