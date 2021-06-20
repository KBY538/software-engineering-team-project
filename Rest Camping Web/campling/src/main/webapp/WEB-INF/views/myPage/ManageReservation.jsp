<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="reservation-infos">
    <c:forEach items="${ownerReservationInfos}" var="reservationInfo">
        <div class="reservation-info" data-label = ${reservationInfo.id}>
            <h5><div class = "info-value">${reservationInfo.roomDto.getName()}</div></h5>
            <div class = "secondary-info">체크인 : <span class = "info-value reservation-date">${reservationInfo.checkInDate.time}</span></div>
            <div class = "secondary-info">체크아웃 : <span class = "info-value reservation-date">${reservationInfo.checkOutDate.time}</span></div>
            <div class = "info-value secondary-info">예약 인원/차량 : ${reservationInfo.reservationHeadCnt}명 / ${reservationInfo.reservationNumCars}대</div>
            <div class = "info-value secondary-info">예약 상태 :
                <c:choose>
                    <c:when test="${reservationInfo.isApprove == 0}">
                        예약 승인 전
                    </c:when>
                    <c:when test="${reservationInfo.isApprove == 1}">
                        승인 됨
                    </c:when>
                    <c:when test="${reservationInfo.isApprove == 2}">
                        예약 거절 됨
                    </c:when>
                </c:choose>
            </div>

            <div class="wrap">
                <c:choose>
                    <c:when test="${reservationInfo.isApprove == 0}">
                        <button type= "button" class = "btn btn-danger reject">예약 거절</button>
                        <button type= "button" class = "btn btn-info approve">예약 승인</button>
                    </c:when>
                </c:choose>
            </div>
        </div>
    </c:forEach>
</div>





