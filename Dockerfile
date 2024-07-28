FROM openjdk:17-jdk-alpine

EXPOSE 8080

ADD target/virtual_power_plant.jar virtual_power_plant.jar

ENTRYPOINT ["java","-jar","virtual_power_plant.jar"]

