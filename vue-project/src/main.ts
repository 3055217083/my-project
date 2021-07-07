import {createApp} from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import Antd from "ant-design-vue"
import "ant-design-vue/dist/antd.css"
import axios from 'axios'
import { setGlobalOptions } from 'vue-request';
const app = createApp(App)
app.config.globalProperties.$axios = axios
// vue-request全局配置
setGlobalOptions({
  //manual: true,
});
app.use(store)
.use(router)
.use(Antd)
.mount('#app')
