import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter);

const originalPush = VueRouter.prototype.push;
VueRouter.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}

const routes = [
    //后台主页
  {
    path: '/',
    name: 'Manage',
    component: ()=>import('../views/Manage'),
    redirect: '/login',
     meta:{ title:"后台管理系统"},
    children: [//子路由
      { path: 'home',name: 'Home' ,meta:{ title:"主页"},component: ()=>import('../views/Home')},
      { path: 'user',name: 'User',meta:{ title:"用户信息管理"},component: ()=>import('../views/User')},
      { path: 'BooksType',name: 'BooksType',meta:{ title:"书籍类型管理"},component: ()=>import('../views/BooksType')},
      { path: 'BOOK',name: 'BOOK',meta:{ title:"书籍管理"},component: ()=>import('../views/BOOK')},
      { path: 'UserTime',name: 'UserTime',meta:{ title:"借阅管理"},component: ()=>import('../views/UserTime')},
      { path: 'Personal',name: 'Personal',meta:{ title:"个人信息"},component: ()=>import('../views/Personal')},
    ]
  },
    //登录
  {
    path: '/login',
    name: 'Login',
    component: () => import('../views/Login')
  },
    //注册
  {
    path: '/register',
    name: 'Register',
    component: () => import('../views/Register')
  },
    //客户端主页
  {
    path: '/homePage',
    name: 'homePage',
    redirect: '/clientType',
    component: () => import('../views/homePage'),
    children: [
      // {path: "/clientHome",name: 'clientHome',component: () => import('../views/clientHome')},
      {path: "/clientType",name: 'clientType',component: () => import('../views/clientType')},
      {path: "/clientBorrowing",name: 'clientBorrowing',component: () => import('../views/clientBorrowing')},
      {path: "/clientBorrowingData",name: 'clientBorrowingData',component: () => import('../views/clientBorrowingData')},
      {path: "/clientPersonal",name: 'clientPersonal',component: () => import('../views/clientPersonal')},
    ]
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
