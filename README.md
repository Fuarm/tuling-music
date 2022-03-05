### Spring Boot 项目学习笔记

### 1、微信云托管

使用微信提供的云服务，需要配置 Dockerfile 和  container.config.json

> Dokcerfile 配置使用 spring.config.import 引入的文件：
>
> 1、Docker 中分为*构建*和*运行*两种环境
> 
> 2、需要在构建运行镜像后 COPY 文件到 `/app`目录

### 2、mysql 数据库 配置

spring boot 的 application.properties 配置

### 3、db migration 脚本

自动生成 flayway 库 执行的 sql 空白 文件

```sh
if [ -n "$1" ];then
  newSqlFile=src/main/resources/db/migration/V`date +%Y%m%d%H%I%S`__${1}.sql
  touch $newSqlFile
  echo "a new migration script generated at: "$newSqlFile
else
  echo "请输入迁移脚本名称"
fi
```

### 4、 flyway 库：db 执行库
> ***注意：***
> 
> 1、flyway 7 社区版仅**支持** mysql8.* 版本
>
> 2、flyway 5.2.* 社区版支持 mysql5.7

### 5、lombok 库： Entity Class get/set 自动生成

Entity Class 中添加 @Data（class） 和 @Id（属性） 注解

### 6、 ksuid 生成器
```xml
<dependency>
    <groupId>com.github.ksuid</groupId>
    <artifactId>ksuid</artifactId>
    <version>1.0.0</version>
</dependency>
```

### 7. Spring DataJPA

### 8. JWT 鉴权
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
    <groupId>com.auth0</groupId>
    <artifactId>java-jwt</artifactId>
    <version>3.18.2</version>
</dependency>
```

### 9. 全局异常统一处理

借助 @RestController 和 @RestControllerAdvice 注解实现controller层全局异常捕获处理

### 10. Swagger

```xml
<!--   Swagger     -->
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-boot-starter</artifactId>
    <version>3.0.0</version>
</dependency>
```
