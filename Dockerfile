FROM openjdk:17
COPY build/libs/regiondict.jar opt/regiondict.jar
ENTRYPOINT ["java", "-jar", "opt/regiondict.jar"]