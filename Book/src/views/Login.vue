<template>
  <div class="wrapper">
    <div style="margin: 200px auto; background-color: #fff; width: 350px; height: 300px; padding: 20px; border-radius: 10px">
      <div style="margin: 20px 0; text-align: center; font-size: 24px"><b>登 录</b></div>
      <el-form :model="user" :rules="rules" ref="userForm">
        <el-form-item prop="username">
          <el-input placeholder="账号" size="medium" style="margin: 6px 0" prefix-icon="el-icon-user" v-model="user.user"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input placeholder="密码" size="medium" style="margin: 6px 0" prefix-icon="el-icon-lock" show-password v-model="user.passwd"></el-input>
        </el-form-item>
        <el-form-item style="margin: 10px 0; text-align: right">
          <el-button type="primary" size="small"  autocomplete="off" @click="login">登录</el-button><br>
          <el-link @click="$router.push('/register')" target="_blank"  style="margin-right: 100px">没有注册点这里</el-link>
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
          { min: 1, max: 20, message: '长度在 1 到 20 个字符', trigger: 'blur' }
        ],
      }
    }
  },
  methods: {
    login() {
      this.$refs['userForm'].validate((valid) => {
        if (valid) {  // 表单校验合法
          console.log(this.user)
          request.post("http://localhost:9090/user/login", this.user).then(res => {
            if(res.code == 200) {
              localStorage.setItem("user", JSON.stringify(res.data))//存储用户信息到浏览器
              if(res.data.user==="root") {this.$router.push("/home")}
              else {this.$router.push("/homePage")}

              this.$message.success("登录成功")
            } else {
              this.$message.error(res.msg)
            }
          });
        }
      });
    },
  /*  register(){
      // this.$alert('注册功能不对外开放\n如需要登录请联系管理员', '警告', {confirmButtonText: '确定'});
      this.$router.push("/register")
    },*/
  }
}
</script>

<style>
.wrapper {
  height: 100vh;
  background-image: linear-gradient(to bottom right, #FC466B , #3F5EFB);
  overflow: hidden;
}
</style>

