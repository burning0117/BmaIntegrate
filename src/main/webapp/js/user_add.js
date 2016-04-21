var user = {
    setting:{
        userFormatError:"用户名格式错误",
        unKnowError:"未知错误发生",
        nameSuccess: "该用户名可以使用",
        nameError: "该用户名已经存在",
        emailSuccess: "输入邮箱格式正确",
        emailError: "输入电子邮箱格式不正确,请重新输入",
        phoneSuccess: "号码格式正确",
        phoneError: "号码格式有错误，请重新输入",
        passwordSuccess: "密码格式正确",
        passwordError: "密码不符合规范，请重新输入",
        password2Success: "密码输入正确",
        password2Error: "两次输入密码不一致，请重新输入",
        correctColor: "blue",
        errorColor: "red",
        correctReputation: "用户信誉度输入区间正确",
        errorReputation: "用户信誉度只能介于0.1-0.99之间"
    },
    filter: {
        userFilter: /[a-zA-Z0-9_\u4e00-\u9fa5]{2,15}/,
        emailFilter: /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/,
        passwordFilter: /^[a-zA-Z]\w{5,17}$/,
        phoneNumberFilter: /^1[3|4|5|7|8]\d{9}$/,
        userReputationFilter: /^0+(.[0-9]{1,2})$/
    },
    formValidate: function () {
        $("input[type='image']").unbind("click");
        $("input[type='image']").bind("click", function () {
        });
    },
    initEvent: function () {
        var filter =this.filter.userFilter;
        var userFormError=this.setting.userFormatError;
        $("input[name='name']").unbind("blur");
        $("input[name='name']").bind("blur", function () {
            var username = $(this).val();
            if (filter.test(username)) {
                user.checkUser($(this).val());
            } else {
                $("#name").text(userFormError).css("color", "red");
            }
        });
    },
    checkUser: function (name) {
        var nameSuccess = this.setting.nameSuccess;
        var errorColor = this.setting.errorColor;
        var correctColor = this.setting.correctColor;
        var unKnowError=this.setting.unKnowError;
        var parameter = {
            name: name
        };
        $.ajax({
            type: "POST",
            url: 'userJSONAction_checkUsername.action',
            data: parameter,
            success: function (data) {
                //alert(data);
                if (data.message == nameSuccess) {
                    $("#name").text(data.message).css("color", correctColor);
                } else {
                    $("#name").text(data.message).css("color", errorColor);
                }
            },
            error: function (data) {
                $("#name").text(unKnowError).css("color", errorColor);
            }
        });
    },
    checkMail: function () {
        var emailSuccess = this.setting.emailSuccess;
        var emailError = this.setting.emailError;
        var correctColor = this.setting.correctColor;
        var errorColor = this.setting.errorColor;
        var filter =this.filter.emailFilter;
        $("input[name='email']").unbind("blur");
        $("input[name='email']").bind("blur", function () {
            var email = $("input[name='email']").val();
            if (filter.test(email)) {
                $("#email").text(emailSuccess).css("color", correctColor);
                return true;
            } else {
                $("#email").text(emailError).css("color", errorColor);
                return false;
            }
        });
    },
    checkPassword: function () {
        var errorColor = this.setting.errorColor;
        var correctColor = this.setting.correctColor;
        var passwordSuccess = this.setting.passwordSuccess;
        var passwordError = this.setting.passwordError;
        var filter = this.filter.passwordFilter;
        $("input[name='password']").unbind("blur");
        $("input[name='password']").bind("blur", function () {
            var password2 = $("input[name='password']").val();
            if (filter.test(password2)) {
                $("#password").text(passwordSuccess).css("color", correctColor);
                return true;
            } else {
                $("#password").text(passwordError).css("color", errorColor);
                return false;
            }
        });
    },
    checkPassword2: function () {
        var password2Error = this.setting.password2Error;
        var password2Success = this.setting.password2Success;
        var correcrColor = this.setting.correctColor;
        var errorColor = this.setting.errorColor;
        $("input[name='password2']").unbind("blur");
        $("input[name='password2']").bind("blur", function () {
            if ($("input[name='password']").val() != $("input[name ='password2']")) {
                $("#password2").text(password2Error).css("color", errorColor);
            } else {
                $("#password2").text(password2Success).css("color", correcrColor);
            }
        });
    },
    checkPhoneNumber: function () {
        var phoneError = this.setting.phoneError;
        var phoneSuccess = this.setting.phoneSuccess;
        var correctColor = this.setting.correctColor;
        var errorColor = this.setting.errorColor;
        var filter = this.filter.phoneNumberFilter;
        $("input[name='phone']").unbind("blur");
        $("input[name='phone']").bind("blur", function () {
            var phone = $("input[name='phone']").val();
            if (filter.test(phone)) {
                $("#phone").text(phoneSuccess).css("color", correctColor);
            } else {
                $("#phone").text(phoneError).css("color", errorColor);
            }
        });

    },
    checkUserReputation: function () {
        var correctReputation = this.setting.correctReputation;
        var errorReputation = this.setting.errorReputation;
        var correctColor = this.setting.correctColor;
        var errorColor = this.setting.errorColor;
        var filter=this.filter.userReputationFilter
        $("input[name='ureputation']").unbind("blur");
        $("input[name='ureputation']").bind("blur", function () {
            var reputation = $(this).val();
            if (filter.test(reputation)) {
                $("#ureputation").text(correctReputation).css("color", correctColor);
            } else {
                $("#ureputation").text(errorReputation).css("color", errorColor);
            }
        });
    }
};
$().ready(function () {
    user.formValidate();
    user.initEvent();
    user.checkMail();
    user.checkPassword();
    user.checkPassword2();
    user.checkPhoneNumber();
    user.checkUserReputation();
});
