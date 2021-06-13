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


