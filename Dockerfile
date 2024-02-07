FROM openjdk:17-jdk-alpine
EXPOSE 8081
ADD target/demoSpringBoot-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java","-jar","/demoSpringBoot-0.0.1-SNAPSHOT.jar"]