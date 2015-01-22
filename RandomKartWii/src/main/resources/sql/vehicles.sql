CREATE TABLE IF NOT EXISTS randomkartwii.vehicles
(
id INT NOT NULL AUTO_INCREMENT,
name CHAR(30),
vehicleType CHAR(30),
size CHAR(30),
PRIMARY KEY (id)
);


TRUNCATE TABLE randomkartwii.vehicles;

INSERT INTO randomkartwii.vehicles (name,vehicleType,size)
VALUES ('Standard Kart S','KART','SMALL');
