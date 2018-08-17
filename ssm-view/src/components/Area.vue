<template>
  <el-table
    :data="tableData"
    border
    style="width: 100%">
    <el-table-column
      prop="id"
      label="ID"
      width="180">
    </el-table-column>
    <el-table-column
      prop="postalcode"
      label="邮编"
      width="180">
    </el-table-column>
    <el-table-column
      prop="address"
      label="地址">
    </el-table-column>
    <el-table-column
      prop="type"
      label="级别">
    </el-table-column>
  </el-table>
</template>

<script>
  import {postRequest} from '../utils/api'

  export default {
    data() {
      return {
        tableData: []
      }
    },
    created() {
      this.getTable()
    },
    methods: {
      getTable() {
        postRequest('getArea').then(res => {
          this.tableData=res.data
        }).catch(error => {
          console.log(error)
        })
      }
    }
  }
</script>

<style scoped>

</style>
