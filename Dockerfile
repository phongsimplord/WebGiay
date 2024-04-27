
FROM maven:3.8.1-openjdk-17 AS builder
# kéo image maven về để để build
WORKDIR /app
# tạo 1 thư mục để chứa ứng dụng trên container
COPY pom.xml .
# copy file pom vào app
RUN mvn dependency:go-offline
# load hết thư viện cần thiết vào app
COPY src ./src
# copy code vào app
RUN mvn package
# chạy để tạo file jar

#đoạn dưới chỉ là dùng jdk chạy file jar đã tạo ở trên
FROM openjdk:17-oracle
WORKDIR /app
COPY --from=builder /app/target/website-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
