$(function () {


    $(".messagePost").hide();

    $('#resetPasswordForm').validate({
        errorElement: 'div',
        onfocusout: false,
        rules: {
            newPassword: {
                required: true
            },
            newPasswordConfirm: {
                equalTo: "#newPassword"
            }
        },
        messages: {
            newPassword: "Write a valid password",
            newPasswordConfirm: "Write the same password"
        },
        submitHandler: function (form) {
            $.ajax("profile", {
                "type": "POST",
                "data": {
                    "changeType": "password",
                    "newPassword": $("#newPassword").val()
                }
            })
                .done(showPopup)
                .fail(ajaxError)
                .always(hidePopup);
            return false;
        }
    });


    $('#informationForm').validate({ // initialize the plugin
        errorElement: 'div',
        onfocusout: false,
        rules: {
            userName: {
                required: true,
                minlength: 3
            },
            firstName: {
                required: true,
                minlength: 2
            },
            lastName: {
                required: true,
                minlength: 2
            },
            dateOfBirth: {
                required: true,
                minlength: 2
            },
            gender: {
                required: true,
            },
            phone: {
                required: true,
                minlength: 2
            },
            email: {
                required: true,
                minlength: 2
            },
            line1: {
                required: true,
                minlength: 2
            },
            city: {
                required: true,
                minlength: 2
            },
            state: {
                required: true,
                minlength: 2
            },
            zipCode: {
                required: true,
                minlength: 2
            }
        },
        messages: {
            userName: "Please insert a valid user name",
            firstName: "Please insert a valid first name",
            lastName: "Please insert a valid last name",
            dateOfBirth: "Please insert a valid date Of birth",
            gender: "Please insert a valid gender",
            phone: "Please insert a valid phone",
            email: "Please insert a valid email",
            line1: "Please insert a valid line 1",
            line2: "Please insert a valid line 2",
            city: "Please insert a valid city",
            state: "Please insert a valid state",
            zipCode: "Please insert a valid zip Code",
        },
        submitHandler: function (form) {

            $.ajax("profile", {
                "type": "POST",
                "data": {
                    "changeType": "info",
                    "userName": $("#userName").val(),
                    "firstName": $("#firstName").val(),
                    "lastName": $("#lastName").val(),
                    "dateOfBirth": $("#dateOfBirth").val(),
                    "gender": $("#gender").val(),
                    "phone": $("#phone").val(),
                    "email": $("#email").val(),
                    "line1": $("#line1").val(),
                    "line2": $("#line2").val(),
                    "city": $("#city").val(),
                    "state": $("#state").val(),
                    "zipCode": $("#zipCode").val()
                }
            })
                .done(showPopup)
                .fail(ajaxError)
                .always(hidePopup);
            return false;
        }
    });

    function showPopup(value) {
        $('.messagePost').fadeIn("slow");
        if (value.includes("info")) {
            $('.messagePost').html("Your Information has been updated");
        } else {
            $('.messagePost').html("Your password has been changed");
        }
    }

    function hidePopup(value) {
        setTimeout(function (e) {
            $('.messagePost').fadeOut("slow");
        }, 2000);
    }

    function ajaxError(xhr, status, exception) {
        console.log(xhr, status, exception);
    }
});