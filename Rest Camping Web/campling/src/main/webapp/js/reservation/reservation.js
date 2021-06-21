(function initialize(){
    $(".reservation-day").each((index, item) => {
        const day = $(item).text()
        $(item).text(`${day}일 (${enToKrWeek($(item).data("week"))})`)
    })
    updateTotalPrice()
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

    const maxHeadCnt = $(".room-max-head-cnt").text();


    if(reservationInfo.reservationHeadCnt == 0 || !reservationInfo.bookerPhoneNum || !reservationInfo.bookerName){
        swalAlert({icon : "error", html : "필수 정보를 모두 입력해주세요."})
        return;
    }
    console.log(reservationInfo.reservationHeadCnt, maxHeadCnt)

    if(Number(maxHeadCnt) < Number(reservationInfo.reservationHeadCnt)){
        swalAlert({icon : "error", html : "예약 인원이 최대 인원보다 높습니다."})
    }else{
        $.ajax({
            type : "POST",
            url : "/reservation",
            contentType: 'application/json',
            data : JSON.stringify(reservationInfo),
            success : (response) => {
                if(response.error === false){
                    const reservationId = response.result.id;
                    window.location.href = `/reservation/confirm/${reservationId}`
                }
            }
        })
    }
})

function getReservationInfo(){
    const campsiteId = $(".campsite-info").data("label");
    const roomId = $(".room-info").data("label");
    const checkInDate = $(".check-in").data("label")
    const checkOutDate = $(".check-out").data("label")
    const reservationHeadCnt = $(".reservation-head-cnt").text();
    const reservationCarCnt = $(".reservation-car-cnt").text();
    const mealKitOrders = []
    const bookerPhoneNum = $(".booker-phone-num").val()
    const bookerName = $(".booker-name").val()

    $(".mealkit-info").each((index, item) => {
        const mealkitId = $(item).data("label")
        const mealkitCnt = $(item).find(".mealkit-cnt").text()
        mealKitOrders.push({cnt : Number(mealkitCnt), mealKit : {id : mealkitId}})
    })

    return {
        bookerName : bookerName,
        bookerPhoneNum : bookerPhoneNum,
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

