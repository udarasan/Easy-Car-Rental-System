// loading contex separately
mainFunction();
getAllCars();
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
$('#userNIC').text(NIC);
    console.log(NIC);

}

function getAllCars() {
    $.ajax({
        method:"GET",
        url:"http://localhost:8080/BackEnd_war_exploded/api/v1/car",
        success:function (resp) {
            console.log(resp);
            $('#regCarTable>tbody').empty();

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
                $('#regCarTable>tbody').append(row);
            }
        }

    })
}


