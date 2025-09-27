HEAD
Sesiones-de-Bienestar
Proyecto de gestión de sesiones
//By Fernando Equité
El proyecto consiste en la creación de un sistema para gestionar citas, servicios, clientes y facturación para el centro de bienestar
incluye el uso de las siguientes tecnologías
Backend en Spring Boot con base de datos PostgreSQL en la nube
Frontend Web en React para administración y recepción
Aplicación Móvil Android para uso de los clientes
las funcionalidades principales son: registro de clientes, facturación, historial de sesiones, gestion de citas, notificaciones y reportes.
(Primer Avance: estructura inicial, diagramas y README)







AVANCE 03

\# Sesiones de Bienestar



\## 📌 Avance 03 – Migración a PostgreSQL con JPA/Hibernate



En esta tercera entrega se migró el sistema de un CRUD en memoria a una base de datos \*\*PostgreSQL\*\* usando \*\*Spring Boot + JPA/Hibernate\*\*.



\### 🔹 Cambios principales

\- Entidades anotadas con `@Entity`, `@Table`, `@Id`, `@GeneratedValue`.  

\- Relaciones:

&nbsp; - Cliente (1) ↔ (N) Cita.

&nbsp; - Servicio (1) ↔ (N) Cita.

&nbsp; - Cita (1) ↔ (1) Factura.

\- Creación de repositorios que extienden `JpaRepository`.  

\- Validaciones de integridad:

&nbsp; - `@Column(unique, nullable)` en atributos clave.

&nbsp; - Relaciones `@OneToMany`, `@ManyToOne`, `@OneToOne` según el caso.



\### 🔹 Diagrama ER

!\[Diagrama ER](docs/ERD.png)



\### 🔹 Evidencia de pruebas

Endpoints REST implementados y probados con Postman:  



\- \*\*Clientes\*\*

&nbsp; - `POST /clientes`

&nbsp; - `GET /clientes`

\- \*\*Servicios\*\*

&nbsp; - `POST /servicios`

&nbsp; - `GET /servicios`

\- \*\*Citas\*\*

&nbsp; - `POST /citas`

&nbsp; - `GET /citas`

\- \*\*Facturas\*\*

&nbsp; - `POST /facturas`

&nbsp; - `GET /facturas`

\- \*\*Usuarios\*\*

&nbsp; - `POST /usuarios`

&nbsp; - `GET /usuarios`



Ejemplo de inserción de Factura:



```json

POST /facturas

{

&nbsp; "fechaEmision": "2025-09-15",

&nbsp; "monto": 200.50,

&nbsp; "cita": { "idCita": 1 }

}



