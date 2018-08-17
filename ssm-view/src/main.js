import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import axios from 'axios'

import 'element-ui/lib/theme-chalk/index.css'

axios.defaults.withCredentials = true //让ajax携带cookie
Vue.prototype.$axios = axios

Vue.use(ElementUI)
//安装插件
// Vue.use(router);//挂载属性

Vue.config.productionTip = false
window.bus = new Vue();
new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: {App}
})
