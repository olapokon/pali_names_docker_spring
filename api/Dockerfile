FROM openjdk:11

WORKDIR /usr/src/app_api

ARG JAR_FILE=target/*.jar
ARG DB_FILE=db/*mv.db

COPY ${JAR_FILE} /usr/src/app_api/target/app.jar
COPY ${DB_FILE} /usr/src/app_api/db/pali_names_database.mv.db

CMD ["java","-jar", "target/app.jar"]