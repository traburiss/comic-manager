import Home from "@/page/Home";
import Login from "@/page/Login";
import Error from "@/page/Error";
import Search from "@/page/search/Search";
import ComicManager from "@/page/comic/manager/ComicManager";
import SeriesManager from "@/page/comic/series/SeriesManager";
import Interest from "@/page/manager/interest/Interest";
import UserManager from "@/page/manager/user/UserManager";
import RoleManager from "@/page/manager/role/RoleManager";
import ConfigManager from "@/page/manager/config/ConfigManager";
import Me from "@/page/me/Me";
import ComicRead from "@/page/comic/read/ComicRead";

export default {
  routers: [
    {path: '', redirect: '/home'},
    {path: '/', redirect: '/home'},
    {
      path: '/home', component: Home, children: [
        {
          path: '',
          redirect: 'search'
        },
        {
          path: 'search',
          component: Search
        },
        {
          path: 'comic',
          component: ComicManager
        },
        {
          path: 'series',
          component: SeriesManager
        },
        {
          path: 'interest',
          component: Interest
        },
        {
          path: 'user',
          component: UserManager
        },
        {
          path: 'role',
          component: RoleManager
        },
        {
          path: 'config',
          component: ConfigManager
        },
        {
          path: 'me',
          component: Me
        }
      ]
    },
    {path: '/comic/reader', component: ComicRead},
    {path: '/login', component: Login},
    {path: '/404', component: Error},
    {path: '/*', redirect: '/404'}
  ]
}
