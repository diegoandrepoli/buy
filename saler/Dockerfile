FROM java:8-jdk-alpine


COPY ./target/saler-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app


RUN sh -c 'touch saler-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","saler-0.0.1-SNAPSHOT.jar"]
