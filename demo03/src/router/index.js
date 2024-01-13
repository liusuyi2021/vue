import VueRouter from 'vue-router'

import First from "@/view/First";
import Second from "@/view/Second";
import Login from "@/view/Login";
import Main from "@/view/Main";
import Vue from "vue";

Vue.use(VueRouter)

const router = new VueRouter({
    mode:"history",
    routes: [
        {
            path: '/main',
            component: Main
        },
        {
            path: '/login',
            component: Login
        },
        {
            path: '/first',
            component: First
        },
        {
            path: '/second',
            component: Second
        }]
})
//vue router连续点击多次路由报错解决方法
const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
    return originalPush.call(this, location).catch(err => err)
}
export default router
