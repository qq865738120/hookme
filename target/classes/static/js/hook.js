/**
 * hook页面js
 * Created by code_xia on 2017/4/13.
 */
Vue.component("my-header", header);
Vue.component("my-sidebar", sidebar);
Vue.component("my-display-post", displayPost);
Vue.component("my-speak", speak);

var hook = new Vue({
    el: '#vue-app',
    data: {
        sidebarIndex: '',
        nickName: '',
        imgUrl: '',
        list: [
            {name: '附近', icon1: '/../img/nearby_icon_1.png', icon2: '/../img/nearby_icon_2.png', class: 'nearby'},
            {name: '社团', icon1: '/../img/organization_icon_1.png', icon2: '/../img/organization_icon_2.png', class: 'organization'},
            {name: '好友', icon1: '/../img/friends_icon_1.png', icon2: '/../img/friends_icon_2.png', class: 'friends'},
            {name: '日记', icon1: '/../img/diary_icon_1.png', icon2: '/../img/diary_icon_2.png', class: 'diary'},
            {name: '我的', icon1: '/../img/user_icon_1.png', icon2: '/../img/user_icon_2.png', class: 'user'}
        ],
        displayPostData: [],
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
            if (this.getCookieValue("icon") == null || this.getCookieValue("icon") === "")
                this.imgUrl = "../img/default_userhead_icon.png";
            else
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
        },
        /**
         * 点击侧边栏
         * @param index
         */
        clickSidebar: function (index) {
            this.sidebarIndex = index;
            if (index == 0) {
                this.$http.get("/hook/nearbyModule").then(function (responce) {
                    this.displayPostData = responce.data;
                }, function () {  });
            }
        },
        /**
         * 点赞按钮
         */
        goodClicked: function (num, id) {
            if (num == 1) {
                this.displayPostData[id].goodNum++;
            } else {
                this.displayPostData[id].goodNum--;
            }
            alert("点赞");
        },
        /**
         * 评论按钮
         */
        speackClicked: function () {
            alert("评论");
        },
        /**
         * 分享按钮
         */
        shareClicked: function () {
            alert("分享");
        },
        /**
         * speackSlotName字段初始化函数
         */
        slotNameInit: function () {
            var arr = [];
            for (var i=1; i<=this.speak.length;){
                arr.push("left", "center", "right");
                i += 3;
            }
            return arr;
        },
    }
});
