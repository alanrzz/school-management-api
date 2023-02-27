 # School Management Api :school:

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
Para empezar a utilizar la API debe contar con un token de acceso. Este token se genera
realizando una petición POST a **`/authentication/signup`** con un usuario, contraseña y rol.

**Ejemplo:**
```json
{
  "email": "admin@admin.com",
  "password": "admin",
  "roles": [
    "admin"
  ],
  "username": "admin"
}
```
Luego de haber registrado el usuario, debe autenticarlo con una petición POST a **`/authentication/login`** enviando sus credenciales.

**Ejemplo:**
```json
{
  "password": "admin",
  "username": "admin"
}
```
Si todo sale bien, deberías recibir una respuesta similar a esta con los datos del usuario (esto significa que ya estás autenticado):
```json
{
  "id": 1,
  "username": "admin",
  "email": "admin@admin.com",
  "roles": [
    "ROLE_ADMIN"
  ],
  "accessToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHJpbmciLCJpYXQiOjE2Nzc1MTMwMjAsImV4cCI6MTY3NzU5OTQyMH0.hmvQlQverQAvy9Q45Jr8STo9ENBiXqhbEil5tKbpZsAFERYKYnZZtSEuyyqGsCHsQxo0R-F3GOljAemZWwUEkw",
  "type": "Bearer"
}
```

### Tecnologías utilizadas
* [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
* [SpringBoot](https://spring.io/projects/spring-boot)
* [Hibernate](https://hibernate.org/)
