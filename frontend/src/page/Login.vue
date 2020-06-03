<template>
  <el-container class="container">
    <el-main class="main">
      <el-row class="main-row">
        <el-col class="title-col" :xs="24" :sm="24" :md="16" :lg="16" :xl="16">
          {{ msg }}
        </el-col>
        <el-col class="from-col" :xs="24" :sm="24" :md="8" :lg="8" :xl="8">
          <el-form ref="from" :model="login" class="login-from">
            <el-form-item class="from-label">
              <el-input placeholder="请输入用户名" v-model="login.userName"></el-input>
            </el-form-item>
            <el-form-item class="from-label">
              <el-input placeholder="请输入密码" v-model="login.passWord" show-password></el-input>
            </el-form-item>
            <el-form-item class="from-label">
              <el-button type="primary" @click="onSubmit" class="login-button">登陆</el-button>
            </el-form-item>
          </el-form>
        </el-col>
        <el-col class="picture-col hidden-sm-and-down" h :md="24" :lg="24" :xl="24">
          
        </el-col>
      </el-row>
    </el-main>
  </el-container>
</template>

<script>
  import loginApi from '../js/api/login'
  import sha from 'js-sha256'
  
  export default {
    name: "Login",
    props: {
      msg: String
    },
    data() {
      return {
        login: {
          userName: '',
          passWord: ''
        }
      }
    },
    methods:{
      onSubmit() {
        this.$message.info("正在登陆")
        loginApi.login(this.login.userName, sha.sha256(this.login.passWord), () => {
          this.$message.success("登陆成功")
          this.$router.push('/home')
        })
      }
    }
  }
</script>

<style scoped>
  h1 {
    text-align: center;
  }
  .main{
    width: 100%;
    height: 100%;
    padding: 0;
  }
  .main-row{
    height: 100%;
  }
  .title-col{
    height: 50%;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 40px;
    font-weight: bold;
  }
  .from-col{
    height: 50%;
  }
  .login-from{
    width: 100%;
    height: 100%;
    padding-top: 20px;
  }
  .login-from>.from-label{
    margin-left: 10px;
    margin-right: 10px;
  }
  .login-button{
    width: 100%;
  }
  .picture-col{
    height: 50%;
    background: #b5cbcd;
  }
</style>
