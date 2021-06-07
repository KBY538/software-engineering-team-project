(function initialize(){
    let $facilityElem = $(".facility");
    let $operaingElem = $(".operating");


    addCheckbox($facilityElem, facilities)
    addCheckbox($operaingElem, operatings)
})()

$(".search-form").submit(async (event) => {
    event.preventDefault()
    let campsiteName = $("input[type = 'search']").val()

    let facilityElem  = document.querySelectorAll(".facility input[type = 'checkbox']:checked")
    let facilities = []

    let operatingElem  = document.querySelectorAll(".operating input[type = 'checkbox']:checked")
    let operatings = []

    facilityElem.forEach((el, index) => {
        facilities.push(el.dataset.name)
    })

    operatingElem.forEach((el, index) => {
        operatings.push(el.dataset.name)
    })
    console.log("asd")
    await search(campsiteName, facilityElem, operatingElem)
})

function search(campsiteName, facilities, operatings){
    return new Promise((resolve, reject) => {
        let data = {
            campsiteName : campsiteName,
            facilities : facilities,
            operatings : operatings
        }

        $.ajax({
            url : "campsite/search",
            type : "POST",
            contentType: "application/json",
            data : data,
            success : function (response) {
                resolve(response)
            }
        })
    })
}
$(document).on("click", ".search-form .ico-cancel", (event) => {
    event.preventDefault()
    const target = event.target;
    const searchInputElem = $(target).closest(".search-form").children(".search-form__search-input");    // 가장 가까운 input 태그

    let facilities = searchInputElem.val("");    // input 태그에 입력된 값 지움.
})