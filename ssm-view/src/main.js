import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import axios from 'axios'
import {postRequest} from '@/utils/api'


axios.defaults.withCredentials = true //让ajax携带cookie

import 'element-ui/lib/theme-chalk/index.css'

Vue.prototype.$axios=axios

Vue.use(ElementUI)
//安装插件
// Vue.use(router);//挂载属性

//检测本地路由
let localRoutes = sessionStorage.getItem('routes')
if (localRoutes) {
  let array = JSON.parse(localRoutes)
  for (let i = 0; i < array.length; i++) {
    router.addRoutes([{
      path: array[i].path,
      component: resolve => require(["@/components/" + array[i].component + ""], resolve),
      meta: {
        keepAlive: array[i].keepAlive
      }
    }])
  }
}

Vue.config.productionTip = false

// window.bus = new Vue()
new Vue({
  el: '#app',
  router: router,
  template: '<App/>',
  components: {App}
})
