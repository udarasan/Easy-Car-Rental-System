// loading contex separately
mainFunction();

function mainFunction() {
    $('.car-details-section').css({display: "block"});
    $('.login-section').css({display: "none"});
    $('.registration-section').css({display: "none"});
}

$('#registerButton').click(function () {
        $('.car-details-section').css({display: "none"});
        $('.login-section').css({display: "none"});
        $('.registration-section').css({display: "block"});
});

$('#loginButton').click(function () {
    $('.car-details-section').css({display: "none"});
    $('.login-section').css({display: "block"});
    $('.registration-section').css({display: "none"});
});

$('#gustHome').click(function () {
    $('.car-details-section').css({display: "block"});
    $('.login-section').css({display: "none"});
    $('.registration-section').css({display: "none"});
})
