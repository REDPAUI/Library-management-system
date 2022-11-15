<template>
<div>
<!--  轮播图-->
  <el-carousel :interval="4000" type="card" height="280px" style="width: 800px;margin: 0 auto" >
    <el-carousel-item v-for="item in typeName" >
      <img :src="item.url" alt="无图片" width="48%"/>
      <div style="position: relative;margin-left: 200px;margin-top: -260px"><span>书名:</span>&nbsp;&nbsp;&nbsp;&nbsp;{{item.title}}<br>
        <span>作者:</span>&nbsp;&nbsp;&nbsp;&nbsp;{{item.author}}<br>
        <span>出版社:</span>&nbsp;&nbsp;{{item.press}}<br>
        <span>ISBN:</span>&nbsp;&nbsp;&nbsp;{{item.ISBN}}<br>
        <span>简介:</span><br>&nbsp;&nbsp;&nbsp;&nbsp;{{item.synopsis}}<br>
      </div>
    </el-carousel-item>
  </el-carousel>
<!--  年度阅读榜单-->
  <el-col :span="4" style="position: relative;margin-left:  1200px;margin-top: -308px ;" >
    <el-card shadow="hover" style="background:#f0f0f4;color: #FFFFFF">
      <h3 style="position: relative;color: #F56C6C;margin-left: 55px">年度读书榜单</h3>
      <br>
      <div style="position: relative;margin-left: 55px">
        <el-link :underline="false"  href="https://book.douban.com/annual/2021?source=navigation" target="_blank" >2021年度读书榜单</el-link><br>
        <el-link :underline="false" href="https://book.douban.com/annual/2020?source=navigation" target="_blank">2020年度读书榜单</el-link><br>
        <el-link :underline="false" href="https://book.douban.com/annual/2019?source=navigation" target="_blank">2019年度读书榜单</el-link><br>
        <el-link :underline="false" href="https://book.douban.com/annual/2018?source=navigation" target="_blank">2018年度读书榜单</el-link><br>
        <el-link :underline="false" href="https://book.douban.com/annual/2017?source=navigation" target="_blank">2017年度读书榜单</el-link><br>
        <el-link :underline="false" href="https://book.douban.com/annual/2016?source=navigation" target="_blank">2016年度读书榜单</el-link><br>
        <el-link :underline="false" href="https://book.douban.com/annual/2015?source=navigation" target="_blank">2015年度读书榜单</el-link><br>
        <el-link :underline="false" href="https://book.douban.com/annual/2014?source=navigation" target="_blank">2014年度读书榜单</el-link><br>
        <el-link :underline="false" href="https://book.douban.com/annual/2013?source=navigation" target="_blank">2013年度读书榜单</el-link><br>
      </div>
      <i style="font-size: 2px;color: #F2F6FC;position: relative;margin-left: 40px">注:年度读书榜单来源豆瓣读书</i>
    </el-card>
  </el-col>
<!--栏目-->
  <h3>哲学</h3><hr>
  <div class="divOne" >
    <div style="height:12px" />
    <div class="divTwo"  v-for="(item,index) in philosophyName" :key="index" >
      <div class="divThree" ><img :src="item.url" alt="无图片" width="100%"/></div>
      <el-link type="primary" :underline="false" style="font-size: 4px;margin-top:14px">{{ item.title }}</el-link>
      <i>{{ item.ISBN }}</i><br>
      &nbsp;&nbsp;&nbsp;
      <el-button type="text" @click="getIndex(item,index)">详情</el-button>
      <el-button type="text" @click="Submit" >借阅</el-button>
    </div>
  </div>
  <h3>散文</h3><hr>
  <div class="divOne" >
    <div style="height:12px" />
    <div class="divTwo"  v-for="(item,index) in proseName" :key="index" >
      <div class="divThree" ><img :src="item.url" alt="无图片" width="100%"/></div>
      <!--      <i>{{ item.title }}</i><br>-->
      <el-link type="primary" :underline="false" style="font-size: 4px;margin-top:14px">{{ item.title }}</el-link>
      <i>{{ item.ISBN }}</i><br>
      &nbsp;&nbsp;&nbsp;
      <el-button type="text" @click="getIndex(item,index)">详情</el-button>
