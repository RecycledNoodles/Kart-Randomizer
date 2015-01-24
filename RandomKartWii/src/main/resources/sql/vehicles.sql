CREATE TABLE IF NOT EXISTS randomkartwii.vehicles
(
id INT NOT NULL AUTO_INCREMENT,
name CHAR(30),
vehicleType CHAR(30),
size CHAR(30),
PRIMARY KEY (id)
);


TRUNCATE TABLE randomkartwii.vehicles;

INSERT INTO randomkartwii.vehicles (name,vehicleType,size) VALUES 
('Standard Kart S','KART','SMALL'),
('Booster Seat','KART','SMALL'),
('Mini Beast','KART','SMALL'),
('Cheep Charger','KART','SMALL'),
('Tiny Titan','KART','SMALL'),
('Blue Falcon','KART','SMALL'),

('Standard Bike S','BIKE','SMALL'),
('Bullet Bike','BIKE','SMALL'),
('Bit Bike','BIKE','SMALL'),
('Quacker','BIKE','SMALL'),
('Magikruiser','BIKE','SMALL'),
('Jet Bubble','BIKE','SMALL'),

('Standard Kart M','KART','MEDIUM'),
('Classic Dragster','KART','MEDIUM'),
('Wild Wing','KART','MEDIUM'),
('Super Blooper','KART','MEDIUM'),
('Daytripper','KART','MEDIUM'),
('Sprinter','KART','MEDIUM'),

('Standard Bike M','BIKE','MEDIUM'),
('Mach Bike','BIKE','MEDIUM'),

('Standard Kart L','KART','LARGE'),

('Standard Bike L','BIKE','LARGE');
