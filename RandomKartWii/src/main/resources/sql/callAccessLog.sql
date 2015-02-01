CREATE TABLE IF NOT EXISTS randomkartwii.callAccessLog
(
id INT NOT NULL AUTO_INCREMENT,
dateAccessed CHAR(10),
callAccessed CHAR(30),
timesAccessed INT NOT NULL DEFAULT 1,
PRIMARY KEY (id)
);
