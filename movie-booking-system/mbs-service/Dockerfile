FROM openjdk:8-alpine
COPY build/libs/mbs-service-*.jar /usr/local/bin/mbs-service.jar
RUN chmod +x /usr/local/bin/mbs-service.jar
ENTRYPOINT ["java", "-jar", "/usr/local/bin/mbs-service.jar"]