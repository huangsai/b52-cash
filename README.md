# b52-cash

* Android Studio 4.1.2 + Gradle 6.8.8
* Java 8 + Kotlin 1.4.30
* Jetpack
* MVVM + MVI


# 模块说明
 
在多模块和组建化开发流的指导思想下，工程划分为app-store、app-views、app-core、app-github、bundle-x模块

重要的事情说三遍：

bundle-x模块之间不存在直接依赖关系且代码天然隔绝，他们的调用关系统一下沉到app-core模块！！！

bundle-x模块之间不存在直接依赖关系且代码天然隔绝，他们的调用关系统一下沉到app-core模块！！！

bundle-x模块之间不存在直接依赖关系且代码天然隔绝，他们的调用关系统一下沉到app-core模块！！！


## app-store模块

持久层，纯java代码实现


## app-views模块

静态资源包括图片、布局文件、颜色、字符串、尺寸


## app-core模块

android平台层、功能模块之间路由、工具集合


## app-github模块

用于修改或二次封装开源代码


## bundle-main模块

启动页、首页、设置、app更新等


## bundle-authenticator模块

用户登录注册、身份验证


## bundle-payment模块

支付相关、交易相关


## bundle-im模块

在线客服、im聊天模块


## 代码组织规则

- 代码模式请参照已有代码

- APP出现的文字全都封装起来

- APP文字大小、颜色值统一用xml配置文件

- APP顶部标题各个样式的UI统一封装

- APP下拉刷新、上拉加载、页面loading、弹窗统一，特殊样式除外

- APP同一个模块下，相同UI可以共用，否则就复制粘贴再修改


## 命名规范

- 全局采用驼峰命名

- 布局xml命名：模块_功能_activity/fragment/layout

- 资源图片命名：模块_功能_功能_bg/icon...

- 资源drawable命名：模块_功能_功能_drawable...

- 资源selector命名：模块_功能_功能_selector...

- 资源color命名：模块_功能_功能_color...