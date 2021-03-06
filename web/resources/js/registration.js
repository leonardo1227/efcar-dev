$(function () {

    $('form').validate({ // initialize the plugin
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
                email: true,
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
            },
            password1: {
                required: true
            },
            password2: {
                equalTo: "#password1"
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
            city: "Please insert a valid city",
            state: "Please insert a valid state",
            zipCode: "Please insert a valid zip Code",
            password1: "Enter a valid password",
            password2: "Does not match",
        },
        submitHandler: function(form) {
            var allowsubmit = false;
            var pass = $('#password1').val();
            var pass2 = $('#password2').val();
            if(pass === pass2){
                allowsubmit = true;
            }
            if(allowsubmit)
                form.submit();
        }
    });

    $('form').validate();
});