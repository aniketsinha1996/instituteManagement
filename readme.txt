Docker command:-

1. docker build institute-management .
2. docker run --name=mysql-db -e MYSQL_ROOT_PASSWORD=aniket@123 -d mysql:8.0.28   //to pull mysql image
3. docker run -p 8080:8006 --name mysqldb -e MYSQL_ROOT_PASSWORD=aniket@123 -e MYSQL_DATABASE=institutemanagementsystem mysql:8.0.28 //to create mysql container
4.  docker network create networkmysql //To create the network:-
5. docker network connect networkmysql mysqldb //to connect to mysql instance
6. docker run -p 8000:8007 --name institute-management --net networkmysql -e MYSQL_HOST=mysqldb -e MYSQL_PORT=3306 -e MYSQL_DB_NAME=institutemanagementsystem -e MYSQL_USER=root -e MYSQL_PASSWORD=aniket@123 institute-management  //to finally run the app
