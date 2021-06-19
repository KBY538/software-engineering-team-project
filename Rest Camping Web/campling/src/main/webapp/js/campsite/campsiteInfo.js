$(".reservation-btn").on("click", (event) => {
    let target = event.target;
    let roomId = $(target).closest(".room-info").data("label")
    let campsiteId = $(target).closest(".campsite-info").data("label")
    window.location = `/reservation/${campsiteId}/${roomId}`
})