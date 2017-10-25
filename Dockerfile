FROM java:8
ADD build/libs/app.jar /
EXPOSE 8080
CMD ["java", "-jar", "/app.jar"]