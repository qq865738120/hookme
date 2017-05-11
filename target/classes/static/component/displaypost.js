/**
 * 展示帖子组件
 * Created by code_xia on 2017/5/11.
 */
Vue.component("my-headportrait", circleHeadPortrait);

var displayPost = Vue.extend({
    props: ['allData'],
    data: function () {
        return {
            url1: "url(",
            url2: ")",
            bgSize: " 100% 100%",
            // imgbg: {
            //     background
            // }
        };
    },
    mounted: function () {

    },
    methods: {
        /**
         * 点赞按钮函数，提供接口
         */
        goodclicked: function (event) {
            var dom = document.getElementsByClassName(event.target.className);
            var srcArr = dom[0].src.split("/");
            if (srcArr[srcArr.length-1] == "good_icon_2.png") {
                dom[0].src = "/../img/good_icon_1.png";
                this.$emit("goodclicked", 1);
            } else {
                dom[0].src = "/../img/good_icon_2.png"
                this.$emit("goodclicked", -1);
            }
        },
        /**
         * 评论按钮函数，提供接口
         */
        speackclicked: function (event) {
            document.getElementsByClassName(event.target.className)[0].src = "/../img/speack_icon_2.png";
            this.$emit("speackclicked");
        },
        /**
         * 分享按钮函数，提供接口
         */
        shareclicked: function () {
            document.getElementsByClassName(event.target.className)[0].src = "/../img/share_icon_2.png";
            this.$emit("shareclicked");
        },
    },
    template:
        "<div id='component-displaypost-div' class='component-displaypost-div'>" +
            "<div class='component-displaypost-head-bg'>" +
                "<div class='component-displaypost-head'>" +
                    "<my-headportrait class='component-displaypost-head-left' :img-url='allData.headPictureUrl' :user-name='allData.nickName'></my-headportrait>" +
                    "<span class='component-displaypost-head-span'>{{allData.dateTimeAndDistance}}</span>" +
                    "<div class='component-displaypost-head-right'>" +
                        "<img class='component-displaypost-head-goodimg' src='/../img/good_icon_1.png' v-on:click='goodclicked' />" + "<span>{{allData.goodNum}}</span>" +
                        "<img class='component-displaypost-head-speachimg' src='/../img/speack_icon_1.png' v-on:click='speackclicked' />" + "<span>{{allData.speachNum}}</span>" +
                        "<img class='component-displaypost-head-shareimg' src='/../img/share_icon_1.png' v-on:click='shareclicked' />" + "<span>{{allData.shareNum}}</span>" +
                    "</div>" +
                "</div>" +
            "</div>" +
            "<div class='component-displaypost-body'>" +
                "<span class='component-displaypost-body-msg'>{{allData.postMsg}}</span>" +
                "<div class='component-displaypost-body-img'>" +
                    "<div v-for='url in allData.imgUrl' :style='{background: url1+url+url2+bgSize}'></div>" +
                "</div>" +
                "<div class='component-displaypost-body-speack'>" +
                    "" +
                "</div>" +
            "</div>" +
        "</div>"
});
