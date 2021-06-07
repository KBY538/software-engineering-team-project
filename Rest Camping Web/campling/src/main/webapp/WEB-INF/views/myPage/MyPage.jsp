<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <%@ include file="../common/CommonHead.jsp"%>
    <link rel="stylesheet" type="text/css" href="/css/mypage/common.css">
    <link rel="stylesheet" type="text/css" href="/css/mypage/campsiteInfoForm.css">
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
                <c:choose>
                    <c:when test="${menu eq 'manage-campsite-info'}">
                        <script>document.querySelector("div.content-container").style.padding = "0";</script>
                        <%@ include file="CampsiteInfoForm.jsp"%>
                    </c:when>
                </c:choose>
            </div>
        </div>
    </div>

    <%@ include file="../common/Footer.jsp"%>
    <%@ include file="../common/CommonScript.jsp"%>
    <script src="/js/mypage/verticalTab.js" type="text/javascript"></script>
    <script src="/js/mypage/common.js" type="text/javascript"></script>
    <script src="/js/common/imageUploader.js" type="text/javascript"></script>
</body>
</html>
