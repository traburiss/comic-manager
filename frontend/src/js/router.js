import Home from "@/page/Home";
import Login from "@/page/Login";
import ERROR from "@/page/ERROR";

export default {
  routers: [
    {path: '', redirect: '/home'},
    {path: '/', redirect: '/home'},
    {path: '/home', component: Home},
    {path: '/login', component: Login},
    {path: '/404', component: ERROR},
    {path: '/*', redirect: '/404'}
  ]
}
