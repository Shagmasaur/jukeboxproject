package main.coding.Main;

import main.coding.DAO.PlayListDao;
import main.coding.DAO.PlaylistDetailsDao;
import main.coding.DAO.SongDao;
import main.coding.Data.PlayList;
import main.coding.Data.PlaylistDetails;
import main.coding.Data.Song;
import main.coding.Utility.DbConnection;
import main.coding.Utility.PlayMusic;

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
    static SongDao songDao = new SongDao();
    static PlayListDao playlistDao = new PlayListDao();
    static PlaylistDetailsDao playlistDetailsDao = new PlaylistDetailsDao();
    static PlayMusic p = new PlayMusic();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException, ClassNotFoundException
    {
        System.out.println(" ");
        System.out.println("------------WELCOME TO MUSIC WORLD-------------");
        System.out.println(" ");

        boolean y = true;
        while (y) {

            System.out.println("Select the operation which you want to perform: ");
            System.out.println(" ");
            System.out.println("Press 1 to play the song ");
            System.out.println("Press 2 to view the playlist ");
            System.out.println("Press 3 to create a playlist ");
            System.out.println("Press 4 to delete the playlist ");
            System.out.println("Press 5 to see the all songs ");
            System.out.println("press 6 to add the songs in the playlist ");
            System.out.println("press 7 to play the song from playlist ");
            System.out.println("Press 8 for exit ");

            int choice =scanner.nextInt();

            switch (choice) {
                case 1: {

                    System.out.println("---------------------------------------------Song List---------------------------------------------");
                    System.out.println(" ");
                    List<Song> songList = songDao.getAllSongs();
                    songDao.printPlaylist(songList);
                    System.out.println(" ");
                    System.out.println("Please select the option on which basis you want to play the song");
                    System.out.println(" ");
                    System.out.println("Press 1 for play the song on the basis of artist ");
                    System.out.println("Press 2 for play the song on the basis of genre ");
                    System.out.println("Press 3 for play the song on the basis of album ");
                    System.out.println("Press 4 for play the song on the basis of song name ");

                    int userchoice = scanner.nextInt();

                    switch (userchoice) {

                        case 1: {
                            System.out.println("Enter the name of artist:");
                            scanner.nextLine();
                            String artist_name = scanner.nextLine();
                            List<Song> sortedlist = songDao.songListOnTheBasisOfArtist(artist_name);
                            songDao.printPlaylist(sortedlist);

                            System.out.println("Enter the song name which you want to play");
                            String songname = scanner.nextLine();
                            try {

                                p.PlaySong(songname);
                            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
                                throw new RuntimeException(e);
                            }

                            break;
                        }
                        case 2: {

                            System.out.println("Enter the song genre:");
                            scanner.nextLine();
                            String genre = scanner.nextLine();
                            List<Song> sortedlist = songDao.songListOnTheBasisOfGenre(genre);
                            songDao.printPlaylist(sortedlist);

                            System.out.println("Enter the song name which you want to play");
                            String songname = scanner.nextLine();

                            try {

                                p.PlaySong(songname);
                            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
                                throw new RuntimeException(e);
                            }

                            break;
                        }
                        case 3: {
                            System.out.println("Enter the album name:");
                            scanner.nextLine();
                            String album_name = scanner.nextLine();
                            List<Song> sortedlist = songDao.songListOnTheBasisOfAlbum(album_name);
                            songDao.printPlaylist(sortedlist);

                            System.out.println("Enter the song name which you want to play");
                            String songname = scanner.nextLine();
                            try {

                                p.PlaySong(songname);
                            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                                throw new RuntimeException(e);
                            }

                            break;
                        }
                        case 4:{
                            System.out.println("Enter the song name which you want to play");
                            scanner.nextLine();
                            String songname=scanner.nextLine();

                            try {
                                p.PlaySong(songname);
                            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        }
                    }
                    break;
                }
                case 2 :{

                    playlistDao.getAllPlaylist();

                    break;
                }
                case 3 : {
                    System.out.println("enter playlistid ");
                    int playlistId = scanner.nextInt();
                    System.out.println("enter playlist name ");
                    scanner.nextLine();
                    String playlistName = scanner.nextLine();
                    playlistDao.addPlaylist(new PlayList(playlistId,playlistName));
                    break;
                }
                case 4 : {
                    System.out.println("enter the name of the playlist which you want to delete ");
                    scanner.nextLine();
                    String playlistName = scanner.nextLine();
                    playlistDao.deletePlaylistByName(playlistName);
                    break;
                }
                case 5 : {
                    System.out.println("-----------------------------------------Song List------------------------------------------------");
                    List<Song> songList = new SongDao().getAllSongs();
                    songDao.printPlaylist(songList);
                    break;
                }
                case 6 : {
                    System.out.println("enter the playlistId ");
                    int playlist_id = scanner.nextInt();
                    List<Song> songList = new SongDao().getAllSongs();
                    songDao.printPlaylist(songList);
                    System.out.println("enter the songName which you want to add in the playlist ");
                    scanner.nextLine();
                    String song_name = scanner.nextLine();
                    playlistDetailsDao.addingSongsToPlayList(new PlaylistDetails(playlist_id,song_name));
                    break;
                }
                case 7 : {
                    List<PlaylistDetails>playlistDetailsList = new ArrayList<>();
                    Connection connection = DbConnection.getConnection();
                    System.out.println("enter the playlist id ");
                    int playlistId = scanner.nextInt();
                    PreparedStatement preparedStatement = connection.prepareStatement("select * from playlist_details where playlist_id = ?");
                    preparedStatement.setInt(1,playlistId);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()){
                        playlistDetailsList.add(new PlaylistDetails(resultSet.getInt(1), resultSet.getString(2)));
                    }
                    System.out.format("%-10s %-20s\n", "PlayListId", "SongName");
                    for (PlaylistDetails sortedlist : playlistDetailsList){
                        System.out.format("%-10s %-20s\n", sortedlist.getPlaylist_Id(), sortedlist.getSong_name());
                    }

                    System.out.println("Enter the song name which you want to play");
                    scanner.nextLine();
                    String songname = scanner.nextLine();
                    try {
                        p.PlaySong(songname);
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                        throw new RuntimeException(e);
                    }

                    break;
                }
                case 8 : {
                    y = false;
                }
            }
        }
    }
}
