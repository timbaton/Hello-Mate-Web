<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!--CSS-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">

    <link rel="stylesheet" href="/css/event_new.css">
<#--map-->
    <link rel="stylesheet" href="/css/map.css">
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
                        <input id="title" name="title" class="form-control" placeholder="Title" type="text" required>
                    </div> <!-- Title// -->

                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-comment-o"></i> </span>
                        </div>
                        <input id="description" name="description" class="form-control" placeholder="Description"
                               type="text" required>
                    </div> <!-- Description -->

                    <div class="form-group input-group">

                        <div id="map"></div>

                        <div class="input-group-prepend" style="margin-top: 14px">
                            <span class="input-group-text"> <i class="fa fa-map-marker" aria-hidden="true"></i> </span>
                        </div>
                        <input id="location" name="location" class="form-control" placeholder="location" type="text"
                               required style="margin-top: 14px" readonly>
                    </div> <!-- Location -->

                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text">  <i class="fa fa-calendar"> </i> </span>
                        </div>
                        <input name="date" class="form-control" placeholder="Date" type="datetime-local" required>
                    </div> <!-- Date -->
                </div><#--forms-->


            <#--images-->
                <div class="container" style="margin-top: 20px;">

                    <label for="images">Attach your images</label>
                    <input name="images" type="file" class="form-control-file"
                           id="images" multiple required>
                </div>
            <#--images-->

                <br>

                <button type="submit" class="btn btn-primary btn-block"> Create Event</button>

            </article>
        </div> <!-- card.// -->

        <br>
        <br>

    </div>
</form>

<#--js-->
<script src="/js/jQuery.js"></script>

<#--Bootstrap-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

<#--MAP-->
<#--<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB-wWPEh-3UWpsWdqPZNjgJqKjXqbD62Gs&callback=initMap"></script>-->

<script src="/js/map.js"></script>
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB-wWPEh-3UWpsWdqPZNjgJqKjXqbD62Gs&callback=initChooserMap">
</script>

</body>
</html>
