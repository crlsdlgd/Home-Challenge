# Hommechallenge - Fullstack - Kanteritas

## Descripción

Este proyecto consiste en el desarrollo de una aplicación web para la gestión de horarios de interrupción del servicio de energía eléctrica en K-Corporation. La solución incluye funcionalidades específicas para dos roles principales: Administrador y Cliente, cada uno con permisos y características personalizadas.

## Funcionalidades Principales

### Para el Administrador:

* Gestión de usuarios: creación, actualización y consulta de usuarios registrados.
* Registro y edición de interrupciones del servicio, asociándolas a ubicaciones específicas.

### Para el Cliente:
* Consulta de interrupciones registradas según su ubicación.
* Actualización de su perfil, incluyendo información personal y ubicación geográfica (coordenadas de latitud y longitud).

### Otras Caracteristicas:

* Integración de autenticación con OAuth 2.0 utilizando Google para inicio de sesión seguro.
* Uso de coordenadas (latitud y longitud) para representar ubicaciones geográficas
* Interfaz intuitiva para seleccionar y actualizar ubicaciones mediante un mapa interactivo de Google Maps.
* Implementación de controles de acceso basados en roles para proteger las rutas y garantizar una experiencia segura y personalizada para cada tipo de usuario.

## Tecnologias Utilizadas
### Backend:
* Java con Spring Boot para la construcción de servicios REST.
* PostgreSQL como base de datos relacional.
para persistencia de datos.
### Frontend:
* Angular para una interfaz dinámica y moderna.
* Google Maps API para la selección interactiva de ubicaciones.
* OAuth 2.0 para autenticación.

## Configuracion Inicial
Antes de empezar, es necesario realizar las siguientes configuraciones:
1. **Crear la base de datos**
Crear la base de datos      kruger_test y restaurarla utilizando el archivo ubicado en:
/databases/create-database-kruger-homechallenge.sql

2. **Configurar usuario y contraseña de la base de datos** 
Editar el archivo kruger-back\src\main\resources\application.properties y configurar los valores correspondientes:
```sh
spring.datasource.username=DATABASE_USER
spring.datasource.password=DATABASE_USER_PASSWORD
```
3. **Configurar las llaves de acceso de Google OAuth 2.0** 
Editar el archivo kruger-back\src\main\resources\application.properties y añadir las claves correspondientes:
```sh
spring.security.oauth2.client.registration.google.client-id=YOUR_CLIENT_ID
spring.security.oauth2.client.registration.google.client-secret=YOUR_CLIENT_SECRET
```
4. **Configurar la API Key de Google Maps** 
Editar el archivo kruger_front\src\index.html e incluir tu API Key de Google Maps en el script:
```sh
<script async src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY"></script>
```

## Cómo Ejecutar el Proyecto
1. Backend: Ejecutar el servidor Spring Boot con el comando:
```sh
./mvnw spring-boot:run
```
2. Frontend: Ejecutar el cliente Angular con:
```sh
ng serve
```
3. Acceder a la aplicación en el navegador desde:
[http://localhost:4200](http://localhost:4200).



## Autores

* Carlos Delgado

## Licencia

* MIT Licence