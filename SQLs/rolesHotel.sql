-- 1. Creamos los roles de la base de datos
CREATE ROLE recepcion NOINHERIT;
CREATE ROLE servicio NOINHERIT;
CREATE ROLE administracion NOINHERIT;

-- 2. Asignamos permisos sobre esquemas y tablas
-- Asumimos que ya tienes el esquema hotel creado

-- Recepción: clientes y reservas
GRANT USAGE ON SCHEMA hotel TO recepcion;
GRANT SELECT, INSERT, UPDATE ON hotel.cliente TO recepcion;
GRANT SELECT, INSERT, UPDATE ON hotel.reserva TO recepcion;
GRANT SELECT ON hotel.habitacion TO recepcion;

-- Servicio: estado de habitaciones y consumos
GRANT USAGE ON SCHEMA hotel TO servicio;
GRANT SELECT, UPDATE ON hotel.habitacion TO servicio;
GRANT SELECT, INSERT ON hotel.adquiere TO servicio;

-- Administración: empleados, servicios y consultas generales
GRANT USAGE ON SCHEMA hotel TO administracion;
GRANT SELECT, INSERT, UPDATE, DELETE ON hotel.empleado TO administracion;
GRANT SELECT, INSERT, UPDATE, DELETE ON hotel.servicio TO administracion;
GRANT SELECT ON hotel.cliente, hotel.reserva, hotel.adquiere TO administracion;
