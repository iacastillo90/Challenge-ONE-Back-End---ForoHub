# 🌟 Foro Hub API

¡Bienvenido a **Foro Hub API**! 🎉  
Una API REST para gestionar tópicos en un foro de aprendizaje colaborativo.  

---

## 📝 **Descripción**  

Este proyecto fue desarrollado como parte de un desafío de Back End. El objetivo es simular el backend de un foro donde estudiantes, profesores y moderadores pueden interactuar mediante la creación, visualización, actualización y eliminación de tópicos relacionados con cursos y proyectos.  

Este foro es ideal para fomentar el aprendizaje colaborativo. ¡Manos a la obra! 🚀  

---

## 🎯 **Objetivos**  

✅ Crear un nuevo tópico.  
✅ Mostrar todos los tópicos creados.  
✅ Mostrar un tópico específico.  
✅ Actualizar un tópico.  
✅ Desactivar (eliminar lógicamente) un tópico.  

---

## ⚙️ **Tecnologías Utilizadas**  

Estas son las herramientas y tecnologías que hacen posible este proyecto:  

- **Java 17** ☕  
- **Spring Boot** 🌱 (Framework para la creación de APIs REST)  
- **JPA (Java Persistence API)** 🗄️ (Para la persistencia de datos)  
- **MySQL** 🐬 (Base de datos relacional)  
- **Lombok** 📌 (Para evitar código repetitivo)  
- **Swagger** 📜 (Documentación interactiva de la API)  
- **Spring Security** 🔒 (Para la autenticación y autorización de usuarios)  

---

## 🛠️ **Arquitectura del Proyecto**  

El proyecto sigue una arquitectura modular para mantenerlo claro y escalable:  

### 📂 **Domain**  
Contiene las entidades principales del sistema:  
`Usuario`, `Curso`, `Topico`, `Respuesta`, `Perfil`, `Permisos`.  

### 📂 **Controller**  
Maneja las peticiones HTTP y mapea las rutas de la API.  

### 📂 **Service**  
Contiene la lógica de negocio y operaciones complejas.  

### 📂 **Repository**  
Define la comunicación con la base de datos utilizando JPA.  

### 📂 **DTO**  
Objetos de transferencia de datos para interactuar entre el cliente y la API.  

### 📂 **Security**  
Configuraciones relacionadas con autenticación y autorización.  

---

## 🚀 **Funcionalidades**  

### 🔹 **Crear un nuevo tópico**  
Permite a los usuarios autenticados registrar un nuevo tópico en el sistema.  

### 🔹 **Listar todos los tópicos**  
Devuelve una lista con los tópicos disponibles.  

### 🔹 **Ver un tópico específico**  
Obtiene los detalles de un tópico basado en su ID.  

### 🔹 **Actualizar un tópico**  
Permite a los usuarios actualizar el contenido de sus tópicos.  

### 🔹 **Desactivar un tópico**  
Realiza una eliminación lógica de un tópico cambiando su estado a inactivo.  

---

## 🖥️ **Cómo Configurar el Proyecto**  

### 1️⃣ **Clonar el repositorio**  
Clona este repositorio en tu máquina local:  
```bash
git clone https://github.com/tu-usuario/foro-hub.git
```
---
### 2️⃣ **Actualiza el archivo application.properties con los datos de conexión a tu base de datos:**  
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/foro_hub

spring.datasource.username=tu_usuario

spring.datasource.password=tu_contraseña
```

### 🏃‍♂️ Cómo Ejecutar el Proyecto 
Desde la terminal:
```bash
mvn spring-boot:run
```