<!--      <el-button type="text" @click="test()">借阅</el-button>-->
    </div>
  </div>
  <h3>社会</h3><hr>
  <div class="divOne" >
    <div style="height:12px" />
    <div class="divTwo"  v-for="(item,index) in societyName" :key="index" >
      <div class="divThree" ><img :src="item.url" alt="无图片" width="100%"/></div>
      <!--      <i>{{ item.title }}</i><br>-->
      <el-link type="primary" :underline="false" style="font-size: 4px;margin-top:14px">{{ item.title }}</el-link>
      <i>{{ item.ISBN }}</i><br>
      &nbsp;&nbsp;&nbsp;
      <el-button type="text" @click="getIndex(item,index)">详情</el-button>
      <el-button type="text" @click="test" >借阅</el-button>
    </div>
  </div>
  <h3>计算机</h3><hr>
  <div class="divOne" >
    <div style="height:12px" />
    <div class="divTwo"  v-for="(item,index) in computerName" :key="index" >
      <div class="divThree" ><img :src="item.url" alt="无图片" width="100%"/></div>
      <!--      <i>{{ item.title }}</i><br>-->
      <el-link type="primary" :underline="false" style="font-size: 4px;margin-top:14px">{{ item.title }}</el-link>
      <i>{{ item.ISBN }}</i><br>
      &nbsp;&nbsp;&nbsp;
      <el-button type="text" @click="getIndex(item,index)">详情</el-button>
      <el-button type="text" >借阅</el-button>
    </div>
  </div>
  <h3>诗词</h3><hr>
  <div class="divOne" >
    <div style="height:12px" />
    <div class="divTwo"  v-for="(item,index) in poetryName" :key="index" >
      <div class="divThree" ><img :src="item.url" alt="无图片" width="100%"/></div>
      <!--      <i>{{ item.title }}</i><br>-->
      <el-link type="primary" :underline="false" style="font-size: 4px;margin-top:14px">{{ item.title }}</el-link>
      <i>{{ item.ISBN }}</i><br>
      &nbsp;&nbsp;&nbsp;
      <el-button type="text" @click="getIndex(item,index)">详情</el-button>
      <el-button type="text" >借阅</el-button>
    </div>
  </div>
  <h3>漫画</h3><hr>
  <div class="divOne" >
    <div style="height:12px" />
    <div class="divTwo"  v-for="(item,index) in cartoonName" :key="index" >
      <div class="divThree" ><img :src="item.url" alt="无图片" width="100%"/></div>
      <!--      <i>{{ item.title }}</i><br>-->
      <el-link type="primary" :underline="false" style="font-size: 4px;margin-top:14px">{{ item.title }}</el-link>
      <i>{{ item.ISBN }}</i><br>
      &nbsp;&nbsp;&nbsp;
      <el-button type="text" @click="getIndex(item,index)">详情</el-button>
      <el-button type="text" >借阅</el-button>
    </div>
  </div>
  <!--  详情-->
  <el-dialog title="介绍"  :visible.sync="dialogFormVisible" width="25%">
    <p class="details">书名:<span class="detailsSpan">{{ form.name }}</span></p>
    <p class="details">作者:<span class="detailsSpan">{{ form.author }}</span></p>
    <p class="details">出版社:<span class="detailsSpan">{{ form.publishing }}</span></p>
    <p class="details">页数：<span class="detailsSpan">{{ form.doubanScore }}页</span></p>
    <p class="details">ISBN:<span class="detailsSpan">{{ form.id }}</span></p>
    <p class="details">内容简介:<br>&nbsp;&nbsp;&nbsp;&nbsp;<span class="detailsSpan">{{ form.description }}</span></p>
    <div slot="footer" class="dialog-footer">
