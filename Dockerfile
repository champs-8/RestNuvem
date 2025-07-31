# Etapa 1: Imagem com Java e Gradle para build
FROM gradle:8.4.0-jdk17 AS builder

# Copia o projeto
COPY --chown=gradle:gradle . /home/gradle/project
WORKDIR /home/gradle/project

# Gera o .jar
RUN gradle build --no-daemon

# Etapa 2: Imagem leve com JRE para rodar a aplicação
FROM eclipse-temurin:17-jre

# Copia o .jar da etapa anterior
COPY --from=builder /home/gradle/project/build/libs/restNuvem-0.0.1-SNAPSHOT.jar app.jar

# Exponha a porta que o Render usa (geralmente 8080)
EXPOSE 8080

# Comando para rodar a aplicação
CMD ["java", "-jar", "app.jar"]
