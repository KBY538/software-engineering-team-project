function activeTab(liElem){ // * 인자로 전달된 li 태그에 해당하는 탭을 활성화
    $('#accordian ul li').removeClass("active");
    liElem.addClass('active');

    var activeWidthVerticalHeight = liElem.innerHeight();
    var activeWidthVerticalWidth = liElem.innerWidth();
    var itemPosVerticalTop = liElem.position();
    var itemPosVerticalLeft = liElem.position();
    $(".selector-active").css({
        "top":itemPosVerticalTop.top + "px",
        "left":itemPosVerticalLeft.left + "px",
        "height": activeWidthVerticalHeight + "px",
        "width": activeWidthVerticalWidth + "px"
    });
}

$(document).on("click", "#accordian ul li", (event) =>{ // 카테고리를 클릭한 경우
    const target = event.target;
    const closestLiElem = $(target).closest("li");

    if(target === closestLiElem[0] || target === closestLiElem.children("a")[0]){  // ! li 태그 또는 자식인 a 태그가 클릭 되었을 때만 동작하도록 해서, 이벤트 위임으로 인해 더보기 버튼(.more-container)을 클릭해도 카테고리가 변경되는 현상을 해결
        activeTab(closestLiElem);   // * a 태그와 가장 가까운 li 태그를 활성화시킴
    }
})