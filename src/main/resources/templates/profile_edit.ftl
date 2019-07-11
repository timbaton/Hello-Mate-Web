<!DOCTYPE html>
<html lang="en">
<head>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<#--CSS-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
    <link rel="stylesheet" href="/css/event_new.css">
    <link rel="stylesheet" href="/css/style.css">

</head>
<body>

<#include "navbar.ftl" />

<form method="post" enctype="multipart/form-data">

    <div class="container">

        <br>
        <br>
        <div class="card bg-light">
            <article class="card-body mx-auto" style="max-width: 400px;">
            <#--forms-->
                <div class="container">

                    <h4 class="card-title mt-3 text-center">Create new event</h4>
                    <p class="text-center">Try your best to interest other people!</p>


                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-angellist" aria-hidden="true"></i> </span>
                        </div>
                        <input id="name" name="name" class="form-control" placeholder="Name" type="text" required>
                    </div> <!-- form-group// -->

                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-comment-o"></i> </span>
                        </div>
                        <input id="surname" name="surname" class="form-control" placeholder="Surname"
                               type="text" required>
                    </div> <!-- form-group// -->

                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-map-marker" aria-hidden="true"></i> </span>
                        </div>
                        <input id="mail" name="mail" class="form-control" placeholder="Mail" type="email"
                               required>
                    </div> <!-- form-group// -->

                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text">  <i class="fa fa-calendar"> </i> </span>
                        </div>
                        <input name="phone" class="form-control" placeholder="Phone" type="number" required>
                    </div> <!-- form-group// -->

                </div>


            <#--images-->
                <div class="container" style="margin-top: 20px;">

                    <label for="images">Change your avatar</label>
                    <input name="avatar" type="file" class="form-control-file"
                           id="avatar" required>
                </div>

                <br>


                <button type="submit" class="btn btn-primary btn-block"> Create Event</button>

                <br>

                <br>

            </article>
        </div> <!-- card.// -->
    </div>
</form>


<#--js-->
<script src="/js/jQuery.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

<script src="/js/event_new.js"></script>
<script src="/js/project.js"></script>
</body>
</html>
