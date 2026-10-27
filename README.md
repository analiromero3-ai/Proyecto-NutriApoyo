# NutriApoyo

Aplicación web universitaria para gestionar el apoyo nutricional. Está desarrollada con Java 25, Spring Boot, Spring MVC, Spring Data JPA, Spring Security, Thymeleaf y MySQL 8.

## Etapa actual

La primera etapa implementa el inicio de sesión personalizado, usuarios con roles y el módulo de Beneficiarios: registro, búsqueda, filtros, consulta, edición y desactivación lógica mediante estado.

## Estructura

- `model`: entidades del dominio (`Usuario` y `RolUsuario`).
- `dao`: acceso a datos mediante repositorios Spring Data JPA.
- `service`: reglas de negocio relacionadas con usuarios.
- `controller`: navegación web.
- `config`: seguridad y creación opcional del primer administrador.
- `templates`: vistas Thymeleaf.

## Configurar MySQL

1. Cree la base de datos local: `CREATE DATABASE nutriapoyo CHARACTER SET utf8mb4;`.
2. Ejecute [schema-nutriapoyo.sql](src/main/resources/db/schema-nutriapoyo.sql).
3. Defina las variables de entorno `NUTRIAPOYO_DB_USERNAME` y `NUTRIAPOYO_DB_PASSWORD`. Si la URL no es la predeterminada, defina también `NUTRIAPOYO_DB_URL`.
4. Para crear el primer administrador solo una vez, defina `NUTRIAPOYO_USUARIO_INICIAL_HABILITADO=true` junto con `NUTRIAPOYO_USUARIO_INICIAL_NOMBRES`, `NUTRIAPOYO_USUARIO_INICIAL_APELLIDOS`, `NUTRIAPOYO_USUARIO_INICIAL_CORREO` y `NUTRIAPOYO_USUARIO_INICIAL_CONTRASENA`.

La contraseña nunca se almacena en texto plano: Spring Security la protege con BCrypt. Después de crear el primer usuario, quite o desactive las variables `NUTRIAPOYO_USUARIO_INICIAL_*`.

## Ejecutar y probar

```powershell
.\mvnw.cmd clean test
.\mvnw.cmd spring-boot:run
```

Abra `http://localhost:8080/login` e ingrese con el administrador configurado. El servidor usa el puerto `8080`.

## Base de datos: módulo Beneficiarios

Ejecute una vez [V2__crear_tabla_beneficiarios.sql](src/main/resources/db/V2__crear_tabla_beneficiarios.sql) sobre MySQL 8. El script solo agrega la tabla e índices del módulo; no elimina ni modifica datos existentes.

El módulo está disponible para los roles `ADMINISTRADOR` y `EVALUADOR`. La desactivación se realiza cambiando el estado a **Inactivo** desde la edición; no existe eliminación física.

## Solicitudes y evaluación

Ejecute una vez [V3__crear_tabla_solicitudes.sql](src/main/resources/db/V3__crear_tabla_solicitudes.sql) después de crear la tabla de beneficiarios. La postulación pública está en `/solicitudes/nueva` y la consulta de estado en `/seguimiento`. La bandeja `/evaluaciones` requiere los roles `ADMINISTRADOR` o `EVALUADOR`.

Los adjuntos aceptan PDF, PNG o JPG de hasta 5 MB y se almacenan fuera de las vistas públicas en `datos/documentos/` por defecto; la ruta puede cambiarse con `NUTRIAPOYO_DOCUMENTOS_RUTA`. La carpeta está excluida de Git.

La evaluación es manual. El sistema solo muestra los valores declarados y no aplica criterios clínicos automáticos, porque el informe no define los umbrales necesarios.

## Reportes previstos

Las siguientes etapas incorporarán reportes alimentados con datos reales: beneficiarios por distrito y rango de edad, solicitudes por estado, entregas por periodo, paquetes entregados y recetas con ingredientes. La exportación a Excel se implementará entonces con Apache POI.

## Dependencias de la rúbrica

Apache Commons Lang se utiliza al normalizar datos de usuario y Guava al validar los datos del administrador inicial. Apache POI está declarada para la próxima etapa de reportes, donde se implementará una exportación real a Excel. Logback registra eventos de arranque sin incluir contraseñas.
