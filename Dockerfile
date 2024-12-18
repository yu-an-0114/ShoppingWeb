
FROM openjdk:17-jdk-slim

RUN apt-get update && apt-get install -y wget gnupg mariadb-server && apt-get clean

ENV MYSQL_ROOT_PASSWORD="yuan1234"
ENV MYSQL_DATABASE="ShoppingWeb"

WORKDIR /app
COPY target/ShoppingWeb-0.0.1-SNAPSHOT.jar /app/ShoppingWeb.jar
EXPOSE 8080 3306
CMD ["sh", "-c", "service mysql start && java $JAVA_OPTS -jar /app/ShoppingWeb.jar"]
