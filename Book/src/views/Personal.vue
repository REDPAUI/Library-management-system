<template>
<div style="width: 500px;padding: 20px;">
  <el-form :model="form" label-width="78px">
    <el-upload
        style="text-align: center"
        class="avatar-uploader"
        action="http://localhost:9090/file/upload"
        :show-file-list="false"
        :on-success="handleAvatarSuccess">
      <img v-if="form.avatar" :src="form.avatar" class="avatar">
      <i v-else class="el-icon-plus avatar-uploader-icon"></i>
    </el-upload>
    <el-form-item label="用户名" >
      <el-input v-model="form.username" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="昵称" >
      <el-input v-model="form.nickname" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="邮箱" >
      <el-input v-model="form.email" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="电话号" >
      <el-input v-model="form.phone" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="地址" >
      <el-input v-model="form.address" autocomplete="off"></el-input>
    </el-form-item>

    <el-form-item>
      <el-button type="primary" @click="save">确 定</el-button>
    </el-form-item>

  </el-form>

</div>
</template>

<script>
import request from "@/utils/request";
import bus from '@/utils/EventBus'

export default {
  name: "Personal",
  data() {
    return {
      form: {},
      user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {}
    }
  },
  created() {
    this.loadTest() ;
  },
  methods: {
    save(){
      request.post("http://localhost:9090/user",this.form).then(res=>{
        if(res){this.$message.success("修改成功")
          // this.loadTest() ;
          bus.$emit('share', this.form)
        }else{this.$message.error("修改失败")}
      })
    },
    handleAvatarSuccess(res) {
      this.form.avatar = res;
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