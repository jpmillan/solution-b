FROM java:8
WORKDIR /app
ARG JAR_FILE=target/solution-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} /app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]