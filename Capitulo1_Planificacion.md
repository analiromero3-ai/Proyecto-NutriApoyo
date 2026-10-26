# CAPÍTULO 1: PLANIFICACIÓN DEL PROYECTO

## 1.0. Contexto Organizacional: Visión, Misión y Entorno
- **Misión:** Desarrollar e implementar una plataforma web eficiente, segura y accesible que canalice de forma directa ayuda alimentaria rica en hierro e información sobre recetas nutricionales a menores de 0 a 15 años en situación de vulnerabilidad con anemia en la región Piura, conectando a las familias con la administración social a través de formularios digitales ágiles.
- **Visión:** Consolidarse al cierre del ciclo académico 2026 como la plataforma tecnológica de gestión y mitigación de la anemia infantil de referencia a nivel regional, facilitando el registro, la evaluación y la entrega oportuna de paquetes alimentarios fortificados.
- **Análisis del Entorno (PESTEL):**
  - **Político / Social:** Alta urgencia pública por reducir la prevalencia de anemia infantil en la región Piura (donde supera el 39% en menores). Existe una fuerte alineación con las políticas públicas del MINSA orientadas a la erradicación de la anemia ferropénica.
  - **Tecnológico:** Alta adopción de teléfonos móviles y conectividad en los hogares, lo que permite la captación de casos de forma directa e inmediata a través de formularios digitales web, eliminando trámites físicos en papel.
  - **Económico:** Optimización de recursos económicos al eliminar los costos operativos e intermediarios de la gestión de campañas masivas, destinando los insumos directamente al armado y distribución de alimentos de alto valor nutricional.
  - **Legal / Normativo:** Cumplimiento de la Ley de Protección de Datos Personales en el manejo de información médica y confidencial de las familias y menores de edad.

---

## 1.1. Lienzo Lean Canvas Reestructurado
- **Problema:** Alta prevalencia de anemia en niños y adolescentes de 0 a 15 años, falta de información sobre recetas nutritivas preparadas con insumos locales ricos en hierro, y desorganización en la recepción de solicitudes de ayuda.
- **Solución:** Registro simplificado de beneficiarios mediante formularios web, catálogo interactivo de recetas nutritivas contra la anemia y asignación directa de paquetes alimentarios fortificados.
- **Propuesta Única de Valor:** Gestión centralizada y trazable del apoyo contra la anemia infantil desde la postulación en línea hasta la entrega de alimentos y la orientación nutricional, sin intermediarios ni campañas de donación externa.
- **Ventaja Competitiva:** Enfoque clínico-nutricional enfocado exclusivamente en la anemia de la población infanto-juvenil (0 a 15 años), integrando recetas educativas y canalización directa en una misma plataforma.
- **Segmento de Clientes:** Familias y tutores de menores de 0 a 15 años con diagnóstico o riesgo de anemia, y administradores de programas sociales comunitarios.
- **Canales:** Portal web principal, formularios digitales de postulación y coordinación directa con centros de salud y comedores locales.
- **Estructura de Costos:** Servidores web, hospedaje de base de datos MySQL y mantenimiento de software (Costo monetario directo de S/ 0.00 por el uso de tecnologías de licencia gratuita).
- **Flujo de Ingresos:** Proyecto de carácter académico y de alto impacto social, sin fines de lucro.

---

## 1.2. Planificación Inicial del Proyecto (Project Charter)
- **Título del Proyecto:** NutriApoyo - Plataforma Web de Gestión Nutricional y Combate contra la Anemia Infantil.
- **Encargada:** Pulache Sullón, Ashlyn Abigail.
- **Duración:** 16 Semanas.
- **Objetivo General:** Desarrollar una plataforma web funcional en arquitectura Java (MVC + DAO) que permita la recepción de postulaciones vía formularios, la evaluación de casos de anemia en menores de 0 a 15 años, la asignación de alimentos nutritivos ricos en hierro y la difusión de un catálogo interactivo de recetas.
- **Entregables Clave:**
  - Plataforma web funcional desarrollada en Java.
  - Modelo de base de datos relacional en MySQL (diseño lógico y físico).
  - Documentación técnica (SRS, Casos de Uso, BPMN, WBS y Gantt).
  - Manual de usuario e informe final.
- **Presupuesto:** S/ 0.00 (Desarrollado con herramientas de software libre).

---

## 1.3. Esquema de Desglose del Trabajo (WBS / EDT)
1. **Gestión del Proyecto**
   - 1.1 Acta de Constitución (Project Charter)
   - 1.2 Lienzo Lean Canvas reestructurado
   - 1.3 Cronograma de actividades (Gantt) y WBS
2. **Análisis del Sistema**
   - **2.1 Definición del problema y alcance (Anemia de 0 a 15 años)**
la atención del apoyo alimentario a menores de 0 a 15 años con anemia en la región Piura se realiza de forma manual y dispersa. Esto retrasa la respuesta a las familias, impide aplicar de manera uniforme los criterios para decidir quién califica y no deja trazabilidad de lo que se entrega.

   - **2.2 Requerimientos funcionales y no funcionales (Formularios y Recetas)**
   - - **2.2.1 Requerimientos funcionales**
     
Se definen 25 requerimientos funcionales, agrupados en cinco módulos: captación de solicitudes mediante formularios, validación de criterios médicos, gestión de paquetes nutricionales, catálogo de recetas y administración y control.

     
     Tabla 1. Diagnóstico operativo y respuesta de NutriApoyo

