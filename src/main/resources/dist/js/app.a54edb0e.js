(function(e){function t(t){for(var r,s,l=t[0],i=t[1],c=t[2],m=0,p=[];m<l.length;m++)s=l[m],Object.prototype.hasOwnProperty.call(a,s)&&a[s]&&p.push(a[s][0]),a[s]=0;for(r in i)Object.prototype.hasOwnProperty.call(i,r)&&(e[r]=i[r]);u&&u(t);while(p.length)p.shift()();return o.push.apply(o,c||[]),n()}function n(){for(var e,t=0;t<o.length;t++){for(var n=o[t],r=!0,l=1;l<n.length;l++){var i=n[l];0!==a[i]&&(r=!1)}r&&(o.splice(t--,1),e=s(s.s=n[0]))}return e}var r={},a={app:0},o=[];function s(t){if(r[t])return r[t].exports;var n=r[t]={i:t,l:!1,exports:{}};return e[t].call(n.exports,n,n.exports,s),n.l=!0,n.exports}s.m=e,s.c=r,s.d=function(e,t,n){s.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:n})},s.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},s.t=function(e,t){if(1&t&&(e=s(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var n=Object.create(null);if(s.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var r in e)s.d(n,r,function(t){return e[t]}.bind(null,r));return n},s.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return s.d(t,"a",t),t},s.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},s.p="/";var l=window["webpackJsonp"]=window["webpackJsonp"]||[],i=l.push.bind(l);l.push=t,l=l.slice();for(var c=0;c<l.length;c++)t(l[c]);var u=i;o.push([0,"chunk-vendors"]),n()})({0:function(e,t,n){e.exports=n("56d7")},"03db":function(e,t,n){"use strict";var r=n("1078"),a=n.n(r);a.a},1078:function(e,t,n){},"56d7":function(e,t,n){"use strict";n.r(t);n("e260"),n("e6cf"),n("cca6"),n("a79d"),n("f771");var r=n("2b0e"),a=n("5c96"),o=n.n(a),s=(n("e05f"),n("0fae"),n("8c4f")),l=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("el-container",{staticClass:"container"},[n("el-header",{staticClass:"header"},[n("el-menu",{attrs:{"default-active":e.activeIndex,mode:"horizontal",router:!0}},[n("el-menu-item",{attrs:{index:"search"}},[e._v("搜索")]),n("el-menu-item",{attrs:{index:"comic"}},[e._v("漫画")]),n("el-menu-item",{attrs:{index:"series"}},[e._v("系列")]),n("el-menu-item",{attrs:{index:"interest"}},[e._v("兴趣")]),n("el-submenu",{attrs:{index:"manager","show-timeout":100,"hide-timeout":100}},[n("template",{slot:"title"},[e._v("管理")]),n("el-menu-item",{attrs:{index:"user"}},[e._v("用户")]),n("el-menu-item",{attrs:{index:"role"}},[e._v("角色")]),n("el-menu-item",{attrs:{index:"config"}},[e._v("配置")])],2),n("el-submenu",{attrs:{index:"myself","show-timeout":100,"hide-timeout":100}},[n("template",{slot:"title"},[e._v("我")]),n("el-menu-item",{attrs:{index:"me"}},[e._v("我")]),n("el-menu-item",{staticClass:"logout",on:{click:e.logout}},[e._v("登出")])],2)],1)],1),n("el-main",{staticClass:"main"},[n("router-view")],1)],1)},i=[],c=(n("ac1f"),n("5319"),{name:"Home",data:function(){return{activeIndex:"search"}},methods:{logout:function(){var e=this;this.$confirm("请再考虑一下下","登出",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning",showClose:!1,confirmButtonClass:"el-button--danger"}).then((function(){e.$message({type:"success",message:"开始登出!"})})).catch((function(){e.$message({type:"info",message:"已取消"})}))}},mounted:function(){console.info(this.$route.path),this.activeIndex=this.$route.path.replace("/home/","")}}),u=c,m=(n("03db"),n("2877")),p=Object(m["a"])(u,l,i,!1,null,null,null),f=p.exports,d=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("el-container",{staticClass:"container"},[n("el-main",{staticClass:"main"},[n("el-row",{staticClass:"main-row"},[n("el-col",{staticClass:"title-col",attrs:{xs:24,sm:24,md:16,lg:16,xl:16}},[e._v(" "+e._s(e.msg)+" ")]),n("el-col",{staticClass:"from-col",attrs:{xs:24,sm:24,md:8,lg:8,xl:8}},[n("el-form",{ref:"from",staticClass:"login-from",attrs:{model:e.login}},[n("el-form-item",{staticClass:"from-label"},[n("el-input",{attrs:{placeholder:"请输入用户名"},model:{value:e.login.userName,callback:function(t){e.$set(e.login,"userName",t)},expression:"login.userName"}})],1),n("el-form-item",{staticClass:"from-label"},[n("el-input",{attrs:{placeholder:"请输入密码","show-password":""},model:{value:e.login.passWord,callback:function(t){e.$set(e.login,"passWord",t)},expression:"login.passWord"}})],1),n("el-form-item",{staticClass:"from-label"},[n("el-button",{staticClass:"login-button",attrs:{type:"primary"},on:{click:e.onSubmit}},[e._v("登陆")])],1)],1)],1),n("el-col",{staticClass:"picture-col hidden-sm-and-down",attrs:{h:"",md:24,lg:24,xl:24}})],1)],1)],1)},h=[],v=n("bc3a"),g=n.n(v),_={post:function(e,t,n,r){return g()({method:"post",url:e,data:t}).then((function(e){try{var t=e.data;200===t.code?n(t):void 0!==r?r(t):a["Message"].error(t.msg)}catch(o){console.error(o),a["Message"].error("未知错误，请稍后重试")}})).catch((function(e){try{void 0!==e.response.data&&null!==e.response.data?void 0!==r?r(e.response.data):a["Message"].error(e.response.data.msg):void 0!==r?r({code:e.response.status,msg:e.response.statusText}):a["Message"].error(e.response.statusText)}catch(t){console.error(t),a["Message"].error("未知错误，请稍后重试")}}))}},b={login:x};function x(e,t,n){return _.post("api/user/login",{loginName:e,passWord:t},n)}var y=n("6c27"),O=n.n(y),$={name:"Login",props:{msg:String},data:function(){return{login:{userName:"",passWord:""}}},methods:{onSubmit:function(){var e=this;this.$message.info("正在登陆"),b.login(this.login.userName,O.a.sha256(this.login.passWord),(function(){e.$message.success("登陆成功"),e.$router.push("/home")}))}}},w=$,j=(n("5eb8"),Object(m["a"])(w,d,h,!1,null,"4bad3bc3",null)),C=j.exports,M=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("h1",[e._v("404")])},E=[],S={name:"Error"},k=S,P=Object(m["a"])(k,M,E,!1,null,null,null),T=P.exports,N=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("h1",[e._v("this is search")])},W=[],I={name:"Search"},B=I,R=Object(m["a"])(B,N,W,!1,null,"65448a8c",null),J=R.exports,z=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("h1",[e._v("comic manager")])},A=[],H={name:"ComicManager"},L=H,U=Object(m["a"])(L,z,A,!1,null,"a88420b2",null),q=U.exports,D=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("h1",[e._v("series manager")])},F=[],G={name:"SeriesManager"},K=G,Q=Object(m["a"])(K,D,F,!1,null,"bef2525a",null),V=Q.exports,X=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("h1",[e._v("因吹斯听")])},Y=[],Z={name:"Interest"},ee=Z,te=Object(m["a"])(ee,X,Y,!1,null,"63497f98",null),ne=te.exports,re=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("h1",[e._v("user manager")])},ae=[],oe={name:"UserManeger"},se=oe,le=Object(m["a"])(se,re,ae,!1,null,"1366cc0e",null),ie=le.exports,ce=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("h1",[e._v("Role")])},ue=[],me={name:"RoleManager"},pe=me,fe=Object(m["a"])(pe,ce,ue,!1,null,"d7c445d8",null),de=fe.exports,he=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("h1",[e._v("config manager")])},ve=[],ge={name:"ComicManager"},_e=ge,be=Object(m["a"])(_e,he,ve,!1,null,"de234eb4",null),xe=be.exports,ye=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("h1",[e._v("this me")])},Oe=[],$e={name:"Me"},we=$e,je=Object(m["a"])(we,ye,Oe,!1,null,"28283fd6",null),Ce=je.exports,Me=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("h1",[e._v("Comic reader")])},Ee=[],Se={name:"ComicRead"},ke=Se,Pe=Object(m["a"])(ke,Me,Ee,!1,null,"55213070",null),Te=Pe.exports,Ne={routers:[{path:"",redirect:"/home"},{path:"/",redirect:"/home"},{path:"/home",component:f,children:[{path:"",redirect:"search"},{path:"search",component:J},{path:"comic",component:q},{path:"series",component:V},{path:"interest",component:ne},{path:"user",component:ie},{path:"role",component:de},{path:"config",component:xe},{path:"me",component:Ce}]},{path:"/comic/reader",component:Te},{path:"/login",component:C},{path:"/404",component:T},{path:"/*",redirect:"/404"}]},We=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{attrs:{id:"app"}},[n("router-view")],1)},Ie=[],Be={name:"App"},Re=Be,Je=Object(m["a"])(Re,We,Ie,!1,null,null,null),ze=Je.exports;r["default"].config.productionTip=!1,r["default"].use(o.a),r["default"].use(s["a"]);var Ae=new s["a"]({mode:"history",base:"/",routes:Ne.routers}),He=new r["default"]({render:function(e){return e(ze)},router:Ae}).$mount("#app");t["default"]={app:He}},"5eb8":function(e,t,n){"use strict";var r=n("6a88"),a=n.n(r);a.a},"6a88":function(e,t,n){},f771:function(e,t,n){}});
//# sourceMappingURL=app.a54edb0e.js.map