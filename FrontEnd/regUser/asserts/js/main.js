// loading contex separately
mainFunction();

function mainFunction() {
    $('.car-details-section').css({display: "none"});
    $('.renal-req-section').css({display: "none"});
    $('.myAccount-section').css({display: "none"});
    $('.rental-status-section').css({display: "none"});
    $('.login-section').css({display: "block"});

}

$('#myAccountButton').click(function () {
    $('.car-details-section').css({display: "none"});
    $('.renal-req-section').css({display: "none"});
    $('.myAccount-section').css({display: "block"});
    $('.rental-status-section').css({display: "none"});
});

$('#RegisteredUserHome').click(function () {
    $('.car-details-section').css({display: "block"});
    $('.renal-req-section').css({display: "block"});
    $('.myAccount-section').css({display: "none"});
    $('.rental-status-section').css({display: "none"});
});

$('#logOutButton').click(function () {
    $('.car-details-section').css({display: "none"});
    $('.renal-req-section').css({display: "none"});
    $('.myAccount-section').css({display: "none"});
    $('.rental-status-section').css({display: "none"});
})

$('#rentStatusButton').click(function () {
    $('.car-details-section').css({display: "none"});
    $('.renal-req-section').css({display: "none"});
    $('.myAccount-section').css({display: "none"});
    $('.rental-status-section').css({display: "block"});
})

$('#login').click(function () {
    let NIC = $('#loginNIC').val();
    let password = $('#loginPassword').val();

    $.ajax({
        method: "GET",
        url: "http://localhost:8080/BackEnd_war_exploded/api/v1/user/"+NIC,
        async: true,
        success:function (resp) {
            console.log(resp.data);
            if (resp.data.password==password){
                console.log("ela")
                loadRegUserDetails(NIC);

            }
        }

    });


});

function loadRegUserDetails(NIC) {
    $('.login-section').css({display: "none"});
    $('.car-details-section').css({display: "block"});
    $('.renal-req-section').css({display: "block"});

    console.log(NIC);


}