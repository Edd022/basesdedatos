# 🏨 Logan Hotel Management System

## 📝 Descripción
Sistema de gestión hotelera desarrollado como proyecto final para la asignatura de Bases de Datos. Esta aplicación permite administrar reservas, clientes, servicios y habitaciones de una cadena hotelera.

## 🛠️ Tecnologías Utilizadas

### Backend
- Java 24
- Spring Boot
- Spring Data JPA
- Spring Security
- PostgreSQL
- Jakarta EE
- Lombok

### Frontend
- React
- Material-UI
- Axios
- React Router DOM

## 🏗️ Arquitectura

El proyecto sigue una arquitectura MVC (Modelo-Vista-Controlador) con una API RESTful:
Backend/ ├── controller/ # Controladores REST ├── model/ # Entidades y modelos ├── repository/ # Interfaces de repositorio ├── service/ # Lógica de negocio └── security/ # Configuración de seguridad
Frontend/ ├── components/ # Componentes React ├── services/ # Servicios API └── utils/ # Utilidades


## 🔐 Roles y Permisos

El sistema implementa tres niveles de acceso:

| Rol | Permisos |
|-----|----------|
| RECEPCION | Gestión de clientes y reservas |
| SERVICIO | Control de habitaciones y servicios adquiridos |
| ADMINISTRACION | Acceso completo al sistema |

## 🚀 Endpoints API

### Clientes
- `GET /apihotel/cliente` - Listar todos los clientes
- `GET /apihotel/cliente/{id}` - Obtener cliente por ID
- `POST /apihotel/cliente` - Crear nuevo cliente
- `PUT /apihotel/cliente/{id}` - Actualizar cliente
- `DELETE /apihotel/cliente/{id}` - Eliminar cliente

### Reservas
- `GET /apihotel/reserva` - Listar todas las reservas
- `POST /apihotel/reserva` - Crear nueva reserva
- `PUT /apihotel/reserva/{id}` - Actualizar reserva
- `DELETE /apihotel/reserva/{id}` - Cancelar reserva

*[Documentación completa de endpoints en desarrollo]*

## 💻 Instalación y Configuración

### Requisitos Previos
- Java 24
- PostgreSQL
- Node.js y npm
- Maven


## 📊 Base de Datos
El sistema utiliza PostgreSQL como gestor de base de datos. El esquema incluye tablas para:
- Clientes
- Reservas
- Habitaciones
- Servicios
- Hoteles
- Relaciones (Ofrece, Adquiere)

## 👥 Contribución
Este es un proyecto académico desarrollado para la Universidad [Nombre de tu Universidad]. Las contribuciones son bienvenidas mediante pull requests.

## 📄 Licencia
Este proyecto está bajo la Licencia MIT - ver el archivo [LICENSE.md](LICENSE.md) para más detalles.

## ✍️ Autor
[Tu Nombre]

## 🎓 Agradecimientos
- Universidad Francisco José de Caldas - Facultad de Ingeniería
- Bases de Datos

---
*Nota: Este proyecto es parte de una asignatura universitaria y está diseñado con fines educativos.*
