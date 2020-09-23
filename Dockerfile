#stage1
FROM tomcat:jdk8 AS Base
EXPOSE 8080

#stage2
FROM maven:latest AS Build
WORKDIR /app

COPY . ./
RUN mvn clean package -DskipTests=true

FROM Base AS Final
COPY --from=Build /app/target/saudedohomem.war ./webapps/
CMD ["catalina.sh", "run"]