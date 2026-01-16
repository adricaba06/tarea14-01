-- Pacientes
INSERT INTO paciente (id, nombre, email, fecha_nacimiento) VALUES (1, 'Ana Pérez', 'ana.perez@email.com', '1990-05-12');
INSERT INTO paciente (id, nombre, email, fecha_nacimiento) VALUES (2, 'Luis Gómez', 'luis.gomez@email.com', '1985-11-03');
INSERT INTO paciente (id, nombre, email, fecha_nacimiento) VALUES (3, 'María López', 'maria.lopez@email.com', '2000-01-25');

-- Profesionales
INSERT INTO profesional (id, nombre, especialidad) VALUES (1, 'Dr. Juan Martínez', 'Medicina General');
INSERT INTO profesional (id, nombre, especialidad) VALUES (2, 'Dra. Carla Fernández', 'Pediatría');
INSERT INTO profesional (id, nombre, especialidad) VALUES (3, 'Dr. Pablo Sánchez', 'Cardiología');

-- Consultas
INSERT INTO consulta (id, observaciones, diagnostico, fecha) VALUES (1, 'Paciente con dolor de cabeza', 'Migraña', '2026-01-15');
INSERT INTO consulta (id, observaciones, diagnostico, fecha) VALUES (2, 'Chequeo rutinario', 'Todo normal', '2026-01-14');
INSERT INTO consulta (id, observaciones, diagnostico, fecha) VALUES (3, 'Dolor en el pecho', 'Estrés', '2026-01-16');

-- Citas
INSERT INTO cita (id, fecha_hora, estado, paciente_id, profesional_id, consulta_id) VALUES (1, '2026-01-15T10:00:00', 'ATENDIDA', 1, 1, 1);
INSERT INTO cita (id, fecha_hora, estado, paciente_id, profesional_id, consulta_id) VALUES (2, '2026-01-14T09:30:00', 'ATENDIDA', 2, 2, 2);
INSERT INTO cita (id, fecha_hora, estado, paciente_id, profesional_id, consulta_id) VALUES (3, '2026-01-16T11:00:00', 'ATENDIDA', 3, 3, 3);
INSERT INTO cita (id, fecha_hora, estado, paciente_id, profesional_id, consulta_id) VALUES (4, '2026-01-17T14:00:00', 'PROGRAMADA', 1, 2, NULL);
INSERT INTO cita (id, fecha_hora, estado, paciente_id, profesional_id, consulta_id) VALUES (5, '2026-01-18T08:30:00', 'PROGRAMADA', 2, 1, NULL);
