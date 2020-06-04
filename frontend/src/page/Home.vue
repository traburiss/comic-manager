<template>
  <el-container class="container">
    <el-header class="header" height="30px">
      <el-menu :default-active="activeIndex" mode="horizontal" :router="true">
        <el-submenu index="myself" :show-timeout="100" :hide-timeout="100">
          <template slot="title">我</template>
          <el-menu-item index="me">我</el-menu-item>
          <el-menu-item class="logout" @click="logout">登出</el-menu-item>
        </el-submenu>
        <el-submenu index="manager" :show-timeout="100" :hide-timeout="100">
          <template slot="title">管理</template>
          <el-menu-item index="user">用户</el-menu-item>
          <el-menu-item index="role">角色</el-menu-item>
          <el-menu-item index="config">配置</el-menu-item>
        </el-submenu>
        <el-menu-item index="interest">兴趣</el-menu-item>
        <el-menu-item index="series">系列</el-menu-item>
        <el-menu-item index="comic">漫画</el-menu-item>
        <el-menu-item index="search">搜索</el-menu-item>
      </el-menu>
    </el-header>
    <el-main class="main">
      <router-view></router-view>
    </el-main>
  </el-container>
</template>

<script>
  export default {
    name: "Home",
    data() {
      return {
        activeIndex: 'search'
      }
    },
    methods: {
      logout() {
        this.$confirm('请再考虑一下下', '登出', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
          showClose: false,
          confirmButtonClass: 'el-button--danger'
        }).then(() => {
          this.$message({
            type: 'success',
            message: '开始登出!'
          });
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消'
          });
        });
      }
    },
    mounted() {
      console.info(this.$route.path)
      this.activeIndex = this.$route.path.replace("/home/", "")
    }
  }
</script>

<style>
  .container {
    width: 100%;
    height: 100%;
    background: #D9ECFF;
  }

  .container > .header {
    width: 100%;
    padding: 0;
    background: #65686a;
    text-align: end;
  }

  .container > .main {
    width: 100%;
    background: #42b983;
    overflow: auto;
  }

  .logout {
    font-weight: bold;
    color: #F56C6C !important;
  }

  .logout:focus,
  .logout:hover {
    color: #f78989 !important;
  }

  .logout:active {
    color: #dd6161 !important;
  }

  .el-menu--horizontal > .el-menu-item {
    float: right;
    height: 30px;
    line-height: 30px;
  }

  .el-menu--horizontal > .el-submenu {
    float: right;
  }

  .el-menu--horizontal > .el-submenu .el-submenu__title {
    height: 30px;
    line-height: 30px;
  }
</style>
