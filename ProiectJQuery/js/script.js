$( document ).ready(function() {

    $(".purpleToFuchsia").click(function() {
        $(".purple").css('background-color', 'fuchsia');
    });

    $(".toggleGreenGrey").click(function(){
        //$( "div div").last().removeClass('green').addClass('grey');
        $( "div div").last().toggleClass('grey');
    });

    $(".switchBoxes").click(function(){

        // $(".red").after($(".green"));
        // $(".purple").before($(".red"));
        //$(".blue").before($(".purple"));

        div1 = $('.red');
        div2 = $('.blue');

        tdiv1 = div1.clone(true);
        tdiv2 = div2.clone(true);

        div1.replaceWith(tdiv2);
        div2.replaceWith(tdiv1);
    });

    $(".insertText").click(function(){
        $(".purple").append('<p class="white">random text</p>')
    });

    var firstClick = null;
    var firstClickClass = null;

    $("div div").each(function(){
        // console.log( $( this ).height() );
        $(this).click(function () {
            if (firstClick == null){
                firstClick = $(this);
                firstClickClass = $(this).attr('class');
            }
            else
            {
                //v1 - bad
                // div1 = firstClick;
                // div2 = $(this);

                // tdiv1 = div1.clone();
                // tdiv2 = div2.clone();
                //
                // div1.replaceWith(tdiv2);
                // div2.replaceWith(tdiv1);

                //v2 - good
                secondClickClass = $(this).attr('class');

                firstClick.removeClass(firstClickClass).addClass(secondClickClass);
                $(this).removeClass(secondClickClass).addClass(firstClickClass);

                firstClickClass = null;
                firstClick = null;

            }
        });


    });


        $( "div div").each(function() {
            $(this).css('height','auto');

            var maxHeight = 0;
            for(var i=0;i<4;i++){
                if(maxHeight<$('div div').eq(i).height())
                    maxHeight=$('div div').eq(i).height();
            }

            $(this).css('min-height',maxHeight);

        });

    $( window ).resize(function() {
        var maxHeight = 0;
        $( "div div").each(function() {
            $(this).css('height','auto');


            for(var i=0;i<4;i++){
                if(maxHeight<$('div div').eq(i).height())
                    maxHeight=$('div div').eq(i).height();
            }

            $(this).css('min-height',maxHeight);

        });
    });




});