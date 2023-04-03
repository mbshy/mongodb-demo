# mongodb-demo
expense tracker with Spring
+ MongoDB
+ Lombok
+ Junit,AssertJ,TestContainers
+ Domain Driven Design
+ Document Transfer Object
+ Swagger UI


## Running inside Docker
```shell
./mvnw -Pcompose clean install
docker build -t shiravand/mongodb-demo .
docker compose up
```
