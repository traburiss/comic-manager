(function(e){function t(t){for(var n,i,o=t[0],l=t[1],u=t[2],m=0,d=[];m<o.length;m++)i=o[m],Object.prototype.hasOwnProperty.call(r,i)&&r[i]&&d.push(r[i][0]),r[i]=0;for(n in l)Object.prototype.hasOwnProperty.call(l,n)&&(e[n]=l[n]);c&&c(t);while(d.length)d.shift()();return s.push.apply(s,u||[]),a()}function a(){for(var e,t=0;t<s.length;t++){for(var a=s[t],n=!0,o=1;o<a.length;o++){var l=a[o];0!==r[l]&&(n=!1)}n&&(s.splice(t--,1),e=i(i.s=a[0]))}return e}var n={},r={app:0},s=[];function i(t){if(n[t])return n[t].exports;var a=n[t]={i:t,l:!1,exports:{}};return e[t].call(a.exports,a,a.exports,i),a.l=!0,a.exports}i.m=e,i.c=n,i.d=function(e,t,a){i.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:a})},i.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},i.t=function(e,t){if(1&t&&(e=i(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var a=Object.create(null);if(i.r(a),Object.defineProperty(a,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var n in e)i.d(a,n,function(t){return e[t]}.bind(null,n));return a},i.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return i.d(t,"a",t),t},i.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},i.p="/";var o=window["webpackJsonp"]=window["webpackJsonp"]||[],l=o.push.bind(o);o.push=t,o=o.slice();for(var u=0;u<o.length;u++)t(o[u]);var c=l;s.push([0,"chunk-vendors"]),a()})({0:function(e,t,a){e.exports=a("56d7")},"03db":function(e,t,a){"use strict";var n=a("1078"),r=a.n(n);r.a},1078:function(e,t,a){},"289e":function(e,t,a){"use strict";var n=a("e8f7"),r=a.n(n);r.a},3240:function(e,t,a){"use strict";var n=a("b639"),r=a.n(n);r.a},"56d7":function(e,t,a){"use strict";a.r(t);a("e260"),a("e6cf"),a("cca6"),a("a79d"),a("f771");var n,r=a("2b0e"),s=a("5c96"),i=a.n(s),o=(a("e05f"),a("0fae"),a("8c4f")),l=a("2b27"),u=a.n(l),c=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-container",{staticClass:"container"},[a("el-header",{staticClass:"header",attrs:{height:"30px"}},[a("el-menu",{attrs:{"default-active":e.activeIndex,mode:"horizontal",router:!0}},[a("el-submenu",{attrs:{index:"myself","show-timeout":100,"hide-timeout":100}},[a("template",{slot:"title"},[e._v("我")]),a("el-menu-item",{attrs:{index:"me"}},[e._v(e._s(e.userData.userName))]),a("el-menu-item",{attrs:{index:""},on:{click:function(t){return e.$refs.editUserName.open()}}},[e._v("修改用户名")]),a("el-menu-item",{attrs:{index:""},on:{click:function(t){return e.$refs.editPassword.open()}}},[e._v("修改密码")]),a("el-menu-item",{staticClass:"logout",attrs:{index:""},on:{click:e.logout}},[e._v("登出")])],2),e.menuList.includes("user")?a("el-submenu",{attrs:{index:"manager","show-timeout":100,"hide-timeout":100}},[a("template",{slot:"title"},[e._v("管理")]),e.menuList.includes("user")?a("el-menu-item",{attrs:{index:"user"}},[e._v("用户")]):e._e(),e.menuList.includes("user")?a("el-menu-item",{attrs:{index:"role"}},[e._v("角色")]):e._e(),e.menuList.includes("user")?a("el-menu-item",{attrs:{index:"library"}},[e._v("书库")]):e._e(),e.menuList.includes("user")?a("el-menu-item",{attrs:{index:"config"}},[e._v("配置")]):e._e()],2):e._e(),e.menuList.includes("user")?a("el-menu-item",{attrs:{index:"series"}},[e._v("系列")]):e._e(),e.menuList.includes("user")?a("el-menu-item",{attrs:{index:"comic"}},[e._v("漫画")]):e._e(),e.menuList.includes("user")?a("el-menu-item",{attrs:{index:"search"}},[e._v("搜索")]):e._e()],1)],1),a("el-main",{staticClass:"main"},[a("router-view")],1),a("edit-user-name",{ref:"editUserName"}),a("edit-password",{ref:"editPassword"})],1)},m=[],d=(a("ac1f"),a("5319"),a("d3b7"),a("bc3a")),p=a.n(d),f={start:function(e){n=s["Loading"].service({text:e,lock:!0})},stop:function(){n&&n.close()}},g={token:"token"};p.a.defaults.baseURL="/api",p.a.interceptors.response.use((function(e){try{if(200===e.status){var t=e.data;return 200===t.code?Promise.resolve(t):(s["Message"].error(t.msg),Promise.reject(t))}if(401!==e.status){var a=e.data;return void 0!==a&&null!==a?(s["Message"].error(a.msg),Promise.reject(a)):(s["Message"].error(e.statusText),Promise.reject({code:e.status,msg:e.statusText}))}f.stop(),jt.app.$cookies.remove(g.token,"/"),jt.app.$router.push("/login").then((function(){s["Message"].error("你还未登陆，请先登陆")}))}catch(n){return console.error(n),s["Message"].error("未知错误，请稍后重试"),Promise.reject({code:-1,msg:"未知错误，请稍后重试"})}}));var h={service:function(e,t,a,n){return p()({method:t,url:e,data:a,params:n})},post:function(e,t,a){return this.service(e,"post",t,a)},delete:function(e,t){return this.service(e,"delete",null,t)},get:function(e,t){return this.service(e,"get",null,t)}},b=a("6c27"),v=a.n(b),w={loginService:function(e,t){return h.post("/user/login",{loginName:e,passWord:v.a.sha256(t)})},logoutService:function(){return h.post("/user/logout",{})}},y=(a("4160"),a("159b"),a("ade3")),_=a("2f62"),x={userData:function(){return h.get("/user/data",{})},editUserName:function(e){return h.post("/user/update/username",{userName:e})},editPassword:function(e,t){return h.post("/user/update/password",{pwd:v.a.sha256(e),newPwd:v.a.sha256(t)})}},$="updateUserData";r["default"].use(_["a"]);var P=new _["a"].Store({state:{userData:{userName:"",loginName:"",roleName:"",menuList:[]},menuList:[]},mutations:Object(y["a"])({},$,(function(e){x.userData().then((function(t){e.userData=t["data"],e.menuList=[],e.userData.menuList.forEach((function(t){e.menuList.push(t["menuCode"])}))}))}))}),k=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{attrs:{title:"修改用户名",visible:e.dialogVisible,width:"30%","show-close":!1},on:{"update:visible":function(t){e.dialogVisible=t}}},[a("el-form",{ref:"userNameForm",attrs:{model:e.user,rules:e.rules,"label-width":"80px"}},[a("el-form-item",{attrs:{label:"旧用户名"}},[a("el-input",{attrs:{disabled:!0},model:{value:e.userName,callback:function(t){e.userName=t},expression:"userName"}})],1),a("el-form-item",{attrs:{label:"新用户名",prop:"newUserName"}},[a("el-input",{attrs:{placeholder:"请输入新的用户名",clearable:!0},model:{value:e.user.newUserName,callback:function(t){e.$set(e.user,"newUserName",t)},expression:"user.newUserName"}})],1)],1),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:e.close}},[e._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:e.update}},[e._v("确 定")])],1)],1)},S=[],L={name:"EditUserName",data:function(){return{dialogVisible:!1,user:{newUserName:""},rules:{newUserName:[{required:!0,message:"请输入新的用户名",trigger:"change"},{min:1,max:30,message:"长度在 1 到 30 个字符",trigger:"change"}]}}},computed:{userName:function(){return this.$store.state.userData.userName}},methods:{open:function(){this.dialogVisible=!0},close:function(){this.user.newUserName="",this.dialogVisible=!1,this.$refs.userNameForm.resetFields()},update:function(){var e=this;this.$refs.userNameForm.validate((function(t){t&&(f.start("正在修改"),x.editUserName(e.user.newUserName).then((function(t){200===t.code?(e.$message.success("修改成功"),e.$store.commit($),e.close()):e.$message.warning(t.msg)})).finally((function(){f.stop()})))}))}}},C=L,z=a("2877"),q=Object(z["a"])(C,k,S,!1,null,"03a313d8",null),E=q.exports,N=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{attrs:{title:"修改密码",visible:e.dialogVisible,width:"30%","show-close":!1},on:{"update:visible":function(t){e.dialogVisible=t}}},[a("el-form",{ref:"editPwdFrom",attrs:{model:e.user,"label-width":"80px",rules:e.rules}},[a("el-form-item",{attrs:{label:"旧密码",prop:"oldPwd"}},[a("el-input",{attrs:{placeholder:"请输入旧的密码","show-password":"",clearable:!0},model:{value:e.user.oldPwd,callback:function(t){e.$set(e.user,"oldPwd",t)},expression:"user.oldPwd"}})],1),a("el-form-item",{attrs:{label:"新密码",prop:"newPwd"}},[a("el-input",{attrs:{placeholder:"请输入新的密码","show-password":"",clearable:!0},model:{value:e.user.newPwd,callback:function(t){e.$set(e.user,"newPwd",t)},expression:"user.newPwd"}})],1),a("el-form-item",{attrs:{label:"新密码",prop:"newPwdAgain"}},[a("el-input",{attrs:{placeholder:"请再次输入新的密码","show-password":"",clearable:!0},model:{value:e.user.newPwdAgain,callback:function(t){e.$set(e.user,"newPwdAgain",t)},expression:"user.newPwdAgain"}})],1)],1),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:e.close}},[e._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:e.update}},[e._v("确 定")])],1)],1)},j=[],I={name:"EditPassword",data:function(){var e=this,t=function(t,a,n){""===a?n(new Error("请再次输入密码")):a.length<6||a.length>30?n(new Error("长度在 6 到 30 个字符")):a!==e.user.newPwd?n(new Error("两次输入密码不一致!")):n()};return{dialogVisible:!1,user:{oldPwd:"",newPwd:"",newPwdAgain:""},rules:{oldPwd:[{required:!0,message:"请输入旧的密码",trigger:"change"},{min:6,max:30,message:"长度在 6 到 30 个字符",trigger:"change"}],newPwd:[{required:!0,message:"请输入新的密码",trigger:"change"},{min:6,max:30,message:"长度在 6 到 30 个字符",trigger:"change"}],newPwdAgain:[{validator:t,trigger:"change"}]}}},methods:{open:function(){this.dialogVisible=!0},close:function(){this.user={oldPwd:"",newPwd:"",newPwdAgain:""},this.dialogVisible=!1,this.$refs.editPwdFrom.resetFields()},update:function(){var e=this;this.$refs.editPwdFrom.validate((function(t){t&&(f.start("正在修改"),x.editPassword(e.user.oldPwd,e.user.newPwdAgain).then((function(t){200===t.code?(e.$message.success("修改成功"),e.close(),f.stop(),e.$confirm("您已修改密码，请问是否要重新登陆","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){f.start("正在登出"),w.logoutService().then((function(){f.stop(),e.$cookies.remove(g.token,"/"),e.$router.push("/login"),e.$message({message:"已登出!"})})).catch((function(){f.stop(),e.$message({type:"warn",message:"登出失败"})}))}))):e.$message.warning(t.msg)})).finally((function(){f.stop()})))}))}}},O=I,T=Object(z["a"])(O,N,j,!1,null,"2254604f",null),M=T.exports,F={name:"Home",components:{EditUserName:E,EditPassword:M},data:function(){return{activeIndex:"search"}},methods:{logout:function(){var e=this;this.$confirm("请再考虑一下下","登出",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning",showClose:!1,confirmButtonClass:"el-button--danger"}).then((function(){f.start("正在登出"),w.logoutService().then((function(){e.logoutFinish()})).catch((function(){f.stop(),e.$message({type:"warn",message:"登出失败"})}))})).catch((function(){e.$message({type:"info",message:"已取消"})}))},logoutFinish:function(){f.stop(),this.$cookies.remove(g.token,"/"),this.$router.push("/login"),this.$message({message:"已登出!"})}},computed:{userData:function(){return this.$store.state.userData},menuList:function(){return this.$store.state.menuList}},mounted:function(){this.activeIndex=this.$route.path.replace("/home/",""),this.$store.commit($)}},A=F,U=(a("03db"),Object(z["a"])(A,c,m,!1,null,null,null)),V=U.exports,B=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-container",{staticClass:"container"},[a("el-main",{staticClass:"main"},[a("el-row",{staticClass:"main-row"},[a("el-col",{staticClass:"title-col",attrs:{xs:24,sm:24,md:16,lg:16,xl:16}},[e._v(" "+e._s(e.msg)+" ")]),a("el-col",{staticClass:"from-col",attrs:{xs:24,sm:24,md:8,lg:8,xl:8}},[a("el-form",{ref:"from",staticClass:"login-from",attrs:{model:e.login}},[a("el-form-item",{staticClass:"from-label"},[a("el-input",{attrs:{placeholder:"请输入用户名"},model:{value:e.login.userName,callback:function(t){e.$set(e.login,"userName",t)},expression:"login.userName"}})],1),a("el-form-item",{staticClass:"from-label"},[a("el-input",{attrs:{placeholder:"请输入密码","show-password":""},model:{value:e.login.passWord,callback:function(t){e.$set(e.login,"passWord",t)},expression:"login.passWord"}})],1),a("el-form-item",{staticClass:"from-label"},[a("el-button",{staticClass:"login-button",attrs:{type:"primary"},on:{click:e.onSubmit}},[e._v("登陆")])],1)],1)],1),a("el-col",{staticClass:"picture-col hidden-sm-and-down",attrs:{h:"",md:24,lg:24,xl:24}})],1)],1)],1)},D=[],R={name:"Login",props:{msg:String},data:function(){return{login:{userName:"",passWord:""}}},methods:{onSubmit:function(){var e=this;this.$message.info("正在登陆"),w.loginService(this.login.userName,this.login.passWord).then((function(){e.$message.success("登陆成功"),e.$router.push("/home")}))}}},W=R,H=(a("289e"),Object(z["a"])(W,B,D,!1,null,"772939a2",null)),J=H.exports,Y=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("h1",[e._v("404")])},G=[],K={name:"Error"},Z=K,Q=Object(z["a"])(Z,Y,G,!1,null,null,null),X=Q.exports,ee=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("h1",[e._v("this is search")])},te=[],ae={name:"Search"},ne=ae,re=Object(z["a"])(ne,ee,te,!1,null,"1ff0734c",null),se=re.exports,ie=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("h1",[e._v("comic manager")])},oe=[],le={name:"ComicManager"},ue=le,ce=Object(z["a"])(ue,ie,oe,!1,null,"c144b8f2",null),me=ce.exports,de=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("h1",[e._v("series manager")])},pe=[],fe={name:"SeriesManager"},ge=fe,he=Object(z["a"])(ge,de,pe,!1,null,"68df026e",null),be=he.exports,ve=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-container",[a("el-header",{staticClass:"search-header"},[a("el-form",{attrs:{size:"small",model:e.queryParam,inline:!0}},[a("el-form-item",{attrs:{label:"名称"}},[a("el-input",{attrs:{clearable:""},model:{value:e.queryParam.name,callback:function(t){e.$set(e.queryParam,"name",t)},expression:"queryParam.name"}})],1),a("el-form-item",[a("el-button",{attrs:{type:"primary"},on:{click:e.search}},[e._v("查询")])],1),a("el-form-item",[a("el-button",{attrs:{type:"success"},on:{click:e.addSubmit}},[e._v("新增")])],1)],1)],1),a("el-main",[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.queryParam.tableLoading,expression:"queryParam.tableLoading"}],attrs:{data:e.resultList}},[a("el-table-column",{attrs:{prop:"name",label:"书库名称","min-width":"10%","show-overflow-tooltip":!0}}),a("el-table-column",{attrs:{prop:"desc",label:"书库说明","min-width":"20%","show-overflow-tooltip":!0}}),a("el-table-column",{attrs:{prop:"type",label:"书库类型","min-width":"5%"},scopedSlots:e._u([{key:"default",fn:function(t){return[1===t.row.type?a("el-tooltip",{staticClass:"item",attrs:{content:"本地文件",placement:"top"}},[a("el-tag",{attrs:{type:"success",size:"mini"}},[e._v("F")])],1):2===t.row.type?a("el-tooltip",{staticClass:"item",attrs:{content:"smb文件",placement:"top"}},[a("el-tag",{attrs:{type:"success",size:"mini"}},[e._v("S")])],1):a("el-tooltip",{staticClass:"item",attrs:{content:"未知",placement:"top"}},[a("el-tag",{attrs:{type:"danger",size:"mini"}},[e._v("未")])],1)]}}])}),a("el-table-column",{attrs:{prop:"status",label:"扫描状态","min-width":"5%"},scopedSlots:e._u([{key:"default",fn:function(t){return[0===t.row.status?a("el-tooltip",{staticClass:"item",attrs:{content:"已准备",placement:"top"}},[a("el-tag",{attrs:{type:"warning",size:"mini"}},[e._v("R")])],1):1===t.row.status?a("el-tooltip",{staticClass:"item",attrs:{content:"正在扫描",placement:"top"}},[a("el-tag",{attrs:{type:"success",size:"mini"}},[e._v("P")])],1):2===t.row.status?a("el-tooltip",{staticClass:"item",attrs:{content:"已完成扫描",placement:"top"}},[a("el-tag",{attrs:{type:"success",size:"mini"}},[e._v("F")])],1):a("el-tooltip",{staticClass:"item",attrs:{content:"未知",placement:"top"}},[a("el-tag",{attrs:{type:"danger",size:"mini"}},[e._v("未")])],1)]}}])}),a("el-table-column",{attrs:{prop:"scanTime",label:"扫描时间",formatter:e.dateFormatter,"min-width":"10%","show-overflow-tooltip":!0}}),a("el-table-column",{attrs:{prop:"scanMsg",label:"扫描信息","min-width":"20%","show-overflow-tooltip":!0}}),a("el-table-column",{attrs:{prop:"updater",label:"更新人","min-width":"10%","show-overflow-tooltip":!0}}),a("el-table-column",{attrs:{prop:"updateTime",label:"更新时间",formatter:e.dateFormatter,"min-width":"10%","show-overflow-tooltip":!0}}),a("el-table-column",{attrs:{prop:"operation",label:"操作","min-width":"10%"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-tooltip",{staticClass:"item",attrs:{content:"编辑",placement:"top"}},[a("el-button",{attrs:{size:"mini",type:"primary",icon:"el-icon-edit"},on:{click:function(a){return e.editSubmit(t.row)}}})],1),a("el-tooltip",{staticClass:"item",attrs:{content:"删除",placement:"top"}},[a("el-button",{attrs:{size:"mini",type:"danger",icon:"el-icon-delete"},on:{click:function(a){return e.deleteSubmit(t.row)}}})],1),a("el-tooltip",{staticClass:"item",attrs:{content:"TAG编辑",placement:"top"}},[a("el-button",{attrs:{size:"mini",type:"success",icon:"el-icon-document-add"},on:{click:function(a){return e.tagManager(t.row)}}})],1)]}}])})],1),a("el-pagination",{attrs:{"current-page":e.pageParam.page,"page-sizes":e.pageParam.pageList,"page-size":e.pageParam.pageSize,total:e.pageParam.total,layout:"->,total, sizes, prev, pager, next"},on:{"size-change":e.querySubmit,"current-change":e.querySubmit,"update:currentPage":function(t){return e.$set(e.pageParam,"page",t)},"update:current-page":function(t){return e.$set(e.pageParam,"page",t)},"update:pageSizes":function(t){return e.$set(e.pageParam,"pageList",t)},"update:page-sizes":function(t){return e.$set(e.pageParam,"pageList",t)},"update:pageSize":function(t){return e.$set(e.pageParam,"pageSize",t)},"update:page-size":function(t){return e.$set(e.pageParam,"pageSize",t)},"update:total":function(t){return e.$set(e.pageParam,"total",t)}}})],1),a("library-info",{ref:"libraryInfo"}),a("tag-info",{ref:"tagInfo"})],1)},we=[],ye=(a("b0c0"),a("841c"),{pageList:[10,20,40,60,120],pageSize:10}),_e={libraryList:function(e){return h.get("/library/list",e)},addLibrary:function(e){return h.post("/library/add",e)},editLibrary:function(e){return h.post("/library/edit",e)},removeLibrary:function(e){return h.delete("/library/remove",e)},tagList:function(e){return h.get("/library/tag/list",e)},tagAdd:function(e){return h.post("/library/tag/add",e)},tagRemove:function(e){return h.delete("/library/tag/remove",e)}};a("4d63"),a("25f0"),a("4d90");function xe(e,t){return null!==e&&void 0!==e?$e(new Date(e),t):"未设置时间"}function $e(e,t){var a;null!==t&&void 0!==t&&""!==t||(t="yyyy-MM-dd hh:mm:ss");var n={"y+":e.getFullYear().toString(),"M+":(e.getMonth()+1).toString(),"d+":e.getDate().toString(),"h+":e.getHours().toString(),"m+":e.getMinutes().toString(),"s+":e.getSeconds().toString(),"S+":e.getMilliseconds().toString()};for(var r in n)a=new RegExp("("+r+")").exec(t),a&&(t=t.replace(a[1],1===a[1].length?n[r]:n[r].padStart(a[1].length,"0")));return t}var Pe=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{attrs:{title:e.edit?"编辑":"新增",visible:e.show,width:"30%","show-close":!1},on:{"update:visible":function(t){e.show=t}}},[a("el-form",{ref:"libraryInfo",attrs:{model:e.data,rules:e.rules,"label-width":"100px"}},[a("el-form-item",{attrs:{label:"名称",prop:"name"}},[a("el-input",{attrs:{clearable:!0},model:{value:e.data.name,callback:function(t){e.$set(e.data,"name",t)},expression:"data.name"}})],1),a("el-form-item",{attrs:{label:"说明",prop:"desc"}},[a("el-input",{attrs:{clearable:!0},model:{value:e.data.desc,callback:function(t){e.$set(e.data,"desc",t)},expression:"data.desc"}})],1),a("el-form-item",{attrs:{label:"类型",prop:"type"}},[a("el-select",{model:{value:e.data.type,callback:function(t){e.$set(e.data,"type",t)},expression:"data.type"}},e._l(e.types,(function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})})),1)],1),a("el-form-item",{attrs:{label:"路径",prop:"path"}},[a("el-input",{attrs:{clearable:!0},model:{value:e.data.path,callback:function(t){e.$set(e.data,"path",t)},expression:"data.path"}})],1),a("el-form-item",{attrs:{label:"参数",prop:"param"}},[a("el-input",{attrs:{clearable:!0},model:{value:e.data.param,callback:function(t){e.$set(e.data,"param",t)},expression:"data.param"}})],1)],1),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:e.close}},[e._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:e.submitConfig}},[e._v("确 定")])],1)],1)},ke=[],Se={name:"LibraryInfo",data:function(){return{edit:!1,show:!1,parent:null,data:{id:0,name:"",desc:"",type:1,path:"",param:""},types:[{value:1,label:"本地文件"},{value:2,label:"SMB"}],rules:{name:[{required:!0,message:"请输入",trigger:"change"},{min:1,max:30,message:"长度在 1 到 20 个字符",trigger:"change"}],desc:[{min:0,max:60,message:"长度在 0 到 60 个字符",trigger:"change"}],path:[{required:!0,message:"请输入",trigger:"change"},{min:1,max:1024,message:"长度在 0 到 1024 个字符",trigger:"change"}],param:[{min:0,max:1024,message:"长度在 0 到 1024 个字符",trigger:"change"}]}}},methods:{openAdd:function(e){this.edit=!1,this.show=!0,this.parent=e},openEdit:function(e,t){this.edit=!0,this.show=!0,this.parent=e,this.data={id:t.id,name:t.name,desc:t.desc,type:t.type,path:t.path,param:t.param}},close:function(){this.show=!1,this.$refs.libraryInfo.resetFields()},submitConfig:function(){var e=this;this.$refs.libraryInfo.validate((function(t){t&&(f.start("正在提交"),e.edit?_e.editLibrary(e.data).then((function(t){200===t.code?(e.close(),e.$message.success("编辑成功"),e.parent.querySubmit()):e.$message.success(t.msg)})).finally((function(){f.stop()})):_e.addLibrary(e.data).then((function(t){200===t.code?(e.close(),e.$message.success("新增成功"),e.parent.querySubmit()):e.$message.success(t.msg)})).finally((function(){f.stop()})))}))}}},Le=Se,Ce=Object(z["a"])(Le,Pe,ke,!1,null,"679fe78e",null),ze=Ce.exports,qe=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{attrs:{title:"标签管理",visible:e.show,width:"30%","show-close":!1},on:{"update:visible":function(t){e.show=t},close:e.close}},[a("div",{staticClass:"tag-div"},[e._l(e.tagList,(function(t,n){return a("el-tag",{key:t.id,staticClass:"tag",attrs:{type:e.typeList[n%5],closable:"","disable-transitions":!1},on:{close:function(a){return e.deleteTag(t.id)}}},[e._v(e._s(t.name))])})),e.inputVisible?a("el-input",{ref:"tagInput",staticClass:"input-tag",attrs:{size:"small"},on:{blur:e.addTag},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.addTag(t)}},model:{value:e.text,callback:function(t){e.text=t},expression:"text"}}):a("el-button",{staticClass:"button-tag",attrs:{size:"small",icon:"el-icon-plus"},on:{click:e.showInput}})],2)])},Ee=[],Ne={name:"TagInfo",data:function(){return{typeList:["","success","info","danger","warning"],show:!1,inputVisible:!1,text:"",tagList:[],libraryId:0,parent:null}},methods:{open:function(e,t){this.show=!0,this.libraryId=t.id,this.parent=e,this.queryTag()},close:function(){this.show=!1,this.inputVisible=!1,this.text="",this.tagList=[],this.libraryId=0,this.parent=null},queryTag:function(){var e=this;_e.tagList({libraryId:this.libraryId}).then((function(t){e.tagList=t.data}))},showInput:function(){this.inputVisible=!0},addTag:function(){var e=this;this.inputVisible=!1,_e.tagAdd({id:0,libraryId:this.libraryId,name:this.text}).finally((function(){e.text="",e.queryTag()}))},deleteTag:function(e){var t=this;this.$confirm("请确认是否要删除","删除",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning",showClose:!1,confirmButtonClass:"el-button--danger"}).then((function(){_e.tagRemove({tagId:e}).finally((function(){t.text="",t.queryTag()}))}))}}},je=Ne,Ie=(a("3240"),Object(z["a"])(je,qe,Ee,!1,null,"6e4cd5e5",null)),Oe=Ie.exports,Te={name:"Library",components:{TagInfo:Oe,LibraryInfo:ze},data:function(){return{queryParam:{tableLoading:!1,name:""},resultList:[],pageParam:{pageList:ye.pageList,page:1,pageSize:ye.pageSize,total:0}}},mounted:function(){this.search()},methods:{search:function(){this.pageParam.page=1,this.querySubmit()},querySubmit:function(){var e=this;this.queryParam.tableLoading=!0,_e.libraryList({page:this.pageParam.page,pageSize:this.pageParam.pageSize,name:this.queryParam.name}).then((function(t){e.resultList=t.data.list,e.pageParam.total=t.data.count})).finally((function(){e.queryParam.tableLoading=!1}))},addSubmit:function(){this.$refs.libraryInfo.openAdd(this)},editSubmit:function(e){this.$refs.libraryInfo.openEdit(this,e)},deleteSubmit:function(e){var t=this;this.$confirm("请确认是否要删除","删除",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning",showClose:!1,confirmButtonClass:"el-button--danger"}).then((function(){f.start("正在删除"),_e.removeLibrary({libraryId:e.id}).then((function(){t.$message.success("删除成功"),t.querySubmit()})).finally((function(){f.stop()}))}))},tagManager:function(e){this.$refs.tagInfo.open(this,e)},dateFormatter:function(e,t,a){return xe(a)}}},Me=Te,Fe=Object(z["a"])(Me,ve,we,!1,null,"00680a32",null),Ae=Fe.exports,Ue=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("h1",[e._v("user manager")])},Ve=[],Be={name:"UserManeger"},De=Be,Re=Object(z["a"])(De,Ue,Ve,!1,null,"c45fc6a2",null),We=Re.exports,He=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("h1",[e._v("Role")])},Je=[],Ye={name:"RoleManager"},Ge=Ye,Ke=Object(z["a"])(Ge,He,Je,!1,null,"3ba15fca",null),Ze=Ke.exports,Qe=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-container",[a("el-header",{staticClass:"search-header"},[a("el-form",{attrs:{size:"small",model:e.queryParam,inline:!0}},[a("el-form-item",{attrs:{label:"名称"}},[a("el-input",{attrs:{clearable:""},model:{value:e.queryParam.name,callback:function(t){e.$set(e.queryParam,"name",t)},expression:"queryParam.name"}})],1),a("el-form-item",[a("el-button",{attrs:{type:"primary"},on:{click:e.search}},[e._v("查询")])],1)],1)],1),a("el-main",[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.queryParam.tableLoading,expression:"queryParam.tableLoading"}],attrs:{data:e.resultList}},[a("el-table-column",{attrs:{prop:"key",label:"配置KEY","min-width":"10%","show-overflow-tooltip":!0}}),a("el-table-column",{attrs:{prop:"value",label:"配置值","min-width":"20%","show-overflow-tooltip":!0}}),a("el-table-column",{attrs:{prop:"name",label:"配置名称","min-width":"15%","show-overflow-tooltip":!0}}),a("el-table-column",{attrs:{prop:"desc",label:"配置说明","min-width":"25%","show-overflow-tooltip":!0}}),a("el-table-column",{attrs:{prop:"type",label:"配置类型","min-width":"5%"},scopedSlots:e._u([{key:"default",fn:function(t){return[0===t.row.type?a("el-tooltip",{staticClass:"item",attrs:{effect:"dark",content:"不可更改的系统配置",placement:"top"}},[a("el-tag",{attrs:{type:"warning",size:"mini"}},[e._v("系")])],1):e._e(),1===t.row.type?a("el-tooltip",{staticClass:"item",attrs:{effect:"dark",content:"系统配置",placement:"top"}},[a("el-tag",{attrs:{type:"success",size:"mini"}},[e._v("系")])],1):e._e(),2===t.row.type?a("el-tooltip",{staticClass:"item",attrs:{effect:"dark",content:"用户配置默认值",placement:"top"}},[a("el-tag",{attrs:{type:"success",size:"mini"}},[e._v("用")])],1):e._e()]}}])}),e._v(" > "),a("el-table-column",{attrs:{prop:"updater",label:"更新人","min-width":"10%","show-overflow-tooltip":!0}}),a("el-table-column",{attrs:{prop:"updateTime",label:"更新时间",formatter:e.dateFormatter,"min-width":"10%","show-overflow-tooltip":!0}}),a("el-table-column",{attrs:{prop:"operation",label:"操作","min-width":"5%"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{disabled:0===t.row.type,size:"mini"},on:{click:function(a){return e.editSubmit(t.row)}}},[e._v("编辑")])]}}])})],1),a("el-pagination",{attrs:{"current-page":e.pageParam.page,"page-sizes":e.pageParam.pageList,"page-size":e.pageParam.pageSize,total:e.pageParam.total,layout:"->,total, sizes, prev, pager, next"},on:{"size-change":e.querySubmit,"current-change":e.querySubmit}})],1),a("config-info",{ref:"configInfo"})],1)},Xe=[],et={configList:function(e){return h.get("/sys_cfg/list",e)},addConfig:function(e){return h.post("/sys_cfg/add",e)},editConfig:function(e){return h.post("/sys_cfg/edit",e)}},tt=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{attrs:{title:e.edit?"编辑":"新增",visible:e.show,width:"30%","show-close":!1},on:{"update:visible":function(t){e.show=t}}},[a("el-form",{ref:"addConfigForm",attrs:{model:e.data,rules:e.rules,"label-width":"100px"}},[a("el-form-item",{attrs:{label:"key",prop:"key"}},[a("el-input",{attrs:{clearable:!0,disabled:e.edit},model:{value:e.data.key,callback:function(t){e.$set(e.data,"key",t)},expression:"data.key"}})],1),a("el-form-item",{attrs:{label:"值",prop:"value"}},[a("el-input",{attrs:{clearable:!0},model:{value:e.data.value,callback:function(t){e.$set(e.data,"value",t)},expression:"data.value"}})],1),a("el-form-item",{attrs:{label:"名称",prop:"name"}},[a("el-input",{attrs:{clearable:!0,disabled:e.edit},model:{value:e.data.name,callback:function(t){e.$set(e.data,"name",t)},expression:"data.name"}})],1),a("el-form-item",{attrs:{label:"说明",prop:"desc"}},[a("el-input",{attrs:{clearable:!0},model:{value:e.data.desc,callback:function(t){e.$set(e.data,"desc",t)},expression:"data.desc"}})],1),a("el-form-item",{attrs:{label:"类型",prop:"desc"}},[a("el-select",{attrs:{disabled:e.edit},model:{value:e.data.type,callback:function(t){e.$set(e.data,"type",t)},expression:"data.type"}},e._l(e.types,(function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})})),1)],1)],1),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:e.close}},[e._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:e.submitConfig}},[e._v("确 定")])],1)],1)},at=[],nt={name:"ConfigInfo",data:function(){var e=new RegExp("^[5A-Za-z-0-9_]+$"),t=function(t,a,n){""===a?n(new Error("请输入")):e.test(a)?(a.length<1||a.length>20)&&n(new Error("长度在 1 到 20 个字符")):n(new Error("请输入英文、数字与下划线")),n()};return{edit:!1,show:!1,parent:null,data:{key:"",value:"",name:"",desc:"",type:1},types:[{value:0,label:"不可修改的系统配置"},{value:1,label:"可修改的系统配置"},{value:2,label:"用户配置默认值"}],rules:{key:[{validator:t,trigger:"change"}],value:[{required:!0,message:"请输入",trigger:"change"},{min:1,max:20,message:"长度在 1 到 20 个字符",trigger:"change"}],name:[{required:!0,message:"请输入",trigger:"change"},{min:1,max:20,message:"长度在 1 到 20 个字符",trigger:"change"}],desc:[{min:0,max:100,message:"长度在 0 到 100 个字符",trigger:"change"}]}}},methods:{openAdd:function(e){this.edit=!1,this.show=!0,this.parent=e},openEdit:function(e,t){this.edit=!0,this.show=!0,this.parent=e,this.data={key:t.key,value:t.value,name:t.name,desc:t.desc,type:t.type}},close:function(){this.show=!1,this.$refs.addConfigForm.resetFields()},submitConfig:function(){var e=this;this.$refs.addConfigForm.validate((function(t){t&&(f.start("正在提交"),e.edit?et.editConfig(e.data).then((function(t){200===t.code?(e.close(),e.$message.success("编辑成功"),e.parent.querySubmit()):e.$message.success(t.msg)})).finally((function(){f.stop()})):et.addConfig(e.data).then((function(t){200===t.code?(e.close(),e.$message.success("新增成功"),e.parent.querySubmit()):e.$message.success(t.msg)})).finally((function(){f.stop()})))}))}}},rt=nt,st=Object(z["a"])(rt,tt,at,!1,null,"b13eebc6",null),it=st.exports,ot={name:"ComicManager",components:{ConfigInfo:it},data:function(){return{queryParam:{tableLoading:!1,name:""},resultList:[],pageParam:{pageList:ye.pageList,page:1,pageSize:ye.pageSize,total:0}}},mounted:function(){this.search()},methods:{search:function(){this.pageParam.page=1,this.querySubmit()},querySubmit:function(){var e=this;this.queryParam.tableLoading=!0,et.configList({page:this.pageParam.page,pageSize:this.pageParam.pageSize,name:this.queryParam.name}).then((function(t){e.resultList=t.data.list,e.pageParam.total=t.data.count})).finally((function(){e.queryParam.tableLoading=!1}))},addSubmit:function(){this.$refs.configInfo.openAdd(this)},editSubmit:function(e){this.$refs.configInfo.openEdit(this,e)},dateFormatter:function(e,t,a){return xe(a)}}},lt=ot,ut=Object(z["a"])(lt,Qe,Xe,!1,null,"354a579b",null),ct=ut.exports,mt=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("h1",[e._v("this me")])},dt=[],pt={name:"Me"},ft=pt,gt=Object(z["a"])(ft,mt,dt,!1,null,"524615f6",null),ht=gt.exports,bt=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("h1",[e._v("Comic reader")])},vt=[],wt={name:"ComicRead"},yt=wt,_t=Object(z["a"])(yt,bt,vt,!1,null,"5f563de6",null),xt=_t.exports,$t={routers:[{path:"",redirect:"/home"},{path:"/",redirect:"/home"},{path:"/home",component:V,children:[{path:"",redirect:"search"},{path:"search",component:se},{path:"comic",component:me},{path:"series",component:be},{path:"library",component:Ae},{path:"user",component:We},{path:"role",component:Ze},{path:"config",component:ct},{path:"me",component:ht}]},{path:"/comic/reader",component:xt},{path:"/login",component:J},{path:"/404",component:X},{path:"/*",redirect:"/404"}]},Pt=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{attrs:{id:"app"}},[a("router-view")],1)},kt=[],St={name:"App"},Lt=St,Ct=Object(z["a"])(Lt,Pt,kt,!1,null,null,null),zt=Ct.exports;r["default"].config.productionTip=!1,r["default"].use(i.a),r["default"].use(o["a"]),r["default"].use(u.a);var qt=new o["a"]({mode:"history",base:"/",routes:$t.routers}),Et=new r["default"]({render:function(e){return e(zt)},store:P,router:qt}).$mount("#app");function Nt(){return null!==Et.$cookies.get(g.token)}qt.beforeEach((function(e,t,a){Nt()||"/login"===e.path?a():(Et.$message.error("您还没有登陆，请重新登陆"),a("/login"))}));var jt=t["default"]={app:Et}},b639:function(e,t,a){},e8f7:function(e,t,a){},f771:function(e,t,a){}});
//# sourceMappingURL=app.a768b1fe.js.map