<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <%@ include file="../common/CommonHead.jsp"%>
    <link rel="stylesheet" type="text/css" href="/css/mypage/common.css">
    <link rel="stylesheet" type="text/css" href="/css/mypage/campsiteInfoForm.css">
    <link rel="stylesheet" type="text/css" href="/css/mypage/manageReservation.css">
    <link rel="stylesheet" type="text/css" href="/css/mypage/searchReservation.css">
    <link rel="stylesheet" type="text/css" href="/css/mypage/verticalTab.css">
    <link rel="stylesheet" type="text/css" href="/css/common/imageUploader.css">
</head>
<body>
    <jsp:include page="../common/Nav.jsp">
        <jsp:param name="userInfo" value="${userInfo}" />
    </jsp:include>

    <div class="content-container">
        <div class="content">
            <div class = "shadow menu-bar">
                <div class = "category-list" id="accordian">
                    <ul class="show-dropdown main-navbar">
                        <c:choose>
                            <c:when test="${user_role.contains('ROLE_ADMIN')}">
                                <%@ include file="menuBar/ManagerMenuBar.jsp"%>
                            </c:when>
                            <c:when test="${user_role.contains('ROLE_OWNER')}">
                                <%@ include file="menuBar/OwnerMenuBar.jsp"%>
                            </c:when>
                            <c:when test="${user_role.contains('ROLE_CAMPER')}">
                                <%@ include file="menuBar/CamperMenuBar.jsp"%>
                            </c:when>
                        </c:choose>
                    </ul>
                </div>

            </div>

            <div class = "main-content">
                <script> let menu = "${menu}"</script>
                <script>document.querySelector("div.content-container").style.padding = "0";</script>

                <c:choose>
                    <c:when test="${menu eq 'manage-campsite-info'}">
                        <%@ include file="CampsiteInfoForm.jsp"%>
                    </c:when>

                    <c:when test="${menu eq 'manage-reservation'}">
                        <jsp:include page="ManageReservation.jsp">
                            <jsp:param name="ownerReservationInfo" value="${ownerReservationInfo}" />
                        </jsp:include>
                    </c:when>

                    <c:when test="${menu eq 'search-reservation'}">
                        <jsp:include page="SearchReservation.jsp">
                            <jsp:param name="camperReservationInfos" value="${camperReservationInfos}" />
                        </jsp:include>
                    </c:when>

                    <c:when test="${menu eq 'manage-campsite'}">
                        <jsp:include page="ManageCampsite.jsp">
                            <jsp:param name="campsiteDtoList" value="${campsiteDtoList}" />
                        </jsp:include>
                    </c:when>
                </c:choose>
            </div>
        </div>
    </div>

    <%@ include file="../common/Footer.jsp"%>
    <%@ include file="../common/CommonScript.jsp"%>
    <script src="/js/mypage/verticalTab.js" type="text/javascript"></script>
    <script src="/js/mypage/common.js" type="text/javascript"></script>
    <script src="/js/mypage/manageReservation.js" type="text/javascript"></script>
    <script src="/js/mypage/manageCampsite.js" type="text/javascript"></script>
    <script src="/js/mypage/searchReservation.js" type="text/javascript"></script>
    <script src="/js/common/imageUploader.js" type="text/javascript"></script>
</body>
</html>
