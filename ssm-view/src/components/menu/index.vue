<template>
  <div class="">
    <h1>一级菜单管理</h1>
    <el-table
      :data="tableData"
      style="width: 100%">
      <el-table-column
        prop="path"
        label="地址"
        width="180">
      </el-table-column>
      <el-table-column
        prop="name"
        label="名称"
        width="180">
      </el-table-column>
      <el-table-column fixed="right" label="菜单级别">
        <template slot-scope="scope">
          是
        </template>
      </el-table-column>
      <el-table-column
        fixed="right"
        label="操作">
        <template slot-scope="scope">
          <el-button @click="handleClick(scope.row)" type="primary" size="small"><i class="el-icon-edit el-icon--left"></i>编辑</el-button>
          <el-button type="danger" size="small"><i class="el-icon-delete el-icon--left"></i>删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
  export default {
    name: "index",
    data() {
      return {
        tableData: [],
        params:{
          id:-1
        },
        RequestURL:'/menu'
      }
    },
    created(){
      this.getMenu()
    },
    methods: {
      getMenu() {
        this.getRequest(this.RequestURL,this.params).then(res=>{
          this.tableData=res.data.data
        }).catch(error=> {
          console.log(error)
        })
      }
    }
  }
</script>

<style scoped>

</style>
