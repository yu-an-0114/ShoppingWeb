# 使用官方 OpenJDK 作为基础镜像
FROM openjdk:23-jdk-slim

# 设置工作目录
WORKDIR /app

# 将本地的 Spring Boot JAR 文件拷贝到容器中
COPY target/ShoppingWeb-0.0.1-SNAPSHOT.jar /app/ShoppingWeb.jar

# 暴露容器的 8080 端口
EXPOSE 8080

# 启动 Spring Boot 应用
ENTRYPOINT ["java", "-jar", "ShoppingWeb.jar"]
