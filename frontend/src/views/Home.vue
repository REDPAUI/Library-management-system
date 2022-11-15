<template>

  <div>
<span class="title">欢迎来到XX图书馆后台管理系统</span>
    <br /><br /><br />
    <div style="margin-left: 230px">
      <b >数据看板：</b>
    <div style="">
    <el-col :span="4">
      <el-card shadow="hover">
        已注册用户：{{ people }}人
      </el-card>
    </el-col>
    </div>
    <div style="">
      <el-col :span="4">
        <el-card shadow="hover">
          图书类型：{{ type }}种
        </el-card>
      </el-col>
    </div>
    <div style="">
      <el-col :span="4">
        <el-card shadow="hover">
         已有图书：{{ quantity }}本
        </el-card>
      </el-col>
    </div>
    <div style="">
      <el-col :span="4">
        <el-card shadow="hover">
          以借阅：{{ borrowing }}次
        </el-card>
      </el-col>
    </div>
    </div>
  </div>
</template>

<script>
import * as echarts from 'echarts';
import request from "@/utils/request";

export default {
  name: "Home",
  data(){
    return {
      people:'',
      type:'',
      quantity:'',
      borrowing:'',
    }
  },
  created() {
    this.b();
  },
  methods: {
  b(){
    request.get("http://localhost:9090/user/nu").then(res=>{
      this.people=res
    });
    request.get("http://localhost:9090/bookstype/nu").then(res=>{
      this.type=res
    });
    request.get("http://localhost:9090/book/nu").then(res=>{
      this.quantity=res
    });
   request.get("http://localhost:9090/ubookov/nu").then(res=>{
    this.borrowing=res
   });
}

  },

}
</script>

<style scoped>
.title{
  margin-left: 480px;
  font-size:25px;
  font-weight: bold;
  color: #000000;

}
.box-card {
  width: 480px;
  height: 350px;
}
</style>