<!--      <el-button @click="dialogForm = true">借阅</el-button>-->
      <el-button @click="dialogFormVisible = false">确 定</el-button>
    </div>
  </el-dialog>
<!--  借阅-->
<!--  <el-dialog title="在线借阅" :visible.sync="dialogForm" width="30%">-->
<!--111-->
<!--  </el-dialog>-->
</div>
</template>

<script>
import request from "@/utils/request";



export default {
  name: "clientType",
  data(){
    return{
      typeName:[
        {url:require("../assets/cover/手书.jpg"),title:"手书",author:"[加] 迈克尔·翁达杰",press:"人民文学出版社",ISBN:'9787020174232',synopsis:'《手书》出版于1998年，诗集分为三部分，包括十八首诗和一首长诗。这些关于爱情、风景、风俗和历史的诗歌，写作于19......'},
        {url:require("../assets/cover/寻觅意义.jpg"),title:"寻觅意义",author:"王德峰",press:"山东文艺出版社",ISBN:'9787532967254',synopsis:'我要用一种形象化的语言说：“背上一个小小的行囊，去做一些并不起眼的小事情。”'},
        {url:require("../assets/cover/解放.jpg"),title:"解放",author:"[英]欧内斯托·拉克劳",press:"南京大学出版社",ISBN:'9787305250774',synopsis:'20世纪末，世界格局发生了巨大变化，各种各样的特殊主义抗争——种族的、民族的、性取向的——风起云涌，反抗着先前统治了......'},
        {url:require("../assets/cover/笔墨游戏.jpg"),title:"笔墨游戏",author:"周游",press:"中华书局",ISBN:'9787101158137',synopsis:'本书分为12个章节，分别从出场、视角、错位、人物、道具、性别、层次、变奏、本性、传承、说教、死亡这12个角度来论述......'},
        {url:require("../assets/cover/白鸟坠入密林.jpg"),title:"白鸟坠入密林",author:"贝客邦",press:"南海出版公司",ISBN:'9787544298476',synopsis:'一桩全员0恶人的少女失踪案，戳痛你的软肋！就算我已失去前路，也想为你照亮迷途。在没有恶人的世界里，悲剧照常发生。'},
        {url:require("../assets/cover/美好的七年.jpg"),title:"美好的七年",author:"[以] 埃特加·凯雷特",press:"人民文学出版社",ISBN:'9787020127153',synopsis:'本书为以色列作家埃特加·凯雷特的随笔集，讲述了七年中发生在他身边的事：儿子列夫出生在恐怖袭击的中心特拉维夫......'},
      ],//类型轮播图
      philosophyName:[
        {title:'如何阅读一本好书',ISBN:'9787100106184',url:require("../assets/cover/philos/如何阅读一本书.jpg")},
        {title:'傲慢与偏见',ISBN:'9787511701572',url:require("../assets/cover/philos/傲慢与偏见.jpg")},
        {title:'中国哲学简史',ISBN:'9787301215692',url:require("../assets/cover/philos/中国哲学简史.jpg")},
        {title:'在绝望之巅',ISBN:'9787559660503',url:require("../assets/cover/philos/在绝望之巅.jpg")},
        {title:'理想国',ISBN:'9787100017565',url:require("../assets/cover/philos/理想国.jpg")},
        {title:'悉达多',ISBN:'9787201112695',url:require("../assets/cover/philos/悉达多.jpg")},
        {title:'人生的智慧',ISBN:' 9787208081178',url:require("../assets/cover/philos/人生的智慧.jpg")},
        {title:'爱欲之死',ISBN:'9787508697086',url:require("../assets/cover/philos/爱欲之死.jpg")},
        {title:'悖论简史',ISBN:'9787522508894',url:require("../assets/cover/philos/悖论简史.jpg")},
      ],//哲学
      proseName:[
        {title:'围城',ISBN:'9787020024759',url:require("../assets/cover/prose/围城.jpg")},
        {title:'悲惨世界',ISBN:'9787532751105',url:require("../assets/cover/prose/悲惨世界.jpg")},
        {title:'飞鸟集',ISBN:'9787560084749',url:require("../assets/cover/prose/飞鸟集.jpg")},
        {title:'人间草木',ISBN:'9787539921969',url:require("../assets/cover/prose/人间草木.jpg")},
        {title:'我与地坛',ISBN:' 9787020083442',url:require("../assets/cover/prose/我与地坛.jpg")},
        {title:'皮囊',ISBN:'9787201088945',url:require("../assets/cover/prose/皮囊.jpg")},
        {title:'暮色将尽',ISBN:'9787220126437',url:require("../assets/cover/prose/暮色将尽.jpg")},
        {title:'瓦尔登湖',ISBN:'9787539954882',url:require("../assets/cover/prose/瓦尔登湖.jpg")},
        {title:'野草',ISBN:'9787540364557',url:require("../assets/cover/prose/野草.jpg")},
      ],//散文
      societyName:[
        {title:'金融学',ISBN:'9787300111346',url:require("../assets/cover/society/金融学.jpg")},
        {title:'绝叫',ISBN:'9787559641182',url:require("../assets/cover/society/绝叫.jpg")},
        {title:'1984',ISBN:'9787559641182',url:require("../assets/cover/society/1984.jpg")},
        {title:'圣母',ISBN:'9787513335256',url:require("../assets/cover/society/圣母.jpg")},
        {title:'乡土中国',ISBN:'9787208062153',url:require("../assets/cover/society/乡土中国.jpg")},
        {title:'制造消费',ISBN:'9787218113715',url:require("../assets/cover/society/制造消费.jpg")},
        {title:'始于与极限',ISBN:'9787513349369',url:require("../assets/cover/society/始于极限.jpg")},
        {title:'置身事内',ISBN:'9787208171336',url:require("../assets/cover/society/置身事外.jpg")},
        {title:'毫无意义的工作',ISBN:'9787521743883',url:require("../assets/cover/society/毫无意义的工作.jpg")},
      ],//社会
      computerName:[
        {title:'设计模式之禅',ISBN:'9787111295440',url:require("../assets/cover/computer/设计模式之禅.jpg")},
        {title:'代码简洁之道',ISBN:'9787115-216878',url:require("../assets/cover/computer/代码简洁之道.jpg")},
        {title:'C语言程序设计',ISBN:'9787302275442',url:require("../assets/cover/computer/C语言程序设计.jpg")},
        {title:'网络安全技术',ISBN:'9787302293910',url:require("../assets/cover/computer/网络安全技术.jpg")},
        {title:'Java程序设计',ISBN:'9787302237556',url:require("../assets/cover/computer/Java程序设计实践教程.jpg")},
        {title:'暗网',ISBN:'9787569923308',url:require("../assets/cover/computer/暗网.jpg")},
        {title:'python编程',ISBN:'9787115546081',url:require("../assets/cover/computer/python编程.jpg")},
        {title:'算法图解',ISBN:'9787115447630',url:require("../assets/cover/computer/算法图解.jpg")},
        {title:'浪潮之巅',ISBN:'9787115514226',url:require("../assets/cover/computer/浪潮之巅.jpg")},
      ],//计算机
      poetryName:[
        {title:'纳兰容若词传',ISBN:'9787539933214',url:require("../assets/cover/poetry/纳兰容若词传.jpg")},
        {title:'月光落在左手上',ISBN:'9787530220702',url:require("../assets/cover/poetry/月光落在左手上.jpg")},
        {title:'任在一起',ISBN:'9787208178366',url:require("../assets/cover/poetry/任在一起.jpg")},
        {title:'十二束绝句',ISBN:'9787111295440',url:require("../assets/cover/poetry/十二束绝句.jpg")},
        {title:'海子的诗',ISBN:'9787020026456',url:require("../assets/cover/poetry/海子的诗.jpg")},
        {title:'大山里的小诗人',ISBN:'9787559446824',url:require("../assets/cover/poetry/大山里的小诗人.jpg")},
        {title:'神的舞者',ISBN:'9787219113585',url:require("../assets/cover/poetry/神的舞者.jpg")},
        {title:'唐诗三百首',ISBN:'9787532580934',url:require("../assets/cover/poetry/唐诗三百首.jpg")},
        {title:'物性论',ISBN:'9787576027037',url:require("../assets/cover/poetry/物性论.jpg")},
      ],//诗歌
      cartoonName:[
        {title:'蓦然回首',ISBN:' 9787513348362',url:require("../assets/cover/cartoon/蓦然回首.jpg")},
        {title:'当尘埃落尽',ISBN:'9787574000643',url:require("../assets/cover/cartoon/当尘埃落尽.jpg")},
        {title:'さよなら絵梨',ISBN:'9784088831671',url:require("../assets/cover/cartoon/さよなら絵梨.jpg")},
        {title:'卢浮宫的猫',ISBN:'9787541098482',url:require("../assets/cover/cartoon/卢浮宫的猫.jpg")},
        {title:'暗流',ISBN:'9787513341417',url:require("../assets/cover/cartoon/暗流.jpg")},
        {title:'半小时漫画中国史',ISBN:'9787539999883',url:require("../assets/cover/cartoon/半小时漫画中国史.jpg")},
        {title:'海归线',ISBN:'9787513341424',url:require("../assets/cover/cartoon/海归线.jpg")},
        {title:'你今天真好看',ISBN:'9787201094359',url:require("../assets/cover/cartoon/你今天真好看.jpg")},
        {title:'Sunny 星之子',ISBN:' 9787559633613',url:require("../assets/cover/cartoon/Sunny 星之子.jpg")},
      ],//漫画
      dialogFormVisible:false,
      dialogForm:false,
      form:[],
      test:'',
      book:{},
      name:'',
    }
  },
  methods: {
    //详情
      getIndex(item,index){
     this.test=item.ISBN
        // console.log(this.test)
       request.get("https://api.jike.xyz/situ/book/isbn/"+this.test+"?apikey=14007.bb2551716810f6ae85ad69b1c1e8d740.004eb44d8a1791b449cb8f54554eba96").then(res =>{this.form=res.data})
        this.dialogFormVisible=true
    },
    Submit(){
    this.$router.push("clientBorrowing")
    },
  }
}
</script>

<style >
/*轮播图*/
.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}
.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}
i{
  font-size: 5px;
}
h3 {
  color: #909399;
  margin-left: 20px;
}
hr {
  background-color: #909399;
}
.divSortOne{
  position: relative;
  margin-left: 10px ;
  color: #333333;
  font-weight: bold;
  font-size: 25px
}
.divSortTwo{
  position: relative;
  margin-top: 6px;
  margin-left: 55px ;
  color: #333333;
  font-weight: bold;
  font-size: 20px
}
.divOne{
  height: 230px;
  width: 1400px;
  margin: 0 auto
}
.divTwo{
  display: inline-block;
  margin-left: 50px;
  height: 210px;width: 100px;background-color:#F2F2F2;
}
.divThree{
  /*图书封面*/
  height: 134px;
  width: 90px;
  margin: 0 auto;
}
button{
  margin-left:10px;
  border-radius:6px;
  border: #FFFFFF 1px solid;
}
button:hover{
  color: #8c939d;
}
.details{
  font-family: "PingFang SC";
  font-size: 16px;
  font-weight: bold;
}
.detailsSpan{
  margin-left: 10px;
  font-family: "Hiragino Sans GB";
  font-size: 12px;
  font-weight: normal;
}
</style>