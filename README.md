# 🛒 Sistema de Ecommerce

Aplicación web de comercio electrónico desarrollada con una arquitectura cliente-servidor, compuesta por:

* **Backend:** Spring Boot (Java)
* **Frontend:** React
* **Base de Datos:** MySQL (XAMPP)

El sistema permite la gestión de productos mediante una API REST y una interfaz web moderna para visualizar, administrar y consumir la información almacenada en la base de datos.

---

# 🚀 Tecnologías Utilizadas

## Backend

* Java 17
* Spring Boot
* Spring Data JPA
* Maven
* MySQL

## Frontend

* React
* Vite
* JavaScript
* HTML5
* CSS3

## Base de Datos

* MySQL (XAMPP)

---

# 📋 Requisitos Previos

Antes de ejecutar el proyecto, asegurate de tener instalado:

* Java 17 o superior
* Node.js (versión LTS recomendada)
* Maven
* XAMPP (Apache y MySQL)

---

# 💾 Configuración de la Base de Datos

1. Abrir el panel de **XAMPP**.
2. Iniciar los servicios:

   * Apache
   * MySQL
3. Ingresar a:

```text
http://localhost/phpmyadmin
```

4. Crear una base de datos llamada:

```sql
ecommerce
```

> **Importante:** El backend está configurado para conectarse a MySQL utilizando el puerto `3306` o `3307` según la configuración local. Verificá que coincida con tu instalación de XAMPP.

---

# ☕ Configuración y Ejecución del Backend

El backend expone una API REST encargada de gestionar los productos y la persistencia de datos.

## 1. Abrir el proyecto

Abrir la carpeta del backend en Visual Studio Code o en el IDE de preferencia.

## 2. Verificar la configuración

Revisar el archivo:

```text
src/main/resources/application.properties
```

Configuración de ejemplo:

```properties
spring.datasource.url=jdbc:mysql://localhost:3307/ecommerce
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
```

## 3. Ejecutar la aplicación

Desde la clase principal:

```text
ProductosApplication.java
```

o desde una terminal:

```bash
mvn spring-boot:run
```

### Inicialización automática

La primera vez que se ejecuta el proyecto, un componente de inicialización (`DataInitializer`) carga automáticamente productos de prueba en la base de datos para facilitar las pruebas y demostraciones.

---

# ⚛️ Configuración y Ejecución del Frontend

El frontend proporciona:

* Catálogo de productos
* Paginación
* Carrito de compras
* Panel de administración y gestión

## 1. Abrir el proyecto

Abrir la carpeta del frontend en una nueva ventana de Visual Studio Code.

## 2. Instalar dependencias

```bash
npm install
```

## 3. Iniciar el servidor de desarrollo

```bash
npm run dev
```

## 4. Abrir la aplicación

Acceder desde el navegador a la URL mostrada en la consola.

Generalmente:

```text
http://localhost:5173
```

---

# 🔄 Arquitectura del Sistema

El flujo de comunicación se encuentra organizado de la siguiente manera:

```text
React (Frontend)
        │
        │ HTTP (Fetch / Axios)
        ▼
Spring Boot (Backend REST API)
        │
        │ JPA / Hibernate
        ▼
MySQL (XAMPP)
```

### Frontend (React)

* Consume la API REST mediante peticiones HTTP.
* Muestra el catálogo de productos.
* Permite operaciones de administración y gestión.

### Backend (Spring Boot)

* Expone endpoints REST.
* Gestiona la lógica de negocio.
* Realiza operaciones CRUD sobre los productos.

### Base de Datos (MySQL)

* Almacena los productos y su información.
* Mantiene la persistencia de los datos del sistema.

---

# 📂 Estructura General del Proyecto

```text
ecommerce/
│
├── backend/
│   ├── src/
│   ├── pom.xml
│   └── application.properties
│
├── frontend/
│   ├── src/
│   ├── public/
│   ├── package.json
│   └── vite.config.js
│
└── README.md
```

---

# ▶️ Puesta en Marcha Rápida

1. Iniciar Apache y MySQL desde XAMPP.
2. Crear la base de datos `ecommerce`.
3. Ejecutar el backend:

```bash
mvn spring-boot:run
```

4. Ejecutar el frontend:

```bash
npm install
npm run dev
```

5. Abrir:

```text
http://localhost:5173

Usuario administrador
Usuario: admin
Contraseña: 1234

Usuario de compra
Usuario: pepe
Contraseña: 1234


```

---

# 👥 Autor: Marina L.

Proyecto desarrollado como entrega final de un sistema de comercio electrónico utilizando Spring Boot, React y MySQL.
