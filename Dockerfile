FROM java:8
EXPOSE 8080
ADD /target/rating-comments-0.0.1-SNAPSHOT.jar rating-comments-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","rating-comments-0.0.1-SNAPSHOT.jar"]
