FROM alpine:latest

MAINTAINER br.com.beblue

RUN echo "http://dl-cdn.alpinelinux.org/alpine/v3.4/community" >> /etc/apk/repositories
RUN apk update
RUN apk add openjdk8-jre

EXPOSE 8080

RUN mkdir -p /app

WORKDIR /app

ENV JAVA_HOME /usr/lib/jvm/java-1.8-openjdk

COPY ./build/libs/app-0.0.1-SNAPSHOT.jar /app

ENTRYPOINT ["java", "-jar","/app/app-0.0.1-SNAPSHOT.jar"]