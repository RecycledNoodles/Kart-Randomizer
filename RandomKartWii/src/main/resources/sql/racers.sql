CREATE TABLE IF NOT EXISTS randomkartwii.racers
(
id INT NOT NULL AUTO_INCREMENT,
name CHAR(30),
size CHAR(30),
PRIMARY KEY (id)
);

TRUNCATE TABLE randomkartwii.racers;

INSERT INTO randomkartwii.racers (name,size) VALUES
('Baby Mario','SMALL'),
('Baby Peach','SMALL'),
('Toad','SMALL'),
('Koopa Troopa','SMALL'),
('Mario','MEDIUM'),
('Luigi','MEDIUM'),
('Peach','MEDIUM'),
('Yoshi','MEDIUM'),
('Wario','LARGE'),
('Waluigi','LARGE'),
('Donkey Kong','LARGE'),
('Bowser','LARGE'),
('Baby Luigi','SMALL'),
('Baby Daisy','SMALL'),
('Toadette','SMALL'),
('Dry Bones','SMALL'),
('Daisy','MEDIUM'),
('Birdo','MEDIUM'),
('Diddy Kong','MEDIUM'),
('Bowser Jr.','MEDIUM'),
('King Boo','LARGE'),
('Rosalina','LARGE'),
('Funky Kong','LARGE'),
('Dry Bowser','LARGE');