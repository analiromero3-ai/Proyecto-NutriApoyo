# NutriApoyo

Aplicación web universitaria para la gestión y canalización de apoyo nutricional dirigida a menores en situación de vulnerabilidad. El proyecto se desarrolla con Java, Spring Boot, Spring MVC, Spring Data JPA, Spring Security, Thymeleaf y MySQL.

## 1. Estado del proyecto

El sistema se desarrolla por etapas, siguiendo los requisitos del informe académico `beta2.pdf`.

La versión actual contempla:

- Inicio de sesión y gestión de usuarios con roles.
- Módulo de beneficiarios: registro, búsqueda, filtros, consulta, edición y desactivación lógica.
- Módulo de solicitudes: postulación y consulta de seguimiento.
- Módulo de evaluación: consulta de solicitudes y evaluación manual por usuarios autorizados.

Las funcionalidades deben verificarse mediante pruebas antes de considerarse completamente validadas.

## 2. Tecnologías

- Java 25.
- Spring Boot.
- Spring MVC y Thymeleaf.
- Spring Data JPA.
- Spring Security.
- MySQL 8.
- Maven Wrapper.
- Git y GitHub.

Las versiones exactas de las dependencias deben consultarse en `pom.xml`.

## 3. Arquitectura

El proyecto sigue una separación por responsabilidades:

- `model`: entidades del dominio.
- `dao`: acceso a datos mediante repositorios.
- `service`: lógica de negocio.
- `controller`: controladores y navegación web.
- `config`: configuración de seguridad y componentes de inicialización.
- `src/main/resources/templates`: vistas Thymeleaf.
- `src/main/resources/static`: recursos estáticos, como CSS.
- `src/main/resources/db`: scripts SQL de la base de datos.

La estructura concreta del código debe consultarse en el repositorio.

## 4. Configuración de MySQL

1. Instala y ejecuta MySQL 8.
2. Crea la base de datos:

   ```sql
   CREATE DATABASE nutriapoyo CHARACTER SET utf8mb4;
   ```

3. Configura las variables de entorno que utiliza la aplicación:

   - `NUTRIAPOYO_DB_USERNAME`
   - `NUTRIAPOYO_DB_PASSWORD`
   - `NUTRIAPOYO_DB_URL`, si corresponde.

4. Revisa los scripts de `src/main/resources/db/` y ejecútalos en el orden requerido por sus dependencias:

   - `schema-nutriapoyo.sql`
   - `V2__crear_tabla_beneficiarios.sql`
   - `V3__crear_tabla_solicitudes.sql`

   Antes de ejecutarlos, comprueba si las tablas ya existen y revisa el contenido de cada script para evitar operaciones duplicadas.

No se deben publicar contraseñas, credenciales ni datos personales en el repositorio.

## 5. Configuración del primer administrador

Si la aplicación utiliza la inicialización opcional del administrador, configura las variables de entorno correspondientes:

- `NUTRIAPOYO_USUARIO_INICIAL_HABILITADO`
- `NUTRIAPOYO_USUARIO_INICIAL_NOMBRES`
- `NUTRIAPOYO_USUARIO_INICIAL_APELLIDOS`
- `NUTRIAPOYO_USUARIO_INICIAL_CORREO`
- `NUTRIAPOYO_USUARIO_INICIAL_CONTRASENA`

Comprueba los nombres y el comportamiento de estas variables en la configuración real del proyecto. Después de crear el primer usuario, deshabilita la inicialización y elimina las variables que ya no sean necesarias.

Las contraseñas deben almacenarse mediante un mecanismo seguro de hash, nunca en texto plano.

## 6. Ejecutar la aplicación en Windows

Abre PowerShell en la carpeta raíz del proyecto.

Para ejecutar las pruebas:

```powershell
.\mvnw.cmd clean test
```

Para iniciar la aplicación:

```powershell
.\mvnw.cmd spring-boot:run
```

Si la aplicación inicia correctamente en el puerto configurado por defecto, abre:

http://localhost:8080/login

Si el Maven Wrapper no puede descargar Maven o las dependencias, comprueba la conexión a Internet y la configuración del entorno.

## 7. Módulo de beneficiarios

El módulo permite gestionar los registros de beneficiarios según las funciones disponibles en el código.

La desactivación lógica cambia el estado del registro en lugar de eliminar físicamente la información.

El acceso debe respetar los roles configurados en Spring Security. Verifica en el código qué operaciones están permitidas a cada rol.

## 8. Solicitudes y evaluación

La aplicación contempla la postulación, el seguimiento y la evaluación de solicitudes de apoyo nutricional.

La evaluación es manual. El sistema no debe realizar diagnósticos médicos automáticos ni aplicar umbrales clínicos no definidos en el informe académico.

Los documentos adjuntos, si están habilitados, deben validarse y almacenarse con acceso restringido, fuera de las rutas públicas.

## 9. Funcionalidades pendientes

Las siguientes áreas deben completarse o verificarse según el alcance de `beta2.pdf`:

- Gestión de paquetes de apoyo e inventario.
- Asignación y registro de entregas.
- Catálogo público de recetas e ingredientes.
- Material educativo nutricional.
- Reportes administrativos.
- Exportación de reportes a PDF y Excel.
- Auditoría de acceso a datos personales y médicos.
- Verificación de requisitos de rendimiento, accesibilidad y copias de seguridad.

Esta lista debe actualizarse conforme cada funcionalidad se implemente y se pruebe.

## 10. Dependencias académicas

El proyecto contempla las siguientes bibliotecas solicitadas:

- **Guava:** verifica sus usos reales en el código.
- **Apache Commons:** verifica qué componentes están declarados y utilizados.
- **Apache POI:** destinada a la generación de reportes Excel cuando se implemente esa funcionalidad.
- **Logback:** configuración de registro de eventos de la aplicación.

La declaración de una dependencia en `pom.xml` no demuestra por sí sola que su funcionalidad esté implementada.

## 11. Pruebas

Ejecuta las pruebas automatizadas con:

```powershell
.\mvnw.cmd clean test
```

Registra los resultados reales de las pruebas y los errores detectados. No se debe considerar validada una funcionalidad si no se ha probado.

## 12. Alcance del proyecto

El sistema se limita a las funcionalidades definidas en el informe académico `beta2.pdf`.

Quedan fuera del alcance las pasarelas de donaciones, los eventos de voluntariado, las aplicaciones móviles nativas, las integraciones con sistemas sanitarios externos y los diagnósticos médicos automatizados.

## 13. Repositorio

Código fuente:

https://github.com/analiromero3-ai/Proyecto-NutriApoyo
