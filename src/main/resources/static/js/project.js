$('.navbar-nav .nav-item .nav-link').on("click", function(){
    $(".nav-item").find(".active").removeClass("active");
    // $('.navbar-nav .nav-item.active').find.removeClass('active');
    // $(this).addClass("active");
    var active = window.location.pathname;
    $(".nav a[href|='" + active + "']").parent().addClass("active");
    // $(this).parent().addClass('active').siblings().removeClass('active');
});
