FROM openjdk:8-jdk-alpine

ADD target/interview-todoapp-0.0.1-SNAPSHOT.jar todoApp.jar

EXPOSE 8080

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /todoApp.jar" ]