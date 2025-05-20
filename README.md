# 👨‍💼 Employee Service API

API REST desarrollada con **Spring Boot 3.4.5** y **Java 21** para la gestión de empleados. Incluye operaciones CRUD, validaciones, logging y documentación Swagger.

---

## 📌 Características

- CRUD completo de empleados (GET, POST, PUT, DELETE)
- Inserción masiva de empleados
- Validaciones personalizadas
- Manejo de excepciones global
- Logging de headers
- Exposición de documentación Swagger UI

---

## 📂 Estructura del proyecto

src/main/java/com/example/employeeservice
├── controller
├── service
├── model
    ├── dto
    ├── entities
├── repository
├── exception
├── interceptors      <-- Logging de headers
├── config            <-- Swagger, log config
└── Application.java

---

## 📦 Modelo de datos

```json
{
  "firstName": "Juan",
  "middleName": "Carlos",
  "lastName": "Pérez",
  "secondLastName": "Gómez",
  "age": 30,
  "gender": "MALE",
  "birthDate": "1993-05-20",
  "position": "Backend Developer"
}
```

---

## 🚀 Endpoints principales

| Método | Endpoint              | Descripción                  |
| ------ | --------------------- | ---------------------------- |
| GET    | `/api/employees`      | Listar todos los empleados   |
| POST   | `/api/employees`      | Crear uno o varios empleados |
| PUT    | `/api/employees/{id}` | Actualizar empleado por ID   |
| DELETE | `/api/employees/{id}` | Eliminar empleado por ID     |

---

## 🔍 Swagger UI

Disponible en:
http://localhost:8080/swagger-ui.html

---

## 🐾 Logging

El sistema loguea automáticamente:

- Método y URI de cada petición
- Headers del request (filtrando sensibles como Authorization)

---

## 🧠 Autor

- Desarrollado por: _Wendy Gabriela Cobo Burelo_
- Contacto: _gaby.burelo@outlook.com_
