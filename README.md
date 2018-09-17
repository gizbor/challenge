Prerequisitos:
- JDK 1.8
- Apache Maven instalado (setear en la variable de ambiente PATH la ruta al mvn.exe) 
- Base de datos: MySQL 

Ejecución desde consola CMD de Windows:
- git clone https://github.com/gizbor/challenge finger-print
- cd finger-print
- Crear base de datos, usuario "fingerprint" y tabla "finger_print_log"
	- Ver finger-print-db-setup.sql con ejemplo.
	- Puede cambiar la configuración en resources/application.properties
- Abrir terminal CMD
- Setear JAVA_HOME al JDK 1.8 (Ejemplo: set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_181)
- Iniciar API: mvnw spring-boot:run (para detener: Ctrl+C)


Importar en Eclipse:
- git clone https://github.com/gizbor/challenge finger-print
- Abra el Eclipse
- File -> Import -> Maven -> Existing Maven project y seleccione la carpeta "finger-print"

Ejecutar desde Eclipse:
- Abra "Run configuration" (en el botón verde "Run")
- Crear una nueva "Java Application"
- Complete los datos:
	- Name: finger-print
	- Main class: com.necar.fingerprint.FingerPrintApplication
	- Project: finger-print
- Presione "Run"

Ejemplos de petición con CURL:

curl -X POST -H 'Content-Type: application/json' -H 'Accept: application/json' -i http://localhost:8080/fingerPrint --data '{"matrix":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]}'

curl -X POST -H 'Content-Type: application/json' -H 'Accept: application/json' -i http://localhost:8080/stats
