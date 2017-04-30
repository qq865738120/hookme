/**
 * Created by code_xia on 2017/4/2.
 */
/**
 * 按钮组件
 * */

var baseButton = Vue.extend({
    data: function () {
        return {
            buttonName: ""
        };
    },
    props: ['value'],
    methods: {
        onclick: function () {
            this.$emit('onclick');
        }
    },
    template:
        "<div id='component-basebutton-div' v-on:click='onclick'>{{value}}</div>",
})