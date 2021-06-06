const swalBasicOption = {
    heightAuto : false,  // true이면 body의 height가 auto가 되어서 페이지 구조가 변함
    allowOutsideClick : false,
    confirmButtonText : "확인",
}

function swalAlert(option) {
    Object.assign(option, swalBasicOption); // 인자로 전달받은 option과 기본 옵션을 합침

    Swal.fire(option)
}

function swalConfirm(option) {
    const confirmBasicOption = {
        showCancelButton: true,
        cancelButtonText: "취소",
    }

    Object.assign(option, confirmBasicOption, swalBasicOption);   // 인자로 전달받은 option, 기본 option, confirm alert의 기본 옵션을 합침

    Swal.fire(option)
}