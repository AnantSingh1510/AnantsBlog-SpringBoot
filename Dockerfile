FROM openjdk:17-jdk

COPY target/Blog.jar .

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "Blog.jar"]