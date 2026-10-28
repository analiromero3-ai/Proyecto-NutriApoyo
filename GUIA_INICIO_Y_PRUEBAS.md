# Guía de inicio y pruebas - NutriApoyo

Esta guía corresponde al código actual de NutriApoyo. La aplicación contiene autenticación, beneficiarios, postulación pública, seguimiento por código y documento, y evaluación manual. Los módulos de centros de salud, paquetes, inventario, entregas, recetas, reportes, auditoría y correo todavía no están implementados.

## A. Requisitos previos

- Java **25**. Compruébalo desde PowerShell:

  ```powershell
  java -version
  ```

  La salida debe indicar una versión `25`.

- MySQL **8** en ejecución. En Windows se puede comprobar desde Servicios (`services.msc`), buscando un servicio como `MySQL80`, o iniciando sesión desde MySQL Workbench.
- No es necesario instalar Maven: el proyecto incluye `mvnw.cmd`.
- Abra PowerShell dentro de la carpeta del proyecto:

  ```powershell
  cd C:\Users\USER\Documents\NutriApoyo
  ```

## B. Configurar MySQL

1. Abra MySQL Workbench, conéctese a su servidor MySQL 8 y ejecute una sola vez:

   ```sql
   CREATE DATABASE nutriapoyo CHARACTER SET utf8mb4;
   ```

2. Seleccione la base `nutriapoyo` y ejecute, en este orden, los scripts del proyecto:

   1. `src/main/resources/db/schema-nutriapoyo.sql`
   2. `src/main/resources/db/V2__crear_tabla_beneficiarios.sql`
   3. `src/main/resources/db/V3__crear_tabla_solicitudes.sql`

   Los scripts no usan `DROP` ni `TRUNCATE`. Si ya existe una base con datos, ejecute solamente los scripts `V2` o `V3` cuya tabla aún no exista. Antes revise sus tablas con:

   ```sql
   USE nutriapoyo;
   SHOW TABLES;
   ```

3. En la misma ventana de PowerShell donde iniciará la aplicación, configure credenciales ficticias de ejemplo reemplazando los valores entre `< >`:

   ```powershell
   $env:NUTRIAPOYO_DB_URL = "jdbc:mysql://localhost:3306/nutriapoyo?allowPublicKeyRetrieval=true&useSSL=false"
   $env:NUTRIAPOYO_DB_USERNAME = "<usuario_mysql>"
   $env:NUTRIAPOYO_DB_PASSWORD = "<contrasena_mysql>"
   ```

   Estas variables duran solo mientras esa terminal esté abierta. No las guarde en archivos `.env` que se suban a Git.

4. Compruebe que Workbench y la aplicación usan la misma base ejecutando:

   ```sql
   SELECT DATABASE();
   ```

   Debe devolver `nutriapoyo`. La URL configurada en PowerShell también debe terminar en `/nutriapoyo`.

## C. Primer administrador e inicio de sesión

El primer administrador se crea solamente si se habilita mediante variables de entorno. En la misma PowerShell configure valores propios; no copie estas contraseñas como datos reales:

```powershell
$env:NUTRIAPOYO_USUARIO_INICIAL_HABILITADO = "true"
$env:NUTRIAPOYO_USUARIO_INICIAL_NOMBRES = "Ana"
$env:NUTRIAPOYO_USUARIO_INICIAL_APELLIDOS = "Prueba"
$env:NUTRIAPOYO_USUARIO_INICIAL_CORREO = "ana.prueba@ejemplo.test"
$env:NUTRIAPOYO_USUARIO_INICIAL_CONTRASENA = "Cambiar-Esta-Clave-2026"
```

Inicie la aplicación una vez. El registro se crea solo si aún no existe ese correo. Después, para impedir intentos de creación inicial en futuros arranques, ejecute:

```powershell
$env:NUTRIAPOYO_USUARIO_INICIAL_HABILITADO = "false"
```

Actualmente no existe una pantalla de administración para crear usuarios de prueba, ni usuarios de interfaz para los roles `EVALUADOR` o `PERSONAL_SALUD`. No inserte contraseñas en texto plano por SQL: cuando se implemente esa administración, las contraseñas deberán crearse con BCrypt desde la aplicación.

## D. Compilar e iniciar

Desde `C:\Users\USER\Documents\NutriApoyo`:

