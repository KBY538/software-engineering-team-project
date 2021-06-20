<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="org.apache.commons.io.FilenameUtils"%>

<html>
    <head>
        <%@ include file="../common/CommonHead.jsp"%>
        <link rel="stylesheet" href="/css/reservation/reservation.css">
    </head>
    <body>
        <jsp:include page="../common/Nav.jsp">
            <jsp:param name="userInfo" value="${userInfo}" />
        </jsp:include>

        <div class="content-container">
            <div class="content">
                <div class="campsite-info" data-label = ${campsiteDto.id}>
                    <div class="room-info shadow" data-label = "${roomDto.id}">

                        <img src= "http://localhost/${FilenameUtils.getName(roomDto.image.filePath)}" class = "room-main-img" alt="">

                        <div class="base-info">
                            <h4><div class = "room-name"></div>${roomDto.name}</h4>
                            <ul>
                                <li>인원 초과 비용 : <span class = "pricePerExcessPerson">${campsiteDto.pricePerExcessPerson}원</span></li>
                                <li>차량 초과 비용 : <span class = "pricePerExcessCar">${campsiteDto.pricePerExcessCar}원</span></li>

                                <li>기준 : <span class = "room-base-head-cnt">${roomDto.baseHeadCnt}</span>명 /
                                    최대 : <span class = "room-max-head-cnt">${roomDto.maxHeadCnt}</span>명</li>
                                <li><div class = "base-num-cnt">기준 차량 : ${roomDto.baseNumCars}대</div></li>
                            </ul>
                        </div>

                        <div class="no-title">
                        <span class="reservation-date check-in" data-label = "${startDate}">
                            <span class = "reservation-month">${startDate.getMonthValue()}</span>월
                            <span class = "reservation-day" data-week = "${startDate.getDayOfWeek()}">${startDate.getDayOfMonth()}</span>
                        </span> ~
                            <span class="reservation-date check-out" data-label = "${endDate}">
                            <span class = "reservation-month">${endDate.getMonthValue()}</span>월
                            <span class = "reservation-day" data-week = "${endDate.getDayOfWeek()}">${endDate.getDayOfMonth()}</span>
                        </span>
                        </div>

                        <div class="no-title" style="display: flex; flex-direction: row; justify-content: center">
                            <div class = "input-box">
                                <div class = "input-label">예약 인원</div>
                                <div class="wrap-row">
                                    <button type="button" class="btn btn-secondary down">-</button>
                                    <div class="input-value reservation-head-cnt">0</div>
                                    <button type="button" class="btn btn-secondary up">+</button>
                                </div>
                            </div>

                            <div class = "input-box">
                                <div class = "input-label">예약 차량 수</div>
                                <div class="wrap-row">
                                    <button type="button" class="btn btn-secondary down">-</button>
                                    <div class="input-value reservation-car-cnt">0</div>
                                    <button type="button" class="btn btn-secondary up">+</button>
                                </div>
                            </div>
                        </div>

                        <div class = "title">예약자 정보</div>
                        <div class = "booker-info">
                            <div class = "no-title">
                                <div class="input-box">
                                    <div class = "input-label">예약자 이름</div>
                                    <input type="text" class = "booker-name">
                                </div>

                                <div class="input-box">
                                    <div class = "input-label">전화번호</div>
                                    <input type="text" class = "booker-phone-num">
                                </div>
                            </div>
                        </div>

                        <div class = "title">밀키트</div>
                        <div class = "mealkit-infos">
                            <c:forEach items="${campsiteDto.mealKits}" var = "mealKitInfo" varStatus="status">
                                <div class = "mealkit-info" data-label = "${mealKitInfo.id}">
                                    <img class = "mealKit-img" src="http://localhost/${FilenameUtils.getName(mealKitInfo.image.filePath)}"></img>
                                    <div class = "right">
                                        <h4><div class = "mealKit-name"></div>${mealKitInfo.name}</h4>
                                        <div>남은 수량 : <span class = "num-remains">${mealKitInfo.numRemains}</span></div>

                                        <div class="wrap-column">
                                            <div class = "price" style="font-weight: bold;">${mealKitInfo.price}</div>원
                                            <div class="wrap-row">
                                                <button type="button" class="btn btn-secondary down">-</button>
                                                <div class="input-value mealkit-cnt">0</div>
                                                <button type="button" class="btn btn-secondary up">+</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>

                        <div class="no-title">
                            <div>총 결제 금액 : <span class="total_price"></span>원</div>
                        </div>

                        <button type="button" class="btn btn-danger reservation-btn">예약하기</button>
                    </div>
                </div>
            </div>
        </div>
        <%@ include file="../common/Footer.jsp"%>
        <%@ include file="../common/CommonScript.jsp"%>
        <script src = "/js/reservation/reservation.js"></script>
    </body>
</html>
