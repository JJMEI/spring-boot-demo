FROM java:8
VOLUME /tmp
ADD spring-boot-freemarker-i18n.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
