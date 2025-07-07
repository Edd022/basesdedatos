
--INTEGRANTES
--Edward Julian Garcia Gaitan – 20212020136
--Andres Felipe Lopez Martinez - 20241020052


CREATE SCHEMA IF NOT EXISTS hotel;
SET search_path TO hotel;

--Creacion de tablas
CREATE TABLE IF NOT EXISTS empleado (
	cedulaE NUMERIC(11),
	primerNE VARCHAR(255) NOT NULL,
	segundoNE VARCHAR(255) NULL,
	primerAE VARCHAR(255) NOT NULL,
	segundoAE VARCHAR(255) NULL,
	calleE VARCHAR(255),
	carreraE VARCHAR(255),
	numeroE VARCHAR(20),
	cargo VARCHAR(255),
	area varchar (255)
);

CREATE TABLE IF NOT EXISTS telefonoE(
	cedulaE NUMERIC(11),
	telefonoE NUMERIC(12)
);

CREATE TABLE IF NOT EXISTS trabaja(
	cedulaE NUMERIC(11),
	idHotel numeric(4)
);


CREATE TABLE IF NOT EXISTS hotel(
	idHotel NUMERIC(4),
	nombreH VARCHAR(255)
);


CREATE TABLE IF NOT EXISTS ofrece(
	idHotel NUMERIC(4),
	idServicio NUMERIC(3)
);


CREATE TABLE IF NOT EXISTS servicio(
	idServicio NUMERIC(3),
	nombreServicio VARCHAR(255),
	costoS NUMERIC(6)
);

