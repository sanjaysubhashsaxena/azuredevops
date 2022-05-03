FROM openjdk:8
VOLUME /tmp
COPY /target/ProductService-0.0.1.jar spring.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "spring.jar"]