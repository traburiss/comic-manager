import Home from "@/page/Home";
import Login from "@/page/Login";
import Error from "@/page/Error";

export default {
  routers: [
    {path: '', redirect: '/home'},
    {path: '/', redirect: '/home'},
    {path: '/home', component: Home},
    {path: '/login', component: Login},
    {path: '/404', component: Error},
    {path: '/*', redirect: '/404'}
  ]
}
