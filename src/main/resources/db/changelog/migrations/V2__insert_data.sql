--liquibase formatted sql

--changeset daye:2
INSERT INTO Estacion (EstNombre) VALUES
    ('Los Postes'),
    ('Los Jardines'), /* 2 */
    ('Pirámide del Sol'),
    ('Presbítero Maestro'), /* 4 */
    ('El Ángel'),
    ('Miguel Grau'), /* 6 */
    ('Gamarra'),
    ('La Cultura'), /* 8 */
    ('San Borja Sur'),
    ('Angamos'), /* 10 */
    ('Ayacucho'),
    ('Jorge Chávez'), /* 12 */
    ('Atocongo'),
    ('María Auxiliadora'); /* 14 */

INSERT INTO TipoLugar (TLugarNombre) VALUES
    ('Abierto'),
    ('Cerrado');

INSERT INTO Actividad (ActNombre) VALUES
    ('Caminata'),
    ('Senderismo'),
    ('Escalar'), /* 3 */
    ('Turismo de aventura'),
    ('Turismo Cultural'),
    ('Surfear'), /* 6 */
    ('Cata de vinos'),
    ('Turismo Recreativo'); /* 8 */

INSERT INTO Usuario (UserDni, UserNombre, UserApPaterno, UserApMaterno, UserUsername, UserPassword, UserActivo) VALUES
    ('71994256',
     'Hamid Farid',
     'Rivera',
     'Gonzales',
     'admin',
     '$2a$10$0KI/OFNKFtYxNWKAUbte2Oh3AwOhB7B3gJS.BqdMv/GqnR4si5vtS',
     1);

INSERT INTO ZonaTuristica (ZonaNombre, ZonaTiempoLlegada, ZonaTiempoRecorrido, ZonaActivo, ZonaEstacion, ZonaActividad, ZonaTipoLugar, ZonaCreadoPor) VALUES
    ('Club zonal Huiracocha', 10, 60, 1, 2, 8, 1,1),
    ('Museo Convento San Francisco y Catacumbas', 15, 40, 1, 5, 5, 2,1),
    ('Museo de Arte', 5, 40, 1, 6, 5, 2,1),
    ('Parque de la Amistad', 10, 30, 1,  11, 1, 1,1),
    ('Parque ecológico Voces por el Clima', 10, 25, 1, 12, 1, 1,1),
    ('Lomas del Paraíso', 15, 40, 1, 5, 4, 1,1),
    ('Circuito mágico del agua', 15, 20, 1, 6, 8, 1,1),
    ('Parque de las Leyendas', 20, 90, 1, 6, 8, 1,1),
    ('Las Lomas de Asia', 40, 40, 1, 14, 2, 1,1),
    ('Bosque El Olivar', 20, 30, 1, 9, 1, 1,1),
    ('Larcomar', 20, 30, 1, 10, 1, 1,1),
    ('Restaurante Amoramar', 25, 20, 1, 11, 7, 1,1),
    ('Las Viñas', 25, 20, 1, 10, 3, 2,1),
    ('Playa La Herradura', 15, 40, 1, 12, 6, 1,1),
    ('PLaya La Pampilla', 30, 40, 1, 1, 6, 1,1),
    ('Parque ecológico de La Molina', 20, 40, 1, 1, 2, 1,1),
    ('PLaya Makaha', 10, 40, 1, 10, 6, 1,1),
    ('Museo Naval del Perú', 30, 30, 1, 1, 5, 2,1),
    ('El Callao Monumental', 20, 40, 1, 11, 5, 2,1),
    ('La Granja Villa', 30, 60, 1, 14, 8, 1,1);