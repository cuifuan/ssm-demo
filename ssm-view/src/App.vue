<template>
  <div id="app">
    <div v-if="!$route.meta.keepAlive">
      <el-container class="home-container">
        <el-header>
          <header-nav></header-nav>
        </el-header>
      </el-container>
      <el-container class="container">
        <el-aside width="200px" class="home-aside">
          <left></left>
        </el-aside>
        <el-container>
          <el-scrollbar style="height: 100%">
          <el-main>
            <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
              <el-breadcrumb-item v-text="this.$router.currentRoute.name"></el-breadcrumb-item>
            </el-breadcrumb>
            <!--<keep-alive>
              <router-view v-if="this.$route.meta.keepAlive"></router-view>
            </keep-alive>-->
            <router-view v-if="!$route.meta.keepAlive" class="main"></router-view>
          </el-main>
          </el-scrollbar>
        </el-container>
      </el-container>
    </div>
    <!-- 登录页 -->
    <router-view v-if="$route.meta.keepAlive"></router-view>
  </div>
</template>


<script>
  import headerNav from '@/components/public/Header'
  import left from '@/components/public/Left'

  export default {
    name: 'app',
    data() {
      return {}
    },
    components: {
      headerNav: headerNav,
      left: left
    }
  }
</script>


<style>
  html, body {
    height: 100%;
    width: 100%;
    -moz-osx-font-smoothing: grayscale;
    -webkit-font-smoothing: antialiased;
    text-rendering: optimizeLegibility;
    font-family: Helvetica Neue, Helvetica, PingFang SC, Hiragino Sans GB, Microsoft YaHei, Arial, sans-serif;
    margin: 0;
  }

  /* 隐藏滚动条 */
  body::-webkit-scrollbar {
    display: none;
  }

  .home_container {
    height: 100%;
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
  }

  /*导航栏*/
  .el-header {
    background-color: #2c3e50;
    color: #333;
    text-align: center;
    display: flex;
    align-items: center;
    justify-content: space-between;
  }

  .el-submenu .el-menu-item {
    width: 180px;
    min-width: 175px;
  }

  .home-aside {
    background-color: #2c3e50;
  }

  .container {
    position: absolute;
    width: 100%;
    height: 100%;
    top: 0;
    left: 0;
    padding-top: 60px;
  }

  .main {
    margin-top: 20px;
    width: 100%;
  }
  .el-scrollbar__wrap {
    overflow-x: hidden;
  }
  .el-main {
    width: 100%;
  }
</style>
