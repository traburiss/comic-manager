import Vue from 'vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/display.css'
import 'element-ui/lib/theme-chalk/index.css'
import '@/css/global.css'
import VueRouter from 'vue-router'
import routers from '@/js/router'
import App from '@/App'

Vue.config.productionTip = false
Vue.use(ElementUI)
Vue.use(VueRouter)

const router = new VueRouter({
  mode: 'history',
  base: '/',
  routes: routers.routers
})
// eslint-disable-next-line no-unused-vars
const app = new Vue({
  render: h => h(App),
  router: router,
}).$mount('#app')
export default {
  app: app
}