| Dimensión | Situación identificada | Consecuencia | Respuesta de NutriApoyo |
| --- | --- | --- | --- |
| Captación de solicitudes | Recepción dispersa, sin un formato único y con trámites en papel. | Pérdida de información y demoras en la atención. | Formulario digital único de solicitud y postulación (RF-01 a RF-07). |
| Verificación médica | Criterios de elegibilidad aplicados sin un registro estandarizado del diagnóstico. | Decisiones inconsistentes entre casos similares. | Validación de criterios médicos y decisión registrada (RF-09, RF-10). |
| Asignación del apoyo | No hay una relación explícita entre la edad del menor y la composición del paquete. | Paquetes poco adecuados al grupo etario. | Paquetes nutricionales definidos por grupo etario (RF-13, RF-15). |
| Entrega y seguimiento | Entregas sin registro centralizado. | Falta de trazabilidad y de indicadores de cobertura. | Registro de entrega y reportes de gestión (RF-16, RF-23). |
| Orientación nutricional | Información sobre recetas con hierro dispersa y poco accesible. | Familias sin guía para continuar la alimentación en casa. | Catálogo público de recetas y contenido educativo (RF-18 a RF-20). |
| Protección de datos | Datos personales y de salud del menor en documentos físicos o sin control de acceso. | Riesgo de exposición de información sensible. | Control de acceso por roles, cifrado y auditoría (RNF-02 a RNF-07). |

## Tabla 2. Delimitación del alcance del sistema

| Dimensión | Incluye | No incluye |
| --- | --- | --- |
| Poblacional | Menores de 0 a 15 años con diagnóstico o riesgo de anemia ferropénica, postulados por su tutor legal o un centro de salud aliado. | Gestantes, adultos y otras condiciones nutricionales distintas de la anemia. |
| Geográfica | Región Piura. | Otras regiones del país. |
| Funcional | Formularios de solicitud, validación de criterios médicos, paquetes nutricionales, catálogo de recetas y panel administrativo. | Campañas de recaudación, pasarelas de donación, gestión de voluntariado y eventos. |
| Clínica | Verificación de criterios médicos a partir de datos y documentos presentados. | Diagnóstico, prescripción y tratamiento médico (p. ej. suplementación). |
| Logística | Registro y trazabilidad de la entrega de paquetes. | Optimización de rutas, transporte y compra de insumos. |
| Tecnológica | Aplicación web responsive en Java (MVC + DAO) con base de datos MySQL. | Aplicación móvil nativa e integración con sistemas externos del sector salud. |
| Temporal | Desarrollo en 16 semanas durante el ciclo académico 2026. | Operación y mantenimiento posteriores a la sustentación. |

## Tabla 3. Módulo de captación de solicitudes: requerimientos funcionales

| ID | Requerimiento | Descripción | Actor |
| --- | --- | --- | --- |
| RF-01 | Registrar solicitud de apoyo | El sistema permitirá al tutor legal completar un formulario digital único de solicitud y postulación al apoyo nutricional. | Tutor legal |
| RF-02 | Registrar datos del menor | El sistema registrará nombres, fecha de nacimiento, sexo, documento de identidad y domicilio del menor, y los datos de contacto del tutor. | Tutor legal |
| RF-03 | Validar datos del formulario | El sistema verificará campos obligatorios, formatos válidos y que la edad del menor esté en el rango de 0 a 15 años antes de aceptar la solicitud. | Sistema |
| RF-04 | Registrar datos del diagnóstico | El sistema registrará el nivel de hemoglobina, la fecha de la medición, el establecimiento de salud y la condición declarada (diagnóstico o riesgo de anemia ferropénica). | Tutor legal / Centro de salud |
| RF-05 | Adjuntar documento de respaldo | El sistema permitirá adjuntar una constancia o resultado médico en formato PDF o imagen, con límite de tamaño. | Tutor legal / Centro de salud |
| RF-06 | Postular desde un centro de salud aliado | El sistema permitirá que el personal autorizado de un centro de salud registre solicitudes en nombre del tutor legal. | Personal de centro de salud |
| RF-07 | Consultar estado de la solicitud | El sistema generará un código de seguimiento y permitirá consultar el estado de la solicitud (recibida, en evaluación, observada, aprobada, rechazada, entregada). | Tutor legal |

## Tabla 4. Módulo de validación de criterios médicos: requerimientos funcionales

| ID | Requerimiento | Descripción | Actor |
| --- | --- | --- | --- |
| RF-08 | Gestionar bandeja de evaluación | El sistema listará las solicitudes pendientes con filtros por estado, fecha y centro de salud. | Evaluador |
| RF-09 | Validar criterios médicos de elegibilidad | El sistema comparará la hemoglobina declarada, ajustada por edad, con los criterios definidos y mostrará al evaluador si el caso cumple los criterios de elegibilidad. | Evaluador / Sistema |
| RF-10 | Aprobar, observar o rechazar solicitud | El evaluador registrará su decisión con el motivo correspondiente; las solicitudes observadas podrán ser subsanadas por el solicitante. | Evaluador |
| RF-11 | Notificar resultado de la evaluación | El sistema enviará al solicitante un aviso por correo electrónico con el resultado de la evaluación. | Sistema |
| RF-12 | Detectar solicitudes duplicadas | El sistema alertará cuando exista otra solicitud vigente para el mismo menor (mismo documento de identidad). | Sistema |

## Tabla 5. Módulo de gestión de paquetes nutricionales: requerimientos funcionales

| ID | Requerimiento | Descripción | Actor |
| --- | --- | --- | --- |
| RF-13 | Gestionar paquetes nutricionales | El administrador podrá crear, consultar, modificar y desactivar paquetes de alimentos ricos en hierro, definiendo su composición por grupo etario. | Administrador |
| RF-14 | Gestionar inventario de insumos | El sistema llevará el control de existencias de los alimentos que componen los paquetes y alertará ante stock bajo. | Administrador |
| RF-15 | Asignar paquete a beneficiario | El sistema asignará a cada solicitud aprobada el paquete correspondiente al grupo etario del menor. | Administrador / Evaluador |
| RF-16 | Registrar entrega del paquete | El sistema registrará la fecha, el responsable y la conformidad de cada entrega, asegurando la trazabilidad hasta el beneficiario. | Administrador |
| RF-17 | Programar entregas periódicas | El sistema permitirá programar entregas sucesivas y recordar las fechas de seguimiento por beneficiario. | Administrador |

