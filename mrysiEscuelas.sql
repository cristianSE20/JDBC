DROP DATABASE IF EXISTS mrysiEscuelas;
CREATE DATABASE mrysiEscuelas CHARACTER SET utf8mb4;
USE mrysiEscuelas;

CREATE TABLE Datos (
    claveEscuela varchar(50) NOT NULL,
    nombreEscuela varchar(50) NOT NULL,
    domicilio varchar(50) NOT NULL,
    turno varchar(2) NOT NULL
);


insert into Datos values("12345", "UPIICSA", "Av. Té 950, Granjas México", "M");
insert into Datos values("12346", "ESIME Zacatenco", "Unidad Profesional Adolfo López Mateos, Zacatenco", "V");
insert into Datos values("12347", "ESIME Culhuacán", "Santa Ana 1000, San Francisco Culhuacán", "M");
insert into Datos values("12348", "ESIME Azcapotzalco", "Av. de las Granjas 682, Santa Catarina", "V");
insert into Datos values("12349", "ESIA Zacatenco", "Unidad Profesional Adolfo López Mateos, Zacatenco", "M");
insert into Datos values("12350", "ESIA Tecamachalco", "Av. Fuente de los Leones 98, Tecamachalco", "V");
insert into Datos values("12351", "ESIQIE", "Unidad Profesional Adolfo López Mateos, Zacatenco", "M");
insert into Datos values("12352", "ESFM", "Unidad Profesional Adolfo López Mateos, Zacatenco", "V");
insert into Datos values("12354", "UPIITA", "Av. IPN 2580, Barrio la Laguna Ticomán", "M");

Select * from Datos