$(".reservation-btn").on("click", () => {
    let target = event.target;
    let roomId = $(target).closest(".room-info").data("label")
    window.location = "/reservation/room/55"
})