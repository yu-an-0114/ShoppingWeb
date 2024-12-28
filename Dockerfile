# 基於 Windows 平台的 Java 17 映像
FROM mcr.microsoft.com/openjdk/jdk:17-windowsservercore-ltsc2022 AS windows_base
FROM openjdk:17-jdk-slim

# 設置工作目錄
WORKDIR /app

# 複製 Spring Boot 應用的 JAR 文件
COPY . .

# 在容器中构建 Spring Boot 应用
RUN ./mvnw clean package -DskipTests
# 将构建的 JAR 文件重命名并移动到指定位置
RUN mv target/ShoppingWeb-0.0.1-SNAPSHOT.jar ShoppingWeb.jar
# 暴露容器的 8080 端口
EXPOSE 8080

# 啟動 Spring Boot 應用
ENTRYPOINT ["java", "-jar", "ShoppingWeb.jar"]
