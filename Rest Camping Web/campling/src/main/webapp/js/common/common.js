const facilities = ['수세식 화장실', "놀이방", "매점", "샤워실", "수영장", "개수대"]
const operatings = ['오토캠핑', "글램핑", "카라반", "펜션", "방가로"];

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

function addCheckbox(elem, checkboxList){
    for(let checkbox of checkboxList) {
        let $checkBoxElem = $(`<label class = "checkbox">
                                <input type='checkbox' data-label = '${checkbox}'><span class = 'icon'></span>${checkbox}
                               </label>`)
        elem.append($checkBoxElem)
    }
}

function basename (filePath){
    return filePath.split("/").slice(-1)[0]
}
function addCommaToNumber(strNumber){    // 정규식을 이용해서 숫자의 3자리 마다 , 추가
    return String(strNumber).replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}