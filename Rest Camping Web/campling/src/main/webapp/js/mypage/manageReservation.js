(function initialize() {
    $(".reservation-date").each((index, item) => {
        const date = new Date(Number($(item).text()))

        $(item).text(date.format("yyyy-MM-dd"))
    })
})()

$(".approve").on("click", (event) => {
    const reservationId = $(event.target).closest(".reservation-info").data("label")
    $.ajax({
        type : "put",
        url : `/reservation/approve?reservationId=${reservationId}`,
        success : (response) => {
            if(!response.error)
                swalAlert({icon : "success", html : "승인되었습니다.", preConfirm: () => {window.location.reload()}})
            else
                swalAlert({icon : "error", html : response.errorMessage, preConfirm : () => {window.location.reload()}})
        },
    })
})

$(".reject").on("click", (event) => {
    const reservationId = $(event.target).closest(".reservation-info").data("label")
    $.ajax({
        type : "put",
        url : `/reservation/reject?reservationId=${reservationId}`,
        success : (response) => {
            if(!response.error)
                swalAlert({icon : "success", html : "거절되었습니다.", preConfirm: () => {window.location.reload()}})
            else
                swalAlert({icon : "error", html : response.errorMessage, preConfirm : () => {window.location.reload()}})
        }
    })
})