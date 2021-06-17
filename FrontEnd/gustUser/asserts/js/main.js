// loading contex separately
mainFunction();
getAllAvailableCars();
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


function getAllAvailableCars() {
    $.ajax({
        method:"GET",
        url:"http://localhost:8080/BackEnd_war_exploded/api/v1/car/getAvailableCars",
        success:function (resp) {
            console.log(resp);
            $('#gustCarTable>tbody').empty();

            for (let car of resp.data){
                let registrationNo=car.registrationNo;
                let brand=car.brand;
                let type=car.type;
                let frontImage=car.frontImage;
                let numberOfPassengers=car.numberOfPassengers;
                let transmissionType=car.transmissionType;
                let fuelType=car.fuelType;
                let color=car.color;
                let dailyRate=car.dailyRate;
                let monthlyRate=car.monthlyRate;
                let freeMileagePerDay=car.freeMileagePerDay;
                let freeMileagePerMonth=car.freeMileagePerMonth;
                let pricePerKm=car.pricePerKm;
                let kmMeterValue=car.kmMeterValue;
                let lastReturnDate=car.lastReturnDate;
                let isAvailable=car.isAvailable
                let isDamaged=car.isDamaged;
                let underMaintenance=car.underMaintenance;

                var row = `<tr><td>${registrationNo}</td><td>${brand}</td><td>${type}</td><td>${frontImage}</td><td>${numberOfPassengers}</td><td>${transmissionType}</td><td>${fuelType}</td><td>${color}</td><td>${dailyRate}</td><td>${monthlyRate}</td><td>${freeMileagePerDay}</td><td>${freeMileagePerMonth}</td><td>${pricePerKm}</td><td>${kmMeterValue}</td><td>${lastReturnDate}</td><td>${isAvailable}</td><td>${isDamaged}</td><td>${underMaintenance}</td></tr>`;
                $('#gustCarTable>tbody').append(row);
            }
        }

    })
}
