<template>
<div>
  <div style="width: 300px;margin: 0 auto;margin-top: 100px">
<!--    个人信息-->
  <el-form :model="user" label-width="78px">
    <el-form-item label="用户ID" >
      <el-input v-model="user.id" autocomplete="off" disabled></el-input>
    </el-form-item>
    <el-form-item label="用户名" >
      <el-input v-model="user.user" autocomplete="off" disabled></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click=" dialogVisible=true">修改密码</el-button>
    </el-form-item>
  </el-form>
<!--    弹窗-->
    <el-dialog title="密码修改"   :visible.sync="dialogVisible" width="30%">
      <el-form :model="Form" status-icon :rules="rules" ref="Form" style="width: 400px">
        <el-form-item label="旧密码" prop="oldPass">
          <el-input type="password" v-model="Form.oldPass" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="pass">
          <el-input type="password" v-model="Form.pass" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="确认密码" prop="checkPass">
          <el-input type="password" v-model="Form.checkPass" autocomplete="off"></el-input>
        </el-form-item>
        <br/>
<!--        按钮-->
        <el-form-item>
          <el-button type="primary" @click="save()">提交修改</el-button>
          <el-button @click="dialogVisible=false">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "clientPersonal",
  data() {
    //验证准则
    var validateOldPass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'));
      } else {
        if (this.Form.oldPass !==this.user.passwd) {
          callback(new Error('请输入正确密码'));
          this.$refs.ruleForm.validateField('checkPass');
        }
        callback();
      }
    };
    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'));
      } else {
        if (this.Form.checkPass !== '') {
          this.$refs.ruleForm.validateField('checkPass');
        }else if(value ===this.user.passwd){
          callback(new Error('请勿使用旧密码'));
        }
        callback();
      }
    };
    var validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'));
      } else if (value !== this.Form.pass) {
        callback(new Error('两次输入密码不一致!'));
      } else {
        callback();
      }
    }
    return {
      Form: {
        oldPass: '',
        pass: '',
        checkPass: '',
      },
      user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {},
      dialogVisible: false,
      //表达验证
      rules: {
        oldPass: [
          {validator: validateOldPass, trigger: 'blur' }
        ],
        pass: [
          { validator: validatePass, trigger: 'blur' }
        ],
        checkPass: [
          { validator: validatePass2, trigger: 'blur' }
        ]
      }
    }
  },
  methods:{
    submitForm() {

    },
    save(){
      this.form.id=this.user.id
      this.form.user=this.user.user
      this.form.passwd=this.checkPass
      request.post("http://localhost:9090/ubook",this.form).then(res=>{
        if(res){this.$message.success("密码修改成功")
        }else{this.$message.error("密码修改失败")}
      })
    },
  }
}
</script>

<style scoped>

</style>