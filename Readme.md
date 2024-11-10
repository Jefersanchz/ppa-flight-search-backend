# Punto de Pago Air - Backend

Este proyecto es el backend de la aplicación de búsqueda de vuelos para la aerolínea Punto de Pago Air (PPA). La aplicación permite a los usuarios buscar itinerarios de vuelos, incluyendo vuelos directos y aquellos con escalas, entre diferentes aeropuertos de la red de PPA.

## Descripción del Proyecto

Punto de Pago Air está en proceso de lanzamiento y operará en 8 aeropuertos colombianos: BOG, MDE, BAQ, BGA, SMR, CTG, CLO y EOH. Este backend proporciona la funcionalidad para buscar vuelos disponibles entre estos aeropuertos considerando una fecha específica de viaje.

### Funcionalidades
- **Búsqueda de vuelos directos** entre aeropuertos.
- **Búsqueda de vuelos con escalas** para encontrar conexiones indirectas.
- **Filtrado por fecha de salida** para mostrar solo vuelos que coincidan con una fecha específica.
- **Ordenación de resultados** por duración o tiempo total de viaje.

## Tecnologías Utilizadas

- **Java** y **Spring Boot**: Para el desarrollo del backend.
- **JPA (Hibernate)**: Para la persistencia de datos.
- **MySQL**: Base de datos relacional para almacenar la información de vuelos y aeropuertos.
- **Swagger**: Documentación interactiva de la API.
- **MapStruct**: Mapeo de entidades y DTOs.
- **Maven**: Gestión de dependencias.

## Instalación y Configuración

### Prerrequisitos

- **Java 17** o superior.
- **Maven 3.6+**.
- **MySQL**: Asegúrate de tener una instancia de MySQL configurada y funcionando.

### Pasos de instalación

1. Clona el repositorio:

   ```bash
   git clone https://github.com/Jefersanchz/ppa-flight-search-backend.git
   cd ppa-flight-search-backend
2. Instala las dependencias usando Maven:
   bash
   Copiar código
   mvn clean install
3. Configura la base de datos en el archivo application.properties o application.yml:

4. properties
Copiar código
## Base de datos local
spring.datasource.url=jdbc:mysql://localhost:3306/ppa_flight_db
## Base de datos produccion
spring.datasource.url=jdbc:mysql://pruebatecnica.czo20w4sih91.us-east-2.rds.amazonaws.com:3306/ppa_flight_db
spring.datasource.username=ppadmin
spring.datasource.password=ppaflytest*
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Configuración de JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

# Configuración de Swagger
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/ppa-flight
# Puerto del servidor
server.port=9000
# Documentación backend
http://ec2-18-191-234-202.us-east-2.compute.amazonaws.com:9000/swagger-ui/index.html#