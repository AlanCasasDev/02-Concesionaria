🚗 Concesionaria - Aplicación Java con Persistencia

Aplicación de escritorio desarrollada en Java que simula la gestión de una concesionaria de vehículos.
Permite registrar, listar, modificar y eliminar vehículos almacenados en una base de datos SQL mediante JPA (EclipseLink).

🛠 Tecnologías utilizadas

Java

Maven

JPA (EclipseLink)

MySQL

Swing (Interfaz gráfica)

XAMPP (para entorno local de base de datos)

Git & GitHub

📂 Estructura del proyecto
src/
 └── main/
      ├── java/
      │     ├── logica
      │     ├── persistencia
      │     └── igu
      └── resources/
pom.xml

logica → Contiene la lógica del negocio.

persistencia → Controladores JPA y acceso a base de datos.

igu → Ventanas y componentes Swing.

pom.xml → Configuración y dependencias del proyecto.

🗄 Configuración de la Base de Datos

⚠️ Este proyecto requiere una base de datos SQL para funcionar.

En mi caso utilicé XAMPP con MySQL.

🔧 Pasos para configurar:

Instalar XAMPP.

Iniciar el servicio Apache y MySQL.

Entrar a http://localhost/phpmyadmin.

Crear una base de datos llamada:

concesionaria

Verificar que las credenciales coincidan con las configuradas en persistence.xml:

<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/javaweb?serverTimezone=UTC"/>
<property name="javax.persistence.jdbc.user" value="root"/>
<property name="javax.persistence.jdbc.password" value=""/>

Si utilizás otro usuario o contraseña, deberás modificar esos valores.

▶ Cómo ejecutar el proyecto
Opción 1 — Desde NetBeans

Abrir el proyecto.

Configurar la base de datos.

Ejecutar el proyecto.

Opción 2 — Desde consola con Maven
mvn clean install
mvn exec:java
📌 Consideraciones técnicas

La generación de tablas está configurada en modo:

eclipselink.ddl-generation = create-tables

Por lo tanto, las tablas se crearán automáticamente si no existen.

El proyecto utiliza transacciones RESOURCE_LOCAL.

📈 Estado del proyecto

✔ Funcional
✔ Persistencia conectada a base de datos
✔ CRUD básico implementado


👨‍💻 Autor

Alan Casas
Desarrollador Java en formación 🚀
