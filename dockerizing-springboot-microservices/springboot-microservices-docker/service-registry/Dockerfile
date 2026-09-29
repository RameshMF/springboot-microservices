FROM eclipse-temurin:26-jre

WORKDIR /app

COPY /target/*.jar app.jar

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "app.jar"]