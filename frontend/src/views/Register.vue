<template>
  <div class="wrapper">
    <div style="margin: 200px auto; background-color: #fff; width: 350px; height: 350px; padding: 20px; border-radius: 10px">
      <div style="margin: 20px 0; text-align: center; font-size: 24px"><b>注 册</b></div>
      <el-form :model="user" :rules="rules" ref="user">
        <el-form-item prop="username">
          <el-input placeholder="账号" size="medium" style="margin: 6px 0" prefix-icon="el-icon-user" v-model="user.user"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input placeholder="密码" size="medium" style="margin: 6px 0" prefix-icon="el-icon-lock" show-password v-model="user.passwd"></el-input>
        </el-form-item>
        <el-form-item prop="confirmPassword">
          <el-input placeholder="确认密码" size="medium" style="margin: 6px 0" prefix-icon="el-icon-lock" show-password v-model="user.confirmPassword"></el-input>
        </el-form-item>
        <el-form-item style="margin: 10px 0; text-align: right">
          <el-button type="primary" size="small"  autocomplete="off" @click="register">注册</el-button>
          <el-button type="warning" size="small"  autocomplete="off" @click="$router.push('/login')">返回登录</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request";
export default {
  name: "Login",
  data() {
    return {
      user: {},
      rules: {
        user: [
          { required: true, message: '请输入用户名', trigger: 'blur' },
          { min: 3, max: 10, message: '长度在 3 到 5 个字符', trigger: 'blur' }
        ],
        passwd: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          {pattern:/^[A-Za-z0-9]+$/,message: '请输入中文、英文、数字包括下划线', trigger: 'blur'},
          { min: 6, max: 12, message: '长度在 6 到 20 个字符', trigger: 'blur' },
        ],
        confirmPassword: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          {pattern:/^[A-Za-z0-9]+$/,message: '请输入中文、英文、数字包括下划线', trigger: 'blur'},
          { min: 6, max: 12, message: '长度在 6到 20 个字符', trigger: 'blur' }
        ],
      }
    }
  },
  methods: {
    register() {
      this.$refs['user'].validate((valid) => {
        if (valid) {  // 表单校验合法
          if(this.user.passwd!=this.user.confirmPassword){
            this.$message.error("密码不一致")
            return false;
          }
          request.post("http://localhost:9090/user/register", this.user).then(res => {
            if(res.code == 200) {
              localStorage.setItem("user", JSON.stringify(res.data))//存储用户信息到浏览器
              this.$message.success("注册成功")
              this.$router.push("/login")
            } else {
              this.$message.error(res.msg)
            }
          });
        }
      });
    },

  }
}
</script>

<style>
.wrapper {
  height: 100vh;
  background: linear-gradient(to right, rgb(127, 127, 213), rgb(134, 168, 231), rgb(145, 234, 228));
  overflow: hidden;
}
</style>

