FROM java:8-jdk-alpine

WORKDIR /opt

ADD user-api/build/libs/user-api.jar user-api.jar

EXPOSE 8081

ENTRYPOINT ["/usr/bin/java"]

CMD ["-jar",  "/opt/user-api.jar"]