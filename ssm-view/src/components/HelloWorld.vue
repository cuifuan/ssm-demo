<template>
  <div>
  <!--  <iframe id="geoPage" width=100 height=100 frameborder=0
            src="https://apis.map.qq.com/tools/geolocation?key=3PQBZ-BOBKD-GDQ4U-PLGJH-RFQCS-HABRO&referer=http://map.qq.com/api/js?v=2.exp">
    </iframe>-->
    <h1>{{msg}}</h1>
  </div>
</template>
<script>
  import {postRequest} from '@/utils/api'
  import {getRequest} from '@/utils/api'

  export default {
    name: 'HelloWorld',
    data() {
      return {
        msg: 'Welcome to Your Vue.js App',
        loc: ''
      }
    },
    created() {
      // this.Tmap()

      // this.getAddress()
    },
    methods: {
      Tmap() {
        window.addEventListener('message', function (event) {
          if (event.data) {
            console.log(event.data)
            this.loc = event.data // 接收位置信息
            if (this.loc) {
              console.log(this.loc.lat)
              console.log(this.loc.lng)
            }
          }
        }, false)

        // 设置6s超时，防止定位组件长时间获取位置信息未响应
        setTimeout(function () {
          if (!this.loc) {
            console.log('定位超时')
          }
        }, 6000) // 6s为推荐值，业务调用方可根据自己的需求设置改时间，不建议太短
      },
      getAddress(){
        getRequest("/getLocation").then(res =>{
          console.log(res.data)
        }).catch(error =>{
          console.log(error)
          console.log('定位超时')
        })
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>

</style>