## Tabla 6. Módulo de catálogo de recetas: requerimientos funcionales

| ID | Requerimiento | Descripción | Actor |
| --- | --- | --- | --- |
| RF-18 | Gestionar catálogo de recetas | El administrador o el evaluador (nutricionista) podrá registrar, modificar y despublicar recetas con ingredientes, porciones, preparación, aporte de hierro y grupo etario recomendado. | Administrador / Evaluador (nutricionista) |
| RF-19 | Consultar y buscar recetas | Cualquier visitante podrá explorar el catálogo y filtrar por grupo etario, ingrediente o tipo de comida sin necesidad de iniciar sesión. | Visitante |
| RF-20 | Mostrar contenido educativo | El sistema publicará consejos de educación nutricional y prevención de la anemia asociados a las recetas. | Visitante |
| RF-21 | Imprimir o descargar receta | El sistema permitirá imprimir o descargar una receta en formato PDF. | Visitante |

## Tabla 7. Módulo de administración y control: requerimientos funcionales

| ID | Requerimiento | Descripción | Actor |
| --- | --- | --- | --- |
| RF-22 | Autenticar usuarios y gestionar roles | El sistema controlará el inicio de sesión y asignará permisos según el rol (administrador, evaluador, personal de centro de salud). El tutor legal accede a su solicitud con el código de seguimiento, sin crear una cuenta. | Administrador |
| RF-23 | Generar reportes de gestión | El sistema mostrará en un panel indicadores de solicitudes atendidas, paquetes distribuidos y beneficiarios por estado. | Administrador |
| RF-24 | Registrar auditoría de accesos | El sistema registrará quién consulta o modifica datos personales y médicos de menores, con fecha y hora. | Sistema |
| RF-25 | Exportar reportes | El sistema permitirá exportar los reportes de gestión a PDF o Excel. | Administrador |

- **2.2.2 Requerimientos no funcionales**

## Tabla 8. Requerimientos no funcionales

| ID | Categoría | Requerimiento | Descripción / Métrica |
| --- | --- | --- | --- |
| RNF-01 | Seguridad | Almacenamiento seguro de credenciales | Las contraseñas se almacenarán con función hash con sal (p. ej. bcrypt); nunca en texto plano. |
| RNF-02 | Seguridad | Control de acceso por roles | Cada recurso será accesible solo para los roles autorizados; los datos de un menor solo serán visibles para su tutor y el personal autorizado. |
| RNF-03 | Seguridad | Cifrado en tránsito | Toda comunicación cliente-servidor se realizará mediante HTTPS/TLS. |
| RNF-04 | Seguridad | Protección de datos sensibles en reposo | Los datos personales y de salud del menor (documento de identidad, diagnóstico, hemoglobina) se almacenarán cifrados en la base de datos. Para detectar duplicados (RF-12) sin descifrar el dato, se comparará un hash del documento de identidad. |
| RNF-05 | Seguridad | Prevención de ataques web comunes | Uso de consultas parametrizadas (PreparedStatement) en la capa DAO, validación y saneamiento de entradas y protección contra XSS y CSRF. |
| RNF-06 | Seguridad / Legal | Cumplimiento de la Ley N.º 29733 | El formulario incluirá consentimiento informado del tutor legal para el tratamiento de datos personales y de salud del menor, con finalidad declarada. |
| RNF-07 | Seguridad | Trazabilidad de acciones | Los eventos de acceso y modificación de datos sensibles quedarán registrados y no podrán ser eliminados por usuarios operativos. |
| RNF-08 | Disponibilidad | Disponibilidad del servicio | Meta de disponibilidad mensual igual o superior a 99 %, excluyendo ventanas de mantenimiento programadas. |
| RNF-09 | Disponibilidad | Respaldo y recuperación | Respaldo automático diario de la base de datos, con meta de pérdida máxima de datos de 24 horas (RPO) y de restauración en 4 horas (RTO). |
| RNF-10 | Rendimiento | Tiempo de respuesta | Las páginas principales responderán en 3 segundos o menos en al menos 95 % de las solicitudes con conexión móvil estándar; las consultas a base de datos, en 2 segundos o menos. |
| RNF-11 | Rendimiento | Capacidad concurrente | El sistema soportará como mínimo 50 usuarios concurrentes sin degradación perceptible. |
| RNF-12 | Usabilidad | Diseño adaptable (responsive) | La interfaz se verá y funcionará correctamente en teléfonos móviles, tabletas y computadoras, priorizando el uso móvil. |
| RNF-13 | Usabilidad | Facilidad de uso del formulario | Lenguaje sencillo, mensajes de error claros y tiempo de llenado del formulario de solicitud menor a 10 minutos para un usuario sin experiencia previa. |
| RNF-14 | Usabilidad | Accesibilidad | Se aplicarán buenas prácticas de WCAG 2.1 nivel AA (contraste, tamaños de texto, etiquetas de formulario). |
| RNF-15 | Mantenibilidad | Arquitectura por capas | El código seguirá el patrón MVC con acceso a datos mediante DAO, para facilitar el mantenimiento y las pruebas. |
| RNF-16 | Portabilidad | Compatibilidad con navegadores | Funcionamiento en las versiones vigentes de Chrome, Edge, Firefox y Safari. |
| RNF-17 | Economía | Uso de software libre | El desarrollo y despliegue usarán tecnologías de licencia gratuita, manteniendo el costo monetario directo en S/ 0.00. |

   - **2.3 Matriz de priorización MoSCOW**
