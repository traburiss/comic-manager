<template>
  <div class="el-submenu" v-if='menu.hasOwnProperty("children")'>
    <el-submenu :index='menu["menuCode"]' :show-timeout='100' :hide-timeout='100'>
      <template slot='title'>{{menu["menuName"]}}</template>
      <unlimited-menu v-for="subMenu in menu['children']" :key="subMenu.id" :menu='subMenu'/>
    </el-submenu>
  </div>
  <el-menu-item v-else :index='menu["menuCode"]'>{{menu["menuName"]}}</el-menu-item>
</template>

<script>
  export default {
    name: "UnlimitedMenu",
    props: {
      menu: {}
    },
  }
</script>

<style scoped>

</style>
