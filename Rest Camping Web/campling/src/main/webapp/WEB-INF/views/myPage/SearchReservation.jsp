<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.apache.commons.io.FilenameUtils"%>

<div class="reservation-infos">
    <c:forEach items="${camperReservationInfos}" var="camperReservationInfo" varStatus="status">
        <div class="reservation-info" data-label = ${camperReservationInfo.id}>
            <div style = "display: flex; flex-direction: row">
                <img src= "http://localhost/${FilenameUtils.getName(camperReservationInfo.campsiteDto.image.filePath)}" class = "campsite-main-img" alt="">

                <div style = "display: flex; flex-direction: column; margin-left: 10px">
                    <h5><div class = "info-value">${camperReservationInfo.campsiteDto.getName()}</div></h5>

                    <div class = "secondary-info">${camperReservationInfo.roomDto.getName()}</div>
                    <div class = "secondary-info">체크인 : <span class = "info-value reservation-date">${camperReservationInfo.checkInDate.time}</span></div>
                    <div class = "secondary-info">체크아웃 : <span class = "info-value reservation-date">${camperReservationInfo.checkOutDate.time}</span></div>
                    <div class = "info-value secondary-info">예약 인원/차량 : ${camperReservationInfo.reservationHeadCnt}명 / ${camperReservationInfo.reservationNumCars}대</div>
                    <div class = "info-value secondary-info">예약자 이름 : ${camperReservationInfo.bookerName}</div>
                    <div class = "info-value secondary-info">예약자 전화번호: ${camperReservationInfo.bookerPhoneNum}</div>

                    <div class = "info-value secondary-info">예약 상태 :
                        <c:choose>
                            <c:when test="${camperReservationInfo.isApprove == 0}">
                                예약 승인 전
                            </c:when>
                            <c:when test="${camperReservationInfo.isApprove == 1}">
                                승인 됨
                            </c:when>
                            <c:when test="${camperReservationInfo.isApprove == 2}">
                                예약 거절 됨
                            </c:when>
                        </c:choose>
                    </div>
                </div>
            </div>

            <div class="wrap">
                <button type= "button" class = "btn btn-danger cancel">예약 취소</button>
                <button type= "button" class = "btn btn-info update">예약 수정</button>
            </div>
        </div>
    </c:forEach>
</div>
