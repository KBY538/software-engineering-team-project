$(".cancel").on("click", (event) => {
    const reservationId = $(event.target).closest(".reservation-info").data("label")
    swalConfirm({"icon" : "info", html : "취소하시겠습니까?", preConfirm :  () =>{
            $.ajax({
                type : "DELETE",
                url : `/reservation?reservationId=${reservationId}`,
                success : (response) => {
                    if(!response.error)
                        swalAlert({icon : "success", html : "취소되었습니다.", preConfirm: () => {window.location.reload()}})
                    else
                        swalAlert({icon : "error", html : response.errorMessage, preConfirm : () => {window.location.reload()}})
                },
            })
        }})
})

$(".update").on("click", (event) => {
    const reservationId = $(event.target).closest(".reservation-info").data("label")
    $.ajax({
        type : "get",
        url : `/reservation/${reservationId}`,
        success : (response) => {
            const bookerName = response.bookerName
            const bookerPhoneNum = response.bookerPhoneNum

            const html = `<div class="input-label">예약자 이름</div>
              <input type="text" class = "bookerName info-input__input" value="${bookerName}">
              <div class="input-label">전화번호</div> 
              <input type="text" class = "bookerPhoneNum info-input__input" value="${bookerPhoneNum}">`

            swalConfirm({html : html,
                preConfirm: () => {
                    const data = {
                        id : reservationId,
                        bookerName : $(".bookerName").val(),
                        bookerPhoneNum : $(".bookerPhoneNum").val()
                    };

                    $.ajax({
                        type : "put",
                        url : `/reservation`,
                        contentType: "application/json",
                        data : JSON.stringify(data),
                        success : (response) => {
                            if(!response.error)
                                swalAlert({icon : "success", html : "수정되었습니다.", preConfirm: () => {window.location.reload()}})
                            else
                                swalAlert({icon : "error", html : response.errorMessage, preConfirm : () => {window.location.reload()}})
                        }
                    })
                }})
        }
    })
})