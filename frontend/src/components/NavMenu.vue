<template>
  <el-menu
      mode="horizontal"
      background-color="#FFFFFF"
      text-color="#000000"
      active-text-color="#ffd04b"   router>
<!--    <el-menu-item index="clientHome"><i class="el-icon-s-home"></i>首页</el-menu-item>-->
    <el-menu-item index="clientType"><i class="el-icon-menu"></i>首页</el-menu-item>
    <el-submenu index="">
      <template slot="title"><i class="el-icon-s-order"></i>借阅中心</template>
      <el-menu-item index="clientBorrowingData"><i class="el-icon-s-data"></i>借阅数据</el-menu-item>
      <el-menu-item index="clientBorrowing"><i class="el-icon-s-management"></i>在线借阅</el-menu-item>
    </el-submenu>
    <el-dropdown style=";margin-left: 1000px">
      <span>{{user.user}} <i class="el-icon-arrow-down"></i></span>
      <el-dropdown-menu slot="dropdown">
        <el-dropdown-item  @click.native="personal">修改密码</el-dropdown-item>
        <el-dropdown-item @click.native="logout">退出</el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>
  </el-menu>

</template>

<script>
export default {
  name: "NavMenu",
  data() {
    return {
      user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {}
    };
  },
  methods: {
    personal(){
     this.$router.push("/clientPersonal")
    },
    logout() {
      this.$router.push("/login")
      localStorage.removeItem("user")//清楚数据
      this.$message.success("退出成功")
    },
  }

}
</script>

<style scoped>

</style>