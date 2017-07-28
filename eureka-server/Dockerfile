FROM java:8-jdk-alpine

WORKDIR /opt

ADD user-api/build/libs/eureka-server.jar eureka-server.jar

EXPOSE 8761

ENTRYPOINT ["/usr/bin/java"]

CMD ["-jar",  "/opt/eureka-server.jar"]