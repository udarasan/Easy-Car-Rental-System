// loading contex separately
mainFunction();

function mainFunction() {
    $('.car-details-section').css({display: "block"});
    $('.registration-section').css({display: "none"});
}

$('#registerButton').click(function () {
    $('.car-details-section').css({display: "none"});
    $('.registration-section').css({display: "block"});
});

$('#gustHome').click(function () {
    $('.car-details-section').css({display: "block"});
    $('.registration-section').css({display: "none"});
})

$('#saveBtn').click(function () {
    registerUser();

})

function registerUser() {

    let nic = $('#nic').val();
    let email = $('#email').val();
    let password = $('#password').val();
    let filename = $('#imgNIC')[0].files[0].name;
    let address = $('#address').val();
    let contact = $('#contact').val();

    let formData = new FormData();

    for (let file of document.getElementById('imgNIC').files) {
        formData.append("file", file);
    }

    formData.append("nic", nic);
    $.ajax({
        method: "POST",
        contentType: false,
        processData: false,
        url: "http://localhost:8080/BackEnd_war_exploded/api/v1/user/uploadIdImage",
        async: true,
        data: formData,
        success: function (resp) {
            console.log(resp.data);
            if (resp.code == 200) {
                $.ajax({
                    method: "POST",
                    contentType: "application/json",
                    url: "http://localhost:8080/BackEnd_war_exploded/api/v1/user/registerUser",
                    data: JSON.stringify({
                        "nic": nic,
                        "email": email,
                        "password": password,
                        "idPhoto": resp.data,
                        "address": address,
                        "contact": contact
                    })

                });
            } else {
                alert("Please Upload a NID")
            }

        }
    });
}

$('#loginButton').click(function () {
    location.replace("http://localhost:63342/Easy-Car-Rental-System/FrontEnd/regUser/index.html")
})