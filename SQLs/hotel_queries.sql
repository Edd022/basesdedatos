--INTEGRANTES
--Edward Julian Garcia Gaitan – 20212020136
--Andres Felipe Lopez Martinez - 20241020052



-- Configurar esquema
SET search_path TO hotel;

-- GESTIÓN DE CLIENTES Y RESERVAS
-- Insertar nuevo cliente
INSERT INTO cliente (cedulaC, primerNC, segundoNC, primerAC, segundoAC, calleC, carreraC, numeroC)
VALUES (?, ?, ?, ?, ?, ?, ?, ?);

-- Insertar teléfono del cliente
INSERT INTO telefonoC (cedulaC, telefonoC) VALUES (?, ?);

-- Insertar correo del cliente
INSERT INTO correoC (cedulaC, correoC) VALUES (?, ?);

-- 1.2 Actualizar información del cliente
UPDATE cliente 
SET primerNC = ?, segundoNC = ?, primerAC = ?, segundoAC = ?,
    calleC = ?, carreraC = ?, numeroC = ?
WHERE cedulaC = ?;

-- 1.3 Consultar información completa del cliente
SELECT c.cedulaC, c.primerNC, c.segundoNC, c.primerAC, c.segundoAC,
       c.calleC, c.carreraC, c.numeroC,
       STRING_AGG(DISTINCT t.telefonoC::text, ', ') as telefonos,
       STRING_AGG(DISTINCT co.correoC, ', ') as correos
FROM cliente c
LEFT JOIN telefonoC t ON c.cedulaC = t.cedulaC
LEFT JOIN correoC co ON c.cedulaC = co.cedulaC
WHERE c.cedulaC = ?
GROUP BY c.cedulaC, c.primerNC, c.segundoNC, c.primerAC, c.segundoAC,
         c.calleC, c.carreraC, c.numeroC;

-- 1.4 Crear nueva reserva
INSERT INTO reserva (idHabitacion, cedulaC, fechaLlegada, detalle)
VALUES (?, ?, ?, ?);

-- 1.5 Consultar reservas por cliente
SELECT r.idReserva, r.idHabitacion, r.fechaLlegada, r.detalle,
       h.precioNoche, ho.nombreH,
       cat.nombreCategoria
FROM reserva r
JOIN habitacion h ON r.idHabitacion = h.idHabitacion
JOIN hotel ho ON h.idHotel = ho.idHotel
LEFT JOIN categoria cat ON h.idHabitacion = cat.idHabitacion
WHERE r.cedulaC = ?
ORDER BY r.fechaLlegada DESC;

-- 2. CONSULTA DISPONIBILIDAD Y ESTADO DE HABITACIONES

-- 2.1 Consultar habitaciones disponibles
SELECT h.idHabitacion, h.idHotel, ho.nombreH, h.precioNoche,
       h.estadoDisponibilidad, cat.nombreCategoria,
       STRING_AGG(ch.caracteristicaH, ', ') as caracteristicas
FROM habitacion h
JOIN hotel ho ON h.idHotel = ho.idHotel
LEFT JOIN categoria cat ON h.idHabitacion = cat.idHabitacion
LEFT JOIN caracteristicaH ch ON h.idHabitacion = ch.idHabitacion
WHERE h.estadoDisponibilidad = true
GROUP BY h.idHabitacion, h.idHotel, ho.nombreH, h.precioNoche,
         h.estadoDisponibilidad, cat.nombreCategoria
ORDER BY h.precioNoche;

-- 2.2 Consultar habitaciones por hotel y categoría
SELECT h.idHabitacion, h.precioNoche, h.estadoDisponibilidad,
       cat.nombreCategoria,
       STRING_AGG(ch.caracteristicaH, ', ') as caracteristicas
FROM habitacion h
LEFT JOIN categoria cat ON h.idHabitacion = cat.idHabitacion
LEFT JOIN caracteristicaH ch ON h.idHabitacion = ch.idHabitacion
WHERE h.idHotel = 1001 AND (cat.nombreCategoria = ? OR ? IS NULL)
GROUP BY h.idHabitacion, h.precioNoche, h.estadoDisponibilidad, cat.nombreCategoria
ORDER BY h.precioNoche;

-- 2.3 Verificar disponibilidad para fechas específicas
SELECT h.idHabitacion, h.precioNoche, cat.nombreCategoria
FROM habitacion h
LEFT JOIN categoria cat ON h.idHabitacion = cat.idHabitacion
WHERE h.estadoDisponibilidad = true
  AND h.idHabitacion NOT IN (
    SELECT r.idHabitacion 
    FROM reserva r 
    WHERE r.fechaLlegada::date = '24-12-2024'::date
  );


-- 3. ACTUALIZAR ESTADO DE HABITACIONES

