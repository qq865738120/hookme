/**
 * 注册页面js
 * Created by code_xia on 2017/4/9.
 */

Vue.component("my-header", header);
Vue.component("my-button", baseButton);
Vue.component("my-fonter", fonter);
var fontComponent = {
    props: ['isShow'],
    data: function () {
        return {
            username: "",
            password1: "",
            password2: "",
            age: "",
        }
    },
    methods:{
        /**
         * 提交按钮函数,提供接口
         */
        finished: function () {
            var vm = this;
            var data = {
                userName: this.username,
                password1: this.password1,
                password2: this.password2,
                age: this.age,
            }
            var checkbox = document.getElementsByClassName("local-component-form-right-body-second-checkbox");
            for (var i=0; i<checkbox.length; i++) {
                if (checkbox[i].checked) {
                    this.$http.post("/register/finished", data).then(function (response) {
                            if (response.headers().msg != undefined) {
                                alert(response.headers().msg);
                            } else {
                                if (response.data.data != undefined) {
                                    if (response.data.data.result == "true"){
                                        console.log(response.data.data.msg);
                                        if (response.data.data.msg == "邮箱注册成功") {
                                            this.$emit('finished');
                                        } else {
                                            alert("注册成功");
                                            window.location = "/"; //重定向到主页
                                        }
                                    }else {
                                        alert(response.data.data.msg);
                                    }
                                }
                            }
                        },
                        function () {
                            alert("服务器无响应,请稍后再试！");
                        })
                } else {
                    alert("请勾选用户服务协议");
                }
            }
        },
    },
    template:
        "<div id='local-component-form-div' v-if='this.isShow'>" +
            "<div class='local-component-form-body'>" +
                "<div class='local-component-form-left'>" +
                    "<div class='local-component-form-left-body'>" +
                        "<div class='local-component-form-body-spandiv'>" +
                            "<span class='local-component-form-body-text1-span'>用户名</span>" +
                            "<br />" +
                            "<span class='local-component-form-body-text2-span'>密码</span>" +
                            "<br />" +
                            "<span class='local-component-form-body-text3-span'>确认密码</span>" +
                            "<br />" +
                            "<span class='local-component-form-body-text4-span'>年龄</span>" +
                        "</div>" +
                        "<div class='local-component-form-body-inputdiv'>" +
                            "<input type='text' class='local-component-form-body-text1-input' placeholder='用户名/邮箱' maxlength='32' v-model='username' />" +
                            "<input type='password' class='local-component-form-body-text2-input' placeholder='密码由16位的字母、数字组成' maxlength='16' v-model='password1' />" +
                            "<input type='password' class='local-component-form-body-text2-input' placeholder='重复输入密码' maxlength='16' v-model='password2' />" +
                            "<input type='text' class='local-component-font-form-text2-input' placeholder='请输入真实年龄' maxlength='3' v-model='age' />" +
                        "</div>" +
                        "<div class='local-component-form-body-tipspan'>" +
                            "<span class='local-component-form-body-text1-span'>*</span>" +
                            "<br />" +
                            "<span class='local-component-form-body-text2-span'>*</span>" +
                            "<br />" +
                            "<span class='local-component-form-body-text3-span'>*</span>" +
                            "<br />" +
                            "<span class='local-component-form-body-text4-span'>*</span>" +
                        "</div>" +
                        "<my-button value='完成' class='finish-button' v-on:onclick='finished'></my-button>" +
                    "</div>" +
                "</div>" +
                "<div class='local-component-form-right'>" +
                    "<div class='local-component-form-right-body'>" +
                        "<div class='local-component-form-right-body-first'>" +
                            "<span>hook用户服务协议</span>"+
                            "<br />"+
                            "hook提供服务的使用者，若您不接受此条款，请勿使用平台提供的服务；一旦使用，表明您已同意以下条款。若您违背以下条款，hook有权在您不知情的情况下，禁止您进入hook，或采取法律措施。"+
                            "<br />"+
                            "一、用户在hook上发布或产生的信息内容、数据由用户及hook共同所有，任何其他组织或个人未经用户本人及hook授权同意，不得复制、转载、擅改其内容，如若转载请注明出处。用户不得在hook发布含有下列内容的信息：" +
                            "<br />"+
                            "1）违反国家宪法所规定的基本原则的；"+
                            "<br />"+
                            "2）危害国家安全，泄露国家秘密，颠覆国家政权，破坏国家统一的；"+
                            "<br />"+
                            "3）损害国家荣誉和利益的；"+
                            "<br />"+
                            "4）煽动民族仇恨、民族歧视，破坏民族团结的；"+
                            "<br />"+
                            "5）破坏国家宗教政策，宣扬邪教和封建迷信的；"+
                            "<br />"+
                            "6）散布谣言，扰乱社会秩序，破坏社会稳定的；"+
                            "<br />"+
                            "7）散布淫秽、色情、赌博、暴力、凶杀、恐怖或者教唆犯罪的；"+
                            "<br />"+
                            "8）侮辱或者诽谤他人，侵害他人合法权益的；"+
                            "<br />"+
                            "9）含有法律、行政法规禁止的其他内容的；"+
                            "<br />"+
                            "10）其他hook认为不适当在此发布的内容，hook保留删除和变更上述相关信息的权利。造成用户损失的，用户自行承担。"+
                            "二、用户应保证提供真实的注册信息，确保信息是正确且完整的，用户相关信息变更时需及时更新相关内容。当由于信息不真实而造成任何损失时，hook不承担任何损失责任。"+
                            "<br />"+
                            "三、请用户保管好自己的账户信息，一旦账号信息丢失或泄露，hook不承担任何损失责任。"+
                            "<br />"+
                            "四、hook不能保证提供的服务能够满足用户的所有要求，也不能保证已存在的服务是否会在使用时中断，以及服务的及时性、安全性、准确性也不能保证。"+
                            "<br />"+
                            "五、用户因违反有关法律、法规或协议规定中的任何条款而给hook或任何第三方造成的损失，用户同意承担由此造成的一切损害赔偿责任。"+
                            "<br />"+
                            "六、在法律允许的范围内，hook保留对本协议任何条款的解释权和随时变更的权利。"+
                        "</div>" +
                        "<div class='local-component-form-right-body-second'>" +
                            "<input class='local-component-form-right-body-second-checkbox' type='checkbox' checked='checked' />" +
                            "<label>我同意并遵守上述协议</label>" +
                        "</div>" +
                    "</div>" +
                "</div>" +
            "</div>" +
        "</div>"
}

var activeComponent = {
    template:
        "<div id='local-component-active-div'>" +
            "<div class='local-component-active-body'>" +
                "<div class='local-component-active-content'>" +
                    "<h1>邮箱验证</h1>" +
                    "<h2>验证邮件发送成功，请登录您的邮箱完成验证。</h2>" +
                    "<h3>常见问题:</h3>" +
                    "<div class='local-component-active-content-tip'>" +
                        "<ul>" +
                            "<li>没有收到邮件？" +
                            "<br/>" +
                            "请确认注册所用的邮箱与你登陆的邮箱一致。" +
                            "</li>" +
                            "<li>邮箱没错，但仍然没有收到邮件？" +
                            "<br/>" +
                            "请确认收件箱没有新邮件。如果没有，可以尝试换个邮箱试试。" +
                            "</li>" +
                        "</ul>" +
                    "</div>" +
                "</div>" +
            "</div>" +
        "</div>"
}

var register = new Vue({
    el: '#vue-app',
    data: {
        show: true,
    },
    methods: {
        finished: function () {
            this.show = !this.show;
        }
    },
    components: {
        "my-font": fontComponent,
        "my-active": activeComponent
    }
})
