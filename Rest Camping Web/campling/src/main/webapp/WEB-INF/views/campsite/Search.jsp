<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <%@ include file="../common/CommonHead.jsp"%>
        <link rel="stylesheet" type="text/css" href="/css/common/search.css">
        <link rel="stylesheet" type="text/css" href="/css/campsite/search.css">
    </head>
    <body>
    <jsp:include page="../common/Nav.jsp">
        <jsp:param name="userInfo" value="${userInfo}" />
    </jsp:include>

    <div class="content-container">
        <div class="content">
            <div class = "shadow menu-bar">
                <div class = "facility filter">
                    <div class = "txt3 label">시설</div><br>
                </div>

                <div class = "operating filter">
                    <div class = "txt3 label">운영 형태</div><br>
                </div>
            </div>

            <div class = "main-content">
                <form class="search-form" data-table-update = "${param.tableUpdate}" data-range = "${param.dataRange}">
                    <button type="submit" class = "kakao-btn btn-search"><span class="kakao-ico ico-search"></span></button>

                    <input type = "search" placeholder="캠핑장 검색" class="search-form__search-input" data-last-input = "0"/>
                    <button class = "kakao-btn btn-cancel"><span class="kakao-ico ico-cancel"></span></button>
                    <div class = "search-form__suggestions" data-selected = "0"></div>  <%-- 추천 검색어 container --%>
                </form>

                <div class = "no-campsite" style="text-align: center">
                        검색된 캠핑장이 존재하지 않습니다.
                </div>

                <div class = "campsiteInfo" style="display: none">
                    <div class = "wrap-row">
                        <a class = "campsiteUrl" href=""><img src="" alt=""></a>
                        <div class = "wrap-column" style="margin-left: 20px; align-content: center">
                            <span class = "operatings"></span> <br>
                            <h4><span class = "campsiteName"></span> <br></h4>
                            <span class = "address"></span> <br>
                            <span class = "contact"></span> <br>
                        </div>
                        <h4 class = "price"></h4> <br>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%@ include file="../common/Footer.jsp"%>
    <%@ include file="../common/CommonScript.jsp"%>
    <script src="/js/campsite/search.js" type="text/javascript"></script>

    </body>
</html>
