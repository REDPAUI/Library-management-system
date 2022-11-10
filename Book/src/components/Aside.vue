<template>
  <!--        菜单页-->
  <el-menu :default-openeds="['1', '3']" style="min-height:100%;overflow-x:hidden" text-color="#fff"  :collapse-transition="false" :collapse="isCollapse" router  >
    <div style="height: 60px;line-height: 60px;text-align: center">
      <img src="../assets/book-open .png" style="width: 30px;position: relative;top:6px;margin-left: 5px">
      <b style="color: #fff" v-show="logoTextShow">图书管后台管理系统</b>
    </div>
    <el-menu-item index="/home" > <i class="el-icon-house"></i><span>主页</span></el-menu-item>
    <el-submenu index="">
      <template slot="title"><i class="el-icon-menu"></i><span>系统管理</span></template>
      <el-menu-item index="/user"><i class="el-icon-user"></i>用户信息管理</el-menu-item>
      <el-menu-item index="/BooksType"><i class="el-icon-reading"></i>书籍类型管理</el-menu-item>
      <el-menu-item index="/BOOK"><i class="el-icon-notebook-1"></i>书籍管理</el-menu-item>
      <el-menu-item index="/UserTime"><i class="el-icon-time"></i>借阅管理</el-menu-item>
    </el-submenu>
  </el-menu>
</template>

<script>
export default {
  name: "Aside",
  props: {
    isCollapse : Boolean,
    logoTextShow:Boolean,
  },

}
</script>

<style scoped>

</style>