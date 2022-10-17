# School Management Api

### Introducción
API REST desarrollada con el objetivo de mantener el registro de distintos datos en una institución educativa.

### Características
* CRUD: estudiantes, profesores, cursos, etc.
* Generación de reportes en formato PDF.
* Autenticación de usuarios basada en roles. 
* Documentación con Swagger.

### Guía de instalación
* Clonar el repositorio desde la [siguiente dirección](https://github.com/alanrzz/school-management-api.git).
* Asegurarse de estar en la rama principal, es la más estable después de los lanzamientos.
* Instalar maven con el siguiente comando:
```
sudo apt install maven
```
* Por defecto se utilizará una base de datos en memoria H2. Puede configurarse a elección en el archivo de entrada [application.yml](https://github.com/alanrzz/school-management-api/blob/main/src/main/resources/application.yml)

### Uso
* Iniciar la aplicación:
```
mvn spring-boot:run
```
* Conectarse a la API en el puerto 8080, usando alguna herramienta como [Postman](https://www.postman.com/) / [Insomnia](https://insomnia.rest/) o bien desde [Swagger](http://localhost:8080/swagger-ui/).

### Ejemplo de puntos finales de estudiantes
| Método HTTP | Punto Final | Acción |
| --- | --- | --- |
| GET | /api/students | Obtener todos los estudiantes |
| GET | /api/students/:id | Obtener un estudiante por su ID |
| POST | /api/students | Registrar un nuevo estudiante |
| PUT | /api/students/:id | Editar un estudiante por su ID |
| DELETE | /api/students/:id | Eliminar un estudiante por su ID |

### Autorización
🏗️...

### Tecnologías utilizadas
* [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
* [SpringBoot](https://spring.io/projects/spring-boot)
* [Hibernate](https://hibernate.org/)
