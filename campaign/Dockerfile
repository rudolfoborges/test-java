FROM java:8-jdk-alpine

WORKDIR /opt

ADD campaign-api/build/libs/campaign-api.jar campaign-api.jar

EXPOSE 8080

ENTRYPOINT ["/usr/bin/java"]

CMD ["-jar",  "/opt/campaign-api.jar"]