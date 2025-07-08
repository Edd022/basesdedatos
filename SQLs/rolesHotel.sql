Espera, te muestro lo que hemos hecho en roles:
-- 1. Creamos los roles de la base de datos
CREATE ROLE recepcion NOINHERIT;
CREATE ROLE servicio NOINHERIT;
CREATE ROLE administracion NOINHERIT;

-- 2. Asignamos permisos sobre esquemas y tablas

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

-- Crear usuarios con contraseñas (de ejemplo)
CREATE USER usuario_recepcion WITH PASSWORD 'password_recepcion';
CREATE USER usuario_servicio WITH PASSWORD 'password_servicio';
CREATE USER usuario_admin WITH PASSWORD 'password_admin';

-- Asignar los roles a los usuarios
GRANT recepcion TO usuario_recepcion;
GRANT servicio TO usuario_servicio;
GRANT administracion TO usuario_admin;

-- Crear tabla de usuarios y roles en el esquema hotel
CREATE TABLE hotel.users (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(500) NOT NULL,
    enabled BOOLEAN NOT NULL
);

CREATE TABLE hotel.authorities (
    username VARCHAR(50),
    authority VARCHAR(50),
    CONSTRAINT fk_authorities_users FOREIGN KEY(username) REFERENCES hotel.users(username)
);

-- Crear índice único
CREATE UNIQUE INDEX ix_auth_username ON hotel.authorities (username, authority);

-- Insertar usuarios (las contraseñas deberán ser encriptadas con BCrypt)
INSERT INTO hotel.users (username, password, enabled) 
VALUES 
    ('usuario_recepcion', '{bcrypt}$2a$10$yourEncryptedPasswordHere', true),
    ('usuario_servicio', '{bcrypt}$2a$10$yourEncryptedPasswordHere', true),
    ('usuario_admin', '{bcrypt}$2a$10$yourEncryptedPasswordHere', true);

-- Asignar roles
INSERT INTO hotel.authorities (username, authority) 
VALUES 
    ('usuario_recepcion', 'ROLE_RECEPCION'),
    ('usuario_servicio', 'ROLE_SERVICIO'),
    ('usuario_admin', 'ROLE_ADMINISTRACION');
-- Table: hotel.authorities

-- DROP TABLE IF EXISTS hotel.authorities;

CREATE TABLE IF NOT EXISTS hotel.authorities
(
    username character varying(50) COLLATE pg_catalog."default",
    authority character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT fk_authorities_users FOREIGN KEY (username)
        REFERENCES hotel.users (username) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS hotel.authorities
    OWNER to postgres;
-- Index: ix_auth_username

-- DROP INDEX IF EXISTS hotel.ix_auth_username;

CREATE UNIQUE INDEX IF NOT EXISTS ix_auth_username
    ON hotel.authorities USING btree
    (username COLLATE pg_catalog."default" ASC NULLS LAST, authority COLLATE pg_catalog."default" ASC NULLS LAST)
    TABLESPACE pg_default;