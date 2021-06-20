(function initialize(){
    $(".reservation-day").each((index, item) => {
        const day = $(item).text()
        $(item).text(`${day}일 (${enToKrWeek($(item).data("week"))})`)
    })
})();

$(".up, .down").on("click", (event) => {
    const target = event.target
    const $inputValue = $(target).siblings(".input-value")
    const originValue = $inputValue.text()

    if($(target).attr("class").includes("up")){
        $inputValue.text(Number(originValue) + 1)
    }
    else{
        if(originValue != 0)
            $inputValue.text(Number(originValue) - 1)
    }

    updateTotalPrice()
})

$(".reservation-btn").on("click", () => {
    const reservationInfo = getReservationInfo();

    $.ajax({
        type : "POST",
        url : "/reservation",
        contentType: 'application/json',
        data : JSON.stringify(reservationInfo),
        success : () => {

        }
    })
})

function getReservationInfo(){
    const campsiteId = $(".campsite-info").data("label");
    const roomId = $(".room-info").data("label");
    const checkInDate = $(".check-in").data("label")
    const checkOutDate = $(".check-out").data("label")
    const reservationHeadCnt = $(".reservation-head-cnt").text();
    const reservationCarCnt = $(".reservation-car-cnt").text();
    const mealKitOrders = []

    $(".mealkit-info").each((index, item) => {
        const mealkitId = $(item).data("label")
        const mealkitCnt = $(item).find(".mealkit-cnt").text()
        mealKitOrders.push({cnt : mealkitCnt, mealKit : {id : mealkitId}})
    })

    return {
        checkInDate : checkInDate,
        checkOutDate : checkOutDate,
        reservationHeadCnt : reservationHeadCnt,
        reservationNumCars : reservationCarCnt,
        roomDto : {id : roomId},
        campsiteDto : {id : campsiteId},
        mealKitOrders : mealKitOrders
    }
}

function updateTotalPrice(){
    const data = getReservationInfo();

    $.ajax({
        type : "POST",
        url : "/reservation/cost",
        contentType: 'application/json',
        data : JSON.stringify(data),
        success : (totalPrice) => {
            $(".total_price").text(totalPrice)
        }
    })
}

