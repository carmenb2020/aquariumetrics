# AquaMetrics App

## Descripción
La aplicación AquaMetrics es una herramienta diseñada para ayudarte a realizar un seguimiento de las métricas de tus acuarios. Puedes almacenar y gestionar información sobre múltiples acuarios, incluyendo parámetros clave y verificar si se encuentran dentro de los rangos preestablecidos para cada uno de ellos. Esta aplicación es ideal para los amantes de los acuarios que desean mantener un registro detallado de las condiciones de sus tanques.

## Autor
- Nombre: Carmen Borja
- Contacto: carmenborjap@gmail.com

## Tecnologías Utilizadas
- Java
- Spring Boot
- Vue 3
- MySQL

## Instalación

### Requisitos Previos
- Java 8 o superior
- Node.js
- MySQL

### Pasos de Instalación

1. Clona este repositorio en tu máquina local:

   ```bash
   git clone https://github.com/tuusuario/aquametrics.git
   ```

2. Configura la base de datos MySQL:
   
   - Crea una base de datos llamada `acuariometrics`.
   - Modifica el archivo `application.properties` en la carpeta `backend/src/main/resources` para configurar la conexión a tu base de datos MySQL:

     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/acuariometrics
     spring.datasource.username=tu_usuario
     spring.datasource.password=tu_contraseña
     ```

3. Navega a la carpeta `frontend` y ejecuta los siguientes comandos para instalar las dependencias y construir la aplicación Vue:

   ```bash
   cd frontend
   npm install
   npm run build
   ```

4. Inicia la aplicación Spring Boot desde la carpeta `backend`:

   ```bash
   cd ../backend
   ./mvnw spring-boot:run
   ```

5. La aplicación estará disponible en `http://localhost:8080`.

## Uso

1. Accede a la aplicación en tu navegador web: `http://localhost:8080`.

2. Registra tus acuarios y define los parámetros que deseas monitorear.

3. Registra las métricas de tus acuarios, asegurándote de ingresar los valores adecuados para cada parámetro.

4. La aplicación verificará automáticamente si las métricas se encuentran dentro de los rangos preestablecidos y te notificará si hay alguna discrepancia.

## Contribución
Si deseas contribuir a este proyecto, siéntete libre de hacerlo. Puedes enviar pull requests y sugerencias a través de GitHub.

## Licencia
Este proyecto está bajo la Licencia MIT.