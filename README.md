# springotameshi

データ投入

 curl -H 'Content-Type:application/json' -H "Accept: application/json" -X POST -d '{"id":"id001","name":"takahashi","age":"33"}' http://localhost:8080/employees
 ⇨失敗？？
 
 http://localhost:8080/employees/
 
 {
"_embedded": {
"employees": [
{
"name": "taka",
"age": 33,
"_links": {
"self": {
"href": "http://localhost:8080/employees/u001"
},
"employee": {
"href": "http://localhost:8080/employees/u001"
}
}
}
]
},
"_links": {
"self": {
"href": "http://localhost:8080/employees{?page,size,sort}",
"templated": true
},
"profile": {
"href": "http://localhost:8080/profile/employees"
}
},
"page": {
"size": 20,
"totalElements": 1,
"totalPages": 1,
"number": 0
}
}


## Springfox(swaggerUI)　　

* 初回は以下実行要  

 ./gradlew cleanIdea idea

*  通常起動
　　
 ./gradlew bootrun

* アクセス　　

http://localhost:8080/swagger-ui.html

http://localhost:8080/v2/api-docs?group=public

dockerお試し

https://plugins.gradle.org/plugin/com.palantir.docker

* Spring-boot-dockerプロジェクト

https://spring.io/guides/gs/spring-boot-docker/

sudo ./gradlew build docker

> Task :docker
Get https://registry-1.docker.io/v2/library/openjdk/manifests/8-jdk-alpine: unauthorized: incorrect username or password

が出た時は認証が必要。

docker login

コマンドでログインしておく。

上記でダメなら、、jar作成後、自分でdocker　buildする。

docker build . -f build/docker/Dockerfile 
docker ps コマンドでビルドしたイメージのIDを確認
//docker run -it  <IMAGE ID> -p 8081:8080
docker run -d -p 8081:8080 <IMAGE ID>
 
 localhost:8081で外部からアクセス。