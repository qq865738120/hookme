/**
 * 下拉菜单组件
 * 依赖的组件：
 * Created by code_xia on 2018/1/12.
 */

var dropMenu = Vue.extend({
    props: ['overImg', 'outImg', 'list'],
    data: function () {
        return {
            style: {
                backgroundImage: 'url('+this.outImg+')',
            },
        }
    },
    methods: {
        /**
         * button鼠标移入事件函数，不提供接口
         */
        mouseOver: function () {
            var button = document.getElementsByClassName("component-drop-menu-button");
            var list = document.getElementsByClassName("component-drop-menu-list");
            button[0].style.backgroundImage = "url("+this.overImg+")";
            list[0].style.display = "block";
        },
        /**
         * button鼠标移出事件函数，不提供接口
         */
        mouseOut: function () {
            var button = document.getElementsByClassName("component-drop-menu-button");
            var list = document.getElementsByClassName("component-drop-menu-list");
            button[0].style.backgroundImage = "url("+this.outImg+")";
            list[0].style.display = "none";
        },
        /**
         * 菜单项点击事件函数，提供接口
         */
        clicked: function (index) {
            this.$emit("clicked", index);
        }
    },
    template:
        "<div id='component-drop-menu-div'>" +
            "<div class='component-drop-menu-button' v-on:mouseover='mouseOver()' v-on:mouseout='mouseOut()' :style='style'></div>" +
            "<div class='component-drop-menu-list' v-on:mouseover='mouseOver()' v-on:mouseout='mouseOut()'>" +
                "<ul>" +
                    "<li v-for='(li, index) in list' v-on:click='clicked(index)'><a href='#'>{{li}}</a></li>" +
                "</ul>" +
            "</div>" +
        "</div>"
})