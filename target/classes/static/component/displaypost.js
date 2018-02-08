/**
 * 展示帖子组件
 * 依赖的组件：
 * 1.circleHeadPortrait
 * Created by code_xia on 2017/5/11.
 */
Vue.component("my-headportrait", circleHeadPortrait);

var displayPost = Vue.extend({
    props: ['allData', 'index'],
    data: function () {
        return {
            url1: "url(",
            url2: ")",
            speakLeft: [],
            speakCenter: [],
            speakRight: [],
            id: null,
        };
    },
    mounted: function () {

    },
    created: function () {
        this.speakInit();
        this.id = this.index;
    },
    methods: {
        /**
         * 点赞按钮函数，提供接口
         */
        goodclicked: function (event) {
            var dom = document.getElementsByClassName(event.target.className);
            var srcArr = dom[this.id].src.split("/");
            if (srcArr[srcArr.length-1] == "good_icon_1.png") {
                dom[this.id].src = "/../img/good_icon_2.png";
                this.$emit("goodclicked", 1, this.id);
            } else {
                dom[this.id].src = "/../img/good_icon_1.png"
                this.$emit("goodclicked", -1, this.id);
            }
        },
        /**
         * 评论按钮函数，提供接口
         */
        speackclicked: function (event) {
            document.getElementsByClassName(event.target.className)[this.id].src = "/../img/speak_icon_2.png";
            this.$emit("speackclicked");
        },
        /**
         * 分享按钮函数，提供接口
         */
        shareclicked: function () {
            document.getElementsByClassName(event.target.className)[this.id].src = "/../img/share_icon_2.png";
            this.$emit("shareclicked");
        },
        /**
         * speak初始化函数
         */
        speakInit: function () {
            for (var i=0; i<this.allData.speak.length; i++) {
                if (i%3 == 0) {
                    this.speakLeft.push(this.allData.speak[i]);
                } else if(i%3 == 1) {
                    this.speakCenter .push(this.allData.speak[i]);
                } else {
                    this.speakRight .push(this.allData.speak[i]);
                }
            }
        }
    },
    template:
        "<div id='component-displaypost-div' class='component-displaypost-div'>" +
            "<div class='component-displaypost-head-bg'>" +
                "<div class='component-displaypost-head'>" +
                    "<my-headportrait class='component-displaypost-head-left' :img-url='allData.headPictureUrl' :user-name='allData.nickName'></my-headportrait>" +
                    "<span class='component-displaypost-head-span'>{{allData.dateTimeAndDistance}}</span>" +
                    "<div class='component-displaypost-head-right'>" +
                        "<img class='component-displaypost-head-goodimg' src='/../img/good_icon_1.png' v-on:click='goodclicked' />" + "<span>{{allData.goodNum}}</span>" +
                        "<img class='component-displaypost-head-speachimg' src='/../img/speak_icon_1.png' v-on:click='speackclicked' />" + "<span>{{allData.speachNum}}</span>" +
                        "<img class='component-displaypost-head-shareimg' src='/../img/share_icon_1.png' v-on:click='shareclicked' />" + "<span>{{allData.shareNum}}</span>" +
                    "</div>" +
                "</div>" +
            "</div>" +
            "<div class='component-displaypost-body'>" +
                "<span class='component-displaypost-body-msg'>{{allData.postMsg}}</span>" +
                "<div class='component-displaypost-body-img'>" +
                    "<div v-for='url in allData.imgUrl' :style='{background: url1+url+url2}'></div>" +
                "</div>" +
                "<div class='component-displaypost-body-speak'>" +
                    "<div class='component-displaypost-body-speak-left'>" +
                        "<div id='component-speak-div' v-for='data in speakLeft'>" +
                            "<div class='component-speak-body'>" +
                                    "<my-headportrait class='component-speak-headportrait' :img-url='data.headPictureUrl' :user-name='data.nickName'></my-headportrait>" +
                                    "<p>时间：{{data.timeout}}</p>" +
                                "<span class='component-speak-span'>{{data.speakMsg}}</span>" +
                            "</div>" +
                        "</div>"+
                    "</div>" +
                    "<div class='component-displaypost-body-speak-center'>" +
                        "<div id='component-speak-div' v-for='data in speakCenter'>" +
                            "<div class='component-speak-body'>" +
                                "<my-headportrait class='component-speak-headportrait' :img-url='data.headPictureUrl' :user-name='data.nickName'></my-headportrait>" +
                                "<p>时间：{{data.timeout}}</p>" +
                                "<span class='component-speak-span'>{{data.speakMsg}}</span>" +
                            "</div>" +
                        "</div>"+
                    "</div>" +
                    "<div class='component-displaypost-body-speak-right'>" +
                        "<div id='component-speak-div' v-for='data in speakRight'>" +
                            "<div class='component-speak-body'>" +
                                "<my-headportrait class='component-speak-headportrait' :img-url='data.headPictureUrl' :user-name='data.nickName'></my-headportrait>" +
                                "<p>时间：{{data.timeout}}</p>" +
                                "<span class='component-speak-span'>{{data.speakMsg}}</span>" +
                            "</div>" +
                        "</div>"+
                    "</div>" +
                "</div>" +
            "</div>" +
        "</div>"
});
