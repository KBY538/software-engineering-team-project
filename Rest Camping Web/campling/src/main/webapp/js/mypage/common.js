(function initialize(){
    $(`#accordian li a[data-label = '${menu}']`).click()

    if(menu === "manage-campsite-info"){
        manageCampsiteInfo();
    }
})();

$(".add-info").on("click", (event) => {
    let target = event.target
    let $inputList = $(target).closest(".option-input-list")
    let $optionWrap = $inputList.children(".normal:last");
    let $cloneElem = $optionWrap.clone(true)
    $optionWrap.after($cloneElem)

    $cloneElem.find("textarea").val(" ")

    $cloneElem.find("input").val("")
    $cloneElem.find(".imagePreview").css("background-image", "")
    let header = $cloneElem.children(".input-wrap__input-header")

    let headerList = header.text().split(" ")

    header.text(headerList[0] + " " + (Number(headerList[1]) + 1))
    header.append(`<button class = "kakao-btn btn-cancel"><span class="kakao-ico ico-cancel" style="vertical-align: middle"></span></button>`)
})

function manageCampsiteInfo(){
    let facility = $("div[data-label = 'facility'] .input-wrap")
    let operating = $("div[data-label = 'operating'] .input-wrap")

    addCheckbox(facility, facilities)
    addCheckbox(operating, operatings)
}


$(document).on("click",".btn-cancel",  (event) => {
    let target = event.target
    $(target).closest(".normal").remove()
})

function getCheckedValue(elems){
    let valueList = []

    elems.each((index, elem) => {
        valueList.push(elem.dataset.label)
    })

    return valueList;
}

