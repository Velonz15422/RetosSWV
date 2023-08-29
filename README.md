# Repositorio para el curso Ingeniería de Software V - UdeM

Este repositorio contendrá todos los ejemplos desarrollados durante el semestre. 
De igual manera, aquí pueden encontrar la información asociada a las entregas que 
deben ser realizadas periódicamente.

Por lo general, todos los ejemplos serán realizados usando como herramientas:
- IntelliJ IDEA Ultimate (pueden acceder a la licencia de estudiantes con sus correos institucionales).
- Java 17+
- Spring boot 3+
- Postman.
- Docker Desktop.
- SourceTree.


# Tema 1: SOAP - Simple Object Access Protocol

Este ejemplo fue realizado siguiendo el tutorial disponible en https://spring.io/guides/gs/producing-web-service/


## Tarea 1: 
Con base en este ejemplo trabajado en clase implemente las siguientes funcionalidades:
* Registrar país.
* Listar todos los países.
* Eliminar país.


# Tema 2: REST - Representational State Transfer
Este ejemplo expone una API REST básica que retorna un saludo como respuesta. El saludo simple puede ser consumido en:  
http://localhost:8080/greeting y el saludo a un nombre en particular en: http://localhost:8080/greeting/{cualquier_nombre}

Para acceder a la herramienta OpenAPI basta con navegar a: http://localhost:8080/swagger-ui.html

## Tarea 2: 
En el ejemplo anterior se hizo uso de una variable enviada en el path (@PathVariable), con base en el ejemplo, implemente 
las siguientes funcionalidades:
* Cree un servicio RESTful que responda a un saludo enviando como parámetro un nombre en la petición (@RequestParam)
* Cree un servicio RESTful que responsa a un saludo enviando como parámetro los nombres y apellidos en un objeto (@RequestBody)


# Tema 3: gRPC
Este ejemplo ha sido desarrollado siguiendo como guía el tutorial disponible en: https://www.baeldung.com/grpc-introduction
Permite exponer un servicio que recibe como parámetro el nombre y apellido de un individuo y retorna como respuesta un saludo.
El servidor se encuentra disponible en: http://localhost:8080


## Tarea 3:
Crear una aplicación con gRPC que exponga 4 métodos remotos:
* sumar
* restar
* multiplicar
* dividir

Todos los métodos deben recibir como parámetros dos números decimales y retornar un valor decimal.
