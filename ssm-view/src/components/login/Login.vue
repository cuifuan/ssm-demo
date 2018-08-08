<template>
  <div id="login">
      <el-form :model="loginForm" :rules="rules" class="login-container" label-position="left" ref="loginForm"
               label-width="0px" v-loading="loading" v-show="isLogin" status-icon>
        <h3 class="login_title">{{title}}</h3>
        <el-form-item prop="username">
          <el-input type="text" v-model="loginForm.username" auto-complete="off" placeholder="账号"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input type="password" v-model="loginForm.password" auto-complete="off" placeholder="密码"></el-input>
        </el-form-item>
        <el-checkbox class="login_remember" v-model="checked" label-position="left">记住密码</el-checkbox>
        <el-form-item style="width: 100%">
          <el-button type="primary" @click="submitClick('loginForm')" style="width: 40%">登录</el-button>
          <el-button type="danger" @click="reg()" style="width: 40%">注册</el-button>
        </el-form-item>
      </el-form>
      <el-form :model="ruleForm2" :rules="rules2" class="login-container" label-position="left" ref="ruleForm2"
               label-width="0px" v-loading="loading" v-show="!isLogin" status-icon>
        <h3 class="login_title">{{title}}</h3>
        <el-form-item prop="name">
          <el-input v-model="ruleForm2.name" placeholder="请输入用户名"></el-input>
        </el-form-item>
        <el-form-item prop="pass">
          <el-input type="password" v-model="ruleForm2.pass" auto-complete="off" placeholder="请输入密码"></el-input>
        </el-form-item>
        <el-form-item prop="checkPass">
          <el-input type="password" v-model="ruleForm2.checkPass" auto-complete="off" placeholder="请确认密码"></el-input>
        </el-form-item>
        <el-form-item style="width: 100%">
          <el-button type="primary" @click="reguser('ruleForm2')" style="width: 40%">提交注册</el-button>
          <el-button type="danger" @click="goback()" style="width: 40%">去登陆</el-button>
        </el-form-item>
      </el-form>
  </div>
</template>

<script>
  import {postRequest} from '../../utils/api'

  export default {
    data() {
      var checkAge = (rule, value, callback) => {
        if (!value) {
          return callback(new Error('用户名不能为空'))
        }else {
          callback()
        }
        /*setTimeout(() => {
          if (!Number.isInteger(value)) {
            callback(new Error('请输入数字值'))
          } else {
            if (value < 18) {
              callback(new Error('必须年满18岁'))
            } else {
              callback()
            }
          }
        }, 1000)*/
      }
      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'))
        } else {
          if (this.ruleForm2.checkPass !== '') {
            this.$refs.ruleForm2.validateField('checkPass')
          }
          callback()
        }
      }
      var validatePass2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'))
        } else if (value !== this.ruleForm2.pass) {
          callback(new Error('两次输入密码不一致!'))
        } else {
          callback()
        }
      }
      return {
        loginForm: {
          username: '',
          password: ''
        },
        rules: {
          username: [{required: true, message: '请输入用户名', trigger: 'blur'}],
          password: [{required: true, message: '请输入密码', trigger: 'blur'}]
        },
        checked: true,
        loading: false,
        title: '系统登录',
        isLogin: true,
        ruleForm2: {
          pass: '',
          checkPass: '',
          name: ''
        },
        rules2: {
          pass: [
            {validator: validatePass, trigger: 'blur'}
          ],
          checkPass: [
            {validator: validatePass2, trigger: 'blur'}
          ],
          name: [
            {validator: checkAge, trigger: 'blur'}
          ]
        }
      }
    },
    methods: {
      submitClick(formName) {
          let _this = this
        this.$refs[formName].validate((valid) => {
          if (!valid) return
          this.loading = true
          postRequest('login', _this.loginForm).then(resp => {
              _this.loading = false
              if (resp.status === 200) {
                console.log(resp.data)
                //成功
                var json = resp.data
                if (json.responseCode === 'SUCCESS') {
                  localStorage.setItem('username', resp.data.user.username)
                  _this.$router.replace({path: '/area'})
                } else {
                  _this.$alert('登录失败!', '失败!')
                }
              }else if (resp.status === 401){
                _this.$message({message: '用户名密码出错！',type: 'warning'});
              }else {
                //失败
                _this.$alert('登录失败!', '失败!')
              }
            }).catch(error=>{
            console.log(error)
            _this.loading = false
            _this.$message({message: '服务器出错！',type: 'error'});
          })
        })
      },
      reg() {
        this.isLogin = false
        this.title = '注册'
      },
      goback() {
        this.isLogin = true
        this.title = '系统登陆'
      },
      reguser(formName) {
        let _this=this
        _this.$refs[formName].validate((valid) => {
          if (!valid) return
            postRequest('reguser', this.ruleForm2).then(resp => {
                if (resp.status === 200) {
                  let json = resp.data
                  console.log(json)
                  if (json.data === -909) {
                    _this.$message({message: '用户名已被注册！',type: 'warning'});
                  } else if(json.data >= 1) {
                    _this.loading = false
                    _this.$message({message: '注册成功,请登录...',type: 'success'});
                    _this.goback()
                  }else{
                    _this.loading = false
                    _this.$message({message: '注册失败',type: 'warning'});
                  }
                }else {
                  _this.loading = false
                  _this.$message({message: '注册失败',type: 'warning'});
                }
              },
              resp => {
                _this.loading = false
                _this.$message({message: '找不到服务器⊙﹏⊙∥!'+resp,type: 'error'});
              }
            ).catch(error => {
              console.log(error)
            })
          _this.loading = false
        })
      }
    }
  }
</script>
<style>
  #login {
    width: 100%;
    height: 100%;
    position: absolute;
    background: url("./bd.png") no-repeat;
    -webkit-background-size: cover;
    background-size: 100% 100%;
    text-align: center;
  }

  .login-container {
    border-radius: 15px;
    background-clip: padding-box;
    margin: 180px auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
    box-shadow: 0 0 25px #cac6c6;
    box-sizing: border-box;
  }

  .login_title {
    margin: 0px auto 40px auto;
    text-align: center;
    color: cornsilk;
  }

  .login_remember {
    margin: 0px 0px 35px 0px;
    text-align: left;
    color: cornsilk;
  }

  .el-form-item__label {
    color: cornsilk !important;
  }
</style>
