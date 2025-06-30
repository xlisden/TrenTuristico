--liquibase formatted sql

--changeset daye:1
CREATE TABLE Estacion
(
    EstId INT NOT NULL AUTO_INCREMENT,
    EstNombre VARCHAR(100) NOT NULL,
    PRIMARY KEY (EstId)
);

CREATE TABLE TipoLugar
(
    TLugarId INT NOT NULL AUTO_INCREMENT,
    TLugarNombre VARCHAR(30) NOT NULL,
    PRIMARY KEY (TLugarId)
);

CREATE TABLE Actividad
(
    ActId INT NOT NULL AUTO_INCREMENT,
    ActNombre VARCHAR(30) NOT NULL,
    PRIMARY KEY (ActId)
);

CREATE TABLE Usuario (
    UserId INT NOT NULL AUTO_INCREMENT,
    UserDni VARCHAR(8) NOT NULL,
    UserNombre VARCHAR(50) NOT NULL,
    UserApPaterno VARCHAR(50) NOT NULL,
    UserApMaterno VARCHAR(50) NOT NULL,
    UserUsername VARCHAR(100) NOT NULL,
    UserPassword VARCHAR(300) NOT NULL,
    UserActivo BIT NOT NULL,
    PRIMARY KEY (UserId),
    UNIQUE KEY UserDni_UNIQUE (UserDni)
);

CREATE TABLE ZonaTuristica
(
    ZonaId INT NOT NULL AUTO_INCREMENT,
    ZonaNombre VARCHAR(100) NOT NULL,
    ZonaTiempoLlegada INT NOT NULL,
    ZonaTiempoRecorrido INT NOT NULL,
    ZonaActivo BIT NOT NULL,
    ZonaEstacion INT NOT NULL,
    ZonaActividad INT NOT NULL,
    ZonaTipoLugar INT NOT NULL,
    ZonaCreadoPor INT NOT NULL,
    PRIMARY KEY (ZonaId),
    FOREIGN KEY (ZonaEstacion) REFERENCES Estacion(EstId),
    FOREIGN KEY (ZonaActividad) REFERENCES Actividad(ActId),
    FOREIGN KEY (ZonaTipoLugar) REFERENCES TipoLugar(TLugarId),
    FOREIGN KEY (ZonaCreadoPor) REFERENCES Usuario(UserId)
);

CREATE TABLE ReporteClima
(
    RepClimaId INT NOT NULL AUTO_INCREMENT,
    RepClimaFecha DATETIME NOT NULL,
    RepClimaHora INT NOT NULL,
    RepClimaTemp FLOAT NOT NULL,
    RepClimaProbabilidadLluvia INT NOT NULL,
    RepClimaIntensidadLluvia FLOAT NOT NULL,
    RepClimaEstacion INT NOT NULL,
    PRIMARY KEY (RepClimaId),
    FOREIGN KEY (RepClimaEstacion) REFERENCES Estacion(EstId)
);

CREATE TABLE HorarioTren
(
    HorTrenId INT NOT NULL AUTO_INCREMENT,
    HorTrenHora VARCHAR(10) NOT NULL,
    HorTrenUbi INT NOT NULL,
    HorTrenEstado INT NOT NULL,
    HorTrenDireccion INT NOT NULL,
    PRIMARY KEY (HorTrenId)
);