MoSCoW clasifica cada requerimiento en cuatro niveles: Must (imprescindible), Should (importante, pero el sistema funciona sin él), Could (deseable si alcanza el tiempo) y Won’t (queda fuera de esta versión). Con un cronograma de 16 semanas, esta clasificación permite definir el alcance mínimo viable

## Tabla 9. Matriz MoSCoW de requerimientos funcionales

| Prioridad | Requerimientos | Justificación |
| --- | --- | --- |
| MUST (14) | RF-01 Registrar solicitud de apoyo RF-02 Registrar datos del menor RF-03 Validar datos del formulario RF-04 Registrar datos del diagnóstico RF-07 Consultar estado de la solicitud RF-08 Gestionar bandeja de evaluación RF-09 Validar criterios médicos de elegibilidad RF-10 Aprobar, observar o rechazar solicitud RF-13 Gestionar paquetes nutricionales RF-15 Asignar paquete a beneficiario RF-16 Registrar entrega del paquete RF-18 Gestionar catálogo de recetas RF-19 Consultar y buscar recetas RF-22 Autenticar usuarios y gestionar roles | Conforman el flujo central de atención y la difusión de recetas; sin ellos el sistema no cumple su propósito. |
| SHOULD (8) | RF-05 Adjuntar documento de respaldo RF-06 Postular desde un centro de salud aliado RF-11 Notificar resultado de la evaluación RF-12 Detectar solicitudes duplicadas RF-14 Gestionar inventario de insumos RF-20 Mostrar contenido educativo RF-23 Generar reportes de gestión RF-24 Registrar auditoría de accesos | Mejoran la calidad y el control del proceso, pero el flujo central funciona sin ellos (p. ej. con revisión manual). |
| COULD (3) | RF-17 Programar entregas periódicas RF-21 Imprimir o descargar receta RF-25 Exportar reportes | Deseables; se incorporan solo si el cronograma lo permite. |
| WON'T (esta versión) | Campañas de recaudación de fondos Pasarelas de donaciones externas Gestión de voluntariado y eventos Aplicación móvil nativa Integración con sistemas externos de salud Diagnóstico o recomendación clínica automatizada | Excluidos por la reestructuración del proyecto o por exceder el plazo y el alcance académico. |

## Tabla 10. Matriz MoSCoW de requerimientos no funcionales

| Prioridad | Requerimientos | Justificación |
| --- | --- | --- |
| MUST (11) | RNF-01 Almacenamiento seguro de credenciales RNF-02 Control de acceso por roles RNF-03 Cifrado en tránsito RNF-04 Protección de datos sensibles en reposo RNF-05 Prevención de ataques web comunes RNF-06 Cumplimiento de la Ley N.º 29733 RNF-09 Respaldo y recuperación RNF-10 Tiempo de respuesta RNF-12 Diseño adaptable (responsive) RNF-15 Arquitectura por capas RNF-17 Uso de software libre | Protegen los datos sensibles de menores, aseguran la recuperación ante fallos y la usabilidad móvil del formulario. |
| SHOULD (5) | RNF-07 Trazabilidad de acciones RNF-08 Disponibilidad del servicio RNF-11 Capacidad concurrente RNF-13 Facilidad de uso del formulario RNF-16 Compatibilidad con navegadores | Elevan la calidad del servicio; se verifican si el tiempo de pruebas lo permite. |
| COULD (1) | RNF-14 Accesibilidad | Mejora deseable de inclusión. |
- **2.4 Especificación de Casos de Uso y Diagrama UML**
  Un caso de uso describe una interacción completa entre un actor y el sistema que produce un resultado de valor para ese actor. Esta sección identifica a los actores, lista los casos de uso derivados de los requerimientos, especifica los de prioridad Must y los representa en diagramas UML.
- **2.4.1. Especificación de casos de uso**
- **2.4.1.1. Actores del sistema**
Un actor es quien interactúa con el sistema desde afuera: una persona o un sistema externo. Los actores primarios inician los casos de uso; los secundarios apoyan al sistema.

## Tabla 11. Actores de NutriApoyo

| Actor | Tipo | Descripción |
| --- | --- | --- |
| Visitante | Primario | Cualquier persona que navega el portal sin iniciar sesión; consulta recetas y contenido educativo. |
| Tutor legal | Primario | Madre, padre o responsable legal del menor. Registra la solicitud y consulta su estado con un código de seguimiento, sin crear una cuenta. |
| Personal de centro de salud | Primario | Personal autorizado de un establecimiento aliado que registra solicitudes en nombre del tutor legal. |
| Evaluador (nutricionista) | Primario | Profesional de salud o nutrición que evalúa solicitudes, verifica criterios médicos y administra el catálogo de recetas. |
| Administrador | Primario | Gestiona paquetes, inventario, entregas, usuarios, reportes y auditoría. |
| Servicio de correo | Secundario | Sistema externo que envía las notificaciones por correo electrónico a los solicitantes. |

- **2.4.1.2. Catálogo de casos de uso**
Los 21 casos de uso cubren los 25 requerimientos funcionales. La columna RF permite rastrear cada requerimiento hasta el caso de uso que lo implementa.

## Tabla 12. Catálogo de casos de uso

