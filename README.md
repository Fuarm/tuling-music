### Spring Boot 项目学习笔记

### 1、微信云托管

使用微信提供的云服务，需要配置 Dockerfile 和  container.config.json

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

### 5、lombok 库： Entity Class get/set 自动生成

Entity Class 中添加 @Data（class） 和 @Id（属性） 注解

### 6、 ksuid 生成器
```xml
# 依赖

<dependency>
    <groupId>com.github.ksuid</groupId>
    <artifactId>ksuid</artifactId>
    <version>1.0.0</version>
</dependency>
```

### 7. Spring DataJPA

