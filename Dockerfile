FROM eclipse-temurin:11-jdk-jammy

WORKDIR /app

COPY target/*.jar /app/scientific-calculator.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/scientific-calculator.jar"]
