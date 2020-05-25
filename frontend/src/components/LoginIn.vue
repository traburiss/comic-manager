<template>
  <el-container class="container">
    <el-main class="main">
      <el-row class="main-row">
        <h1>{{ msg }}</h1>
      </el-row>
    </el-main>
    <el-aside class="login-side">
      <el-form ref="from" :model="login" class="login-from" label-width="50px">
        <el-form-item label="用户" class="from-label">
          <el-input placeholder="请输入用户名" v-model="login.userName"></el-input>
        </el-form-item>
        <el-form-item label="密码" class="from-label">
          <el-input placeholder="请输入密码" v-model="login.passWord" show-password></el-input>
        </el-form-item>
        <el-form-item class="from-label">
          <el-button type="primary" @click="onSubmit" class="login-button">登陆</el-button>
        </el-form-item>
      </el-form>
    </el-aside>
  </el-container>
</template>

<script>
  export default {
    name: "LoginIn",
    props: {
      msg: String
    },
    data(){
      return{
        login:{
          userName:'',
          passWord:''
        }
      }
    },
    methods:{
      onSubmit(){
        console.info(this.login)
      }
    }
  }
</script>

<style scoped>
  h1 {
    text-align: center;
  }
  .container{
    width: 100%;
    height: 100%;
  }
  .main{
    width: 100%;
    height: 100%;
  }
  .main-row{
    height: 100%;
  }
  .main-row>h1{
    margin-top: 20%;
  }
  .login-side{
    width: 400px !important;
    margin: 50px;
  }
  .login-from{
    margin-top: 50%;
  }
  .login-button{
    width: 100%;
  }
</style>
