mainFunction();
function mainFunction() {
    $('.dashboard-section').css({display: "block"});
    $('.manage-car-section').css({display: "none"});
    $('.view-customer-section').css({display: "none"});
    $('.calculate-income-section').css({display: "none"});
    $('.view-rental-request-section').css({display: "none"});
}

$('#dashboardButton').click(function () {
    $('.dashboard-section').css({display: "block"});
    $('.manage-car-section').css({display: "none"});
    $('.view-customer-section').css({display: "none"});
    $('.calculate-income-section').css({display: "none"});
    $('.view-rental-request-section').css({display: "none"});
})

$('#manageCarButton').click(function () {
    $('.dashboard-section').css({display: "none"});
    $('.manage-car-section').css({display: "block"});
    $('.view-customer-section').css({display: "none"});
    $('.calculate-income-section').css({display: "none"});
    $('.view-rental-request-section').css({display: "none"});
})

$('#viewCustomersButton').click(function () {
    $('.dashboard-section').css({display: "none"});
    $('.manage-car-section').css({display: "none"});
    $('.view-customer-section').css({display: "block"});
    $('.calculate-income-section').css({display: "none"});
    $('.view-rental-request-section').css({display: "none"});
})

$('#calculateIncomeButton').click(function () {
    $('.dashboard-section').css({display: "none"});
    $('.manage-car-section').css({display: "none"});
    $('.view-customer-section').css({display: "none"});
    $('.calculate-income-section').css({display: "block"});
    $('.view-rental-request-section').css({display: "none"});
})

$('#viewRentalReqButton').click(function () {
    $('.dashboard-section').css({display: "none"});
    $('.manage-car-section').css({display: "none"});
    $('.view-customer-section').css({display: "none"});
    $('.calculate-income-section').css({display: "none"});
    $('.view-rental-request-section').css({display: "block"});
    requestStatusTableDataLoad();
})

$('#addCar').click(function () {

    var today = new Date();
    var dd = String(today.getDate()).padStart(2, '0');
    var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
    var yyyy = today.getFullYear();

    today = mm + '/' + dd + '/' + yyyy;

    let registrationNo=$('#registrationNo').val();
    let brand=$('#brand').val();
    let type=$('#type').val();
    let frontImage=$('#frontImage').val();
    let numberOfPassengers=$('#numberOfPassengers').val();
    let transmissionType=$('#transmissionType').val();
    let fuelType=$('#fuelType').val();
    let color=$('#color').val();
    let dailyRate=$('#dailyRate').val();
    let monthlyRate=$('#monthlyRate').val();
    let freeMileagePerDay=$('#freeMileagePerDay').val();
    let freeMileagePerMonth=$('#freeMileagePerMonth').val();
    let pricePerKm=$('#pricePerKm').val();
    let kmMeterValue=$('#kmMeterValue').val();
    let lastReturnDate=today;
    let isAvailable="YES";
    let isDamaged="NO";
    let underMaintenance="NO";


    let formData=new FormData();
    for (let file of document.getElementById('frontImage').files) {
        formData.append("file", file);
    }

    formData.append("registrationNo", registrationNo);

    $.ajax({
        method:"POST",
        contentType:false,
        processData:false,
        url:"http://localhost:8080/BackEnd_war_exploded/api/v1/car/uploadCarImage",
        async:true,
        data:formData,
        success:function (resp){
            console.log(resp.data);

             if (resp.code==200){
                    $.ajax({
                        method: "POST",
                        contentType: "application/json",
                        url: "http://localhost:8080/BackEnd_war_exploded/api/v1/car/registerCar",
                        data: JSON.stringify({
                            'registrationNo': registrationNo,
                            'brand': brand,
                            'type': type,
                            'frontImage': resp.data,
                            'numberOfPassengers': numberOfPassengers,
                            'transmissionType': transmissionType,
                            'fuelType': fuelType,
                            'color': color,
                            'dailyRate': dailyRate,
                            'monthlyRate': monthlyRate,
                            'freeMileagePerDay': freeMileagePerDay,
                            'freeMileagePerMonth': freeMileagePerMonth,
                            'pricePerKm': pricePerKm,
                            'kmMeterValue': kmMeterValue,
                            'lastReturnDate': lastReturnDate,
                            'isAvailable': isAvailable,
                            'isDamaged': isDamaged,
                            'underMaintenance': underMaintenance
                        }),
                        success:function (rt) {
                            if (rt.code==200){
                                console.log("wade goda udarayaaaaaa!")
                                getAllCars();
                            }else {
                                console.log("uba maha kalakanniyek bn!")
                            }
                        }
                    })

             }
        }
    })

});
getAllUsers();

