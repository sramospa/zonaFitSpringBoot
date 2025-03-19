Practica de SpringBoot

# ZonaFitSpringBoot

### Descripción
ZonaFitSpringBoot es una aplicación desarrollada con Spring Boot para la gestión de clientes en un sistema de gimnasio. Permite administrar clientes, incluyendo su registro, consulta, actualización y eliminación.

## Tecnologías Utilizadas
- Java 17
- Spring Boot 3
- Spring Data JPA
- MySQL
- Lombok
- Swagger (OpenAPI) para documentación
- Maven

## Instalación y Configuración
1. Clona este repositorio:
   ```sh
   git clone https://github.com/sramospa/zonaFitSpringBoot.git
   ```
2. Configura la base de datos en `application.properties` o `application.yml`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/zona_fit_db
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   ```
3. Ejecuta la aplicación:
   ```sh
   mvn spring-boot:run
   ```

## Estructura del Proyecto
El proyecto sigue una arquitectura en capas:
- **Modelo (`model`)**: Contiene las entidades como `Cliente`.
- **Repositorio (`repositorio`)**: Interfaces para la persistencia de datos con `Spring Data JPA`.
- **Servicio (`servicio`)**: Implementa la lógica de negocio.
- **Presentación (`ZonaFitApplication.java`)**: Implementa la interfaz de consola para gestionar clientes.

## Contribuciones
Las contribuciones son bienvenidas. Si deseas colaborar, abre un issue o envía un pull request.

## Licencia
Este proyecto está bajo la licencia MIT.


