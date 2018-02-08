/**
 * 评论组件
 * 依赖的组件：
 * 1.circleHeadPortrait
 * Created by code_xia on 2017/5/11.
 *
 * allData参数格式speak: [{timeout: '', userName: '', nickName: '', headPictureUrl: '', speakMsg: ''},],
 * timeout：时间，userName：用户名，nickName：用户昵称，headPictureUrl：头像url，speakMsg：评论消息
 */
Vue.component("my-headportrait", circleHeadPortrait);

var speak = Vue.extend({
    props: ['allData'],
    methods: {

    },
    template:
        "<div id='component-speak-div'>" +
            "<div class='component-speak-body'>" +
                "<my-headportrait class='component-speak-headportrait' :img-url='allData.headPictureUrl' :user-name='allData.nickName'></my-headportrait>" +
                "<p>时间：{{data.timeout}}</p>" +
                "<span class='component-speak-span'>{{allData.speakMsg}}</span>" +
            "</div>" +
        "</div>"
});