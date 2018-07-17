$(function () {
    var password = $("#newPassword");
    var passwordConfirm = $("#newPasswordConfirm");
    function validatePassword() {
        if (password.val() !== passwordConfirm.val()) {
            passwordConfirm[0].setCustomValidity("Passwords Don't Match");
        } else {
            passwordConfirm[0].setCustomValidity('');
        }
    }

    $('#passwordForm').validate({
        errorElement: 'div',
        rules: {
            oldPassword: {
                required: true,
                minLength: 8
            },
            newPassword: {
                required: true,
                minLength: 8
            },
            newPasswordConfirm: {
                required: true,
                equalTo: '#newPassword'
            }
        },
        messages: {
            oldPassword: "Write your old password",
            newPassword: "Inser a valid password",
            newPasswordConfirm: "Write the same password"
        },
        submitHandler: function(form) {
            form.submit();
        }
    });



    $('#informationForm').validate({ // initialize the plugin
        errorElement: 'div',
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
        submitHandler: function(form) {
            form.submit();
        }
    });
});