```powershell
.\mvnw.cmd clean test
.\mvnw.cmd compile
.\mvnw.cmd spring-boot:run
```

Abra [http://localhost:8080/login](http://localhost:8080/login). El arranque correcto muestra un mensaje similar a `Started NutriapoyoApplication` y el puerto `8080`.

Para detener el servidor, vuelva a la consola donde se ejecuta y presione `Ctrl+C`. Para iniciarlo de nuevo, ejecute:

```powershell
.\mvnw.cmd spring-boot:run
```

Si el puerto está ocupado, identifique el proceso sin cambiar el puerto:

```powershell
Get-NetTCPConnection -LocalPort 8080 -ErrorAction SilentlyContinue
```

Cierre solamente el proceso que reconozca como una instancia anterior de NutriApoyo. No se requiere otro servicio además de MySQL.

## E. Pruebas manuales

| N.º | Función | Rol | Pasos y datos ficticios | Resultado esperado y comprobación |
|---|---|---|---|---|
| 1 | Inicio de sesión | Administrador | Ingrese con el correo inicial configurado. | Redirige a `/inicio`. |
| 2 | Clave incorrecta | Visitante | Use el mismo correo y una clave incorrecta. | Muestra error de acceso; no ingresa. |
| 3 | Registrar beneficiario | Administrador/Evaluador | Abra **Gestionar beneficiarios** → **Registrar beneficiario**. Use `Lucía Prueba`, nacimiento `2018-05-10`, documento `DOC-1001`, tutor `María Prueba`, teléfono `999999999`. | Redirige al listado y muestra confirmación. |
| 4 | Validar datos | Administrador/Evaluador | Intente guardar sin nombres o con nacimiento de hace 16 años. | El formulario conserva lo escrito y muestra el error. |
| 5 | Editar e inactivar | Administrador/Evaluador | Abra **Editar**, cambie distrito a `Castilla` y estado a **Inactivo**. | El detalle conserva ID y fecha de registro; cambia distrito y estado. |
| 6 | Buscar y filtrar | Administrador/Evaluador | En el listado busque `Lucía`; filtre distrito `Castilla` y estado **Inactivo**. | Solo aparecen coincidencias. |
| 7 | Centro de salud/personal | No disponible | No hay pantalla ni tabla implementada. | Pendiente. |
| 8 | Postulación pública | Visitante | Abra `/solicitudes/nueva`; use un menor ficticio con documento `SOL-1001`, edad menor a 16 años, tutor y consentimiento marcado. | Se genera código `SOL-AAAA-XXXXXXXX`. |
| 9 | Seguimiento | Visitante | Abra `/seguimiento`; ingrese el código recibido y `SOL-1001`. | Muestra estado y fecha, sin datos personales. |
| 10 | Solicitud duplicada | Visitante | Repita la postulación con `SOL-1001`. | Informa que existe una solicitud vigente. |
| 11 | Adjuntos | Visitante | Adjunte un PDF/JPG/PNG ficticio menor de 5 MB; luego pruebe otro tipo o mayor tamaño. | Acepta el permitido; rechaza el inválido con mensaje. |
| 12 | Iniciar evaluación | Administrador/Evaluador | Abra `/evaluaciones`, entre a la solicitud y pulse **Iniciar evaluación**. | Estado cambia a **En evaluación**. |
| 13 | Subsanar observación | No disponible | No existe edición pública de solicitudes observadas. | Pendiente. |
| 14 | Decidir solicitud | Administrador/Evaluador | En una solicitud en evaluación seleccione **Aprobada**, **Observada** o **Rechazada** y escriba motivo. | Guarda decisión, fecha y motivo. |
| 15-19 | Inventario, paquetes, asignación y entrega | No disponible | No hay rutas ni tablas activas. | Pendiente. |
| 20-21 | Recetas públicas | No disponible | No hay catálogo ni recetas. | Pendiente. |
| 22 | Reportes/Excel/PDF | No disponible | Apache POI está declarada, pero no hay reporte funcional. | Pendiente. |
| 23 | Restricciones URL | Visitante | Intente abrir `/beneficiarios` o `/evaluaciones`. | Spring Security redirige a inicio de sesión. |
| 24-25 | Auditoría, correo y agenda | No disponible | No existen estas funciones. | Pendiente. |

## F. Comprobar persistencia real

Después de cada operación, consulte en Workbench:

```sql
USE nutriapoyo;

SELECT id, nombres, apellidos, numero_documento, distrito, estado, fecha_registro
FROM beneficiarios
WHERE numero_documento = 'DOC-1001';

SELECT s.codigo_seguimiento, s.estado, s.fecha_solicitud, b.numero_documento
FROM solicitudes s
JOIN beneficiarios b ON b.id = s.beneficiario_id
WHERE b.numero_documento = 'SOL-1001';
```

Para demostrar persistencia: registre datos ficticios, ejecute estas consultas, detenga Java con `Ctrl+C`, reinicie con `.\mvnw.cmd spring-boot:run`, y vuelva a consultar tanto desde la web como desde Workbench. Un mensaje de éxito no prueba por sí solo que la fila exista: las consultas anteriores sí lo hacen.

Las relaciones de paquete, entrega, inventario y receta no pueden comprobarse todavía porque esas tablas no están implementadas. La operación de solicitudes se guarda en una transacción; si se detecta duplicado vigente, no debe generarse una segunda solicitud.

## G. Errores frecuentes

| Síntoma | Causa probable | Cómo comprobarlo | Solución |
|---|---|---|---|
| `UnsupportedClassVersionError` | Java no es 25. | `java -version`. | Instale/seleccione JDK 25. |
| `Communications link failure` | MySQL apagado o URL incorrecta. | Workbench no conecta. | Inicie MySQL y revise `NUTRIAPOYO_DB_URL`. |
| `Access denied` | Usuario o clave MySQL incorrectos. | Pruebe las mismas credenciales en Workbench. | Corrija variables de entorno. |
| `Unknown database 'nutriapoyo'` | La base no existe. | `SHOW DATABASES;`. | Cree `nutriapoyo` sin borrar otras bases. |
| Tabla/columna faltante | Script SQL pendiente. | `SHOW TABLES;`. | Ejecute el siguiente script pendiente en orden. |
| Usuario inicial no aparece | Variables no están en esa PowerShell o el correo ya existe. | Revise `usuarios` sin mostrar hashes. | Defina variables y reinicie; no duplique correo. |
| Error 403 | Falta token CSRF o sesión vencida. | Revise que el formulario renderizado incluya token. | Recargue la página e intente de nuevo; no desactive CSRF. |
| Formulario no guarda | Validación de servidor. | Revise mensajes bajo cada campo. | Corrija datos; la fecha de registro la genera el servidor. |
| Archivo rechazado | Tipo, firma o tamaño no permitido. | Revise extensión, contenido y tamaño. | Use PDF/JPG/PNG real de máximo 5 MB. |
| Error al guardar adjunto | Ruta local sin permiso. | Revise `NUTRIAPOYO_DOCUMENTOS_RUTA`. | Use una carpeta local escribible, fuera de `static`. |

## H. Resultados y limitaciones

La última ejecución completa registrada antes de los ajustes finales ejecutó 4 pruebas sin fallos: contexto Spring, formulario y seguimiento público, y prevención de solicitud vigente duplicada. La prueba de fecha de beneficiario y los ajustes posteriores requieren ejecutar nuevamente `.\mvnw.cmd clean test` en su equipo; la ejecución en este entorno quedó bloqueada antes de producir un informe final.

No se verificó MySQL real, SMTP, HTTPS, respaldos, rendimiento o disponibilidad porque no hay credenciales ni servicios disponibles en este entorno. Tampoco se debe afirmar cumplimiento legal o clínico hasta realizar esas verificaciones.

### Lista de demostración para sustentación

1. Configure MySQL y ejecute los tres scripts.
2. Cree el administrador por variables de entorno e inicie sesión.
3. Registre un beneficiario y confirme su fila con `SELECT`.
4. Presente una postulación pública, consulte su código y evalúela manualmente.
5. Demuestre que un visitante no puede abrir `/evaluaciones` por URL directa.
6. Explique que el flujo objetivo completo es `postulación -> evaluación -> subsanación -> aprobación -> asignación -> entrega -> reporte`, pero solo las etapas de postulación y evaluación están implementadas hoy.
7. Explique que catálogo de recetas y control de acceso de nutricionista están pendientes; no se deben presentar como funcionalidades terminadas.
