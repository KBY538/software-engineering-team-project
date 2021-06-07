<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar">
    <ul class="lnk">
        <li><a class="navbar__menu" href="/campsite">캠핑장</a></li>
        <li><a class="navbar__menu" href="/community">커뮤니티 게시판</a></li>
        <li><a class="navbar__menu" href="/notice">공지사항</a></li>
        <li><a class="navbar__menu" href="/mypage/">마이페이지</a></li>
    </ul>

    <div class = "auth">
        <c:if test="${not empty userInfo.username}">
            <span class = "username">${userInfo.username}님</span>
        </c:if>

        <a class="navbar__menu" id = "logout" href="/logout">로그인/로그아웃</a>
    </div>
</nav>