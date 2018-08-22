<template>
  <el-menu
    :default-active="activeIndex"
    class="el-menu-demo"
    mode="horizontal"
    @select="handleSelect"
    background-color="#2c3e50"
    text-color="#fff"
    active-text-color="#ffd04b">
    <template v-for="(item,index) in navData">
      <!--<router-link v-if="item.children.length===1 && !item.children[0].children && !item.alwaysShow" :to="item.path+'/'+item.children[0].path" :key="item.children[0].name">
        <el-menu-item :index="item.path+'/'+item.children[0].path" :class="{'submenu-title-noDropdown':!isNest}">
          <span v-if="item.children[0].meta&&item.children[0].meta.title">{{item.children[0].meta.title}}</span>
        </el-menu-item>
      </router-link>-->
      <el-menu-item :key="index" :index="item.path" v-if="item.children.length<=0">
        {{item.name}}
      </el-menu-item>
      <el-submenu v-else :index="index.toString()" :key="index">
        <template slot="title">{{item.name}}</template>
        <el-menu-item v-for="child in item.children" :key="child.name" :index="child.path">
          {{child.name}}
        </el-menu-item>
      </el-submenu>
    </template>
    <!--用户名下拉框-->
    <el-dropdown @command="handleCommand" class="home_userinfo">
      <span class="el-dropdown-link">
         {{currentUserName}}<i class="el-icon-arrow-down el-icon-right"></i>
      </span>
      <el-dropdown-menu slot="dropdown">
        <el-dropdown-item command="logout" divided>注销</el-dropdown-item>
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
        activeIndex: '1',
        currentUserName: '',
        navData: []
      }
    },
    created() {
      this.activeIndex = this.$router.history.current.path.replace("/", "")
      this.currentUserName = sessionStorage.getItem('username')
      this.navData = JSON.parse(sessionStorage.getItem('routes'))
      console.log(this.navData)
    },
    methods: {
      handleSelect(key, keyPath) {
        console.log(keyPath+"---"+key)
        this.$router.push(key)
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
      }
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
