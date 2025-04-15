# 🏥 MS Minsa Health

Este microservicio forma parte de un sistema distribuido para la gestión de datos de salud del MINSA. Ha sido desarrollado en Java con Spring Boot y utiliza PostgreSQL como base de datos. Está diseñado para integrarse fácilmente en una arquitectura de microservicios con variables de entorno configurables.

---

## 📊 Dataset utilizado

- **Nombre:** Student Mental Health
- **Fuente:** [Kaggle - Student Mental Health](https://datosabiertos.gob.pe/dataset/establecimientos-de-salud)
- **Descripción:** Este dataset contiene información sobre el estado mental de estudiantes, incluyendo niveles de ansiedad, depresión y acceso a ayuda psicológica. Se puede utilizar para análisis predictivo y generación de reportes.

---

---

## 🚀 Tecnologías utilizadas

- Java 17
- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- Maven
- Docker (opcional)

---

## 🛠️ Requisitos previos

- [Java 17+](https://adoptium.net/)
- [Maven 3+](https://maven.apache.org/)
- [PostgreSQL 12+](https://www.postgresql.org/)
- [Docker](https://www.docker.com/) (opcional)
- Base de datos PostgreSQL corriendo en el puerto `5433` (por defecto)

---

## ⚙️ Configuración

Este microservicio está preparado para recibir variables de entorno, pero también funciona con valores por defecto si no se configuran.

### 📄 `application.properties`

```properties
spring.application.name=ms-minsa-health

server.port=${SERVER_PORT:8082}

spring.datasource.url=${SPRING_DB_URI:jdbc:postgresql://localhost:5433/health_db}
spring.datasource.username=${SPRING_DB_USERNAME:postgres}
spring.datasource.password=${SPRING_DB_PASSWORD:postgres}

spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=${SPRING_DB_DDL:update}

spring.servlet.multipart.max-file-size=10MB
