/**
 * Created by code_xia on 2017/4/3.
 */
/**
 * 页脚组件
 * */

var fonter = Vue.extend({
    props: ['value1'],
    methods: {
        onclick1: function () {
            this.$emit('onclick1');
        }
    },
    template:
        "<div id='component-fonter-div'>" +
            "<hr />" +
            "<a>{{value1}}</a>"+
        "</div>"
})