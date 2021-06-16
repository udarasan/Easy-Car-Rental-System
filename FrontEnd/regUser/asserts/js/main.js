// loading contex separately
mainFunction();
getAllCars();
function mainFunction() {
    $('.car-details-section').css({display: "none"});
    $('.renal-req-section').css({display: "none"});
    $('.myAccount-section').css({display: "none"});
    $('.rental-status-section').css({display: "none"});
    $('.login-section').css({display: "block"});
    $('#myAccountButton').css({display: "none"});
    $('#rentStatusButton').css({display: "none"});
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
                showTopButtons();

            }
        }

    });


});
$('#logOutButton').click(function () {
    loadRegUserDetails(90);
})

function loadRegUserDetails(NIC) {
    $('.login-section').css({display: "none"});
    $('.car-details-section').css({display: "block"});
    $('.renal-req-section').css({display: "block"});
$('#userNIC').text(NIC);
    console.log(NIC);

}

function showTopButtons() {
    $('#myAccountButton').css({display: "block"});
    $('#rentStatusButton').css({display: "block"});
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

/*---------------------Rental Request Sending Area*---------------------------/ */

$('#sendRequest').click(function () {

    let s= $("input[name='flexRadioDefault']:checked").val()
    console.log(s);

    if (s==1){
        withDriverRentalRequest();
    }else if (s==2){
        withoutDriverRentalRequest();
    }else {
        console.log("please select Driver or Not")
    }

})

function withDriverRentalRequest() {
    console.log("Need A Driver");

}
function myFunction() {
    var generateRequestID = Math.floor((Math.random() * 1000) + 1);
    return generateRequestID;

}

function withoutDriverRentalRequest() {
    console.log("No Need A Driver");



    let requestId=myFunction();
    console.log(requestId)
    let nic=$('#reNIC').val();
    let registerNO=$('#reRegisterNO').val();
    let did="Without Driver";
    let pickupDate=$('#pickUpDate').val();
    let pickupTime=$('#pickUPTime').val();
    let pickupVenue=$('#pickUpVenue').val();
    let returnDate=$('#returnDate').val();
    let returnTime=$('#returnTime').val();
    let returnVenue=$('#returnVenue').val();
    let requestStatus="Pending"
    let description="Not Available Now"

    $.ajax({
        method:"POST",
        contentType: "application/json",
        url: "http://localhost:8080/BackEnd_war_exploded/api/v1/rentalRequest/sendRequest",
        data: JSON.stringify({
            "requestId": requestId,
            "nic": nic,
            "registerNO": registerNO,
            "did": did,
            "pickupDate": pickupDate,
            "pickupTime": pickupTime,
            "pickupVenue": pickupVenue,
            "returnDate": returnDate,
            "returnTime": returnTime,
            "returnVenue": returnVenue,
            "requestStatus": requestStatus,
            "description": description
                    
        })
    })

}


