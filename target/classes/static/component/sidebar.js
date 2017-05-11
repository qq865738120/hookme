/**
 * 侧边栏组件
 * Created by code_xia on 2017/5/8.
 *
 * list参数格式[{name:'', icon1:'', icon2:'' ,class:''}]
 * name：列表项，icon1：图标路径， icon2：图标路径， class：列表项类名
 */

var sidebar = Vue.extend({
    props: ['list'],
    data: function () {
        return {
            red: "#444",
            url1: 'url(',
            url2: ')',
            backgroundStyle: {
                backgroundRepeat: 'no-repeat',

            }
        };
    },
    /**
     * 挂载dom前执行的钩子函数
     */
    mounted: function() {
        var li = document.getElementsByTagName("li");
        for (var i=0; i<li.length; i++) {
            li[i].addEventListener("mouseover", function (vm) {
                var obj = event.srcElement ? event.srcElement : event.target;
                var dom = document.getElementsByClassName(obj.className)
                for (var j=0; j<vm.list.length; j++){
                    if (vm.list[j].class==obj.className){
                        dom[0].innerHTML = "<img src="+vm.list[j].icon2+" />" + vm.list[j].name;
                    }
                }
            }.bind(event, this), false);
            li[i].addEventListener("mouseout", function (vm) {
                var obj = event.srcElement ? event.srcElement : event.target;
                var dom = document.getElementsByClassName(obj.className)
                for (var j=0; j<vm.list.length; j++){
                    if (vm.list[j].class==obj.className){
                        dom[0].innerHTML = "<img src="+vm.list[j].icon1+" />" + vm.list[j].name;
                    }
                }
            }.bind(event, this), false);
        }
        li[0].click();
    },
    methods: {
        /**
         * 点击函数，提供接口
         * @param index ：被点击的列表项的索引
         */
        clicked: function (index) {
            for (var i=0; i<this.list.length; i++){
                var dom = document.getElementsByClassName(this.list[i].class);
                if (i == index){ //被激活的li
                    dom[0].id = "component-sidebar-li-active";
                } else {
                    dom[0].id = "";
                }
            }
            this.$emit("clicked", index);
        }
    },
    template:
        "<div id='component-sidebar-div'>" +
            "<div class='component-sidebar-body'>" +
                "<ul class='component-sidebar-ul'>" +
                    "<li v-for='(li, index) in list' v-on:click='clicked(index)' v-bind:class='li.class'>" +
                        "<img v-bind:src='li.icon1' />" + "{{li.name}}" +
                    "</li>" +
                "</ul>"+
            "</div>" +
        "</div>"
})