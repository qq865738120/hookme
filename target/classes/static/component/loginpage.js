/**
 * Created by code_xia on 2017/4/3.
 */
/**
 * 登陆组件
 * 依赖的组件：
 *  1.baseButton
 * */

Vue.component("my-button", baseButton);

var loginPage = Vue.extend({
    props: ['postUrl','loginLocation','registerLocation','forgetLocation'], //postUrl：登陆请求url  loginLocation：登陆成功后重定向url
    // registerLocation：点击注册按钮重定向url  forgetLocation：点击忘记密码重定向url
    data: function(){
        return{
            username: "",
            password: "",
        }
    },
    methods: {
        /**
         * 关闭按钮接口
         */
        close: function () {
            this.$emit("close");
        },
        /**
         * 登陆按钮，不提供接口
         */
        login: function () {
            var vm = this;
            var data = {
                userName: this.username,
                password: this.password
            };
            this.$http.post(this.postUrl, data).then(function (response) {
                var code = response.data.data.code;
                var msg = response.data.data.msg;
                if (code != "3") { //表单验证失败
                    alert(msg);
                }else{ //登陆成功
                    window.location = this.loginLocation; //重定向到登陆成功后的页面
                    console.log(msg)
                }
            },
            function () {
                alert("服务器无响应,请稍后再试！");
            })
        },
        /**
         * 注册账号按钮，不提供接口
         */
        register: function () {
            window.location = this.registerLocation;
        }
    },
    template:
        "<div id='component-loginpage-div'>" +
            "<div class='component-loginpage-pagediv'>" +
                "<my-button value='x' class='component-loginpage-close' v-on:onclick='close'></my-button>" +
                "<div class='component-loginpage-slogan'></div>" +
                "<div class='body'>" +
                    "<input type='text' class='component-loginpage-username-text' placeholder='用户名/邮箱' maxlength='32' v-model='username' />" +
                    "<my-button value='注册账号' class='component-loginpage-button1' v-on:onclick='register' ></my-button>" +
                    "<input type='password' class='component-loginpage-password-text' placeholder='密码' maxlength='16' v-model='password' />" +
                    "<my-button value='忘记密码' class='component-loginpage-button2'  maxlength='16'  ></my-button>" +
                    "<my-button value='登录' class='component-loginpage-button3' v-on:onclick='login'></my-button>" +
                "</div>" +
            "</div>" +
        "</div>"
})