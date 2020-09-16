# 1. Building the App with Maven
FROM maven:3-jdk-11

ADD . /magicnumber
WORKDIR /magicnumber

# Just echo so we can see, if everything is there :)
RUN ls -l

# Run Maven build
RUN mvn clean install


# 2. Just using the build artifact and then removing the build-container
FROM openjdk:11-jdk

MAINTAINER Phellipe Rodrigues

VOLUME /tmp

# Add Spring Boot app.jar to Container
COPY --from=0 "/magicnumber/target/magicnumber.jar" app.jar

# Fire up our Spring Boot app by default
CMD [ "sh", "-c", "java $JAVA_OPTS -Dspring.profiles.active=prod -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]