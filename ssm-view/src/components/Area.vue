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
  import {getRequest} from '../utils/api'

  export default {
    name: "area",
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
        console.log(111)
        getRequest('getArea').then(res => {
          console.log(res.data)
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
