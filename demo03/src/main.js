import Vue from 'vue'
import App from './App.vue'
import ElementUi from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css';
import router from '@/router'
//引入axios
import axios from 'axios'
//设置axios为全局属性
Vue.prototype.$axios = axios

Vue.config.productionTip = false
Vue.use(ElementUi)
new Vue({
    router, // 注入路由器
    render: h => h(App),
}).$mount('#app')
