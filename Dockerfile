#FROM openjdk:17
FROM public.ecr.aws/docker/library/openjdk:17

COPY ./build/libs/tafuserservice.jar tafuserservice.jar
EXPOSE 8082
CMD ["java","-jar","tafuserservice.jar"]