/**
 * 页头组件
 * 依赖的组件：
 *  1.circleHeadPortrait
 * Created by code_xia on 2017/4/9.
 */

Vue.component("head-portrait", circleHeadPortrait);

var header = Vue.extend({
    props: ['homeUrl','headPicture','nickName','displayRight'], //headPicture：头像图片路径  nickName：昵称
    data: function () {
        return {
            headerStyle: {
                float: 'left'
            },
        }
    },
    methods: {
        /**
         * logo点击事件函数，不提供接口
         */
        clickLogo: function () {
            window.location = this.homeUrl;
        },
        /**
         * 注销函数，不提供接口
         */
        logout: function () {
            var cookies = document.cookie.split(";");
            for (var i=0; i<cookies.length; i++)
                document.cookie = cookies[i].split("=")[0]+"="+"";
            alert("注销成功");
            this.clickLogo();
        },
        /**
         * 头像点击事件函数，提供接口
         */
        onclick: function () {
            this.$emit('onclick');
        }
    },
    template:
        "<div id='component-header-div'>" +
            "<div class='component-header-body'>" +
                "<div class='component-header-logo' v-on:click='clickLogo' ></div>" +
                "<div class='component-header-body-right' v-if='this.displayRight'>" +
                    "<head-portrait class='component-header-headportrait' :img-url='headPicture' :user-name='nickName' v-on:onclick='onclick' :style='headerStyle' ></head-portrait>" +
                    "<div class='component-header-logout' v-on:click='logout' ></div>" +
                "</div>" +
            "</div>" +
        "</div>"
});
