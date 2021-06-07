<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <%@ include file="common/CommonHead.jsp"%>
    </head>
    <body>
        <jsp:include page="./common/Nav.jsp">
            <jsp:param name="userInfo" value="${userInfo}" />
        </jsp:include>

        <div class="content-container">
            <div class="content"></div>
        </div>

        <%@ include file="common/Footer.jsp"%>
        <%@ include file="common/CommonScript.jsp"%>
    </body>
</html>
