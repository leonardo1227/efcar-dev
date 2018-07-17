$(function(){

    setCurrentDate();

    $("#btnSearch").click(function(){
        var model =  $("#txtModel").val();
        var brand =  $("#ddlBrand option:selected").val();
        var type =  $("#ddlType option:selected").val();
        var date =  $("#txtDate").val();
        doSearch(model, brand, type, date);
    });
});

function setCurrentDate(){
    var now = new Date();
    var day = ("0" + now.getDate()).slice(-2);
    var month = ("0" + (now.getMonth() + 1)).slice(-2);
    var today = now.getFullYear()+"-"+(month)+"-"+(day) ;

    $('#txtDate').val(today);
}

function doSearch(model, brand, type, date){

    $.ajax({
        url : 'home',
        type : 'POST',
        data : {
            'date' : date,
            'model' : model,
            'brand' : brand,
            'type' : type
        },
        dataType:'json',
        success : function(data) {
            setProductList(data);
            setClickPagNavEvent();
        },
        error : function(request,error)
        {
            alert("Request: "+JSON.stringify(request));
        }
    });
}

function setProductList(data){

    var productsContainer = $("#productsContainer");
    var pagination = $("<div class='pagination' id='pagination'>");
    var paginationIndex = 0;
    var row = $("<div class='row page" + paginationIndex +"'>");

    productsContainer.empty();


    for(var key in data){

        // set page
        if(key % 9 === 0){
            paginationIndex++;
            var page = $("<a href='#'>");
            page.text(paginationIndex);

            if(paginationIndex === 1){
                page.addClass("active");
            }

            pagination.append(page);
        }

        //set row
        if(key % 3 === 0){
            productsContainer.append(row);
            row = $("<div class='row page" + paginationIndex +"'>");
        }

        //buld the elements
        var column = $("<div class='column' id='column" + data[key].id +"'>");
        var a1 = $("<a href='' class='productClicable'>");
        var img = $("<image class='productImage' src="+  data[key].pictures[0] +">");
        a1.append(img);
        column.append(a1);
        var a2 = $("<a href='' class='productClicable'>\">");
        a2.text(data[key].model.name + "  " + data[key].model.year);
        column.append(a2);
        row.append(column);
    }

    productsContainer.prepend(pagination);

    if(row.length > 0){
        productsContainer.append(row);
    }

    $(".productClicable").click(function(e){
        var id = e.target.parentElement.parentElement.id.replace("column", "");
        var endDate = $("#txtEndDate").val();
        var date = $("#txtDate").val();
        window.location.href =   window.location.href + "/select?carId=" +id+ "&date=" + date + "&endDate=" + endDate;
        return false;
    });

    applyPagination();
}


function applyPagination(){
    var activePageNumber = $(".productsContainer a.active").text();
    $("div.row").hide();
    $("div.page" + activePageNumber).show();
}

function setClickPagNavEvent() {
    $("#pagination a").on("click", function (e) {
        $("a").removeClass("active");
        $(this).addClass("active");
        applyPagination();
    });
}

function isValidDate(input){
    var status = false;
    if (!input || input.length <= 0) {
        status = false;
    } else {
        var result = new Date(input);
        if (result == 'Invalid Date') {
            status = false;
        } else {
            status = true;
        }
    }
    return status;
}