package main.coding.Data;

import main.coding.Main.JukeBoxImpl;
import main.coding.Utility.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainOperations
{
    List<Song> songList = new ArrayList<>();
    public List<Song> getAllsong() {
        List<Song> list = new ArrayList<>();
        try {
            Connection connection = DbConnection.getConnection();

            String query = "select * from songs";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Song songData = new Song();

                songData.setSongId(rs.getInt(1));
                songData.setSongName(rs.getString(2));
                songData.setArtist(rs.getString(3));
                songData.setDuration(rs.getString(4));
                songData.setAlbum(rs.getString(5));
                songData.setGenre(rs.getString(6));
                songData.setFilepath(rs.getString(7));
                list.add(songData);
            }
            for (Song songs : list) {
                System.out.format("%-10s %-18s %-15s %-18s %-18s %-15s  \n", songs.getSongId(), songs.getSongName(), songs.getDuration(), songs.getArtist(), songs.getAlbum(), songs.getGenre());

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Song> searchBySongName(String songName) throws SQLException, ClassNotFoundException {

        List<Song> newLL = new ArrayList<>();
        Connection connection = DbConnection.getConnection();
        String sql = "select * from songs where trackName like ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, songName + "%");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            newLL.add(new Song(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7)));
        }
        return newLL;
    }

    public List<Song> searchByArtist(String artistName) throws SQLException, ClassNotFoundException {

        List<Song> newLL = new ArrayList<>();
        Connection connection = DbConnection.getConnection();
        String sql = "select * from songs where artist like ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, artistName + "%");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            newLL.add(new Song(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7)));
        }
        return newLL;
    }

    public List<Song> searchByGenre(String genre) throws SQLException, ClassNotFoundException {

        List<Song> newLL = new ArrayList<>();
        Connection connection = DbConnection.getConnection();
        String sql = "select * from songs where genre like ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, genre + "%");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            newLL.add(new Song(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7)));
        }
        return newLL;
    }
    public void playSongs() throws Exception {
        Scanner scanner = new Scanner(System.in);
        PlaySongs playSong = new PlaySongs();
        Song songs = new Song();
        PlayList playList = new PlayList();

        System.out.println("PLEASE SELECT THE OPTION \n1: PLAY A SONG \n2: GO TO PLAYLIST\n3: GO BACK TO MAIN MENU");
        int choice = scanner.nextInt();

        switch (choice) {
            case (1):
                System.out.println("PLEASE ENTER THE SONG ID YOU WANT TO PLAY");
                int songID = scanner.nextInt();
                playSong.playSong(songs.returnPath(songID));
                break;
            case (2):
                System.out.println("1 FOR CREATING A NEW PLAYLIST\n2 FOR EXISTING PLAYLIST");
                int userChoice = scanner.nextInt();
                switch (userChoice) {
                    case (1):
                        playList.createAPlayList();
                    case (2):
                        List<Song> playList1 = playList.existingPlaylist();
                        System.out.format("%-10s %-30s %-30s %-30s %-30s %-30s \n", "SongID", "SongName", "Duration","Album", "Artist","GenreType");
                        System.out.println("============================================================================================");
                        for (Song songs2 : playList1) {
                            System.out.format("%-10s %-30s %-30s %-30s %-30s %-30s \n", songs.getSongId(), songs.getSongName(), songs.getDuration(),songs.getAlbum(), songs.getArtist(), songs.getGenre());
                        }
                        System.out.println("-----------------------------------------------------------------------------------------");
                        System.out.println("\t\t1: DO YOU WANT TO PLAY THE ENTIRE PLAYLIST");
                        System.out.println("\t\t2: DO YOU WANT TO PLAY A SONG FROM PLAYLIST");
                        System.out.println("\t\t3: GO BACK TO MAIN MENU");
                        int select = scanner.nextInt();
                        switch (select) {
                            case (1):
                                playSong.playSong(playList1);
                                break;
                            case (2):
                                System.out.format("%-10s %-30s %-30s %-30s %-30s %-30s \n", "SongID", "SongName", "Duration","Album", "Artist","GenreType");
                                System.out.println("============================================================================================");
                                for (Song songs2 : playList1) {
                                    System.out.format("%-10s %-30s %-30s %-30s %-30s %-30s \n", songs.getSongId(), songs.getSongName(), songs.getDuration(),songs.getAlbum(), songs.getArtist(), songs.getGenre());
                                }
                                System.out.println("PLEASE ENTER THE SONGID YOU WANT TO PLAY");
                                int song_id = scanner.nextInt();
                                playSong.playSong(songs.returnPath(song_id));

                            case (3):
                                String[] arg = new String[0];
                                JukeBoxImpl.main(arg);
                                break;
                            default:
                                System.err.println("PLEASE SELECT THE CORRECT OPTION");
                        }

                }
                break;
            case (3):
                break;
            default:
                System.err.println("PLEASE SELECT THE RIGHT OPTION");


        }
    }

}