function getAllUsers() {
    $.ajax({
        method:"GET",
        url:"http://localhost:8080/BackEnd_war_exploded/api/v1/user",
        success:function (resp) {
        console.log(resp);
            $('#customerTable>tbody').empty();

            for (let user of resp.data){
                let nic = user.nic;
                let email = user.email;
                let password = user.password;
                let id = user.idPhoto;
                let address = user.address;
                let contact = user.contact;
                let idPhoto="<img style='width: 100px; height: 100px' src='asserts/img/" + id + "'>"

                var row = `<tr><td>${nic}</td><td>${email}</td><td>${password}</td><td>${idPhoto}</td><td>${address}</td><td>${contact}</td></tr>`;
                $('#customerTable>tbody').append(row);
            }
        }

    })
}
getAllCars();
function getAllCars() {
    $.ajax({
        method:"GET",
        url:"http://localhost:8080/BackEnd_war_exploded/api/v1/car",
        success:function (resp) {
            console.log(resp);
            $('#carTable>tbody').empty();

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
                $('#carTable>tbody').append(row);
            }
        }

    })
}

function requestStatusTableDataLoad() {
    $.ajax({
        method: "GET",
        url: "http://localhost:8080/BackEnd_war_exploded/api/v1/rentalRequest",
        async: true,
        success:function (resp) {
            console.log(resp.data);
            $('.admin-rentalRequestStatusTable>tbody').empty();

            for (let request of resp.data){
                let requestId=request.requestId;
                let nic=request.nic;
                let registrationNo=request.registrationNo;
                let did=request.did;
                let pickupDate=request.pickupDate;
                let pickupTime=request.pickupTime;
                let pickupVenue=request.pickupVenue;
                let returnDate=request.returnDate;
                let returnTime=request.returnTime;
                let returnVenue=request.returnVenue;
                let requestStatus=request.requestStatus;
                let description=request.description;

                var row = `<tr><td>${requestId}</td><td>${nic}</td><td>${registrationNo}</td><td>${did}</td><td>${pickupDate}</td><td>${pickupTime}</td><td>${pickupVenue}</td><td>${returnDate}</td><td>${returnTime}</td><td>${returnVenue}</td><td>${requestStatus}</td><td>${description}</td></tr>`;
                $('.admin-rentalRequestStatusTable>tbody').append(row);
            }



        }

    });

}

$('#accept').click(function () {
    let reqId=$('#requestId').val();
    $.ajax({
        method:"PUT",
        url:"http://localhost:8080/BackEnd_war_exploded/api/v1/rentalRequest/acceptRentalRequest/"+"Accept"+"/"+reqId,

    })
})
$('#denied').click(function () {
    let reqId=$('#requestId').val();
    $.ajax({
        method:"PUT",
        url:"http://localhost:8080/BackEnd_war_exploded/api/v1/rentalRequest/acceptRentalRequest/"+"Denied"+"/"+reqId,

    })
})
$('#pending').click(function () {
    let reqId=$('#requestId').val();
    $.ajax({
        method:"PUT",
        url:"http://localhost:8080/BackEnd_war_exploded/api/v1/rentalRequest/acceptRentalRequest/"+"Pending"+"/"+reqId,

    })
})

$('.admin-rentalRequestStatusTable').click(function () {
    var id = $(this).closest("tr").find('tr:nth-child(1)').text();
    console.log(id)
});
