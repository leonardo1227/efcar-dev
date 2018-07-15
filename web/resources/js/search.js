$(function(){

    setCurrentDate();

    $("#btnSearch").click(function(){
        var model =  $("#txtModel").val();
        var brand =  $("#ddlBrand option:selected").val();
        var type =  $("#ddlType option:selected").val();
        var data =  $("#txtDate").val();
        doSearch(model, brand, type);

    });
});

function setCurrentDate(){
    var now = new Date();
    var day = ("0" + now.getDate()).slice(-2);
    var month = ("0" + (now.getMonth() + 1)).slice(-2);
    var today = now.getFullYear()+"-"+(month)+"-"+(day) ;

    $('#txtDate').val(today);
}

function doSearch(model, brand, type){

    $.ajax({
        url : 'home',
        type : 'POST',
        data : {
            'model' : model,
            'brand' : brand,
            'type' : type
        },
        dataType:'json',
        success : function(data) {
        },
        error : function(request,error)
        {
            alert("Request: "+JSON.stringify(request));
        }
    });
}