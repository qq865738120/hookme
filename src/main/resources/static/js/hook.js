/**
 * hook页面js
 * Created by code_xia on 2017/4/13.
 */
Vue.component("my-header", header);
Vue.component("my-sidebar", sidebar);
Vue.component("my-display-post", displayPost);

var hook = new Vue({
    el: '#vue-app',
    data: {
        nickName: '',
        imgUrl: '',
        list: [
            {name: '附近', icon1: '/../img/nearby_icon_1.png', icon2: '/../img/nearby_icon_2.png', class: 'nearby'},
            {name: '社团', icon1: '/../img/organization_icon_1.png', icon2: '/../img/organization_icon_2.png', class: 'organization'},
            {name: '好友', icon1: '/../img/friends_icon_1.png', icon2: '/../img/friends_icon_2.png', class: 'friends'},
            {name: '日记', icon1: '/../img/diary_icon_1.png', icon2: '/../img/diary_icon_2.png', class: 'diary'}
        ],
        displayPostData: {
            nickName: "没什么大不了",
            headPictureUrl: "/../img/testHeadPicture.jpg",
            dateTimeAndDistance: "时间：21h     距离：1.2km",
            goodNum: "514",
            speachNum: "23",
            shareNum: "1",
            postMsg: "技术开发好卡手机话费快捷回复的卡发没发么那部分可减肥哈咖啡吧地方吗本发明的房间啊回复我空间而被人们不舒服马师傅",
            imgUrl: [
                "/../img/homebj.jpg",
                "/../img/loginbg.jpg",
                "/../img/homebj.jpg",
            ],
        },
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
        },
        /**
         * 点击侧边栏
         * @param index
         */
        clickSidebar: function (index) {
            alert(index);
        },
        /**
         * 点赞按钮
         */
        goodClicked: function (num) {
            if (num == 1) {
                this.displayPostData.goodNum += 1;
            } else {
                this.displayPostData.goodNum -= 1;
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
        }
    }
});
