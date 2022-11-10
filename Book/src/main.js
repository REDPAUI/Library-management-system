import Vue from 'vue'
import App from './App.vue'
import router from './router'
//导入ui
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
//导入css
import './assets/gloable.css'
import './assets/el.css'
//导入
import  {VueJsonp}  from "vue-jsonp";
import axios from "axios";
// import weather from 'vue-mini-weather'


Vue.config.productionTip = false
Vue.use(ElementUI,{size: 'small'});
Vue.use(VueJsonp);
Vue.prototype.$axios = axios
// Vue.use(weather)

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
