<template>
<div style="font-size: 12px;line-height: 60px; display: flex">
  <div style="flex: 1;font-size: 18px">
    <span :class="collapseBtnClass" style="cursor: pointer" @click="collapse" ></span>
<!--          面包屑-->
    <el-breadcrumb separator="/" style="display: inline-block ;margin-left: 10px" >
      <el-breadcrumb-item :to="item.path" v-for="(item,index) in breadList" :key="index">{{ item.meta.title }}</el-breadcrumb-item>
    </el-breadcrumb>
  </div>
  <el-dropdown style="width: 120px;cursor: pointer ;" >
<!--    头像-->
    <div style="display: inline-block ;">
      <img :src="user.avatar" alt=""
           style="width: 30px; border-radius: 50%; position: relative; top: 10px; right: 5px">
      <span>{{ user.user }}</span><i class="el-icon-arrow-down" style="margin-left: 5px"></i>
    </div>
    <el-dropdown-menu slot="dropdown">
      <el-dropdown-item  @click.native="$router.push('/Personal')">个人信息</el-dropdown-item>
      <el-dropdown-item divided @click.native="logout">退出</el-dropdown-item>
    </el-dropdown-menu>
  </el-dropdown>
</div>
</template>

<script>
import router from "@/router";
import request from "@/utils/request";

import bus from '@/utils/EventBus'
import user from "@/views/User";

export default {
  name: "Header",
  props: {
    collapseBtnClass: String,
    collapse: Function,
    signOut:Function,
  },
data() {
    return {
      breadList: [] ,// 路由集合
     user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {}
    };
},
  watch: {
    $route() {
      this.getBreadcrumb();
    }
  },
  methods: {
    isHome(route) {
      return route.name === "home";
    },
    getBreadcrumb() {

      let matched = this.$route.matched;
      //如果不是首页
      // if (!this.isHome(matched[0])) {
      //   matched = [{path: "/home", meta: {title: "首页"}}].concat(matched);
      // }
      this.breadList = matched;
    },
    logout() {
      this.$router.push("/login")
      localStorage.removeItem("user")//清楚数据
      this.$message.success("退出成功")
    }
  },
  created() {
    this.getBreadcrumb();
    bus.$on('share', val => {
      // this.user=val
      localStorage.setItem("user", JSON.stringify(val))//存储用户信息到浏览器
      this.user=localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {}
    })


  },
}
</script>

<style scoped>

</style>