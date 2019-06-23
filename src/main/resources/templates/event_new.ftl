<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up</title>


    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">

<#--style-->
    <link rel="stylesheet" href="/css/event_new.css">
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>

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
                        <input id="title" name="title" class="form-control" placeholder="Title" type="text" required>
                    </div> <!-- form-group// -->

                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-comment-o"></i> </span>
                        </div>
                        <input id="description" name="description" class="form-control" placeholder="Description"
                               type="text" required>
                    </div> <!-- form-group// -->

                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-map-marker" aria-hidden="true"></i> </span>
                        </div>
                        <input id="location" name="location" class="form-control" placeholder="location" type="text"
                               required>
                    </div> <!-- form-group// -->

                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text">  <i class="fa fa-calendar"> </i> </span>
                        </div>
                        <input name="date" class="form-control" placeholder="Date" type="date" required>
                    </div> <!-- form-group// -->

                </div>


            <#--images-->
                <div class="container" style="margin-top: 20px;">

                    <label for="images">Attach your images</label>
                    <input name="images" type="file" class="form-control-file"
                           id="images" multiple>
                </div>

                <br>

                <button type="submit" class="btn btn-primary btn-block"> Create Event</button>

                <br>

                <br>

            </article>
        </div> <!-- card.// -->
    </div>
</form>


<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<script src="vendor/jquery/jquery.min.js"></script>
<script src="/js/event_new.js"></script>
</body>
</html>
