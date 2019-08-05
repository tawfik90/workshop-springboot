FROM java:8
LABEL maintainer=“ahmed.tawfik.is@gmail.com”
VOLUME /tmp
EXPOSE 8080
ADD target/demo.jar demo.jar
ENTRYPOINT ["java","-jar","demo.jar"]