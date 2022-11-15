<template>
<div>
  <div style="margin: 0 auto;width: 300px">
  <el-form :model="user" label-width="78px">
    <el-form-item label="ID" >
      <el-input v-model="user.id" autocomplete="off" disabled></el-input>
    </el-form-item>
    <el-form-item label="用户名" >
      <el-input v-model="user.user" autocomplete="off" disabled></el-input>
    </el-form-item>
    <el-form-item label="密码" >
      <el-input v-model="user.passwd" autocomplete="off"></el-input>
    </el-form-item>

    <el-form-item>
      <el-button type="primary" @click="save">确 定</el-button>
    </el-form-item>

  </el-form>
  </div>
</div>
</template>

<script>
import request from "@/utils/request";
import user from "@/views/User";

export default {
  name: "clientPersonal",
  data() {
    return {
      form:{},
      user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {},
    }
  },
  methods:{
    save(){
      request.post("http://localhost:9090/user",this.user).then(res=>{
        if(res){this.$message.success("修改成功")
          this.$router.push("/login")
          localStorage.removeItem("user")//清楚数据
          // this.$message.success("退出成功")
        }else{this.$message.error("修改失败")}
      })
    },
  }
}
</script>

<style scoped>

</style>