
<%@ page import="org.apache.commons.io.FilenameUtils"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <%@ include file="../common/CommonHead.jsp"%>
        <link rel="stylesheet" type="text/css" href="/css/campsite/campsiteInfo.css">
    </head>
    <body>
        <jsp:include page="../common/Nav.jsp">
            <jsp:param name="userInfo" value="${userInfo}" />
        </jsp:include>

        <div class="content-container">
            <div class="content">
                <div class="campsite-info shadow" data-label = "${campsiteDto.id}">
                    <div class = "title-info">
                        <div class = "left">
                            <img src= "http://localhost/${FilenameUtils.getName(campsiteDto.image.filePath)}" class = "campsite-main-img" alt="">
                        </div>

                        <div class = "right">
                            <div class = "base-info">
                                <h2><div class = "campsite-name"></div>${campsiteDto.name}</h2>
                                <div class = "campsite-address">${campsiteDto.address}</div>

                                <div class = "campsite-contact"><i class="fa fa-phone"> ${campsiteDto.contact}</i></div>
                                <div class = "campsite-desc">
                                    <div class = "title">소개글</div>
                                    <div class = "information">${campsiteDto.introduction}</div>

                                    <div class = "title">공지사항</div>
                                    <div class = "notice">${campsiteDto.notice}</div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class = "detail-info">
                        <div class = "title">예약정보</div>
                        <div class = "info-content">
                            <div class = "reservation-info">
                                <ul>
                                    <li><div class = "pricePerExcessPerson">인원 초과 비용 : ${campsiteDto.pricePerExcessPerson}원</div></li>
                                    <li><div class = "pricePerExcessCar">차량 초과 비용 : ${campsiteDto.pricePerExcessCar}원</div></li>
                                    <li>
                                        <div class = "facility">시설 :
                                            <c:forEach items="${campsiteDto.facilities}" var="facility" varStatus="status">
                                                ${facility} <c:if test="${not status.last}">, </c:if>
                                            </c:forEach>
                                        </div>
                                    </li>
                                    <li>
                                        <div class = "operating">운영 형태 :
                                            <c:forEach items="${campsiteDto.operatingTypes}" var="operating" varStatus="status">
                                                ${operating} <c:if test="${not status.last}">, </c:if>
                                            </c:forEach>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>

                        <div class = "title">방 정보</div>
                        <c:forEach items="${campsiteDto.rooms}" var = "roomInfo" varStatus="status">
                            <div class = "room-infos">
                                <div class = "room-info" data-label = "${roomInfo.id}">
                                    <img class = "room-img" src="http://localhost/${FilenameUtils.getName(roomInfo.image.filePath)}"></img>
                                    <div class = "right">
                                        <h4><div class = "room-name"></div>${roomInfo.name}</h4>
                                        <div class = "room-capacity">
                                            <span class = "room-base-head-cnt">기준 : <span>${roomInfo.baseHeadCnt}명</span></span>/
                                            <span class = "room-max-head-cnt">최대 : <span>${roomInfo.maxHeadCnt}명</span></span>
                                            <div class = "room-remains">남은방 : <span>${roomInfo.numRemains}</span></div>
                                        </div>

                                        <div class = "wrap-column">
                                            <div class = "room-price">${roomInfo.price}<small>원</small></div>
                                            <button type="button" class="btn btn-danger reservation-btn">예약하기</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>

                        <div class = "title">주변 관광지 정보</div>
                        <c:forEach items="${campsiteDto.touristInfos}" var = "touristInfo" varStatus="status">
                            <div class = "tourist-infos">
                                <div class = "tourist-info">
                                    <img class = "tourist-img" src="http://localhost/${FilenameUtils.getName(touristInfo.image.filePath)}"></img>
                                    <div class = "right">
                                        <h4><div class = "tourist-name">${touristInfo.name}</div></h4>
                                        <div class = "tourist-address">${touristInfo.address}</div>
                                        <div class = "tourist-desc" style="margin-top: 20px">${touristInfo.desc}</div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>

                        <div class = "title">주변 맛집 정보</div>
                        <c:forEach items="${campsiteDto.restaurantInfos}" var = "restaurantInfo" varStatus="status">
                            <div class = "restaurant-infos">
                                <div class = "restaurant-info">
                                    <img class = "restaurant-img" src="http://localhost/${FilenameUtils.getName(restaurantInfo.image.filePath)}"></img>
                                    <div class = "right">
                                        <h4><div class = "restaurant-name">${restaurantInfo.name}</div></h4>
                                        <div class = "restaurant-address">${restaurantInfo.address}</div>
                                        <div class = "restaurant-desc" style="margin-top: 20px">${restaurantInfo.desc}</div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>

        <%@ include file="../common/Footer.jsp"%>
        <%@ include file="../common/CommonScript.jsp"%>
        <script src="/js/campsite/campsiteInfo.js" type="text/javascript"></script>
    </body>
</html>
