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
            <el-input style="width: 200px;"placeholder="请输入书籍名称" v-model="book" ></el-input> <el-button style="margin-left: 5px" type="primary" icon="el-icon-search" @click="load">搜索</el-button>
            </span>
    </div>
    <!--          表单-->
    <el-table :data="tableData" header-cell-class-name="headerBg" @selection-change="handleSelectionChange" >
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column prop="id" label="ID" width="80"></el-table-column>
      <el-table-column prop="isbn" label="ISBN"></el-table-column>
      <el-table-column prop="bookname" label="书籍名称"></el-table-column>
      <el-table-column prop="bookprice" label="书籍价格"></el-table-column>
      <el-table-column prop="bookauthor" label="作者"></el-table-column>
      <el-table-column prop="publishedhouse" label="出版社"></el-table-column>
      <el-table-column prop="bookcategory" label="类型">
        <template slot-scope="scope">
          {{typebook(scope.row.bookcategory)}}
        </template>
      </el-table-column>
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
    <el-dialog title="添加书籍信息" :visible.sync="dialogFormVisible" width="30%">
      <el-form :model="form" label-width="78px">
        <el-form-item label="ISBN" >
          <el-input v-model="form.isbn" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="书籍名称" >
          <el-input v-model="form.bookname" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="书籍价格" >
          <el-input v-model="form.bookprice" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="作者" >
          <el-input v-model="form.bookauthor" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="出版社" >
          <el-input v-model="form.publishedhouse" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="类型" >
          <el-input v-model="form.bookcategory" autocomplete="off"></el-input>
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
      // typename:"",
      book:'',
    }
  },
  created() {
    this.load();
  },
  methods: {
    load(){
      request.get("http://localhost:9090/book/page",{
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
          bookname: this.book
        }
      }).then(res =>{
        this.tableData=res.records
        this.total=res.total
      })
    },
    save(){
      request.post("http://localhost:9090/book",this.form).then(res=>{
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
      request.delete("http://localhost:9090/book/"+id).then(res=>{
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
      request.post("http://localhost:9090/book/del/batch",ids).then(res =>{
        if(res){this.$message.success("删除成功")
          this.load();
        }else{this.$message.error("删除失败")}
      })
    },
    typebook(val){
      if(val==111){this.typename='哲学'; return this. typename}
      if(val==112){this.typename='散文'; return this. typename}
      if(val==113){this.typename='计算机'; return this. typename}
      if(val==114){this.typename='社会'; return this. typename}
      if(val==115){this.typename='诗词'; return this. typename}
      if(val==116){this.typename='漫画'; return this. typename}
    }
  },
}


</script>

<style >
.headerBg{
  background-color: #fcfcfc !important;

}
</style>