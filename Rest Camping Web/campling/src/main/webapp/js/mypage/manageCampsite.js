$(".campsite-approve").on("click", (event) => {
    const campsiteId = $(event.target).closest(".campsite-info").data("label")

    $.ajax({
        type : "put",
        url : `/campsite/approve/${campsiteId}`,
        success : (response) => {
            if(!response.error)
                swalAlert({icon : "success", html : "승인되었습니다.", preConfirm: () => {window.location.reload()}})
            else
                swalAlert({icon : "error", html : response.errorMessage, preConfirm : () => {window.location.reload()}})
        },
    })
})

$(".campsite-reject").on("click", (event) => {
    const campsiteId = $(event.target).closest(".campsite-info").data("label")

    $.ajax({
        type : "put",
        url : `/campsite/reject/${campsiteId}`,
        success : (response) => {
            if(!response.error)
                swalAlert({icon : "success", html : "거부되었습니다.", preConfirm: () => {window.location.reload()}})
            else
                swalAlert({icon : "error", html : response.errorMessage, preConfirm : () => {window.location.reload()}})
        }
    })
})