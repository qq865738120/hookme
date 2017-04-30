/**
 * hook页面js
 * Created by code_xia on 2017/4/13.
 */
Vue.component("my-header",header);

var hook = new Vue({
    el: '#vue-app',
    data: {
        nickName: '',
        imgUrl: '',
    },
    created: function () {
        this.setNickName();
        this.setImgUrl();
    },
    methods: {
        /**
         * 头像点击事件函数
         */
        headPictureClick: function () {
            alert("点击头像");
        },
        /**
         * 获取昵称函数
         */
        setNickName: function () {
            this.nickName = this.getCookieValue("nickname");
        },
        /**
         * 获取头像图片函数
         */
        setImgUrl: function () {
            this.imgUrl = this.getCookieValue("icon");
        },
        /**
         * 获取cookie值
         */
        getCookieValue: function (name) {
            var cookies = document.cookie.split(";");
            for (var i=0; i<cookies.length; i++){
                var nameAndValue = cookies[i].split("=");
                if (nameAndValue[0] == " "+name){
                    return nameAndValue[1]
                }
            }
        }
    }
});
