FROM openjdk:8-jdk-alpine

RUN mkdir /opt/rubikxapi
ADD . / /opt/rubikxapi/

WORKDIR /opt/rubikxapi

RUN ./gradlew build

RUN cp build/libs/*.jar /opt/app.jar

ENTRYPOINT ["java","-jar","/opt/app.jar"]
