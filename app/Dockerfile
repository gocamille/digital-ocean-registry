FROM openjdk:latest
ADD ./target/api-qonvo-standalone.jar /srv/app/.
# WORKDIR /usr/src/qonvo
CMD [ "java", "-jar", "/srv/app/api-qonvo-standalone.jar" ]