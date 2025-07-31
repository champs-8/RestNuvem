# Imagem oficial com JDK 17 (ou 21 se seu projeto usar)
FROM eclipse-temurin:17-jdk

# Define o diretório de trabalho
WORKDIR /app

# Copia os arquivos necessários
COPY build/libs/restNuvem-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta que o Render define
EXPOSE 8080

# Comando para iniciar a aplicação
CMD ["java", "-jar", "app.jar"]
