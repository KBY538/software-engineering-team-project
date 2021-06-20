<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>

    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/fonts/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="/css/auth/util.css">
    <link rel="stylesheet" type="text/css" href="/css/auth/main.css">

</head>
<body>
<div class="limiter">
    <div class="login-container">
        <div class="login-wrap p-l-60 p-r-60 p-t-55 p-b-40">
            <form class="login-form validate-form flex-sb flex-w" method="post" action = "/authenticate">
                <span class="login-form__title p-b-32">로그인</span>

                <div class="input-wrap validate-input m-b-36" data-validate="아이디를 입력해주세요">
                    <input class="input-wrap__input" type="text" name="username" placeholder="아이디">
                    <span class="input-wrap__input-focus"></span>
                </div>

                <div class="input-wrap validate-input m-b-12" data-validate="비밀번호를 입력해주세요">
                            <span class="btn-show-pass">
                                <i class="fa fa-eye"></i>
                            </span>
                    <input class="input-wrap__input" type="password" name="password" placeholder="비밀번호">
                    <span class="input-wrap__input-focus"></span>
                </div>

                <div class="flex-sb-m w-full p-b-40" style="justify-content: center">
                    <div>
                        <a href="/signUp" class="txt3">회원가입</a>
                    </div>
                </div>
                <span class = "login-form__fail-msg p-b-15">${loginFailMsg}</span>
                <button class="login-form__login-btn">Login</button>
            </form>
        </div>
    </div>
</div>
<div id="dropDownSelect1"></div>

<script type="text/javascript" async="" src="https://www.google-analytics.com/analytics.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<%@ include file="../common/CommonScript.jsp"%>
<script src="/js/auth/login.js" type="text/javascript"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>

<script type="text/javascript">
    window.dataLayer = window.dataLayer || [];

    function gtag() {
        dataLayer.push(arguments);
    }

    gtag('js', new Date());

    gtag('config', 'UA-23581568-13');
</script>
</body>
</html>
