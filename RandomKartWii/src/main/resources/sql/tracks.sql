CREATE TABLE IF NOT EXISTS randomkartwii.tracks
(
id INT NOT NULL AUTO_INCREMENT,
name CHAR(30),
cup CHAR(30),
PRIMARY KEY (id)
);

TRUNCATE TABLE randomkartwii.tracks;

INSERT INTO randomkartwii.tracks (name,cup) VALUES
('Luigi Circuit','Mushroom'),
('Moo Moo Meadows','Mushroom'),
('Mushroom Gorge','Mushroom'),
('Toad''s Factory','Mushroom'),

('Mario Circuit','Flower'),
('Coconut Mall','Flower'),
('DK Summit','Flower'),
('Wario''s Gold Mine','Flower'),

('Daisy Circuit','Star'),
('Koopa Cape','Star'),
('Maple Treeway','Star'),
('Grumble Volcano','Star'),

('Dry Dry Ruins','Special'),
('Moonview Highway','Special'),
('Bowser''s Castle','Special'),
('Rainbow Road','Special');