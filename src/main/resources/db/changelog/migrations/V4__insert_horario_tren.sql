--liquibase formatted sql

--changeset felipe:2


INSERT INTO horariotren (HorTrenId, HorTrenHora, HorTrenUbi, HorTrenEstado, HorTrenDireccion) VALUES (1, '14:00:00', 1, 2, 1)
                                                                                                   ,(2, '14:00:05', 1, 1, 1)
                                                                                                   ,(3, '14:00:10', 1, 1, 1);

