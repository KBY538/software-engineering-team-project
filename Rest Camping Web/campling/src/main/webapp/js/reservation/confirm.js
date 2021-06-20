$(".confirm-button").on("click", () => {
    window.location = "/main"
});

(function initialize() {
    $(".reservation-date").each((index, item) => {
        const date = new Date(Number($(item).text()))

        $(item).text(date.format("yyyy-MM-dd"))
    })
})()