| ID | Caso de uso | Actor principal | RF | Prioridad |
| --- | --- | --- | --- | --- |
| CU-01 | Registrar solicitud de apoyo | Tutor legal | RF-01, RF-02, RF-03, RF-04, RF-05 | Must |
| CU-02 | Postular desde centro de salud aliado | Personal de centro de salud | RF-06 | Should |
| CU-03 | Consultar estado de la solicitud | Tutor legal | RF-07 | Must |
| CU-04 | Gestionar bandeja de evaluación | Evaluador | RF-08 | Must |
| CU-05 | Validar criterios médicos de elegibilidad | Evaluador | RF-09, RF-12 | Must |
| CU-06 | Resolver solicitud (aprobar, observar o rechazar) | Evaluador | RF-10 | Must |
| CU-07 | Notificar resultado de la evaluación | Servicio de correo | RF-11 | Should |
| CU-08 | Subsanar solicitud observada | Tutor legal | RF-10 | Must |
| CU-09 | Gestionar paquetes nutricionales | Administrador | RF-13 | Must |
| CU-10 | Gestionar inventario de insumos | Administrador | RF-14 | Should |
| CU-11 | Asignar paquete a beneficiario | Administrador / Evaluador | RF-15 | Must |
| CU-12 | Registrar entrega del paquete | Administrador | RF-16 | Must |
| CU-13 | Programar entregas periódicas | Administrador | RF-17 | Could |
| CU-14 | Gestionar catálogo de recetas | Administrador / Evaluador | RF-18 | Must |
| CU-15 | Consultar y buscar recetas y contenido educativo | Visitante | RF-19, RF-20 | Must |
| CU-16 | Imprimir o descargar receta | Visitante | RF-21 | Could |
| CU-17 | Autenticar usuario | Administrador, Evaluador, Personal de centro de salud | RF-22 | Must |
| CU-18 | Gestionar usuarios y roles | Administrador | RF-22 | Must |
| CU-19 | Generar reportes de gestión | Administrador | RF-23 | Should |
| CU-20 | Exportar reportes | Administrador | RF-25 | Could |
| CU-21 | Consultar registro de auditoría | Administrador | RF-24 | Should |

- **2.4.1.3. Fichas de especificación**
Se especifican los 13 casos de uso de prioridad Must con una misma plantilla: actor, descripción, requerimientos asociados, precondiciones, flujo básico (el camino normal), flujos alternos y excepciones (lo que puede salir distinto) y postcondiciones (cómo queda el sistema al terminar). Los casos de prioridad Should y Could se especificarán con la misma plantilla si el cronograma lo permite. Los casos de uso del Evaluador, del Personal de centro de salud y del Administrador presuponen una sesión iniciada (CU-17).

## Fichas de especificación de casos de uso

Las siguientes fichas conservan los campos y el contenido registrado en el documento original.

### CU-01 · Registrar solicitud de apoyo

| Campo | Detalle |
|---|---|
| Actor principal | Tutor legal |
| Actores secundarios | Ninguno |
| Descripción | El tutor legal completa el formulario digital único con los datos del menor, el diagnóstico y el consentimiento informado para postular al apoyo nutricional. |
| Requerimientos asociados | RF-01, RF-02, RF-03, RF-04, RF-05 · RNF-06, RNF-13 |
| Prioridad (MoSCoW) | Must |
| Precondiciones | El sistema está disponible y el tutor accede al portal web (no requiere cuenta). |
| Flujo básico | El tutor selecciona “Solicitar apoyo nutricional” en el portal. El sistema muestra el formulario con cuatro secciones: datos del tutor, datos del menor, diagnóstico y consentimiento. El tutor completa los datos del tutor y del menor (RF-02). El tutor registra la hemoglobina, la fecha de medición, el establecimiento de salud y la condición declarada (RF-04). El tutor adjunta la constancia o resultado médico en PDF o imagen (RF-05). El tutor acepta el consentimiento informado para el tratamiento de datos personales y de salud (RNF-06). El tutor envía el formulario. El sistema valida campos obligatorios, formatos y que la edad del menor esté entre 0 y 15 años (RF-03). El sistema registra la solicitud en estado “Recibida”, genera el código de seguimiento y lo muestra al tutor. |
| Flujos alternos y excepciones | A1 (paso 8): Datos incompletos o con formato inválido: el sistema marca cada campo con un mensaje claro, conserva lo ingresado y vuelve al paso 3. A2 (paso 8): Edad fuera del rango de 0 a 15 años: el sistema no acepta la solicitud e informa el rango de atención del programa. A3 (paso 5): Archivo con formato no permitido o que excede el tamaño máximo: el sistema lo rechaza y solicita adjuntar otro. A4 (paso 7): El tutor no acepta el consentimiento: el sistema no permite enviar el formulario. |
| Postcondiciones | Solicitud registrada en estado “Recibida”, con código de seguimiento, disponible en la bandeja de evaluación. |

### CU-03 · Consultar estado de la solicitud

| Campo | Detalle |
|---|---|
| Actor principal | Tutor legal |
| Actores secundarios | Ninguno |
| Descripción | El tutor consulta en qué etapa se encuentra su solicitud usando el código de seguimiento entregado al postular. |
| Requerimientos asociados | RF-07 · RNF-02, RNF-05 |
| Prioridad (MoSCoW) | Must |
| Precondiciones | La solicitud fue registrada y el tutor conoce su código de seguimiento. |
| Flujo básico | El tutor selecciona “Consultar mi solicitud”. El sistema solicita el código de seguimiento y el documento de identidad del menor. El tutor ingresa ambos datos. El sistema verifica que correspondan a una misma solicitud. El sistema muestra el estado actual (recibida, en evaluación, observada, aprobada, rechazada o entregada), la fecha de la última actualización y, si corresponde, el motivo de la decisión. |
| Flujos alternos y excepciones | A1 (paso 4): El código y el documento no coinciden: el sistema muestra un mensaje genérico, sin revelar si el código existe, y permite reintentar. Tras varios intentos fallidos bloquea la consulta por un tiempo (RNF-05). A2 (paso 5): El estado es “Observada”: el sistema muestra el motivo y ofrece la opción “Subsanar solicitud” (CU-08). |
| Postcondiciones | Ninguna; es una consulta de solo lectura. |

