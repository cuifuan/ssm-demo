import Vue from 'vue'
import Router from 'vue-router'
import userpower from './../utils/user'

Vue.use(Router)

const Login = resolve => require(['@/components/login/Login'], resolve)

const NotFound = resolve => require(['@/components/errorPage/404'], resolve)

// const Area = resolve => require(['@/components/Area'], resolve)

// const HelloWorld = resolve => require(['@/components/HelloWorld'], resolve)

// const Home = resolve => require(['@/components/Home'], resolve)

/**
 * 静态路由
 */
export const staticRouters = [
  {
    path: '/',
    redirect:'/login'
  },
  {
    path: '/login',
    name: '登录',
    component: Login,
    meta: {
      keepAlive: false
    }
  },
  {
    path: '/404',
    name: '404',
    component: NotFound,
    meta: {
      keepAlive: false
    }
  }
]

const router = new Router({
  routes: staticRouters
})

/*
 * 权限拦截
 * */

// const whiteList = ['/', '/login'] //白名单,不需要登录的路由
/*router.beforeEach((to, from, next) => {
  if (sessionStorage.getItem('routes')) {
    let array = JSON.parse(sessionStorage.getItem('routes'))
    for (let i = 0; i < array.length; i++) {
      // let c = JSON.parse(sessionStorage.getItem('routes')),
      // let  lastUrl = getLastUrl(window.location.href, '/')
      // console.log(lastUrl)
      // if (array[i].path === lastUrl) { //动态路由页面的刷新事件
        console.log(array[i])
      /!*  let newRoutes = staticRouters.concat([{
          path: array[i].path,
          component: resolve => require(["@/components/" + array[i].component + ""], resolve)
        }])*!/
        // localStorage.removeItem('routes')
        router.addRoutes([{
          path: array[i].path,
          component: resolve => require(["@/components/" + array[i].component + ""], resolve)
        }])
        // router.replace(array[i].path) //replace,保证浏览器回退的时候能直接返回到上个页面，不会叠加
      }
    // }
  }
  router.replace(getLastUrl(window.location.href, '/'))
  next()
})*/

// var getLastUrl = (str, yourStr) => str.slice(str.lastIndexOf(yourStr))//取到浏览器出现网址的最后"/"出现的后边的字符

/*
router.beforeEach((to, from, next) => {
    next()
})

router.afterEach((to, from, next) => {
})
*/
//检测本地路由
/*let localRoutes = sessionStorage.getItem('routes')
if (localRoutes) {
  console.log(JSON.parse(localRoutes))
  router.addRoutes(JSON.parse(localRoutes))
}*/
export default router