-- 3.1 Actualizar estado de disponibilidad
UPDATE habitacion 
SET estadoDisponibilidad = ?
WHERE idHabitacion = ?;

-- 3.2 Actualizar precio por noche
UPDATE habitacion 
SET precioNoche = ?
WHERE idHabitacion = ?;

-- 3.3 Consultar estado actual de habitación
SELECT h.idHabitacion, h.estadoDisponibilidad, h.precioNoche,
       ho.nombreH, cat.nombreCategoria,
       COUNT(r.idReserva) as reservas_activas
FROM habitacion h
JOIN hotel ho ON h.idHotel = ho.idHotel
LEFT JOIN categoria cat ON h.idHabitacion = cat.idHabitacion
LEFT JOIN reserva r ON h.idHabitacion = r.idHabitacion
WHERE h.idHabitacion = ?
GROUP BY h.idHabitacion, h.estadoDisponibilidad, h.precioNoche,
         ho.nombreH, cat.nombreCategoria;

-- 4. REGISTRO DE CONSUMOS ADICIONALES

-- 4.1 Registrar consumo adicional
INSERT INTO adquiere (cedulaC, idHabitacion, idServicio, fechaHora)
VALUES (?, ?, ?, ?);

-- 4.2 Consultar consumos por cliente
SELECT a.fechaHora, s.nombreServicio, s.costoS, h.idHabitacion,
       ho.nombreH, r.idReserva
FROM adquiere a
JOIN servicio s ON a.idServicio = s.idServicio
JOIN habitacion h ON a.idHabitacion = h.idHabitacion
JOIN hotel ho ON h.idHotel = ho.idHotel
LEFT JOIN reserva r ON a.idHabitacion = r.idHabitacion AND a.cedulaC = r.cedulaC
WHERE a.cedulaC = 41567890
ORDER BY a.fechaHora DESC;

-- 4.3 Calcular total de consumos por reserva
SELECT r.idReserva, SUM(s.costoS) as total_consumos,
       COUNT(a.idServicio) as cantidad_servicios
FROM reserva r
LEFT JOIN adquiere a ON r.idHabitacion = a.idHabitacion AND r.cedulaC = a.cedulaC
LEFT JOIN servicio s ON a.idServicio = s.idServicio
WHERE r.idReserva = ?
GROUP BY r.idReserva;

-- 5. GESTIÓN DE EMPLEADOS

-- 5.1 Insertar nuevo empleado
INSERT INTO empleado (cedulaE, primerNE, segundoNE, primerAE, segundoAE, 
                     calleE, carreraE, numeroE, cargo, area)
VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);

-- Insertar teléfono del empleado
INSERT INTO telefonoE (cedulaE, telefonoE) VALUES (?, ?);

-- Asignar empleado a hotel
INSERT INTO trabaja (cedulaE, idHotel) VALUES (?, ?);

-- 5.2 Actualizar información del empleado
UPDATE empleado 
SET primerNE = ?, segundoNE = ?, primerAE = ?, segundoAE = ?,
    calleE = ?, carreraE = ?, numeroE = ?, cargo = ?, area = ?
WHERE cedulaE = ?;

-- 5.3 Eliminar empleado
DELETE FROM trabaja WHERE cedulaE = ?;
DELETE FROM telefonoE WHERE cedulaE = ?;
DELETE FROM empleado WHERE cedulaE = ?;

-- 5.4 Consultar empleados por hotel
SELECT e.cedulaE, e.primerNE, e.segundoNE, e.primerAE, e.segundoAE,
       e.cargo, e.area, ho.nombreH,
       STRING_AGG(t.telefonoE::text, ', ') as telefonos
FROM empleado e
JOIN trabaja tr ON e.cedulaE = tr.cedulaE
JOIN hotel ho ON tr.idHotel = ho.idHotel
LEFT JOIN telefonoE t ON e.cedulaE = t.cedulaE
WHERE ho.idHotel = 1001
GROUP BY e.cedulaE, e.primerNE, e.segundoNE, e.primerAE, e.segundoAE,
         e.cargo, e.area, ho.nombreH
ORDER BY e.primerAE, e.primerNE;


-- 6. ADMINISTRACIÓN DE SERVICIOS

-- 6.1 Insertar nuevo servicio
INSERT INTO servicio (idServicio, nombreServicio, costoS)
VALUES (?, ?, ?);

-- Insertar características del servicio
INSERT INTO caracteristicaS (idServicio, caracteristica)
VALUES (?, ?);

-- Asignar servicio a hotel
INSERT INTO ofrece (idHotel, idServicio) VALUES (?, ?);

-- 6.2 Actualizar servicio
UPDATE servicio 
SET nombreServicio = ?, costoS = ?
WHERE idServicio = ?;

-- 6.3 Consultar servicios por hotel
SELECT s.idServicio, s.nombreServicio, s.costoS,
       STRING_AGG(cs.caracteristica, ', ') as caracteristicas
