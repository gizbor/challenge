Precondiciones
- JDK 1.8
- Apache Maven instalado. 
- Base de datos: MySQL 

Ejecución
1) Setear la base de datos.
finger-print-db-setup.sql
2) Abrir CMD
3) Setear JAVA_HOME: set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_181
4) mvnw spring-boot:run (para detener: Ctrl+C)


Ejemplos de petición:

curl -X POST -H 'Content-Type: application/json' -H 'Accept: application/json' -i http://localhost:8080/fingerPrint --data '{"matrix":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]}'

curl -X POST -H 'Content-Type: application/json' -H 'Accept: application/json' -i http://localhost:8080/stats
