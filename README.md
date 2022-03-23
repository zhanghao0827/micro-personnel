# 员工管理系统

>**演示**：http://120.48.10.133:8888/index.html
>
>**前端项目地址**：https://github.com/zhanghao0827/micro-personnel-ui
>
>**个人主页**：https://hao2coding.gitee.io/icoding

## 介绍

基于Spring Boot开发，支持用户管理、权限管理、部门管理、员工管理、邮箱服务、日志管理等功能。

技术: Spring、Spring MVC、MyBatis、WebSocket、POI



## 快速部署

### 准备工作 

JDK (推荐 1.8 版本) 

Mysql (5.7 或 8.0 版本) 

5/76/7 

Redis >= 3.0 

Maven >= 3.0 

Node >= 10 (推荐长期支持版) 

### 必要配置 

#### 数据库

创 建 mysql 数 据 库 micro_personnel（ 字 符 集 为 utf8 ） ， 并 导 入 sql 文 件 

`micro-personnel/src/main/resources/micro_personnel.sql`

#### 文件上传

[安装FastDFS](https://hao2coding.gitee.io/icoding/#/middleware/fastdfs/)，在`micro-personnel/src/main]/resources/fastdfs-client.properties` 配置相关信息



### 项目启动 

#### 启动后端 

使用 IntelliJ IDEA(推荐)或 Eclispe 导入后端项目工程 ，由于使用 Maven 进行依赖管理，IDE 需要集成 Maven 配置，初次导入会自动下载所需依赖包，请耐心等待。(推荐 Maven 使用阿里云镜像)。 

修改`micro-personnel/src/main/resources/application.properties`配置文件，修改 mysql和 redis 的连接信息（如：账号，密码，端口等） 

依赖下载完成后，运行 `com.easyhao.micro.personnel.MicroPersonnelApplication.java ` 启动类 



#### 启动前端 

1. 进入前端项目 

   cd micro-personnel-ui

2. 安装前端依赖 

   npm install --registry=https://registry.npm.taobao.org 

3. 本地开发模式启动项目 

   npm run dev 



### 提示

因为本项目是前后端完全分离的，所以需要前后端都单独启动好，才能进行访问。 

如果 npm install 报错，可以使用安装 yarn 

npm install -g yarn 

yarn config set registry https://registry.npm.taobao.org -g 

使用 yarn install 安装前端所需依赖



## 联系我

>若有任何问题，可添加本人微信

<img src="https://zhang-hao.oss-cn-beijing.aliyuncs.com/wechat.JPG" style="zoom: 33%;" />