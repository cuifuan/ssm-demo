<template>
  <el-menu
    :default-active="activeIndex"
    class="el-menu-demo"
    mode="horizontal"
    @select="handleSelect"
    background-color="#2c3e50"
    text-color="#fff"
    active-text-color="#ffd04b">
    <el-menu-item v-for="(n,index) in navData" :key="index" :index="n.component">{{n.name}}</el-menu-item>
    <!-- <el-menu-item index="area">地区</el-menu-item>
     <el-submenu index="3">
       <template slot="title">我的工作台</template>
       <el-menu-item index="3-1">选项1</el-menu-item>
       <el-menu-item index="3-2">选项2</el-menu-item>
       <el-menu-item index="3-3">选项3</el-menu-item>
       <el-submenu index="3-4">
         <template slot="title">选项4</template>
         <el-menu-item index="3-4-1">选项1</el-menu-item>
         <el-menu-item index="3-4-2">选项2</el-menu-item>
         <el-menu-item index="3-4-3">选项3</el-menu-item>
       </el-submenu>
     </el-submenu>
     <el-menu-item index="4" disabled>消息中心</el-menu-item>
     <el-menu-item index="5">订单管理</el-menu-item>-->


    <el-dropdown @command="handleCommand" class="home_userinfo">
      <span class="el-dropdown-link">
         {{currentUserName}}<i class="el-icon-arrow-down el-icon-right"></i>
      </span>
      <el-dropdown-menu slot="dropdown">
        <el-dropdown-item command="sysMsg">系统消息</el-dropdown-item>
        <el-dropdown-item command="MyArticle">我的文章</el-dropdown-item>
        <el-dropdown-item command="MyHome">个人主页</el-dropdown-item>
        <el-dropdown-item command="logout" divided>退出登录</el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>
  </el-menu>
</template>

<script>
  import {getRequest} from '../../utils/api'
  import {postRequest} from '../../utils/api'

  export default {
    name: "Header",
    data() {
      return {
        activeIndex: 'Home',
        currentUserName: '',
        navData: []
      }
    },
    created() {
      this.activeIndex = this.$router.history.current.path.replace("/", "")
      this.currentUserName = sessionStorage.getItem('username')
      // this.navData = JSON.parse(sessionStorage.getItem('routes'))
      console.log(222)
    },
    methods: {
      handleSelect(key, keyPath) {
        this.$router.replace("/" + keyPath)
      },
      handleCommand(command) {
        if (command === 'logout') {
          this.$confirm('注销登录吗?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            postRequest("/logout")
            this.currentUserName = '游客'
            sessionStorage.clear()
            this.$router.replace({path: '/login'})
            this.$message({
              type: 'success',
              message: '注销成功!'
            })
          }).catch(() => {
            this.$message({
              type: 'warning',
              message: '注销失败'
            })
          })
        }
      },
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
          this.navData = routesArray
          console.log(111)
        }).catch(error => {
          console.log(error)
        })
      }
    },
    created() {
      this.initmenu()
    }
  }
</script>

<style scoped>
  .el-menu-demo {
    width: 100%;
    height: 60px;
  }

  .home_userinfo {
    /*position: absolute;*/
    float: right;
    display: inline;
    margin-right: 20px;
    font-size: 15px;
    margin-top: 20px;
  }

  .el-dropdown-link {
    color: aliceblue;
    font-size: 18px;
  }

  .nava {
    display: block;
  }
</style>
