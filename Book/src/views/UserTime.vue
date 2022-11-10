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
            <el-input v-model="valueUser" style="width: 120px;margin-left: 5px"placeholder="请输入用户名"  ></el-input>

            <el-input  style="width: 150px;margin-left: 5px"placeholder="请输入书籍名" v-model="valueBook"></el-input>
            <el-select v-model="valueStat" style="width: 150px;margin-left: 5px" placeholder="请选择状态">
              <el-option label="已归还" value="true"></el-option>
              <el-option label="未归还" value="false"></el-option>
            </el-select>
            <el-date-picker v-model="valueTimeOne" style="width: 184px;margin-left: 5px"  type="date" placeholder="选择开始日期时间"></el-date-picker>
            <el-date-picker v-model="valueTimeTwo" style="width: 184px;margin-left: 5px"  type="date" placeholder="选择结束时间" ></el-date-picker>
        <el-button style="margin-left: 5px" type="primary" icon="el-icon-search" @click="search">搜索</el-button>
     </span>
    </div>
    <!--          表单-->

    <el-table :data="tableData" header-cell-class-name="headerBg" @selection-change="handleSelectionChange" >
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column prop="id" label="ID" width="80"></el-table-column>
      <el-table-column prop="bookname" label="书籍名称"></el-table-column>
      <el-table-column prop="user" label="用户"></el-table-column>
      <el-table-column prop="begintime"  label="开始时间">
        <template slot-scope="scope">
          {{timeTranslate(scope.row.begintime)}}
        </template>
      </el-table-column>
      <el-table-column prop="endtime" label="结束时间">
        <template slot-scope="scope">
          {{timeTranslate(scope.row.endtime)}}
        </template>
      </el-table-column>
      <el-table-column label="状态">
        <template slot-scope="scope">
          <el-switch v-model="scope.row.stat"  active-color="#13ce66" inactive-color="#ff4949" disabled></el-switch>
        </template>
      </el-table-column>
      <el-table-column label="超时" >
        <template slot-scope="scope" >
        {{tiemterm(scope.row.endtime,scope.row.stat)}}
          <el-link :underline="false" type="success" v-if="term">未超时</el-link>
          <el-link :underline="false" type="danger" v-else="term">已超时</el-link>
        </template>
      </el-table-column>

      <el-table-column prop="type" label="类型"></el-table-column>
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
    <el-dialog title="借阅中心" :visible.sync="dialogFormVisible" width="30%">
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="用户名">
          <el-input v-model="form.userid" placeholder="请输入用户id"></el-input>
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
          <el-button type="primary" @click="save">确 定</el-button>
          <el-button @click="dialogFormVisible = false">取 消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>

</template>

<script>
import request from "@/utils/request";
import dayjs from "dayjs"

export default {
  name: "User",
  data() {
    return {
      book:[],
      tableData:[],
      total: 0,
      pageNum:1,
      pageSize:10,
      //  修改表的数据
      dialogFormVisible:false,
      form:{},
      multipleSelection: [],
      headerBg:'headerBg',
      value:true,
      term:false,
      //搜索框
      valueUser:'',
      valueBook:'',
      valueStat:'',
      valueTimeOne:'',
      valueTimeTwo:'',
    }
  },
  created() {
    this.load();
  },
  methods: {
    load(){
      request.get("http://localhost:9090/ubookov/page",{
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
        }
      }).then(res =>{
        // console.log(res.data)
        this.tableData=res.data
        this.total=res.total
      })
    },
    save(){
      request.post("http://localhost:9090/ubook",this.form).then(res=>{
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
      request.delete("http://localhost:9090/ubook/"+id).then(res=>{
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
      request.post("http://localhost:9090/ubook/del/batch",ids).then(res =>{
        if(res){this.$message.success("删除成功")
          this.load();
        }else{this.$message.error("删除失败")}
      })
    },
    timeTranslate (val){
      return dayjs(val).format('YYYY年MM月DD日')
    },
    tiemterm(val,stat){
      if(stat===true){
        this.term=true
      }else if(stat===false){
        var end=Number(dayjs(val).format('YYYYMMDD'))
        var sta=Number(dayjs().format('YYYYMMDD'))
        var jg=sta-end
        if(jg<0){ this.term=true}else{ this.term=false}

      }
    },
    search(){

    }
  },
}


</script>

<style >
.headerBg{
  background-color: #fcfcfc !important;

}
</style>