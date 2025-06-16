# Proyecto

## Descripción

Este proyecto implementa una aplicación utilizando un enfoque de arquitectura MVC, con un backend desarrollado en Java utilizando Spring Boot y Gradle, y un frontend en Angular con TypeScript. El almacenamiento de datos se realiza en una base de datos en memoria H2.

---

## Tecnologías Utilizadas

### Backend:

* **Java**: Versión 17.
* **Spring Boot**: Framework principal para la construcción de la aplicación backend.
* **Gradle**: Versión 8.14, utilizado como herramienta de construcción y gestión de dependencias.
* **H2 Database**: Base de datos en memoria para pruebas y desarrollo rápido.

### Frontend:

* **Angular**: Framework para la creación de aplicaciones web modernas.
* **TypeScript**: Lenguaje utilizado en el desarrollo del frontend para tipado estático y mantenimiento del código.

### Arquitectura:

* **MVC (Modelo-Vista-Controlador)**

---

## Configuración e Instalación

### Requisitos Previos

* Java 17 instalado y configurado.
* Gradle 8.14 instalado.
* Node.js y npm instalados para el frontend.
* Angular CLI instalado globalmente.

### Pasos para el Backend

1. Clonar el repositorio del proyecto.
2. Navegar al directorio del backend.
3. Ejecutar el siguiente comando para iniciar la aplicación:

   ```bash
   ./gradlew bootRun
   ```
4. Acceder a la aplicación desde `http://localhost:8081`.

### Pasos para el Frontend

1. Navegar al directorio del frontend.
2. Instalar las dependencias ejecutando:

   ```bash
   npm install
   ```
3. Iniciar el servidor de desarrollo:

   ```bash
   ng serve
   ```
4. Acceder a la aplicación desde `http://localhost:4200`.

---

## Uso de la Base de Datos H2

La base de datos H2 está configurada para ejecutarse en memoria durante el desarrollo. Para acceder a la consola de H2:

1. Iniciar el backend.
2. Abrir en el navegador `http://localhost:8080/h2-console`.

   `Los Datos se encuentre pre cargargados al inciar la aplicacion`

---

## Estructura del Proyecto

### Backend

```
/src/main/java
    /com/ejemplo/proyecto
        /controller   # Controladores
        /service      # Lógica de negocio
        /repository   # Acceso a la base de datos
        /model        # Entidades
```

### Frontend

```
/src/app
  /employee
    /components   # Componentes de la aplicación
    /services     # Servicios para interactuar con la API
    /models     # Interfaces y modelos de datos
  /department
    /components   # Componentes de la aplicación
    /services     # Servicios para interactuar con la API
    /models     # Interfaces y modelos de datos
```


