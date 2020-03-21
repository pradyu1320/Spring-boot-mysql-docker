FROM openjdk:8
EXPOSE 8080
ADD target/com.pradyu-0.0.1-SNAPSHOT.jar com.pradyu-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/com.pradyu-0.0.1-SNAPSHOT.jar"]