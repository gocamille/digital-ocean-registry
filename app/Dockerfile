FROM openjdk:latest
WORKDIR /srv/app
ARG HOSTNAME
ARG KUBERNETES_PORT
ADD ./target/api-qonvo-standalone.jar .
CMD [ "java", "-jar", "api-qonvo-standalone.jar" ]