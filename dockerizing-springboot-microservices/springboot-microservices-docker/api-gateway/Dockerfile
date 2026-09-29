FROM eclipse-temurin:26-jre

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 9191

ENTRYPOINT ["java", "-jar", "app.jar"]