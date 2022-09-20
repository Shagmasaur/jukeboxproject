package main.coding.Main;


import main.coding.Data.MainOperations;
import main.coding.Data.PlaySongs;
import main.coding.Data.PlayList;
import main.coding.Data.Song;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JukeBoxImpl
{
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        Song songsObj = new Song();
        PlaySongs playSongObj = new PlaySongs();
        PlayList playListObj = new PlayList();
        MainOperations jukeBoxOperation = new MainOperations();

        System.out.println("------------------------------Welcome to Jukebox-----------------------------------------");
        System.out.println("                                      Songs Table");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.format("%-10s %-18s %-15s %-18s %-18s %-15s  \n", "Song ID", "Song Name", "Duration", "Album", "Artist", "Genre");
        System.out.println("======================================================================================================");
        jukeBoxOperation.getAllsong();



        int opt = 0;
        while (opt != 3) {
            System.out.println("============================================================================================");
            System.out.println(".....PLEASE SELECT THE OPTION .....");
            System.out.println("Enter 1 : Want to Search A Song\nEnter 2 : For creating new playlist\nEnter 3 : Go back to your existing play list\nEnter 4 : Exit");
            System.out.println("============================================================================================");
            opt = scanner.nextInt();
            try {


                switch (opt) {

                    case (1):
                        System.out.println("...............Search song based on following option.............");
                        System.out.println("Enter 1 : Display all Songs\nEnter 2 :Display song by Artist Name\nEnter 3 :Display song by Genre Type\nEnter 4 :Display song by Song Name\nEnter 5 : Go back to previous menu");
                        System.out.println("============================================================================================");
                        int option = scanner.nextInt();
                        switch (option) {

                            case (1):

                                System.out.format("%-10s %-18s %-15s %-18s %-18s %-15s \n", "SongID", "SongName", "Duration", "Album", "Artist", "GenreType");
                                jukeBoxOperation.getAllsong();
                                System.out.println("============================================================================================");

                                System.out.println("PLEASE SELECT THE OPTION \n1:To  play a song \n2: Go to your playlistt\n3: Go back to the main menu");
                                int choice = scanner.nextInt();

                                switch (choice) {
                                    case (1):
                                        System.out.println("Enter song id which you want to play");
                                        int songID = scanner.nextInt();
                                        playSongObj.playSong(songsObj.returnPath(songID));
                                        break;
                                    case (2):
                                        System.out.println("1.For Creating new playlist\n2.Go back to existing playlist");
                                        int userChoice = scanner.nextInt();
                                        switch (userChoice) {
                                            case (1):
                                                playListObj.createAPlayList();
                                            case (2):
                                                List<Song> playList = playListObj.existingPlaylist();
                                                System.out.format("%-10s %-30s %-30s %-30s %-30s %-30s \n", "SongID", "SongName", "Duration", "Album", "Artist", "GenreType");
                                                System.out.println("============================================================================================");
                                                for (Song songs : playList) {
                                                    System.out.format("%-10s %-30s %-30s %-30s %-30s %-30s \n", songs.getSongId(), songs.getSongName(), songs.getDuration(), songs.getAlbum(), songs.getArtist(), songs.getGenre());
                                                }
                                                System.out.println("============================================================================================");
                                                System.out.println("Enter 1: DO YOU WANT TO PLAY THE ENTIRE PLAYLIST\nEnter 2: DO YOU WANT TO PLAY A SONG FROM PLAYLIST\nEnter 3: GO BACK TO MAIN MENU");
                                                int select = scanner.nextInt();
                                                switch (select) {
                                                    case (1):
                                                        //want to listen entire play list
                                                        playSongObj.playSong(playList);
                                                        break;
                                                    case (2):
                                                        // want to listen a particular song
                                                        System.out.format("%-10s %-30s %-30s %-30s %-30s %-30s \n", "SongID", "SongName", "Duration", "Rating", "Artist", "GenreType");
                                                        System.out.println("============================================================================================");
                                                        for (Song songs : playList) {
                                                            System.out.format("%-10s %-30s %-30s %-30s %-30s %-30s \n", songs.getSongId(), songs.getSongName(), songs.getDuration(), songs.getAlbum(), songs.getArtist(), songs.getGenre());
                                                        }
                                                        System.out.println("Please enter the song id you want to play....");
                                                        int song_id = scanner.nextInt();
                                                        playSongObj.playSong(songsObj.returnPath(song_id));

                                                    case (3):
                                                        // go back to main menu
                                                        String[] arg = new String[0];
                                                        JukeBoxImpl.main(arg);
                                                        break;
                                                    default:
                                                        System.err.println("Not a valid option");
                                                }

                                        }
                                        break;
                                    case (3):
                                        String[] arg = new String[0];
                                        JukeBoxImpl.main(arg);
                                        break;
                                    default:
                                        System.err.println("PLEASE SELECT THE RIGHT OPTION");


                                }
                                break;

                            case (2):
                                System.out.println("PLEASE ENTER THE ARTIST NAME YOU WANT TO SEARCH");
                                scanner.nextLine();
                                String artistName = scanner.nextLine();
                                List<Song> songsListOfArtist = jukeBoxOperation.searchByArtist(artistName);
                                System.out.format("%-10s %-30s %-30s %-30s %-30s %-30s \n", "SongID", "SongName", "Duration", "Rating", "Artist", "GenreType");
                                System.out.println("-----------------------------------------------------------------------------------------");
                                for (Song songs : songsListOfArtist) {
                                    System.out.format("%-10s %-30s %-30s %-30s %-30s %-30s \n", songs.getSongId(), songs.getSongName(), songs.getDuration(), songs.getAlbum(), songs.getArtist(), songs.getGenre());
                                }
                                jukeBoxOperation.playSongs();
                                break;
                            case (3):
                                System.out.println("PLEASE ENTER THE GENRE TYPE YOU WANT TO SEARCH");
                                scanner.nextLine();
                                String genreType = scanner.nextLine();
                                List<Song> songsList1 = jukeBoxOperation.searchByGenre(genreType);
                                System.out.format("%-10s %-30s %-30s %-30s %-30s %-30s \n", "SongID", "SongName", "Duration", "Rating", "Artist", "GenreType");
                                System.out.println("-----------------------------------------------------------------------------------------");
                                for (Song songs : songsList1) {
                                    System.out.format("%-10s %-30s %-30s %-30s %-30s %-30s \n", songs.getSongId(), songs.getSongName(), songs.getDuration(), songs.getAlbum(), songs.getArtist(), songs.getGenre());
                                }
                                jukeBoxOperation.playSongs();
                                break;
                            case (4):
                                System.out.println("PLEASE ENTER THE SONG NAME YOU WANT TO SEARCH");
                                scanner.nextLine();
                                String songName = scanner.nextLine();
                                List<Song> songsListBasedOnName = jukeBoxOperation.searchBySongName(songName);
                                System.out.format("%-10s %-30s %-30s %-30s %-30s %-30s \n", "SongID", "SongName", "Duration", "Rating", "Artist", "Genre");
                                System.out.println("--------------------------------------------------------------------------------------------");
                                for (Song songs : songsListBasedOnName) {
                                    System.out.format("%-10s %-30s %-30s %-30s %-30s %-30s \n", songs.getSongId(), songs.getSongName(), songs.getDuration(), songs.getAlbum(), songs.getArtist(), songs.getGenre());
                                }
                                jukeBoxOperation.playSongs();
                                break;
                            case (5):
                                String[] arg = new String[0];
                                JukeBoxImpl.main(arg);
                                break;

                            default:
                                System.err.println("PLEASE SELECT THE RIGHT OPTION");
                                //option = scanner.nextInt();
                        }
                        break;

                    case (2):
                        playListObj.createAPlayList();
                        break;
                    case (3):
                        List<Song> playListEx = playListObj.existingPlaylist();
                        System.out.format("%-10s %-30s %-30s %-30s %-30s %-30s \n", "SongID", "SongName", "Duration", "Rating", "Artist", "Genre");
                        System.out.println("--------------------------------------------------------------------------------------------");
                        for (Song songs : playListEx) {
                            System.out.format("%-10s %-30s %-30s %-30s %-30s %-30s \n", songs.getSongId(), songs.getSongName(), songs.getDuration(), songs.getAlbum(), songs.getArtist(), songs.getGenre());
                        }
                        System.out.println("-----------------------------------------------------------------------------------------");
                        System.out.println("1: DO YOU WANT TO PLAY THE ENTIRE PLAYLIST");
                        System.out.println("2: DO YOU WANT TO PLAY A SONG FROM PLAYLIST\n3.DO YOU WANT TO ADD SONGS INTO THIS EXISTING PLAY LIST");
                        System.out.println("4: GO BACK TO MAIN MENU");
                        int select = scanner.nextInt();
                        switch (select) {
                            case (1):
                                playSongObj.playSong(playListEx);
                                JukeBoxImpl.main(args);
                                break;
                            case (2):
                                System.out.format("%-10s %-30s %-30s %-30s %-30s %-30s \n", "SongID", "SongName", "Duration", "Rating", "Artist", "Genre");
                                System.out.println("--------------------------------------------------------------------------------------------");
                                for (Song songs : playListEx) {
                                    System.out.format("%-10s %-30s %-30s %-30s %-30s %-30s \n", songs.getSongId(), songs.getSongName(), songs.getDuration(), songs.getAlbum(), songs.getArtist(), songs.getGenre());
                                }
                                System.out.println("Enter the song id you want to play");
                                int song_id = scanner.nextInt();
                                playSongObj.playSong(songsObj.returnPath(song_id));
                                break;
                            case 3:
                                playListObj.addSongsIntoPlayList();
                                break;
                            case 4:
                                JukeBoxImpl.main(args);
                                break;
                        }
                        break;

                    case (4):
                        System.exit(0);

                }
            } catch (UnsupportedAudioFileException e) {
                System.out.println("e = " + e);
            } catch (SQLException e) {
                System.out.println("e = " + e);
            } catch (LineUnavailableException e) {
                System.out.println("e = " + e);
            } catch (IOException e) {
                System.out.println("e = " + e);
            } catch (ClassNotFoundException e) {
                System.out.println("e = " + e);
            }
        }
    }
}
