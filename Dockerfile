From openjdk:8
EXPOSE 8080
ADD target/SpringAngularConnect-0.0.1-SNAPSHOT.war  SpringAngularConnect-0.0.1-SNAPSHOT.war
ENTRYPOINT [ "java","-jar","/SpringAngularConnect-0.0.1-SNAPSHOT.war" ]
