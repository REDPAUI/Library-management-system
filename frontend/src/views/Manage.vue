<template>
    <el-container style="min-height:100vh;">
<!--      菜单栏-->
      <el-aside :width="asidewith+'px'" style="background-color: rgb(238, 241, 246);">
          <Aside :is-collapse="isCollapse" :logoTextShow="logoTextShow"/>
      </el-aside>
      <el-container>
<!--        头部-->
        <el-header style=" border-bottom: 1px solid #ccc;">
          <Header :collapseBtnClass="collapseBtnClass" :collapse="collapse" />
        </el-header>
<!--  表单-->
        <el-main>
<!--          表示当前页面的子路由会在  <router-view/>中展示-->
          <router-view />
        </el-main>
      </el-container>
    </el-container>
</template>
<style>

</style>
<script>

import request from "@/utils/request";
import Aside from "@/components/Aside";
import Header from "@/components/Header";

export default {
  data() {
    return {
      collapseBtnClass: 'el-icon-s-fold',
      isCollapse: false,
      asidewith:200,
      logoTextShow:true,

    }
  },
  created() {

  },
components: {
  Aside,
  Header,
},
  methods: {
    collapse(){//收缩与展开
      this.isCollapse = !this.isCollapse;
      if(this.isCollapse) {
        this.asidewith=64
        this.collapseBtnClass = 'el-icon-s-unfold'
        this.logoTextShow=!this.logoTextShow;
      }else {
        this.asidewith=200
        this.collapseBtnClass = 'el-icon-s-fold'
        this.logoTextShow=!this.logoTextShow;
      }
    },
    },

};
</script>

