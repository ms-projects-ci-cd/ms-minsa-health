# Usa una imagen base con JDK 17
FROM eclipse-temurin:17-jdk-alpine

# Argumento del archivo JAR a empaquetar
ARG JAR_FILE=target/*.jar

# Copia el JAR compilado al contenedor
COPY ${JAR_FILE} app.jar

# Expone el puerto por defecto de Spring Boot
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "/app.jar"]
