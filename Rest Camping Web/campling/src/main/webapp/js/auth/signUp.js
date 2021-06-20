
function usernameValidation(username){
    return new Promise((resolve, reject) => {
        $.ajax({
            url : `/username/validation?username=${username}`,
            type : "GET",
            success : function(response) {
                resolve(response) ;
            },
        })
    })
}



(function ($) {
    "use strict";

    /*==================================================================
    [ Validate ]*/
    var input = $('.validate-input .input-wrap__input');

    $('.validate-form').on('submit',async function(event){
        event.preventDefault()
        var check = true;
        let username = $("input[name = 'username']").val()
        let password = $("input[name = 'password']").val()
        let passwordValidation = $("input[name = 'password-validation']").val()

        if(passwordValidation !== password){
            swalAlert({icon : "error", html : "비밀번호 일치하지 않습니다."})
            check = false;
        }

        for(var i=0; i<input.length; i++) {
            if(validate(input[i]) == false){
                showValidate(input[i]);
                check=false;
            }
        }

        if(check){
            let response = await usernameValidation(username)

            if(!response.error){
                check = true
            }else{
                swalAlert({icon : "error", html : response.errorMessage})
                check = false;
            }
        }

        if(check){
            let termCheck = $('#terms')[0].checked

            if(!termCheck){
                swalAlert({icon : "error", html : "개인정보 수집 및 이용에 대한 안내에 <br> 모두 동의해주세요."})
            }else{
                $.ajax({
                    url : "/signUp",
                    type : "POST",
                    data : {username : username, password : password},
                    success : function (response){
                        if(!response.error){
                            swalAlert({icon : "success",
                                html : "회원가입에 성공하였습니다.",
                                preConfirm : () => {
                                    window.location = "/login"
                                }})
                        }
                    }
                })
            }
        }
    });


    $('.validate-form .input-wrap__input').each(function(){
        $(this).focus(function(){
            hideValidate(this);
        });
    });

    function validate (input) {
        if($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
            if($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
                return false;
            }
        }
        else {
            if($(input).val().trim() == ''){
                return false;
            }
        }
    }

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }

    /*==================================================================
    [ Show pass ]*/
    var showPass = 0;
    $('.btn-show-pass').on('click', function(){
        if(showPass == 0) {
            $(this).next('input').attr('type','text');
            $(this).find('i').removeClass('fa-eye');
            $(this).find('i').addClass('fa-eye-slash');
            showPass = 1;
        }
        else {
            $(this).next('input').attr('type','password');
            $(this).find('i').removeClass('fa-eye-slash');
            $(this).find('i').addClass('fa-eye');
            showPass = 0;
        }

    });
})(jQuery);