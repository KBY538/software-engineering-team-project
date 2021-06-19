(function initialize(){
    let $facilityElem = $(".facility");
    let $operaingElem = $(".operating");


    addCheckbox($facilityElem, facilities)
    addCheckbox($operaingElem, operatings)
})()

$(".search-form").submit(async (event) => {
    event.preventDefault()
    let campsiteName = $("input[type = 'search']").val()

    let facilityElem  = $(".facility input[type = 'checkbox']:checked")
    let facilities = []

    let operatingElem  = $(".operating input[type = 'checkbox']:checked")
    let operatings = []

    facilityElem.each((index, el) => {
        facilities.push(el.dataset.label)
    })

    operatingElem.each((index, el) => {
        operatings.push(el.dataset.label)
    })

    let searchResult = await search(campsiteName, facilities, operatings)
    showSearchResult(searchResult)
})

$(document).on("click", ".campsiteInfo", (event) => {
    let url = $(event.target).closest(".campsiteInfo").data("src")
    window.location = url;
})

function showSearchResult(searchResult){
    $(".campsiteInfo").filter(function() {
        return $(this).css('display') != 'none';
    }).remove();

    if(searchResult.length > 0){    // 검색 결과가 있는 경우
        $(".no-campsite").css("display", "none")

        for(let campsiteInfo of searchResult){
            let $campsiteInfo = $(".campsiteInfo:first").clone()

            let imageFilePath = campsiteInfo.image.filePath;

            $campsiteInfo.css("display", "block");
            $campsiteInfo.data("src", `/campsite/${campsiteInfo.id}`)
            $campsiteInfo.find("img").attr("src", "http://localhost/" + basename(imageFilePath))
            $campsiteInfo.find(".operatings").text(campsiteInfo.operatingTypes.join(", "))
            $campsiteInfo.find(".campsiteName").text(campsiteInfo.name)
            $campsiteInfo.find(".address").text(campsiteInfo.address)
            $campsiteInfo.find(".contact").text(campsiteInfo.contact)
            $campsiteInfo.find(".price").text(addCommaToNumber(campsiteInfo.cheapestRoomPrice) + " ~")

            $(".main-content").append($campsiteInfo)
        }
    }else{  // 검색 결과가 없는 경우
        $(".no-campsite").css("display", "block")
    }
}

function search(campsiteName, facilities, operatings){
    return new Promise((resolve, reject) => {
        $.ajax({
            url : `campsite/search?campsiteName=${campsiteName}&facilities=${facilities.join(", ")}&operatings=${operatings.join(", ")}`,
            type : "GET",
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

    searchInputElem.val("");    // input 태그에 입력된 값 지움.
})