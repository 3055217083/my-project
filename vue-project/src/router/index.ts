import {createRouter, createWebHistory, RouteRecordRaw} from 'vue-router'

import IndexAndHome from "../layout/indexAndHome.vue";
import Test from "../ATest4ShowSomeView.vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: '',
    name: '主页',
    component: IndexAndHome,
    children: [
      {
        path: '/...',
        name: '名字',
        component: Test,
      },
    ]
  }
  , {
    path: '/test',
    name: '测试',
    component: Test,
  }
  , {
    path: '/abc',
    name: '名字',
    component: {template:'<div>465645654654654</div>'},
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
