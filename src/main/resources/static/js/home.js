/**
 * 主页js
 * Created by code_xia on 2017/4/1.
 */
Vue.component("my-button", baseButton)
Vue.component("my-loginpage", loginPage)
Vue.component("my-fonter", fonter)

var home = new Vue({
    el: '#vue-app',
    data: {
        islogin: false,
    },
    methods: {
        loginclick1: function () {
            this.islogin = true;
        },
        loginpageclose: function () {
            this.islogin = false;
        },
    }
});