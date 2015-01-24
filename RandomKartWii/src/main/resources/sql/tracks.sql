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
('Rainbow Road','Special')

('Peach Beach - GCN','Shell'),
('Yoshi Falls - DS','Shell'),
('Ghost Valley 2 - SNES','Shell'),
('Mario Raceway - N64','Shell'),

('Sherbet Land - N64','Banana'),
('Shy Guy Beach - GBA','Banana'),
('Delfino Square - DS','Banana'),
('Waluigi Stadium - GCN','Banana'),

('Desert Hills - DS','Leaf'),
('Bowser Castle 3 - GBA','Leaf'),
('DK''s Jungle Parkway - N64','Leaf'),
('Mario Circuit - GCN','Leaf'),

('Mario Circuit 3 - SNES','Lightning'),
('Peach Gardens - DS','Lightning'),
('DK Mountain - GCN','Lightning'),
('Bowser''s Castle - N64','Lightning');