CREATE TABLE IF NOT EXISTS caracteristicaS(
	idServicio NUMERIC(3),
	caracteristica VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS cliente (
	cedulaC NUMERIC(11),
	primerNC  VARCHAR(255) NOT NULL,
	segundoNC VARCHAR(255) NULL,
	primerAC  VARCHAR(255) NOT NULL,
	segundoAC VARCHAR(255) NULL,
	calleC VARCHAR(255),
	carreraC VARCHAR(255),
	numeroC VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS telefonoC(
	cedulaC NUMERIC(11),
	telefonoC NUMERIC(12)
);

CREATE TABLE IF NOT EXISTS correoC(
	cedulaC NUMERIC(11),
	correoC VARCHAR (255)
);

CREATE TABLE IF NOT EXISTS reserva(
	idHabitacion NUMERIC(4),
	cedulaC NUMERIC(11), 
	fechaLlegada TIMESTAMP,
	detalle VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS habitacion(
	idHotel NUMERIC(4),
	idHabitacion NUMERIC(4),
	idcategoria integer,
	estadoDisponibilidad BOOLEAN NULL,
	precioNoche NUMERIC (7)
);

CREATE TABLE IF NOT EXISTS caracteristicaH(
	idHabitacion NUMERIC(4),
	caracteristicaH VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS tieneC(
	idHabitacion NUMERIC(4),
	idCategoria NUMERIC(2),
);

CREATE TABLE IF NOT EXISTS categoria(
	idCategoria INT GENERATED ALWAYS AS IDENTITY,
	nombreCategoria VARCHAR(255)	
);

CREATE TABLE IF NOT EXISTS adquiere(
	cedulaC NUMERIC(11),
	idHabitacion NUMERIC(4),
	idServicio NUMERIC(3),
	fechaHora TIMESTAMP
);

--Constraints
--Empleado
ALTER TABLE empleado
ADD CONSTRAINT PK_empleado PRIMARY KEY (cedulaE);
ALTER TABLE empleado
ADD CONSTRAINT CK_cedulaE CHECK (cedulaE>0);

--telefonoE
ALTER TABLE telefonoE
ADD CONSTRAINT FK_cedulaET FOREIGN KEY (cedulaE)
REFERENCES empleado (cedulaE);
ALTER TABLE telefonoE
ADD CONSTRAINT PK_telefonoE PRIMARY KEY (cedulaE, telefonoE);

--hotel
ALTER TABLE hotel
ADD CONSTRAINT PK_hotel PRIMARY KEY (idHotel);
ALTER TABLE hotel
ADD CONSTRAINT UQ_hotel_nombre UNIQUE (nombreH);

--trabaja
ALTER TABLE trabaja
ADD CONSTRAINT FK_cedulaETra FOREIGN KEY (cedulaE)
REFERENCES empleado (cedulaE);
ALTER TABLE trabaja
ADD CONSTRAINT FK_idHotelTra FOREIGN KEY (idHotel)
REFERENCES hotel (idHotel);
ALTER TABLE trabaja
ADD CONSTRAINT PK_trabaja PRIMARY KEY (cedulae, idhotel);

--servicio
ALTER TABLE servicio
ADD CONSTRAINT pk_servicio PRIMARY KEY (idServicio);

--ofrece
ALTER TABLE ofrece
ADD CONSTRAINT FK_idHotelO FOREIGN KEY (idHotel)
REFERENCES hotel (idHotel);
ALTER TABLE ofrece
ADD CONSTRAINT FK_idServicioO FOREIGN KEY (idServicio)
REFERENCES servicio (idServicio);
ALTER TABLE ofrece
ADD CONSTRAINT PK_ofrece PRIMARY KEY (idhotel, idservicio)

--habitacion
ALTER TABLE habitacion
ADD CONSTRAINT FK_idHotelH FOREIGN KEY (idHotel)
REFERENCES hotel (idHotel);
ALTER TABLE habitacion
ADD CONSTRAINT PK_habitacion PRIMARY KEY (idHabitacion);
ALTER TABLE habitacion
ADD CONSTRAINT FK_categoriaH FOREIGN KEY (idcategoria)
REFERENCES categoria (idcategoria)

--caracteristicaS
ALTER TABLE caracteristicaS
ADD CONSTRAINT FK_idServicioCS FOREIGN KEY (idServicio)
REFERENCES servicio (idServicio);

--cliente
ALTER TABLE cliente
ADD CONSTRAINT PK_cliente PRIMARY KEY (cedulaC);
ALTER TABLE cliente
ADD CONSTRAINT CK_cedulaC CHECK (cedulaC > 0);

--telefonoC
ALTER TABLE telefonoC
ADD CONSTRAINT fk_cedulaCTC FOREIGN KEY (cedulaC)
REFERENCES cliente (cedulaC);
ALTER TABLE telefonoC
ADD CONSTRAINT PK_telefonoC PRIMARY KEY (cedulaC, telefonoC);

--correoC
ALTER TABLE correoC
ADD CONSTRAINT FK_cedulaCC FOREIGN KEY (cedulaC)
REFERENCES cliente(cedulaC);
ALTER TABLE correoC
ADD CONSTRAINT PK_correoC PRIMARY KEY (cedulaC, correoC);

--reserva
ALTER TABLE reserva
ADD CONSTRAINT FK_idHabitacionR FOREIGN KEY (idHabitacion)
REFERENCES habitacion (idHabitacion);
ALTER TABLE reserva
ADD CONSTRAINT FK_cedulaCR FOREIGN KEY (cedulaC)
REFERENCES cliente(cedulaC);
ALTER TABLE reserva
ADD CONSTRAINT PK_idReserva PRIMARY KEY (idReserva, cedulaC, fechaLlegada);

--caracteristicaH
ALTER TABLE caracteristicaH 
ADD CONSTRAINT FK_idHabitacionCH FOREIGN KEY (idHabitacion)
REFERENCES habitacion (idHabitacion);
ALTER TABLE caracteristicaH
ADD CONSTRAINT PK_caracteristicaH PRIMARY KEY (idHabitacion, caracteristicaH);

--categoria
ALTER TABLE categoria
ADD CONSTRAINT PK_categoria PRIMARY KEY (idCategoria);

--adquiere
ALTER TABLE adquiere
ADD CONSTRAINT FK_cedulaCA FOREIGN KEY (cedulaC)
REFERENCES cliente(cedulaC);
ALTER TABLE adquiere 
ADD CONSTRAINT FK_idHabitacionA FOREIGN KEY (idHabitacion)
REFERENCES habitacion (idHabitacion);
ALTER TABLE adquiere
ADD CONSTRAINT FK_idServicio FOREIGN KEY (idServicio)
REFERENCES servicio (idServicio);
ALTER TABLE adquiere 
ADD CONSTRAINT PK_adquiere PRIMARY KEY (cedulaC, idHabitacion, idServicio, fechaHora);x|