### CU-04 · Gestionar bandeja de evaluación

| Campo | Detalle |
|---|---|
| Actor principal | Evaluador |
| Actores secundarios | Ninguno |
| Descripción | El evaluador revisa el listado de solicitudes pendientes, las filtra y selecciona la que va a evaluar. |
| Requerimientos asociados | RF-08 |
| Prioridad (MoSCoW) | Must |
| Precondiciones | El evaluador inició sesión (CU-17). |
| Flujo básico | El evaluador ingresa a la bandeja de evaluación. El sistema lista las solicitudes pendientes, de la más antigua a la más reciente. El evaluador aplica filtros por estado, fecha o centro de salud. El sistema actualiza el listado según los filtros. El evaluador selecciona una solicitud. El sistema muestra el detalle completo y cambia el estado a “En evaluación”. |
| Flujos alternos y excepciones | A1 (paso 4): Ninguna solicitud cumple los filtros: el sistema muestra “No se encontraron solicitudes” y permite limpiar los filtros. A2 (paso 6): Otro evaluador ya tiene abierta la solicitud: el sistema lo informa y la muestra en modo solo lectura. |
| Postcondiciones | La solicitud seleccionada queda en estado “En evaluación”. |

### CU-05 · Validar criterios médicos de elegibilidad

| Campo | Detalle |
|---|---|
| Actor principal | Evaluador |
| Actores secundarios | Sistema |
| Descripción | El sistema compara la hemoglobina declarada, ajustada por edad, con los criterios definidos y alerta de posibles duplicados, para apoyar la decisión del evaluador. |
| Requerimientos asociados | RF-09, RF-12 · RNF-04 |
| Prioridad (MoSCoW) | Must |
| Precondiciones | El evaluador inició sesión (CU-17) y tiene abierta una solicitud en estado “En evaluación” (CU-04). |
| Flujo básico | El sistema comprueba si existe otra solicitud vigente para el mismo menor (mismo documento de identidad) y, si la hay, muestra una alerta (RF-12). El sistema compara la hemoglobina declarada, ajustada por la edad del menor, con los valores de referencia configurados (RF-09). El sistema muestra el resultado: si el caso cumple o no los criterios de elegibilidad. El evaluador revisa el documento adjunto y lo contrasta con los datos declarados. El evaluador confirma la verificación y pasa a resolver la solicitud (CU-06). |
| Flujos alternos y excepciones | A1 (paso 4): No hay documento adjunto: el sistema lo advierte y el evaluador puede continuar para observar la solicitud y pedir el documento. A2 (paso 1): Existe una solicitud duplicada vigente: el evaluador decide si rechaza la solicitud por duplicidad o continúa, y la decisión queda registrada. A3 (paso 2): La hemoglobina está fuera de un rango plausible: el sistema alerta de un posible error de digitación para que el evaluador lo revise. |
| Postcondiciones | Resultado de la validación registrado para sustentar la decisión del evaluador. El sistema no emite un diagnóstico médico. |

### CU-06 · Resolver solicitud (aprobar, observar o rechazar)

| Campo | Detalle |
|---|---|
| Actor principal | Evaluador |
| Actores secundarios | Servicio de correo |
| Descripción | El evaluador registra su decisión sobre la solicitud y el sistema notifica el resultado al solicitante. |
| Requerimientos asociados | RF-10, RF-11 |
| Prioridad (MoSCoW) | Must |
| Precondiciones | El evaluador inició sesión (CU-17). La solicitud está “En evaluación” y los criterios fueron validados (CU-05). |
| Flujo básico | El evaluador selecciona la decisión “Aprobar”. El sistema solicita confirmación. El evaluador confirma. El sistema registra la decisión (usuario, fecha y hora) y cambia el estado a “Aprobada”. El sistema deja la solicitud disponible para la asignación del paquete (CU-11). El sistema notifica el resultado al solicitante (CU-07). |
| Flujos alternos y excepciones | A1 (paso 1): Observar: el evaluador indica qué debe corregirse o adjuntarse; el motivo es obligatorio. El estado pasa a “Observada” y el tutor puede subsanarla (CU-08). A2 (paso 1): Rechazar: el evaluador registra el motivo, que es obligatorio. El estado pasa a “Rechazada”. A3 (pasos 1 y 4): Falta el motivo en una observación o rechazo: el sistema no permite guardar la decisión. |
| Postcondiciones | Decisión registrada con su autor y su motivo; el solicitante queda notificado. |

### CU-08 · Subsanar solicitud observada

| Campo | Detalle |
|---|---|
| Actor principal | Tutor legal |
| Actores secundarios | Ninguno |
| Descripción | El tutor corrige los datos o adjunta los documentos que el evaluador observó para que la solicitud vuelva a evaluarse. |
| Requerimientos asociados | RF-10, RF-03, RF-05 |
| Prioridad (MoSCoW) | Must |
| Precondiciones | La solicitud está en estado “Observada” y el tutor accedió a ella con su código (CU-03). |
| Flujo básico | El tutor selecciona “Subsanar solicitud”. El sistema muestra el motivo de la observación y habilita solo los campos y documentos que deben corregirse. El tutor corrige los datos o adjunta el nuevo documento. El tutor envía la corrección. El sistema valida los datos (RF-03). El sistema actualiza la solicitud, cambia el estado a “En evaluación” y la devuelve a la bandeja del evaluador. |
| Flujos alternos y excepciones | A1 (paso 5): Los datos no superan la validación: el sistema muestra los errores y vuelve al paso 3. A2 (paso 4): El tutor no modificó nada: el sistema no permite enviar y recuerda qué debe corregirse. |
| Postcondiciones | Solicitud corregida y nuevamente en evaluación; se conserva el historial de la observación. |

### CU-09 · Gestionar paquetes nutricionales

