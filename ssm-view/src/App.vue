<template>
  <div id="app">
    <!-- 其他页 -->
    <el-container v-if="!$route.meta.keepAlive" class="home-container">
      <el-header class="home-header">
        <keep-alive>
          <!-- 导航栏 -->
          <header-nav></header-nav>
        </keep-alive>
      </el-header>
      <el-container>
        <el-main>
          <!-- Body -->
          <router-view class="main"></router-view>
        </el-main>
      </el-container>
    </el-container>
    <!-- 登录页 -->
    <router-view v-if="$route.meta.keepAlive"></router-view>
  </div>

</template>

<script>
  import {postRequest} from '@/utils/api'
  import header from "@/components/public/Header"
  import left from '@/components/public/Left'

  export default {
    name: 'app',
    data() {
      return {}
    },
    created() {
      // this.initmenu()
      // this.$refs.headerNav.getNav()
    },
    components: {
      headerNav: header,
      left: left
    },
    methods: {
      goMuisc() {
        //第一种跳转方法
        this.$router.push('/home')  //此处的名称必须和main.js路由规则配置的path值一致

      },
      testParams() {
        //查询字符串的方式，比如  /music_country?id=1&name=2
        this.$router.push({
          name: 'music', query: {id: 1, name: 2}
        })

      }/*,
      initmenu() {
        postRequest('/router').then(res => {
          let routesArray = []
          let routerjson = res.data.data
          if (routerjson == null) return
          for (let i = 0; i < routerjson.length; i++) {
            let pathx = routerjson[i].path
            let keepAlivex = routerjson[i].keepAlive
            let json = [{
              path: pathx,
              name: routerjson[i].name,
              component: (resolve) => require(['@/components/' + routerjson[i].component + '.vue'], resolve),
              meta: {
                keepAlive: keepAlivex
              }
            }]
            this.$router.addRoutes(json)
            routesArray.push({
              'path': pathx,
              'component': routerjson[i].component,
              'keepAlive': keepAlivex,
              'name': routerjson[i].name
            })
          }
          this.$router.addRoutes([{path: '*', redirect: '/404'}])
          sessionStorage.removeItem("routes")
          sessionStorage.setItem("routes", JSON.stringify(routesArray))
          console.log(111)
        }).catch(error => {
          console.log(error)
        })
      }*/
    }
  }
</script>


<style scoped>
  /* 隐藏滚动条 */
  body::-webkit-scrollbar {
    display: none;
  }

  .home-container {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
  }

  .home-header {
    background-color: #2c3e50;
    color: #2c3e50;
    text-align: center;
    display: flex;
    align-items: center;
    justify-content: space-between;
    box-sizing: content-box;
  }

  #app {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    margin: 0;
    /*overflow: hidden;*/
    font-family: 'Microsoft YaHei', Helvetica Neue, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
  }
</style>
