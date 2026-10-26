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

   - 2.2 Requerimientos funcionales y no funcionales (Formularios y Recetas)
   - 2.3 Matriz de priorización MoSCOW
   - 2.4 Especificación de Casos de Uso y Diagrama UML
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
