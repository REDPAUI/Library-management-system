<template>
<div>
  <el-col :span="8" style="margin-left: 450px">
    <el-card shadow="never">
      <h3 style="text-align: center;color: #606266">借阅中心</h3>
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="用户名">
          <el-input v-model="user.id" placeholder="请输入用户id" disabled></el-input>
        </el-form-item>
        <el-form-item label="书籍名称">
          <el-input v-model="form.bookid" placeholder="请输入书本id"></el-input>
        </el-form-item>
        <el-form-item label="状态">
          <el-select v-model="form.stat" placeholder="请选择归还状态">
            <el-option label="未归还" value="false"></el-option>
            <el-option label="已归还" value="true"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="归还时间">
          <el-date-picker
              v-model="form.endtime"
              type="datetime"
              placeholder="选择日期时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">确 定</el-button>
          <el-button @click="test">取 消</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </el-col>
</div>
</template>

<script>

import request from "@/utils/request";

export default {
  name: "clientBorrowing",
  data() {
    return {
      user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {},
      form:{},
      time:'',
    };
  },
  methods: {
test(){
  this.form={}
},
    onSubmit(){
  this.form.userid=this.user.id
      request.post("http://localhost:9090/ubook",this.form).then(res=>{
        if(res){this.$message.success("借阅成功")
          this.form={}
          // this.$router.push("clientType")
        }else{this.$message.error("借阅失败")}
      })

    },
  },

  components:{
  }
}
</script>

<style scoped>

</style>