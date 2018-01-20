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
docker run -itd -p 8081:8080 --name springotameshi 50a160b967d2<IMAGE ID> 
 
http://localhost:8081/
でアクセス。

止める時は、

docker stop springotameshi


pcf用のコマンド
  ./gradlew clean build
  cf login
  cf push mforumapp -p build/libs/springotamashi-0.0.1-SNAPSHOT.jar 
  
  cf push p build/libs/springotamashi-0.0.1-SNAPSHOT.jar --route-path mforumapp
  
　https://mforumapp.cfapps.io/  

