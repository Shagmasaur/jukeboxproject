CREATE DATABASE IF NOT EXISTS jukeboxdb;
USE jukeboxdb;
CREATE TABLE songs(song_id int primary key, song_name varchar(30), song_artist varchar(30), song_duration varchar(30), song_album varchar(30), song_genre varchar(30), filepath varchar(30));
CREATE TABLE playlist(playlist_id int, playlist_name varchar(30));
CREATE TABLE playlist_details(playlist_id int, song_name varchar(30));
Drop table songs;
CREATE TABLE songs(song_id int primary key, song_name varchar(30), song_artist varchar(30), song_duration varchar(30), song_album varchar(30), song_genre varchar(30), filepath varchar(300));
INSERT INTO songs VALUE(100, 'DigitalPresentation', 'Song1', '02:47','Capstone', 'Ambience', 'E:\Java\jukeboxproject\src\main\resources\Song1.wav');
Select * from songs;
INSERT INTO songs VALUE(101, 'SoftPiano', 'Song2', '02:16','Capstone', 'Ambience', 'E:\Java\jukeboxproject\src\main\resources\Song2.wav');
INSERT INTO songs VALUE(102, 'SoftPianoMusic', 'Song3', '02:16','Capstone', 'Ambience', 'E:\Java\jukeboxproject\src\main\resources\Song3.wav');
INSERT INTO songs VALUE(103, 'Wav21', 'Song4', '01:56','Capstone', 'Ambience', 'E:\Java\jukeboxproject\src\main\resources\Song4.wav');
INSERT INTO songs VALUE(104, 'Wav25', 'Song5', '02:15','Capstone', 'Ambience', 'E:\Java\jukeboxproject\src\main\resources\Song5.wav');
INSERT INTO songs VALUE(105, 'Wav86', 'Song6', '00:05','Capstone', 'Ambience', 'E:\Java\jukeboxproject\src\main\resources\Song6.wav');
INSERT INTO songs VALUE(106, 'Wav24', 'Song7', '02:12','Capstone', 'Ambience', 'E:\Java\jukeboxproject\src\main\resources\Song7.wav');