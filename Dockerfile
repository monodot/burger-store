# Build the application first using Maven
FROM docker.io/library/maven:3.8-eclipse-temurin-11 as build
WORKDIR /app
COPY . .
RUN mvn install

# Inject the JAR file into a new container to keep the file small
FROM docker.io/library/eclipse-temurin:11-jre
WORKDIR /app
COPY --from=build /app/target/burger-store-*.jar /app/app.jar

RUN curl -L https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/download/v1.15.0/opentelemetry-javaagent.jar -o /app/opentelemetry-javaagent.jar

EXPOSE 8080
ENTRYPOINT ["java","-javaagent:/app/opentelemetry-javaagent.jar","-jar","/app/app.jar"]