FROM servicio s
JOIN ofrece o ON s.idServicio = o.idServicio
LEFT JOIN caracteristicaS cs ON s.idServicio = cs.idServicio
WHERE o.idHotel = 1001
GROUP BY s.idServicio, s.nombreServicio, s.costoS
ORDER BY s.nombreServicio;

-- 6.4 Consultar todos los servicios disponibles
SELECT s.idServicio, s.nombreServicio, s.costoS,
       STRING_AGG(DISTINCT cs.caracteristica, ', ') as caracteristicas,
       STRING_AGG(DISTINCT ho.nombreH, ', ') as hoteles
FROM servicio s
LEFT JOIN caracteristicaS cs ON s.idServicio = cs.idServicio
LEFT JOIN ofrece o ON s.idServicio = o.idServicio
LEFT JOIN hotel ho ON o.idHotel = ho.idHotel
GROUP BY s.idServicio, s.nombreServicio, s.costoS
ORDER BY s.nombreServicio;


-- 7. CONSULTAS PARA ANÁLISIS ADMINISTRATIVO

-- 7.1 Reporte de ocupación por hotel
SELECT ho.nombreH, 
       COUNT(h.idHabitacion) as total_habitaciones,
       COUNT(CASE WHEN h.estadoDisponibilidad = false THEN 1 END) as ocupadas,
       COUNT(CASE WHEN h.estadoDisponibilidad = true THEN 1 END) as disponibles,
       ROUND(
         (COUNT(CASE WHEN h.estadoDisponibilidad = false THEN 1 END) * 100.0 / 
          COUNT(h.idHabitacion)), 2
       ) as porcentaje_ocupacion
FROM hotel ho
LEFT JOIN habitacion h ON ho.idHotel = h.idHotel
GROUP BY ho.idHotel, ho.nombreH
ORDER BY porcentaje_ocupacion DESC;

-- 7.2 Ingresos por servicios adicionales
SELECT s.nombreServicio, COUNT(a.idServicio) as veces_consumido,
       SUM(s.costoS) as ingresos_totales,
       AVG(s.costoS) as promedio_por_consumo
FROM servicio s
LEFT JOIN adquiere a ON s.idServicio = a.idServicio
GROUP BY s.idServicio, s.nombreServicio
ORDER BY ingresos_totales DESC;

-- 7.3 Clientes más frecuentes
SELECT c.cedulaC, c.primerNC, c.primerAC,
       COUNT(r.idReserva) as total_reservas,
       SUM(h.precioNoche) as ingresos_habitaciones,
       COALESCE(SUM(s.costoS), 0) as ingresos_servicios,
       (SUM(h.precioNoche) + COALESCE(SUM(s.costoS), 0)) as ingresos_totales
FROM cliente c
JOIN reserva r ON c.cedulaC = r.cedulaC
JOIN habitacion h ON r.idHabitacion = h.idHabitacion
LEFT JOIN adquiere a ON c.cedulaC = a.cedulaC
LEFT JOIN servicio s ON a.idServicio = s.idServicio
GROUP BY c.cedulaC, c.primerNC, c.primerAC
ORDER BY ingresos_totales DESC
LIMIT 10;

-- 7.4 Reservas por período
SELECT DATE_TRUNC('month', r.fechaLlegada) as mes,
       COUNT(r.idReserva) as total_reservas,
       COUNT(DISTINCT r.cedulaC) as clientes_unicos,
       SUM(h.precioNoche) as ingresos_habitaciones
FROM reserva r
JOIN habitacion h ON r.idHabitacion = h.idHabitacion
WHERE r.fechaLlegada >= ? AND r.fechaLlegada <= ?
GROUP BY DATE_TRUNC('month', r.fechaLlegada)
ORDER BY mes;

-- 7.5 Empleados por área y hotel
SELECT ho.nombreH, e.area, COUNT(e.cedulaE) as total_empleados,
       STRING_AGG(DISTINCT e.cargo, ', ') as cargos
FROM empleado e
JOIN trabaja t ON e.cedulaE = t.cedulaE
JOIN hotel ho ON t.idHotel = ho.idHotel
GROUP BY ho.idHotel, ho.nombreH, e.area
ORDER BY ho.nombreH, e.area;

-- 7.6 Análisis de precios por categoría
SELECT cat.nombreCategoria,
       COUNT(h.idHabitacion) as total_habitaciones,
       MIN(h.precioNoche) as precio_minimo,
       MAX(h.precioNoche) as precio_maximo,
       AVG(h.precioNoche) as precio_promedio
FROM categoria cat
JOIN habitacion h ON cat.idHabitacion = h.idHabitacion
GROUP BY cat.nombreCategoria
ORDER BY precio_promedio DESC;