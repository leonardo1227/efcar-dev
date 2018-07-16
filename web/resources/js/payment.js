$(function () {

    $('#cardNumber').blur(function () {
        let cardNumberValue = $('#cardNumber');
        //alert(cardNumberValue.val());
       $.ajax("http://localhost:8080/efcar/cardInformationController?cod="+cardNumberValue.val()[0])
           .done(showCardIcon())
           .fail(ajaxError());
    });
    
    function showCardIcon(value) {
        console.log(JSON.stringify(value));
        //$('#paymentFieldSetInformation').class({"background": value.iconUrl+" no-repeat right"})
        //console.log("gottin")
        //$.each(value, function (index,v) {
        //    console.log(v);
            //$('#paymentFieldSetInformation').class({"background": v.iconUrl+" no-repeat right"});
        //});

    }

    function ajaxError(xht, status, exception) {
        console.log(xhr, status, exception);
    }

});