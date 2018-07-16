$(function () {
    var password = $("#passwordId");
    var passwordConfirm = $("#passwordConfirmId");
    function validatePassword() {
        if (password.val() !== passwordConfirm.val()) {
            passwordConfirm[0].setCustomValidity("Passwords Don't Match");
        } else {
            passwordConfirm[0].setCustomValidity('');
        }
    }
    password.change(validatePassword);
    passwordConfirm.keyup(validatePassword);
});