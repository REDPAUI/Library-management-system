<template>
<div>
  <el-col :span="10">
    <el-card shadow="never">
      <h3 style="text-align: center;color: #606266">借阅数据</h3>
      <template>
        <el-table :data="tableData" width="700px">
          <el-table-column prop="bookname" label="书名" width="150px" >
<!--            <template slot-scope="scope">-->
<!--              {{bookName1(scope.row.bookid)}}-->
<!--            </template>-->
          </el-table-column>
<!--          <el-table-column prop="address" label="类型" width="70px"></el-table-column>-->
          <el-table-column  label="借阅时间" width="120x">
            <template slot-scope="scope">
              {{timeTranslate(scope.row.begintime)}}
            </template>
          </el-table-column>
          <el-table-column  label="归还时间" width="120px">
            <template slot-scope="scope">
              {{timeTranslate(scope.row.endtime)}}
            </template>
          </el-table-column>
          <el-table-column prop="address" label="状态" width="80px">
            <template slot-scope="scope">
              <el-switch v-model="scope.row.stat"  active-color="#13ce66" inactive-color="#ff4949" disabled></el-switch>
            </template>
          </el-table-column>
        </el-table>
      </template>
      <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="pageNum"
          :page-sizes="[5, 10, 15, 20]"
          :page-size="pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total" >
      </el-pagination>
      <!--  </span>-->
    </el-card>
  </el-col>
</div>
</template>

<script>
import request from "@/utils/request";
import dayjs from "dayjs"
export default {
  name: "clientBorrowingData",
  data() {
    return {
      tableData: [],
      total: 0,
      pageNum: 1,
      pageSize: 10,
      user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {},
      bookname:'test',
    }
  },
  created() {
    this.load();
  },
  methods: {
    load(){
      request.get("http://localhost:9090/ubookov/pageOne",{
        params: {
          id: this.user.id,
          pageNum: this.pageNum,
          pageSize: this.pageSize
        }
      }).then(res =>{
        this.tableData=res.data
        this.total=res.total
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
    timeTranslate (val){
      return dayjs(val).format('YYYY年MM月DD日')
    },
    bookName1(val){
      if (val===1001){
        this.bookname='《如何阅读一本好书》'
        return this.bookname
      }
      if (val===1002){
        this.bookname='《设计模式之禅》'
        return this.bookname
      }
      if (val===1003){
        this.bookname='《代码整洁之道》'
        return this.bookname
      }
      if (val===1004){
        this.bookname='《金融学》'
        return this.bookname
      }
      if (val===1005){
        this.bookname='《围城》'
        return this.bookname
      }
      if (val===1006){
        this.bookname='《C语言程序设计》'
        return this.bookname
      }
      if (val===1007){
        this.bookname='《网络安全技术》'
        return this.bookname
      }
      if (val===1008){
        this.bookname='《傲慢与偏见》'
        return this.bookname
      }
      if (val===1009){
        this.bookname='《悲惨世界》'
        return this.bookname
      }
      if (val===1010){
        this.bookname='《纳兰容若词传》'
        return this.bookname
      }
      if (val===1011){
        this.bookname='《瓦尔登湖 : 梭罗散文选》'
        return this.bookname
      }
      if (val===1013){
        this.bookname='《Java程序设计实践教程》'
        return this.bookname
      }
      if (val===1014){
        this.bookname='《飞鸟集:中英对照版》'
        return this.bookname
      }
    }
  }
}
</script>

<style scoped>

</style>