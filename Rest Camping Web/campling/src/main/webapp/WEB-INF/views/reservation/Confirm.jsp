<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/css/mypage/common.css">
<link rel="stylesheet" type="text/css" href="/css/mypage/campsiteInfoForm.css">
<link rel="stylesheet" type="text/css" href="/css/reservation/confirm.css">

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
                <div class = "reservation-info">
                    <div class="info-input">
                        <div class="" data-option="on">
                            <div class="info-input__row">
                                <div class="info-input__row-header">캠핑장 정보 </div>
                                <div class="option-input-list">
                                    <div class="option-wrap">
                                        <div class="input-wrap">
                                            <div class="input-wrap__input-header">캠핑장 이름</div>
                                            <div class = "info-value">${reservationDto.campsiteDto.getName()}</div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="info-input__row">
                                <div class="info-input__row-header">방 정보 </div>
                                <div class="option-input-list">
                                    <div class="option-wrap">
                                        <div class="input-wrap">
                                            <div class="input-wrap__input-header">방 이름</div>
                                            <div class = "info-value">${reservationDto.roomDto.getName()}</div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="info-input__row">
                                <div class="info-input__row-header">예약 정보 </div>
                                <div class="option-input-list">
                                    <div class="option-wrap">
                                        <div class="input-wrap">
                                            <div class="input-wrap__input-header">예약 번호</div>
                                            <div class = "info-value">${reservationDto.id}</div>
                                        </div>

                                        <div class="input-wrap">
                                            <div class="input-wrap__input-header">체크인</div>
                                            <div class = "info-value reservation-date">${reservationDto.checkOutDate.time}</div>
                                        </div>

                                        <div class="input-wrap">
                                            <div class="input-wrap__input-header">체크 아웃</div>
                                            <div class = "info-value reservation-date">${reservationDto.checkOutDate.time}</div>
                                        </div>

                                        <div class="input-wrap">
                                            <div class="input-wrap__input-header">총 결제 금액</div>
                                            <div class = "info-value">${reservationDto.totalPrice}</div>
                                        </div>

                                        <div class="input-wrap">
                                            <div class="input-wrap__input-header">예약 인원</div>
                                            <div class = "info-value">${reservationDto.reservationHeadCnt}</div>
                                        </div>

                                        <div class="input-wrap">
                                            <div class="input-wrap__input-header">예약 차량 수</div>
                                            <div class = "info-value">${reservationDto.reservationNumCars}</div>
                                        </div>

                                        <div class="input-wrap">
                                            <div class="input-wrap__input-header">예약 상태</div>
                                            <div class = "info-value">
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
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="info-input__row">
                                <div class="info-input__row-header">밀키트 정보</div>
                                <div class="option-input-list">
                                    <div class="option-wrap">
                                        <c:forEach items="${reservationDto.mealKitOrders}" var="mealkitOrder" varStatus="status">
                                            <div class="input-wrap">
                                                <div class="input-wrap__input-header">밀키트 ${status.count}</div>
                                                <div class = "info-value">${mealkitOrder.mealKit.name} * ${mealkitOrder.cnt}</div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>

                            <div class="info-input__row">
                                <div class="info-input__row-header">예약자 정보 </div>
                                <div class="option-input-list">
                                    <div class="option-wrap">
                                        <div class="input-wrap">
                                            <div class="input-wrap__input-header">이름</div>
                                            <div class = "info-value">${reservationDto.bookerName}</div>
                                        </div>
                                        <div class="input-wrap">
                                            <div class="input-wrap__input-header">전화번호</div>
                                            <div class = "info-value">${reservationDto.bookerPhoneNum}</div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="info-input__row">
                                <div class="action">
                                    <button type="button" class="confirm-button">확인</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <%@ include file="../common/Footer.jsp"%>
        <%@ include file="../common/CommonScript.jsp"%>
        <script src = "/js/reservation/confirm.js"></script>
    </body>
</html>
