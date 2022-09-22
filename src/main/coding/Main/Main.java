package main.coding.Main;

import main.coding.DAO.PlayListDao;
import main.coding.DAO.SongListDao;
import main.coding.Utility.DbConnection;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws SQLException, ClassNotFoundException, UnsupportedAudioFileException, LineUnavailableException, IOException {
        Scanner scanner = new Scanner(System.in);
        SongListDao songDao = new SongImpl();
        PlayListDao playListDao = new PlayListIMPL();
        AudioPlayer audioPlayer = new AudioPlayer();

        int response = 0;
        while (response == 0) {


            System.out.println();
            System.out.println("********************************************************************************************************************************************************************");
            System.out.println("***********---JUCKBOX PLAYLIST---***********");
            System.out.println("SEARCH your SONG AND PLAYLIST");
            System.out.println("\n1.GET ALL SONGS\n2.SEARCH SONG BY NAME\n3.SEARCH SONG BY ARTIST NAME\n4.SEARCH SONG BY GENRE\n5.SEARCH_PLAYLIST_BY_NAME\n6.SEARCH_PLAYLIST_BY_USER_ID\n7.INSERT SONG \n8.GET_All_SONG_OF_PLAYLIST\n0.EXIT JUCKBOX");
            int choice1 = scanner.nextInt();
            scanner.nextLine();
            switch (choice1) {
                case 1:
                    songDao.getAllSong();
                    System.out.println();
                    System.out.println("==============================================================================================================================================================");
                    System.out.println("PRESS 1 TO PLAY SONG");
                    //System.out.println("PRESS 2 SEARCH SONG BY NAME");
                    //System.out.println("PRESS 3 SEARCH SONG BY ARTIST NAME");
                    //System.out.println("PRESS 4 SEARCH SONG BY GENRE");
                    audioPlayer.audioPlaying(DbConnection.getConnection());
                    break;
                case 2:
                    System.out.println("ENTER YOUR SONG NAME");
                    String preferred_song = scanner.nextLine();
                    songDao.searchBySongName(preferred_song);
                    System.out.println();
                    System.out.println("==============================================================================================================================================================");
                    System.out.println("PRESS 1 TO PLAY SONG");
                    audioPlayer.audioPlaying(DbConnection.getConnection());
                    break;
                case 3:
                    System.out.println("ENTER ARTIST NAME");
                    String preferred_artist = scanner.nextLine();
                    songDao.searchByArtistName(preferred_artist);
                    System.out.println();
                    System.out.println("==============================================================================================================================================================");
                    System.out.println("PRESS 1 TO PLAY SONG");
                    audioPlayer.audioPlaying(DbConnection.getConnection());
                    break;
                case 4:
                    System.out.println("ENTER GENRE NAME");
                    String genre1 = scanner.nextLine();
                    songDao.searchByGenre(genre1);
                    System.out.println();
                    System.out.println("==============================================================================================================================================================");
                    System.out.println("PRESS 1 TO PLAY SONG");
                    audioPlayer.audioPlaying(DbConnection.getConnection());
                    break;

                case 5:
                    System.out.println("SEARCH PLAYLIST BY NAME");
                    String playListName1 = scanner.nextLine();
                    playListDao.searchPlayListByName(playListName1);
                    System.out.println();
                    System.out.println("==============================================================================================================================================================");
                    System.out.println("PRESS 1 TO PLAY SONG");
                    audioPlayer.audioPlaying(DbConnection.getConnection());
                    break;
                case 6:
                    System.out.println("SEARCH PLAYLIST BY ID");
                    String playListId = scanner.nextLine();
                    playListDao.searchPlayListById(8055);
                    System.out.println("==============================================================================================================================================================");
                    System.out.println("PRESS 1 TO PLAY SONG");
                    audioPlayer.audioPlaying(DbConnection.getConnection());
                    break;
                case 7:
                    System.out.println("INSERT SONG INTO PLAYLIST");
                    String addSong = scanner.nextLine();
                    playListDao.insertIntoPlaylist("Soft Piano Music_16000_mono.wav",2);
                    playListDao.showAllPlayList();
                    System.out.println("==============================================================================================================================================================");
                    System.out.println("PRESS 1 TO PLAY SONG");
                    audioPlayer.audioPlaying(DbConnection.getConnection());
                    break;
                case 9:
                    playListDao.showAllPlayList();
                    System.out.println();
                    System.out.println("==============================================================================================================================================================");
                    System.out.println("PRESS 1 TO PLAY SONG");
                    audioPlayer.audioPlaying(DbConnection.getConnection());
                    break;
                case 0:
                    System.out.println("Exiting from juckbox");
                    System.exit(0);
                    break;
                default:
                    System.out.println("invalid option");

            }


        }
    }



}
