FROM java:8
WORKDIR /home
RUN apt-get -y update && apt-get -y install
COPY ./GRPC_Server-0.0.1-jar-with-dependencies.jar /home/GRPC.jar
CMD ["java","-jar","/home/JRPC.jar"]