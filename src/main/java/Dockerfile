FROM ubuntu:latest
LABEL authors="Silva"

ENTRYPOINT ["top", "-b"]


# Imagen base de JDK
FROM eclipse-temurin:17-jdk-alpine

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo build.gradle y el directorio src
COPY build.gradle ./
COPY src ./src

# Copiar el archivo de configuración del wrapper de Gradle
COPY gradlew ./
COPY gradle ./gradle

# Dar permisos al wrapper
RUN chmod +x ./gradlew

# Ejecutar la compilación del proyecto
RUN ./gradlew build --no-daemon

# Exponer el puerto en el que se ejecutará la aplicación
EXPOSE 8080

# Ejecutar la aplicación
CMD ["./gradlew", "bootRun"]
