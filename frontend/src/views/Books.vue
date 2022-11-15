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
            <el-input style="width: 200px;"placeholder="请输入书籍名称"  ></el-input> <el-button style="margin-left: 5px" type="primary" icon="el-icon-search" @click="load">搜索</el-button>
            </span>
  </div>

</div>
</template>

<script>
export default {
  name: "Books"
}
</script>

<style scoped>

</style>