# POSTMAN
# SOAP

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:web="http://udem.edu.co/isv/ejemplo-soap">
    <soapenv:Header/>
    <soapenv:Body>
        <web:getCountryRequest>
            <web:name>Colombia</web:name>
        </web:getCountryRequest>
    </soapenv:Body>
</soapenv:Envelope>

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:web="http://udem.edu.co/isv/ejemplo-soap">
    <soapenv:Header/>
    <soapenv:Body>
        <web:registerCountryRequest>
            <web:country>
                <web:name>Colombia</web:name>
                <web:population>50882891</web:population>
                <web:capital>Bogotá</web:capital>
                <web:currency>Peso</web:currency>
            </web:country>
        </web:registerCountryRequest>
    </soapenv:Body>
</soapenv:Envelope>

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:web="http://udem.edu.co/isv/ejemplo-soap">
    <soapenv:Header/>
    <soapenv:Body>
        <web:deleteCountryRequest>
            <web:name>Colombia</web:name>
        </web:deleteCountryRequest>
    </soapenv:Body>
</soapenv:Envelope>


<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:web="http://udem.edu.co/isv/ejemplo-soap">
    <soapenv:Header/>
    <soapenv:Body>
        <web:getAllCountriesRequest/>
    </soapenv:Body>
</soapenv:Envelope>

# REST
localhost:8080/swagger-ui.html
 # GRPC
Para cualquier método
{
  "numero1": 5.0,
  "numero2": 3.0
} 

# GraphQL
{
  "query": "mutation CreateAuthor($name: String!, $thumbnail: String!) { createAuthor(name: $name, thumbnail: $thumbnail) { id name thumbnail } }",
  "variables": {
    "name": "",
    "thumbnail": "URL IMAGEN"
  }
}

{
  "query": "mutation { createPost( title: \"Nuevo título\", text: \"Contenido del post\", category: \"Nueva categoría\", authorId: \"9b558386-c014-457f-8e3a-a698b5bea1d1\" ) { id title text category author { id name thumbnail } } }"
}




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

# TAREAS: PRIMERA PARTE

---

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

# Tema 4: GraphQL
Este ejemplo ha sido desarrollado siguiendo como guía el tutorial disponible en: https://www.baeldung.com/spring-graphql.
Provee funcionalidades para consultar información acerca de posts y sus autores. El servidor está disponible en la URL: http://localhost:8080/graphql. 
La colección de Postman disponible en el proyecto contiene llamados para consumir los recursos.


## Tarea 4:
Modificar la aplicación para que la información consultada en los DAOs provenga de una base de datos en memoria (H2) y que se apoye en Spring Data.


# TAREAS: SEGUNDA PARTE

---

# Tema 5: Testing
Las pruebas unitarias y de integración juegan un papel crucial para garantizar la calidad de un producto de software. La planeación, implementación y mantenimiento 
de éstas impactará de manera significativa los tiempos de desarrollo y la capacidad para agregar nuevas funcionalidades.


## Tarea 5:
Seguir el tutorial expuesto en la página: https://developer.okta.com/blog/2019/03/28/test-java-spring-boot-junit5. Agregar una nueva funcionalidad que permita determinar
el número de años, meses, semanas, días, horas, minutos y segundos que han transcurrido desde la fecha de nacimiento ingresada. Agregar sus respectivos tests.


# Tema 6: Kubernetes (K8S)
En el medio actual, donde la nube se ha convertido en una pieza fundamental en el desarrollo de software y donde la cultura DEVOPS ha permeado toda la industria,
K8S surge como una herramienta vital para orquestar el despliegue contenerizado de aplicaciones. Comprender sus elementos básicos resulta relevante para cualquier
desarrollador de software bien informado.

## Tarea 6:
Realizar el tutorial expuesto en: https://learnk8s.io/spring-boot-kubernetes-guide. Desplegarlo de manera local usando Minikube.
