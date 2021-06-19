<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.apache.commons.io.FilenameUtils"%>

<html>
    <head>
        <%@ include file="../common/CommonHead.jsp"%>
    </head>
    <body>
        <jsp:include page="../common/Nav.jsp">
            <jsp:param name="userInfo" value="${userInfo}" />
        </jsp:include>

        <div class="content-container">
            <div class="content">
                <div class="room-info shadow" data-label = "${roomDto.id}">
                    <div class = "title-info">
                        <div class = "left">
                            <img src= "http://localhost/${FilenameUtils.getName(roomDto.image.filePath)}" class = "campsite-main-img" alt="">
                        </div>
                    </div>
                </div>

            </div>
        </div>

        <%@ include file="../common/Footer.jsp"%>
        <%@ include file="../common/CommonScript.jsp"%>
    </body>
</html>
