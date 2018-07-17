$(function () {

    $('#cardNumber').blur(function () {
        var cardNumberValue = $('#cardNumber');
        $.ajax("cardInformationController", {"type":"GET",
                "data":{"code":cardNumberValue.val()[0]}})
           .done(showCardIcon)
           .fail(ajaxError);
    });
    
    function showCardIcon(value) {
        if(value){
            $('#paymentFieldSetInformation').css({"background": "url('"+value.iconUrl+"') no-repeat right"});
        }else{
            $('#paymentFieldSetInformation').css({"background": "none"});
        }
    }

    function ajaxError(xhr, status, exception) {
        console.log(xhr, status, exception);
    }

});