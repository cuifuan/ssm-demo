<template>
  <el-menu
    :default-active="activeIndex2"
    class="el-menu-demo"
    mode="horizontal"
    @select="handleSelect"
    background-color="#2c3e50"
    text-color="#fff"
    active-text-color="#ffd04b">
    <el-menu-item index="1">处理中心</el-menu-item>
    <el-submenu index="2">
      <template slot="title">我的工作台</template>
      <el-menu-item index="2-1">选项1</el-menu-item>
      <el-menu-item index="2-2">选项2</el-menu-item>
      <el-menu-item index="2-3">选项3</el-menu-item>
      <el-submenu index="2-4">
        <template slot="title">选项4</template>
        <el-menu-item index="2-4-1">选项1</el-menu-item>
        <el-menu-item index="2-4-2">选项2</el-menu-item>
        <el-menu-item index="2-4-3">选项3</el-menu-item>
      </el-submenu>
    </el-submenu>
    <el-menu-item index="3" disabled>消息中心</el-menu-item>
    <el-menu-item index="4"><a href="https://www.ele.me" target="_blank">订单管理</a></el-menu-item>
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

  export default {
      name: "Header",
      data() {
        return {
          activeIndex: '1',
          activeIndex2: '1',
          currentUserName: ''
        };
      },
      created() {
       this.currentUserName=localStorage.getItem('username')
      },
      methods: {
        handleSelect(key, keyPath) {
          console.log(key, keyPath);
        },
        handleCommand(command){
          var _this = this;
          if (command === 'logout') {
            this.$confirm('注销登录吗?', '提示', {
              confirmButtonText: '确定',
              cancelButtonText: '取消',
              type: 'warning'
            }).then(function () {
              getRequest("/logout")
              _this.currentUserName = '游客';
              localStorage.clear();
              _this.$router.replace({path: '/'});
            }, function () {
              //取消
            })
          }
        }
      }
    }
</script>

<style scoped>
 .el-menu-demo{
   width: 100%;
   height: 60px;
 }
 .home_userinfo {
   /*position: absolute;*/
   float: right;
   /*display: inline;*/
   margin-right:20px;
   font-size: 15px;
   margin-top: 20px;
 }
  .el-dropdown-link{
    color: aliceblue;
    font-size: 18px;
  }
</style>
