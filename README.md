# comic-manager

#### 突发奇想，目标是做一个简单的漫画管理工具，以管理数百到几千本漫画为目标，个人使用，顺便在用一些自己不太常用的组件。

### 下面是主要要实现的目标

* 前端
  * 标准功能：
    * 登录(页面权限校验)
    * 主页：漫画搜索，显示过滤条件：漫画名(模糊搜索)，标签，评分；隐藏过滤条件：用户兴趣组
    * 漫画阅读：阅读，评分，增加漫画标签，下载
    * 我：登出，更换用户名
  * 管理员功能：
    * 漫画管理：新增删除漫画，新增删除标签，删除漫画会提示是否删除漫画文件。
    * 系列管理：新增删除系列，移出移入漫画到系列
  * 超级管理员：
    * 用户管理：新增删除编辑用户，设定用户角色，兴趣圈
    * 角色管理：新增删除编辑角色，设定角色权限
    * 兴趣圈管理：新增删除兴趣圈，配置兴趣圈书库路径(暂时准备支持文件，smb)，兴趣圈文件扫描，删除兴趣圈只会删除漫画索引，不会真的删除漫画。
    * 配置管理：配置参数管理，目前仅有登陆超时时间，是否启动登陆超时时间，漫画前端缓存页数。
* 后端
  * 以上所有的接口
  * 兴趣圈扫描简单支持zip/文件夹识别
  * 导入文件以zip包存在兴趣圈根目录当天的文件夹下面
* 数据库
  * Mysql(我甚至想用sqlite)
* 目前预想的安装方案：
  * 手动：数据库安装（mysql），ddl执行，java服务启动
  * Docker：mysql的Docker为基础镜像，把服务和数据库放在一起（真就没必要高性能高可用，我甚至想用sqlite）

### 下面是次要目标

* 移动端：实现前端功能
* S3、hdfs、mongo来进行文件存储
* 兼容其他DB

## License

    Copyright 2020 traburiss

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
