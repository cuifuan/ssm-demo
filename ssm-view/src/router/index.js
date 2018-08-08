import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

const Login = resolve => require(['@/components/login/Login'], resolve)

const hello = resolve => require(['@/components/ArticleList'], resolve)

const Home = resolve => require(['@/components/Home'], resolve)

const ArticleList = resolve => require(['@/components/ArticleList'], resolve)

const CateMana = resolve => require(['@/components/CateMana'], resolve)

const DataCharts = resolve => require(['@/components/DataCharts'], resolve)

const PostArticle = resolve => require(['@/components/PostArticle'], resolve)

const UserMana = resolve => require(['@/components/UserMana'], resolve)

const BlogDetail = resolve => require(['@/components/BlogDetail'], resolve)

const error = resolve => require(['@/components/errorPage/404'], resolve)

const perssion = resolve => require(['@/components/errorPage/401'], resolve)

const areaz = resolve => require(['@/components/Area'], resolve)





export default new Router({
  routes: [
    {
      path: '/',
      name: '登录',
      component: Login,
      meta: {
        keepAlive: false
      }
    },{
      path: '/area',
      name: 'area',
      component: areaz,
      meta: {
        keepAlive: true
      }
    },
    {
      path: '/home',
      name: 'app',
      component: Home,
      // hidden: true,
      meta: {
        keepAlive: true
      }
    },{
      path: '/index',
      name: 'app',
      component: hello,
      // hidden: true,
      meta: {
        keepAlive: true
      }
    },{
      path: '/404',
      name: '404',
      component: error,
      meta: {
        keepAlive: false
      }
    }, {
      path: '/401',
      name: '401',
      component: perssion,
      meta: {
        keepAlive: false
      }
    },{
      path: '/home',
      component: Home,
      name: '文章管理',
      iconCls: 'fa fa-file-text-o',
      children: [
        {
          path: '/articleList',
          name: '文章列表',
          component: ArticleList,
          meta: {
            keepAlive: true
          }
        }, {
          path: '/postArticle',
          name: '发表文章',
          component: PostArticle,
          meta: {
            keepAlive: false
          }
        }, {
          path: '/blogDetail',
          name: '博客详情',
          component: BlogDetail,
          hidden: true,
          meta: {
            keepAlive: false
          }
        }, {
          path: '/editBlog',
          name: '编辑博客',
          component: PostArticle,
          hidden: true,
          meta: {
            keepAlive: false
          }
        }
      ]
    }, {
      path: '/home',
      component: Home,
      name: '用户管理',
      children: [
        {
          path: '/user',
          iconCls: 'fa fa-user-o',
          name: '用户管理',
          component: UserMana
        }
      ]
    }, {
      path: '/home',
      component: Home,
      name: '栏目管理',
      children: [
        {
          path: '/cateMana',
          iconCls: 'fa fa-reorder',
          name: '栏目管理',
          component: CateMana
        }
      ]
    }, {
      path: '/home',
      component: Home,
      name: '数据统计',
      iconCls: 'fa fa-bar-chart',
      children: [
        {
          path: '/charts',
          iconCls: 'fa fa-bar-chart',
          name: '数据统计',
          component: DataCharts
        }
      ]
    },
    {
      path: '*',
      redirect: '/404'
    }
  ]
})