| Campo | Detalle |
|---|---|
| Actor principal | Administrador |
| Actores secundarios | Ninguno |
| Descripción | El administrador crea, consulta, modifica y desactiva los paquetes de alimentos ricos en hierro, definidos por grupo etario. |
| Requerimientos asociados | RF-13 |
| Prioridad (MoSCoW) | Must |
| Precondiciones | El administrador inició sesión (CU-17). |
| Flujo básico | El administrador ingresa al módulo de paquetes nutricionales. El sistema lista los paquetes con su grupo etario y estado (activo o inactivo). El administrador selecciona “Nuevo paquete”. El administrador ingresa el nombre, el grupo etario y los alimentos con sus cantidades. El sistema valida que el paquete tenga grupo etario y al menos un alimento. El sistema guarda el paquete y confirma la operación. |
| Flujos alternos y excepciones | A1 (paso 3): Modificar: el administrador elige un paquete existente, cambia sus datos y guarda. Las asignaciones anteriores conservan la composición con la que se entregaron. A2 (paso 3): Desactivar: el paquete deja de ofrecerse para nuevas asignaciones, pero no se elimina, para conservar el historial. A3 (paso 5): Ya existe un paquete activo con el mismo nombre y grupo etario: el sistema lo advierte y solicita confirmar o cambiar el nombre. |
| Postcondiciones | Paquete disponible (o desactivado) para su asignación a beneficiarios. |

### CU-11 · Asignar paquete a beneficiario

| Campo | Detalle |
|---|---|
| Actor principal | Administrador |
| Actores secundarios | Evaluador |
| Descripción | El sistema propone el paquete que corresponde al grupo etario del menor de una solicitud aprobada, y el actor lo confirma. |
| Requerimientos asociados | RF-15, RF-14 |
| Prioridad (MoSCoW) | Must |
| Precondiciones | El actor inició sesión (CU-17). La solicitud está “Aprobada” y existen paquetes activos (CU-09). |
| Flujo básico | El actor abre la lista de solicitudes aprobadas sin paquete asignado. El actor selecciona una solicitud. El sistema calcula la edad del menor, determina su grupo etario y propone el paquete correspondiente. El actor revisa la propuesta y la confirma. El sistema registra la asignación y la deja pendiente de entrega (CU-12). |
| Flujos alternos y excepciones | A1 (paso 3): No existe un paquete activo para ese grupo etario: el sistema lo informa y no permite asignar hasta que el administrador cree uno (CU-09). A2 (paso 4): Si el inventario está implementado (CU-10) y no hay stock suficiente: el sistema advierte y permite posponer la asignación. |
| Postcondiciones | Paquete asignado a la solicitud aprobada, listo para su entrega. |

### CU-12 · Registrar entrega del paquete

| Campo | Detalle |
|---|---|
| Actor principal | Administrador |
| Actores secundarios | Ninguno |
| Descripción | El administrador registra la entrega física del paquete al tutor, dejando trazabilidad hasta el beneficiario. |
| Requerimientos asociados | RF-16 |
| Prioridad (MoSCoW) | Must |
| Precondiciones | El administrador inició sesión (CU-17). La solicitud está aprobada y tiene un paquete asignado (CU-11). |
| Flujo básico | El administrador busca la solicitud por código de seguimiento o documento de identidad. El sistema muestra al beneficiario y el paquete asignado. El administrador entrega físicamente el paquete al tutor. El administrador registra la fecha, el responsable de la entrega y la conformidad (nombre y documento de quien recibe). El sistema guarda la entrega y cambia el estado de la solicitud a “Entregada”. |
| Flujos alternos y excepciones | A1 (paso 3): El tutor no se presenta: el administrador registra el intento con su motivo y la solicitud sigue aprobada, pendiente de entrega. A2 (paso 1): La entrega ya fue registrada: el sistema lo informa y no permite duplicarla. |
| Postcondiciones | Entrega registrada con fecha, responsable y conformidad; solicitud en estado “Entregada”. |

### CU-14 · Gestionar catálogo de recetas

| Campo | Detalle |
|---|---|
| Actor principal | Administrador / Evaluador (nutricionista) |
| Actores secundarios | Ninguno |
| Descripción | El actor registra, modifica y despublica recetas con alimentos ricos en hierro para orientar a las familias. |
| Requerimientos asociados | RF-18 |
| Prioridad (MoSCoW) | Must |
| Precondiciones | El actor inició sesión (CU-17). |
| Flujo básico | El actor ingresa al módulo de recetas. El sistema lista las recetas con su estado (publicada o no publicada). El actor selecciona “Nueva receta”. El actor ingresa nombre, ingredientes, porciones, preparación, aporte de hierro y grupo etario recomendado. El sistema valida los campos obligatorios y que el aporte de hierro sea un valor numérico positivo. El actor elige “Publicar” y el sistema guarda la receta, que queda visible en el catálogo público. |
| Flujos alternos y excepciones | A1 (paso 3): Modificar: el actor edita una receta existente y guarda los cambios. A2 (paso 3): Despublicar: la receta deja de mostrarse a los visitantes, pero se conserva. A3 (paso 6): El actor elige “Guardar sin publicar”: la receta queda registrada pero no visible. A4 (paso 5): Faltan datos obligatorios: el sistema no permite guardar y señala los campos. |
| Postcondiciones | Receta registrada y publicada (o no publicada) según la elección del actor. |

### CU-15 · Consultar y buscar recetas y contenido educativo

