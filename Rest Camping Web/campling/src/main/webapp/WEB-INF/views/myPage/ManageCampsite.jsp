<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.apache.commons.io.FilenameUtils"%>

<div class="reservation-infos">
<c:forEach items="${campsiteDtoList}" var="campsiteDto" varStatus="status">
    <div class="campsite-info" data-label = ${campsiteDto.id}>
    <div style = "display: flex; flex-direction: row">
        <img src= "http://localhost/${FilenameUtils.getName(campsiteDto.image.filePath)}" class = "campsite-main-img" alt="">

        <div style = "display: flex; flex-direction: column; margin-left: 10px">
            <h5><div class = "info-value">${campsiteDto.name}</div></h5>

            <div class = "secondary-info">${campsiteDto.address}</div>
            <div class = "secondary-info">요청자 : ${campsiteDto.owner}</div>
            <div class = "secondary-info info-value">연락처 : ${campsiteDto.contact}</div>

            <div class = "secondary-info info-value">시설 :
                <c:forEach items="${campsiteDto.facilities}" var="facility" varStatus="status">
                    ${facility} <c:if test="${not status.last}">, </c:if>
                </c:forEach>
            </div>

            <div class = "secondary-info info-value">운영형태 :
                <c:forEach items="${campsiteDto.operatingTypes}" var="operating" varStatus="status">
                    ${operating} <c:if test="${not status.last}">, </c:if>
                </c:forEach>
            </div>

            <div class = "info-value secondary-info">등록 상태 :
                <c:choose>
                    <c:when test="${campsiteDto.isApprove == 0}">
                        승인 전
                    </c:when>
                    <c:when test="${campsiteDto.isApprove == 1}">
                        승인 됨
                    </c:when>
                    <c:when test="${campsiteDto.isApprove == 2}">
                        승인 거절 됨
                    </c:when>
                </c:choose>
            </div>
        </div>
    </div>

    <div class="wrap">
        <c:choose>
            <c:when test="${campsiteDto.isApprove == 0}">
                <button type= "button" class = "btn btn-danger campsite-reject">등록 거부</button>
                <button type= "button" class = "btn btn-info campsite-approve">등록 승인</button>
            </c:when>
        </c:choose>
    </div>
    </div>
</c:forEach>
</div>
