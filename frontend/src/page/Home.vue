<template>
  <el-container class='container'>
    <el-header class='header' height='30px'>
      <el-menu :default-active='activeIndex' mode='horizontal' :router='true'>
        <el-submenu index='myself' :show-timeout='100' :hide-timeout='100'>
          <template slot='title'>我</template>
          <el-menu-item index='me'>{{userData.userName}}</el-menu-item>
          <el-menu-item @click="$refs.editUserName.open()">修改用户名</el-menu-item>
          <el-menu-item @click="$refs.editPassword.open()">修改密码</el-menu-item>
          <el-menu-item class='logout' @click='logout'>登出</el-menu-item>
        </el-submenu>
        <el-submenu v-if='menuList.includes("user")' index='manager' :show-timeout='100' :hide-timeout='100'>
          <template slot='title'>管理</template>
          <el-menu-item v-if='menuList.includes("user")' index='user'>用户</el-menu-item>
          <el-menu-item v-if='menuList.includes("user")' index='role'>角色</el-menu-item>
          <el-menu-item v-if='menuList.includes("user")' index='library'>书库</el-menu-item>
          <el-menu-item v-if='menuList.includes("user")' index='config'>配置</el-menu-item>
        </el-submenu>
        <el-menu-item v-if='menuList.includes("user")' index='series'>系列</el-menu-item>
        <el-menu-item v-if='menuList.includes("user")' index='comic'>漫画</el-menu-item>
        <el-menu-item v-if='menuList.includes("user")' index='search'>搜索</el-menu-item>
      </el-menu>
    </el-header>
    <el-main class='main'>
      <router-view></router-view>
    </el-main>
    <edit-user-name ref="editUserName"/>
    <edit-password ref="editPassword"/>
  </el-container>
</template>

<script>
  import api from '@/js/api/login'
  import loading from '@/js/common/loading';
  import cookie from '@/js/common/cookie';
  import {UPDATE_USER_DATA} from '@/store'
  import EditUserName from "@/page/me/EditUserName";
  import EditPassword from "@/page/me/EditPassword";
  
  export default {
    name: 'Home',
    components: {EditUserName, EditPassword},
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
          loading.start('正在登出')
          api.logoutService().then(() => {
            this.logoutFinish()
          }).catch(() => {
            loading.stop()
            this.$message({type: 'warn', message: '登出失败'})
          })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消'
          });
        });
      },
      logoutFinish() {
        loading.stop()
        this.$cookies.remove(cookie.token, '/')
        this.$router.push('/login')
        this.$message({message: '已登出!'});
      }
    },
    computed: {
      userData() {
        return this.$store.state.userData
      },
      menuList() {
        return this.$store.state.menuList
      }
    },
    mounted() {
      this.activeIndex = this.$route.path.replace('/home/', '')
      this.$store.commit(UPDATE_USER_DATA)
    }
  }
</script>

<style>
  .container {
    width: 100%;
    height: 100%;
  }

  .container > .header {
    width: 100%;
    padding: 0;
    background: #65686a;
    text-align: end;
  }

  .container > .main {
    width: 100%;
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
