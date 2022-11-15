<template>
<div style="width: 500px;padding: 20px;">
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
</template>

<script>
import request from "@/utils/request";

export default {
  name: "Personal",
  data() {
    return {
      user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {}
    }
  },
  created() {
    this.loadTest() ;
  },
  methods: {
    save(){
      request.post("http://localhost:9090/user",this.user).then(res=>{
        if(res){this.$message.success("修改成功")
          this.$router.push("/login")
          localStorage.removeItem("user")//清楚数据
        }else{this.$message.error("修改失败")}
      })
    },
    loadTest(){
      request.post("http://localhost:9090/user/search", this.user).then(res => {
        this.form = res.data;
        // localStorage.setItem("user", JSON.stringify(res.data))//存储用户信息到浏览器
      })
    }
  }
}
</script>

<style >
.avatar-uploader .el-upload {
  border: 1px solid #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
.avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 128px;
  height: 128px;
  line-height: 128px;
  text-align: center;
}
.avatar {
  width: 128px;
  height: 128px;
  display: block;
}

</style>