import Vue from 'vue'
import Router from 'vue-router'
import userpower from './../utils/user'

Vue.use(Router)

const Login = resolve => require(['@/components/login/Login'], resolve)

const NotFound = resolve => require(['@/components/errorPage/404'], resolve)

const areaz = resolve => require(['@/components/Area'], resolve)

const HelloWorld = resolve => require(['@/components/HelloWorld'], resolve)

/**
 * 静态路由
 */
export const staticRouters = [
  {
    path: '/',
    name: '登录',
    component: Login,
    meta: {
      keepAlive: false
    }
  },
  {
    path: '/login',
    name: '登录',
    component: Login,
    meta: {
      keepAlive: false
    }
  }/*,
  {
    path: '*',
    name: '404',
    component: NotFound,
    meta: {
      keepAlive: false
    }
  }*/
]

const router=new Router({
  routes: staticRouters
})

/*
 * 权限拦截
 * */

// const whiteList = ['/', '/login'] //白名单,不需要登录的路由


router.beforeEach((to, from, next) => {
  let currentUserName=sessionStorage.getItem('username')
  if(currentUserName!=null){
    next()
  }
})

router.afterEach((to, from, next) => {
  BaseSet.addOpendPage(router.app, to.name, to.params, to.query, to.meta, to.path)
})

export default router