$(".confirm-button").on("click", async () => {
    let valid = true;

    let inputs = $(".necessary").closest(".info-input__row").find("input[type = 'number'], input[type = 'text']")

    inputs.each((index, input) => {
        if (! input.value){
            //valid = false
        }
    })

    if(!valid)
        swalAlert({icon : "error", html : "필수 정보를 모두 입력해주세요."})
    else{
        let campsiteName = $("input[name = 'campsiteName']").val()
        let campsiteAddress = $("input[name = 'campsiteAddress']").val()
        let campsitePhoneNum = $("input[name = 'campsitePhoneNum']").val()
        let campsiteIntroduction = $("textarea[name = 'campsiteIntroduction']").val()
        let campsiteNotice = $("textarea[name = 'campsiteNotice']").val()
        let pricePerExcessCar = $("input[name = 'pricePerExcessCar']").val()
        let pricePerExcessPerson = $("input[name = 'pricePerExcessPerson']").val()

        let facilities = getCheckedValue($("div[data-label= 'facility'] input[type = 'checkbox']:checked"))
        let operatings = getCheckedValue($("div[data-label= 'operating'] input[type = 'checkbox']:checked"))
        let campsiteImageFile, roomImageFile, mealKitImageFile, touristImageFile, restaurantImageFile

        campsiteImageFile = $(".campsite input[type = file]")[0].files[0]
        let campsiteFilePath = (campsiteImageFile) ? await upload(campsiteImageFile) : ""

        let $roomElem = $(".room")
        let roomInfoList = []

        await new Promise((resolve, reject) => {
            $roomElem.each(async (index, elem) => {
                roomImageFile = $(elem).find("input[type = file]")[0].files[0]
                let filePath = (roomImageFile) ? await upload(roomImageFile) : ""

                let name = $(elem).find("input[name = 'name']").val()
                let price = $(elem).find("input[name = 'price']").val()
                let baseHeadCnt = $(elem).find("input[name = 'baseHeadCnt']").val()
                let baseNumCars = $(elem).find("input[name = 'baseNumCars']").val()
                let maxHeadCnt = $(elem).find("input[name = 'maxHeadCnt']").val()
                let numRemains = $(elem).find("input[name = 'numRemains']").val()

                roomInfoList.push({name : name, price : price, numRemains : numRemains, maxHeadCnt : maxHeadCnt, baseHeadCnt : baseHeadCnt, baseNumCars : baseNumCars, image : {filePath : filePath}})

                if (index === $roomElem.length -1)
                    resolve()
            })
        })

        let $mealKitElem = $(".mealKit")
        let mealKitInfoList = []

        await new Promise((resolve, reject) => {
            $mealKitElem.each(async (index, elem) => {
                mealKitImageFile = $(elem).find("input[type = file]")[0].files[0]
                let filePath = (mealKitImageFile) ? await upload(mealKitImageFile) : ""

                let name = $(elem).find("input[name = 'name']").val()
                let price = $(elem).find("input[name = 'price']").val()
                let numRemains = $(elem).find("input[name = 'numRemains']").val()

                mealKitInfoList.push({name : name, price : price, numRemains : numRemains, image : {filePath : filePath}})

                if (index === $mealKitElem.length -1)
                    resolve()
            })
        })

        let $touristElem = $(".tourist")
        let touristInfoList = []

        await new Promise((resolve, reject) => {
            $touristElem.each(async (index, elem) => {
                touristImageFile = $(elem).find("input[type = file]")[0].files[0]
                let filePath = (touristImageFile) ? await upload(touristImageFile) : ""

                let name = $(elem).find("input[name = 'name']").val()
                let address = $(elem).find("input[name = 'address']").val()
                let desc = $(elem).find("textarea[name = 'desc']").val()

                touristInfoList.push({name : name, address : address, desc : desc, image : {filePath : filePath}})

                if (index === $touristElem.length -1)
                    resolve()
            })
        })


        let $restaurantElem = $(".restaurant")
        let restaurantInfoList = []

        await new Promise((resolve, reject) => {
            $restaurantElem.each(async (index, elem) => {
                restaurantImageFile = $(elem).find("input[type = file]")[0].files[0]
                let filePath = (restaurantImageFile) ? await upload(restaurantImageFile) : ""

                let name = $(elem).find("input[name = 'name']").val()
                let address = $(elem).find("input[name = 'address']").val()
                let desc = $(elem).find("textarea[name = 'desc']").val()

                restaurantInfoList.push({name : name, address : address, desc : desc, image : {filePath : filePath}})
                if (index === $restaurantElem.length -1)
                    resolve()
            })
        })


        let data = {
            name : campsiteName,
            address : campsiteAddress,
            contact : campsitePhoneNum,
            introduction : campsiteIntroduction,
            notice :  campsiteNotice,
            operatingTypes : operatings,
            facilities : facilities,
            pricePerExcessPerson : pricePerExcessPerson,
            pricePerExcessCar : pricePerExcessCar,
            rooms : roomInfoList,
            mealKits : mealKitInfoList,
            touristInfos : touristInfoList,
            restaurantInfos : restaurantInfoList,
            image : {filePath : campsiteFilePath}
        }

        $.ajax({
            type: "POST",
            url: "/campsite",
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function (response) {
                if (response.error === false) {    // 서버에서 error를 응답한 경우
                    swalAlert({icon : "success", html : "캠핑장 정보가 저장되었습니다."})
                } else {
                    swalAlert({icon : "error", html : "캠핑장 정보 등록에 실패하였습니다."})
                }
            },
            error: function (req, status, error) {
                swalAlert({icon : "error", html : "캠핑장 정보 등록에 실패하였습니다."})
            }
        })

    }
})

function upload(file){
    return new Promise((resolve, reject) => {
        let formData = new FormData()
        formData.append("file", file)

        $.ajax({
            type: "POST",
            enctype: "multipart/form-data",    // multipart는 폼 데이터가 여러 부분으로 나뉘어 서버로 전송되는 것을 의미함 (https://velog.io/@runningwater/TIL-form-%EC%A0%84%EC%86%A1-%EC%8B%9C-enctype-%ED%99%95%EC%9D%B8%ED%95%98%EA%B8%B0 참조)
            url: "/upload",
            data: formData,
            processData: false,    // 기본 값은 true이며, true일때는 data 값들이 쿼리스트링 형태인 key1=value1&key2=value2 형태로 전달된다. 하지만 이렇게 하면 file 값들은 제대로 전달되지 못하므로,  해당 값을 false로 해주어 { key1 : 'value1', key2 : 'value2' } 형태로 전달해 주어야 file 값들이 제대로 전달된다.
            contentType: false,    // 기본값은 'application/x-www-form-urlencoded'이다. 해당 기본 타입으로는 파일이 전송 안되기 때문에 false로 해주어야 한다.
            success: function (response) {
                resolve(response)
            },
            error: function (req, status, error) {
                swalAlert({icon : "error", html : "이미지 업로드에 실패하였습니다."})
                reject()
            }
        })
    })
}