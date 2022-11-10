<template>
<div>
  <div class="bg">欢迎访问XXX图书馆</div>
  <el-container>
<!--    导航栏-->
    <el-header style="height: 62px"><NavMenu style="margin: 0 auto"></NavMenu></el-header>
<!--    主路由-->
    <el-main>
      <router-view />
    </el-main>
<!--    <el-footer>Footer</el-footer>-->
  </el-container>
</div>
</template>

<script>
import NavMenu from "@/components/NavMenu";
export default {
  name: "homePage",
  data(){
    return{

    }
  },
  components: {
  NavMenu
  },
}
</script>

<style >
.bg{
  height: 45px;
  color: #FFFFFF;
  font-size: 28px;
  background: linear-gradient(to right, rgb(54, 209, 220), rgb(91, 134, 229));
}
</style>