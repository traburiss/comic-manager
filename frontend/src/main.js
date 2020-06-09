import '@/css/global.css'
import Vue from 'vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/display.css'
import 'element-ui/lib/theme-chalk/index.css'
import VueRouter from 'vue-router'
import VueCookies from 'vue-cookies'
import routers from '@/js/router'
import App from '@/App'
import cookie from '@/js/common/cookie';
import {global} from '@/store';

Vue.config.productionTip = false
Vue.use(ElementUI)
Vue.use(VueRouter)
Vue.use(VueCookies)

const router = new VueRouter({
  mode: 'history',
  base: '/',
  routes: routers.routers
})
// eslint-disable-next-line no-unused-vars
const app = new Vue({
  render: h => h(App),
  store: global,
  router: router,
}).$mount('#app')
router.beforeEach((to, from, next) => {
  if (!isLogin() && to.path !== '/login') {
    app.$message.error('您还没有登陆，请重新登陆')
    next('/login')
  } else {
    next()
  }
})

function isLogin() {
  return app.$cookies.get(cookie.token) !== null
}

export default {
  app: app
}
