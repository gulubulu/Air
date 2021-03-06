$(function () {
    //resize window
    $(window).bind("load resize", function () {
        topOffset = 50;
        width = (this.window.innerWidth > 0) ? this.window.innerWidth : this.screen.width;
        if (width < 768) {
            $('div.navbar-collapse').addClass('collapse');
            $('input.submit').addClass('btn-block')
            topOffset = 100; // 2-row-menu
        } else {
            $('input.submit').removeClass('btn-block')
            $('div.navbar-collapse').removeClass('collapse');
        }

        height = ((this.window.innerHeight > 0) ? this.window.innerHeight : this.screen.height) - 1;
        height = height - topOffset;
        if (height < 1) height = 1;
        if (height > topOffset) {
            $("#page-wrapper").css("min-height", (height) + "px");
        }
    });

    $("#side-menu .menu-item").click(function () {
        $("#side-menu .menu-item")
            .removeClass('active')
            .find('i').removeClass('fa-edit').addClass('fa-dashboard')
        $(this).addClass('active').find('i')
            .removeClass('fa-dashboard').addClass('fa-edit')
        $(".page-header").text(this.text)
        var ctx = $(this).attr('id')
        $(".detail-menu > div").removeClass("active")
        $(".detail-menu > div[data-type=\"" + ctx + "\"]").addClass('active')

        $(".navbar-collapse").collapse("hide")
    })

    // $("#side-menu .menu-item")[0].click()

    $('#side-menu').metisMenu();
});