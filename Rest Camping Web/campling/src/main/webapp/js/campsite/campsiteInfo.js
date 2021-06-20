(function initialize(){
    $('input[name="reservation-date-input"]').daterangepicker({
            locale: {cancelLabel: '취소', applyLabel : "적용"}
        }
    );
})()

$(".reservation-btn").on("click", (event) => {
    const target = event.target;
    const roomId = $(target).closest(".room-info").data("label")
    const campsiteId = $(target).closest(".campsite-info").data("label")
    const dateFormat = "yyyy-MM-dd"
    const startDate = $('input[name = "reservation-date-input"]').data('daterangepicker').startDate._d.format(dateFormat)
    const endDate = $('input[name = "reservation-date-input"]').data('daterangepicker').endDate._d.format(dateFormat)

    window.location = `/reservation/${campsiteId}/${roomId}?startDate=${startDate}&endDate=${endDate}`
})