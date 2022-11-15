<template>
<div>
  <!--          增删改查-->
  <div style="padding: 4px 0">
    <el-button @click="Add" icon="el-icon-plus" type="primary" >添加</el-button>
    <el-popconfirm
        style="margin-left: 4px"
        confirm-button-text='确定'
        cancel-button-text='取消'
        icon="el-icon-info"
        icon-color="red"
        title="确定删除吗？"
        @confirm="delbatch">
      <el-button slot="reference" icon="el-icon-minus" type="danger">批量删除</el-button>
    </el-popconfirm>
<!--    搜索-->
    <span style="float: right">
            <el-input style="width: 200px;"placeholder="请输入用户名" v-model="username" ></el-input> <el-button style="margin-left: 5px" type="primary" icon="el-icon-search"  @click="load" >搜索</el-button>
            </span>
  </div>
  <!--          表单-->
  <el-table :data="tableData" header-cell-class-name="headerBg" @selection-change="handleSelectionChange" >
    <el-table-column type="selection" width="55"></el-table-column>
    <el-table-column prop="id" label="ID" width="80"></el-table-column>
    <el-table-column prop="user" label="用户名"></el-table-column>
    <el-table-column prop="passwd" label="密码"></el-table-column>
    <el-table-column  label="操作" width="300" align="center">
      <template slot-scope="scope">
        <el-button @click="handleEdit(scope.row)" icon="el-icon-edit" type="warning" >修改</el-button>
        <el-popconfirm
            style="margin-left: 4px"
            confirm-button-text='确定'
            cancel-button-text='取消'
            icon="el-icon-info"
            icon-color="red"
            title="确定删除吗？"
            @confirm="handleDelet(scope.row.id)"
        >
          <el-button slot="reference" icon="el-icon-delete" type="danger">删除</el-button>
        </el-popconfirm>
      </template>
    </el-table-column>
  </el-table>
  <!--          分页-->
  <div style="padding: 10px 0">
    <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="pageNum"
        :page-sizes="[5, 10, 15, 20]"
        :page-size="pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total">
    </el-pagination>
  </div>
  <!--          添加用户-->
  <el-dialog title="添加用户" :visible.sync="dialogFormVisible" width="30%">
    <el-form :model="form" label-width="78px">
      <el-form-item label="用户名" >
        <el-input v-model="form.user" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="密码" >
        <el-input v-model="form.passwd" autocomplete="off"></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="dialogFormVisible = false">取 消</el-button>
      <el-button type="primary" @click="save">确 定</el-button>
    </div>
  </el-dialog>
</div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "User",
  data() {
    return {
      tableData:[],
      total: 0,
      pageNum:1,
      pageSize:10,
      //  修改表的数据
      dialogFormVisible:false,
      form:{},
      multipleSelection: [],
      headerBg:'headerBg',
      username: '',
       // input1:[],
    }
  },
  created() {
    this.load();
},
  methods: {
    load(){
      request.get("http://localhost:9090/user/page",{
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
          user: this.username,
        }
      }).then(res =>{
        // console.log(res)
        this.tableData=res.records
        this.total=res.total
      })
    },
    save(){
      request.post("http://localhost:9090/user",this.form).then(res=>{
        if(res){this.$message.success("添加成功")
          this.dialogFormVisible = false
          this.load();
        }else{this.$message.error("添加失败")}
      })

    },
    handleSizeChange(pageSize){
      // console.log(`每页 ${pageSize} 条`);
      this.pageSize=pageSize;
      this.load();
    },
    handleCurrentChange(pageNum){
      // console.log(`当前页: ${pageNum}`);
      this.pageNum=pageNum;
      this.load();
    },
    Add(){
      this.dialogFormVisible=true
      this.form={}
    },
    handleEdit(row){
      this.form={};
      this.form=row;
      this.dialogFormVisible=true
    },
    handleDelet(id){
      request.delete("http://localhost:9090/user/"+id).then(res=>{
        if(res){this.$message.success("删除成功")
          this.load();
        }else{this.$message.error("删除失败")}
      })
    },
    handleSelectionChange(val){
      // console.log(val)
      this.multipleSelection=val
    },
    delbatch(){
      let ids=this.multipleSelection.map(v => v.id)//[{},{}] => [id,id]
      console.log(ids)
      request.post("http://localhost:9090/user/del/batch",ids).then(res =>{
        if(res){this.$message.success("删除成功")
          this.load();
        }else{this.$message.error("删除失败")}
      })
    },

  },
}


</script>

<style >
.headerBg{
  background-color: #fcfcfc !important;

}
</style>