| Campo | Detalle |
|---|---|
| Actor principal | Visitante |
| Actores secundarios | Ninguno |
| Descripción | Cualquier persona explora el catálogo de recetas ricas en hierro y lee los consejos de educación nutricional, sin iniciar sesión. |
| Requerimientos asociados | RF-19, RF-20 |
| Prioridad (MoSCoW) | Must |
| Precondiciones | Ninguna; el catálogo es público. |
| Flujo básico | El visitante ingresa al catálogo de recetas. El sistema muestra las recetas publicadas. El visitante filtra por grupo etario, ingrediente o tipo de comida. El sistema muestra las recetas que cumplen los filtros. El visitante selecciona una receta. El sistema muestra su detalle (ingredientes, porciones, preparación y aporte de hierro) junto con los consejos de educación nutricional asociados. |
| Flujos alternos y excepciones | A1 (paso 4): Ninguna receta cumple los filtros: el sistema lo indica y sugiere ampliar la búsqueda. A2 (paso 6): El visitante desea guardar la receta: puede imprimirla o descargarla en PDF (CU-16). |
| Postcondiciones | Ninguna; es una consulta de solo lectura. |

### CU-17 · Autenticar usuario

| Campo | Detalle |
|---|---|
| Actor principal | Administrador, Evaluador o Personal de centro de salud |
| Actores secundarios | Ninguno |
| Descripción | El usuario inicia sesión y el sistema le habilita únicamente las opciones que corresponden a su rol. |
| Requerimientos asociados | RF-22, RF-24 · RNF-01, RNF-02, RNF-05 |
| Prioridad (MoSCoW) | Must |
| Precondiciones | El usuario tiene una cuenta activa creada por el administrador (CU-18). |
| Flujo básico | El usuario selecciona “Iniciar sesión”. El usuario ingresa su usuario y contraseña. El sistema valida las credenciales comparando el hash con sal de la contraseña (RNF-01). El sistema identifica el rol y redirige al panel correspondiente, con solo las opciones permitidas (RNF-02). El sistema registra el acceso en la auditoría (RF-24). |
| Flujos alternos y excepciones | A1 (paso 3): Credenciales incorrectas: el sistema muestra un mensaje genérico, sin indicar cuál dato falló. A2 (paso 3): Varios intentos fallidos seguidos: el sistema bloquea el acceso temporalmente. A3 (paso 3): La cuenta está desactivada: el sistema niega el acceso. A4 (paso 4): Sesión inactiva por un tiempo prolongado: el sistema la cierra automáticamente y pide volver a iniciar sesión. |
| Postcondiciones | Sesión iniciada con el rol correspondiente; acceso registrado en la auditoría. |

### CU-18 · Gestionar usuarios y roles

| Campo | Detalle |
|---|---|
| Actor principal | Administrador |
| Actores secundarios | Ninguno |
| Descripción | El administrador crea y mantiene las cuentas del personal que opera el sistema y les asigna su rol. |
| Requerimientos asociados | RF-22 · RNF-01, RNF-02 |
| Prioridad (MoSCoW) | Must |
| Precondiciones | El administrador inició sesión (CU-17). |
| Flujo básico | El administrador ingresa al módulo de usuarios. El sistema lista los usuarios con su rol y estado. El administrador selecciona “Nuevo usuario”. El administrador ingresa nombres, correo electrónico y rol (evaluador, personal de centro de salud o administrador). El sistema valida los datos y verifica que el correo no esté registrado. El sistema crea la cuenta con una contraseña temporal que el usuario deberá cambiar en su primer acceso. |
| Flujos alternos y excepciones | A1 (paso 5): El correo ya está registrado: el sistema lo informa y no crea la cuenta. A2 (paso 3): Cambiar rol: el administrador edita el rol de un usuario y el cambio se aplica en su siguiente inicio de sesión. A3 (paso 3): Desactivar usuario: la cuenta no puede iniciar sesión, pero se conserva para mantener la trazabilidad. |
| Postcondiciones | Cuenta creada, modificada o desactivada; la acción queda registrada en la auditoría. |

## Diagramas UML
Se presentan cuatro diagramas, uno por grupo funcional, para que cada uno sea legible. En ellos, el rectángulo es el límite del sistema; los óvalos son casos de uso; las figuras humanas son actores; la línea continua une al actor con el caso de uso que ejecuta; la flecha punteada «include» indica que el caso de uso de origen siempre ejecuta al de destino; y la flecha punteada «extend» indica que el caso de uso de origen amplía al de destino solo cuando se cumple una condición.


3. **Diseño del Sistema**
   - 3.1 Modelado de Procesos de Negocio en BPMN (AS-IS y TO-BE)
   - 3.2 Diseño Lógico (DER) y Físico (MySQL) de la Base de Datos
   - 3.3 Arquitectura de Software Java (MVC + DAO)
4. **Desarrollo e Implementación**
   - 4.1 Programación Backend en Java
   - 4.2 Interfaz Web UI/UX (Formularios, Recetas y Dashboard)
   - 4.3 Integración con Base de Datos MySQL
5. **Pruebas, Despliegue y Cierre**
   - 5.1 Pruebas funcionales e integración
   - 5.2 Pruebas de seguridad y roles
   - 5.3 Entrega del informe final y sustentación

---

## 1.4. Cronograma de Actividades (Diagrama de Gantt)
- **Semanas 1 - 3:** Planificación Inicial del Proyecto (Project Charter, Lean Canvas y WBS).
- **Semanas 4 - 5:** Análisis de Requerimientos y Levantamiento de Casos de Uso de Formularios y Recetas.
- **Semanas 6 - 7:** Diseño del Sistema (Modelo de Base de Datos MySQL, BPMN y Arquitectura Java MVC).
- **Semanas 8 - 12:** Desarrollo e Implementación Modular (Formularios de postulación, Catálogo de Recetas y Panel Administrativo).
- **Semanas 13 - 15:** Pruebas Funcionales, Validación de Seguridad por Roles y Correcciones.
- **Semana 16:** Entrega del Informe Final y Sustentación del Proyecto.
