/**
 * 头像组件
 * Created by code_xia on 2017/4/9.
 */

var circleHeadPortrait = Vue.extend({
    props: ['imgUrl','userName'], //imgUrl：头像图片路径  userName：用户昵称
    data: function () {
        return {
            background: {
                background: 'url('+this.imgUrl+')',
                backgroundSize: '100% 100%',
                backgroundRepeat: 'no-repeat'
            }
        }
    },
    methods: {
        /**
         * 点击事件函数，提供接口
         */
        onclick: function () {
            this.$emit('onclick');
        }
    },
    template:
        "<div id='component-circleHeadPortrait-div' v-on:click='onclick' >" +
            "<div class='component-circleHeadPortrait-img' :style='background'>" +
            "</div>" +
            "<span class='component-circleHeadPortrait-name'>" +
                "{{userName}}" +
            "</span>" +
        "</div>"
})