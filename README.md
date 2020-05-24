# comic-manager
##### 突发奇想，目标是做一个简单的漫画管理工具，个人使用。

##### 下面是主要要实现的目标

1. 前端
   1. 简单用户系统（登陆校验即可）
   2. 简单组织系统（组织决定漫画的范围）
   3. 漫画导入，下载，删除，查看，标题，简单介绍，标签，评分
   4. 相关配置，包括本地路径，导入后的压缩等级，翻页，因为目标是在个人局域网的NAS上部署，所以图片肯定要尽可能的清晰。
2. 后端
   1. 上面前端的接口
   2. 支持本地文件的扫描，支持包括zip包，文件夹路径的导入
   3. 尽可能的提高性能，之前用过一个类似的东西，问题就在于性能不好
   4. 数据库采用mysql
3. 移动端
   1. 同前端功能