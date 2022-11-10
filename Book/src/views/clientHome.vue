<template>
<div>
  <!--  轮播图-->
  <el-carousel :interval="4000" type="card" height="280px" style="width: 800px;margin: 0 auto" >
    <el-carousel-item v-for="item in homeName" >
      <img :src="item.url" alt="无图片" width="48%"/>
      <div style="position: relative;margin-left: 200px;margin-top: -260px"><span>书名:</span>&nbsp;&nbsp;&nbsp;&nbsp;{{item.title}}<br>
        <span>作者:</span>&nbsp;&nbsp;&nbsp;&nbsp;{{item.author}}<br>
        <span>出版社:</span>&nbsp;&nbsp;{{item.press}}<br>
        <span>ISBN:</span>&nbsp;&nbsp;&nbsp;{{item.ISBN}}<br>
        <span>简介:</span><br>&nbsp;&nbsp;&nbsp;&nbsp;{{item.synopsis}}<br>
      </div>
    </el-carousel-item>
  </el-carousel>
<!--用户信息卡片-->
  <el-col :span="4">
    <el-card shadow="hover">
      <p> <span class="el-icon-user">{{user.user}}</span>,欢迎登录XXX图书馆</p>
      <div> </div>
    </el-card>
  </el-col>
</div>
</template>

<script>
import request from "@/utils/request";
import dayjs from "dayjs"

export default {
  name: "clientHome",
  data(){
    return{
      index: null,
      homeName:[
        {url:require("../assets/cover/手书.jpg"),title:"手书",author:"[加] 迈克尔·翁达杰",press:"人民文学出版社",ISBN:'9787020174232',synopsis:'《手书》出版于1998年，诗集分为三部分，包括十八首诗和一首长诗。这些关于爱情、风景、风俗和历史的诗歌，写作于19......'},
        {url:require("../assets/cover/寻觅意义.jpg"),title:"寻觅意义",author:"王德峰",press:"山东文艺出版社",ISBN:'9787532967254',synopsis:'我要用一种形象化的语言说：“背上一个小小的行囊，去做一些并不起眼的小事情。”'},
        {url:require("../assets/cover/解放.jpg"),title:"解放",author:"[英]欧内斯托·拉克劳",press:"南京大学出版社",ISBN:'9787305250774',synopsis:'20世纪末，世界格局发生了巨大变化，各种各样的特殊主义抗争——种族的、民族的、性取向的——风起云涌，反抗着先前统治了......'},
        {url:require("../assets/cover/笔墨游戏.jpg"),title:"笔墨游戏",author:"周游",press:"中华书局",ISBN:'9787101158137',synopsis:'本书分为12个章节，分别从出场、视角、错位、人物、道具、性别、层次、变奏、本性、传承、说教、死亡这12个角度来论述......'},
        {url:require("../assets/cover/白鸟坠入密林.jpg"),title:"白鸟坠入密林",author:"贝客邦",press:"南海出版公司",ISBN:'9787544298476',synopsis:'一桩全员0恶人的少女失踪案，戳痛你的软肋！就算我已失去前路，也想为你照亮迷途。在没有恶人的世界里，悲剧照常发生。'},
        {url:require("../assets/cover/美好的七年.jpg"),title:"美好的七年",author:"[以] 埃特加·凯雷特",press:"人民文学出版社",ISBN:'9787020127153',synopsis:'本书为以色列作家埃特加·凯雷特的随笔集，讲述了七年中发生在他身边的事：儿子列夫出生在恐怖袭击的中心特拉维夫......'},
      ],//首页轮播图
      user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {},
      weather:[],//天气
    }
  },
  created() {

  },
  methods: {
    timeTranslate (val){
      return dayjs(val).format('YYYY年MM月DD日-HH:mm:ss')
    },

  }
}
</script>

<style >
.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}

</style>