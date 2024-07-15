# 第一阶段-使用maven镜像打包项目jar
FROM maven:3.8.7-eclipse-temurin-8 AS compile-stage

ENV PROJECT_NAME eureka-service
ENV WORK_PATH /usr/src/$PROJECT_NAME

ADD . $WORK_PATH

WORKDIR $WORK_PATH

RUN --mount=type=cache,target=/root/.m2,id=maven-cache mvn -B -Dmaven.test.skip clean package

# 第二阶段-运行jar
FROM eclipse-temurin:8u372-b07-jre-centos7 AS deploy-stage

ENV PROJECT_NAME eureka-service
ENV WORK_PATH2 /app

WORKDIR $WORK_PATH2

# 复制上一阶段的jar
COPY --from=compile-stage $WORK_PATH/target/$PROJECT_NAME.jar .

ADD runboot.sh /app/

RUN chmod a+x runboot.sh

CMD ["sh","-c","/app/runboot.sh"]