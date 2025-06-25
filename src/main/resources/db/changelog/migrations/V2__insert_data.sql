--liquibase formatted sql

--changeset daye:2
INSERT INTO Estacion (EstNombre) VALUES
    ('Los Postes'),
    ('Los Jardines'),
    ('Pirámide del Sol'),
    ('Presbítero Maestro'),
    ('El Ángel'),
    ('Miguel Grau'),
    ('Gamarra'),
    ('La Cultura'),
    ('San Borja Sur'),
    ('Angamos'),
    ('Ayacucho'),
    ('Jorge Chávez'),
    ('Atocongo'),
    ('María Auxiliadora');

INSERT INTO TipoLugar (TLugarNombre) VALUES
    ('Abierto'),
    ('Cerrado');

INSERT INTO Actividad (ActNombre) VALUES
    ('Caminata'),
    ('Senderismo'),
    ('Escalar'),
    ('Nadar'),
    ('Turismo Cultural'),
    ('Surfear'),
    ('Volar'),
    ('Cata de vinos');

INSERT INTO Usuario (UserDni, UserNombre, UserApPaterno, UserApMaterno, UserUsername, UserPassword, UserActivo) VALUES
    ('71994256',
     'Hamid Farid',
     'Rivera',
     'Gonzales',
     'admin',
     '$2a$10$0KI/OFNKFtYxNWKAUbte2Oh3AwOhB7B3gJS.BqdMv/GqnR4si5vtS',
     1);