create database jukebox;
use jukebox;
-- TASK 1
CREATE TABLE SONG_LIST(SONG_ID INT PRIMARY KEY auto_increment not NULL,
SONG_NAME VARCHAR(50) NOT NULL,
ARTIST_NAME VARCHAR(50),
ALBUM_NAME VARCHAR(50),
GENRE VARCHAR(50),
DURATION VARCHAR(50),
PATH_LOCATION VARCHAR (50));
INSERT INTO  SONG_LIST (SONG_NAME,ARTIST_NAME,ALBUM_NAME,GENRE,DURATION,PATH_LOCATION) VALUE ('DigitalPresentation','Song1','Audience', 'Ambience','02:47','E:\Java\jukeboxproject\src\main\resources\Song1.wav');
INSERT INTO  SONG_LIST (SONG_NAME,ARTIST_NAME,ALBUM_NAME,GENRE,DURATION,PATH_LOCATION) VALUE ('SoftPiano','Song2','Intervention', 'Classical','02:16','E:\Java\jukeboxproject\src\main\resources\Song2.wav');
INSERT INTO  SONG_LIST (SONG_NAME,ARTIST_NAME,ALBUM_NAME,GENRE,DURATION,PATH_LOCATION) VALUE ('SoftPianoMusic','Song3','Chaos', 'HipHop','02:16','E:\Java\jukeboxproject\src\main\resources\Song3.wav');
INSERT INTO  SONG_LIST (SONG_NAME,ARTIST_NAME,ALBUM_NAME,GENRE,DURATION,PATH_LOCATION) VALUE ('Wav21','Song4','Blinded', 'Relaxing','01:56','E:\Java\jukeboxproject\src\main\resources\Song4.wav');
INSERT INTO  SONG_LIST (SONG_NAME,ARTIST_NAME,ALBUM_NAME,GENRE,DURATION,PATH_LOCATION) VALUE ('Wav25','Song5','PerfectStorm', 'Techno','02:15','E:\Java\jukeboxproject\src\main\resources\Song5.wav');
INSERT INTO  SONG_LIST (SONG_NAME,ARTIST_NAME,ALBUM_NAME,GENRE,DURATION,PATH_LOCATION) VALUE ('Wav86','Song6','LongStory', 'EDM','00:05','E:\Java\jukeboxproject\src\main\resources\Song6.wav');
INSERT INTO  SONG_LIST (SONG_NAME,ARTIST_NAME,ALBUM_NAME,GENRE,DURATION,PATH_LOCATION) VALUE ('Wav24','Song7','BlankCanvas', 'RockandRoll','02:12','E:\Java\jukeboxproject\src\main\resources\Song7.wav');
Select * from SONG_LIST;
-- TASK 2
CREATE TABLE USER_DETAIL(USER_ID INT PRIMARY KEY  NOT NULL,
PASSWORD VARCHAR(20) NOT NULL,
NAME VARCHAR(20) NOT NULL,
PHONE_NO LONG NOT NULL,
EMAIL VARCHAR(30));
INSERT INTO USER_DETAIL (USER_ID,PASSWORD,NAME,PHONE_NO,EMAIL) VALUE (1234,'ABHISHEK@3','ABHISHEK SHARMA',1234567891,'RANDOM@GMAIL.COM');
CREATE TABLE PLAYLIST(PLAYLIST_ID INT PRIMARY KEY auto_increment NOT NULL,
PLAYLIST_NAME VARCHAR(20) NOT NULL,
 USER_ID INT, 
 FOREIGN KEY(USER_ID) REFERENCES USER_DETAIL(USER_ID));
INSERT INTO PLAYLIST (PLAYLIST_NAME,USER_ID) VALUES('HIPHOP',1234);
INSERT INTO PLAYLIST (PLAYLIST_NAME,USER_ID) VALUES('AMBIENCE',1234);
Select * from playlist

