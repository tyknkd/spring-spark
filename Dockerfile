# syntax=docker/dockerfile:1
FROM eclipse-temurin:11-jre-jammy AS jre-jammy-spark
RUN curl https://archive.apache.org/dist/spark/spark-3.3.2/spark-3.3.2-bin-hadoop3-scala2.13.tgz -o spark.tgz && \
    tar -xf spark.tgz && \
    mv spark-3.3.2-bin-hadoop3-scala2.13 /opt/spark && \
    rm spark.tgz
ENV SPARK_HOME="/opt/spark"
ENV PATH="${PATH}:/opt/spark/bin:/opt/spark/sbin"

FROM gradle:8.4-jdk11 AS gradle-build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM jre-jammy-spark AS app
RUN mkdir -p /app
COPY --from=gradle-build /home/gradle/src/build/libs/*-0.1.jar /app/app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]