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
- En construcción 

## 🏗️ Arquitectura

El proyecto sigue una arquitectura MVC (Modelo-Vista-Controlador) con una API RESTful:
Backend/ ├── controller/ # Controladores REST ├── model/ # Entidades y modelos ├── repository/ # Interfaces de repositorio ├── service/ # Lógica de negocio └── security/ # Configuración de seguridad


## 🔐 Roles y Permisos

El sistema implementa tres niveles de acceso:

| Rol | Permisos |
|-----|----------|
| RECEPCION | Gestión de clientes y reservas |
| SERVICIO | Control de habitaciones y servicios adquiridos |
| ADMINISTRACION | Acceso completo al sistema |

## 🚀 Endpoints API

##  API Endpoints Detallados

### Cliente (`/apihotel/cliente`)
> Requiere rol: RECEPCION

| Método | Endpoint | Descripción | Rol Requerido |
|--------|----------|-------------|---------------|
| GET | `/` | Obtiene lista de todos los clientes | RECEPCION |
| GET | `/{cedulaC}` | Obtiene cliente por cédula | RECEPCION |
| POST | `/` | Crea nuevo cliente | RECEPCION |
| PUT | `/{cedulaC}` | Actualiza información de cliente | RECEPCION |
| DELETE | `/{cedulaC}` | Elimina cliente del sistema | ADMINISTRACION |

### Hotel (`/apihotel/hotel`)
> Requiere rol: ADMINISTRACION

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/` | Lista todos los hoteles |
| GET | `/{idHotel}` | Obtiene hotel por ID |
| POST | `/` | Registra nuevo hotel |
| DELETE | `/{idHotel}` | Elimina hotel |

### Reserva (`/apihotel/reserva`)
> Requiere rol: RECEPCION

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/` | Lista todas las reservas |
| GET | `/{idReserva}` | Obtiene reserva por ID |
| POST | `/` | Crea nueva reserva |
| PUT | `/{idReserva}` | Actualiza reserva existente |
| DELETE | `/{idReserva}` | Cancela reserva |

### Habitación (`/apihotel/habitacion`)
> Requiere rol: SERVICIO, ADMINISTRACION

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/` | Lista todas las habitaciones |
| GET | `/{numHabitacion}` | Obtiene habitación por número |
| POST | `/` | Registra nueva habitación |
| PUT | `/{numHabitacion}` | Actualiza información de habitación |
| DELETE | `/{numHabitacion}` | Elimina habitación del sistema |

### Servicio (`/apihotel/servicio`)
> Requiere rol: SERVICIO, ADMINISTRACION

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/` | Lista todos los servicios disponibles |
| GET | `/{idServicio}` | Obtiene servicio por ID |
| POST | `/` | Crea nuevo servicio |
| PUT | `/{idServicio}` | Actualiza información de servicio |
| DELETE | `/{idServicio}` | Elimina servicio |

### Servicios Adquiridos (`/apihotel/adquiere`)
> Requiere rol: SERVICIO

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/` | Lista todos los servicios adquiridos |
| GET | `/{idServicio}/{cedulaC}` | Obtiene servicio adquirido específico |
| POST | `/` | Registra nuevo servicio adquirido |
| PUT | `/{idServicio}/{cedulaC}` | Actualiza servicio adquirido |
| DELETE | `/{idServicio}/{cedulaC}` | Elimina registro de servicio adquirido |

### Servicios por Hotel (`/apihotel/ofrece`)
> Requiere rol: ADMINISTRACION

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/` | Lista todos los servicios ofrecidos por hoteles |
| GET | `/{idhotel}/{idservicio}` | Obtiene servicio específico de un hotel |
| POST | `/` | Registra nuevo servicio para un hotel |
| PUT | `/{idhotel}/{idservicio}` | Actualiza servicio ofrecido |
| DELETE | `/{idhotel}/{idservicio}` | Elimina servicio de un hotel |

### Formato de Respuestas

Las respuestas siguen el siguiente formato JSON:

### Códigos de Estado

- 200: Operación exitosa
- 201: Recurso creado exitosamente
- 400: Solicitud incorrecta
- 401: No autorizado
- 403: Acceso prohibido
- 404: Recurso no encontrado
- 500: Error interno del servidor

*[Documentación completa de endpoints en desarrollo]*

## 💻 Instalación y Configuración

### Requisitos Previos
- Java 24
- PostgreSQL

## 📊 Base de Datos
El sistema utiliza PostgreSQL como gestor de base de datos. El esquema incluye tablas para:
- Clientes
- Reservas
- Habitaciones
- Servicios
- Hoteles
- Relaciones (Ofrece, Adquiere)

## 👥 Contribución
Este es un proyecto académico desarrollado para la Universidad FJdC. Las contribuciones son bienvenidas mediante pull requests.

## 📄 Licencia
Este proyecto está bajo la Licencia GNU - ver el archivo [LICENSE.md](LICENSE.md) para más detalles.

## ✍️ Autor
Edd

## 🎓 Agradecimientos
- Universidad Francisco José de Caldas - Facultad de Ingeniería
- Bases de Datos

---
*Nota: Este proyecto es parte de una asignatura universitaria y está diseñado con fines educativos.*
