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
                            }else {
                                console.log("uba maha kalakanniyek bn!")
                            }
                        }
                    })
             }
        }
    })

});


