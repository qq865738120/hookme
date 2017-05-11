/**
 * 评论组件
 * Created by code_xia on 2017/5/11.
 */
Vue.component("my-headportrait", circleHeadPortrait);

var speack = Vue.extend({
    template:
        "<div id='component-speack-div'>" +
            "<my-headportrait class='component-speak-headportrait' :img-url='allData.headPictureUrl' :user-name='allData.nickName'></my-headportrait>" +
        "</div>"
});