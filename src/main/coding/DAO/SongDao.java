package main.coding.DAO;

import main.coding.Data.Song;
import main.coding.Utility.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SongDao
{
    List<Song> songs = new ArrayList<>();


    public List<Song> getAllSongs() throws SQLException, ClassNotFoundException {

        List<Song> allSongsList = new ArrayList<>();
        Connection connection = DbConnection.getConnection();
        String sql = "Select * from songs; ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            allSongsList.add(new Song(resultSet.getInt(1),resultSet.getString(2),
                    resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6)));
        }
        return allSongsList;
    }

    public boolean CheckIfSongIdPresent(int id) throws SQLException, ClassNotFoundException {
        Connection con = DbConnection.getConnection();
        try {
            PreparedStatement prs = con.prepareStatement("select * from songs where song_id='" + id + "' ");
            ResultSet rs = prs.executeQuery();
            while (rs.next()) {
                int id_check = rs.getInt(1);
                if (id_check != 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public static void printPlaylist(List<Song> songList) {
        System.out.format("%-10s %-20s %-20s %-20s %-20s %-20s\n", "song_Id", "song_name", "song_album", "song_genre", "song_duration", "song_artist");
        System.out.println(" ");
        for (Song song : songList) {
            System.out.format("%-10s %-20s %-20s %-20s %-20s %-20s\n", song.getSongId(), song.getSongName(), song.getArtist(), song.getDuration(), song.getAlbum(), song.getGenre());
        }
    }

    public static List<Song>songListOnTheBasisOfGenre(String genre) throws SQLException, ClassNotFoundException {
        List<Song> sortedlist = new ArrayList<>();
        Connection connection = DbConnection.getConnection();
        String sql = "Select * from songs where song_genre = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,genre);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            sortedlist.add(new Song(resultSet.getInt(1),resultSet.getString(2),
                    resultSet.getString(3),resultSet.getString(4),resultSet.getString(5), resultSet.getString(6)));
        }
        return sortedlist;
    }
    public static List<Song>songListOnTheBasisOfArtist(String song_artist) throws SQLException, ClassNotFoundException {
        List<Song> sortedlist = new ArrayList<>();
        Connection connection = DbConnection.getConnection();
        String sql = "Select * from songs where song_artist = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,song_artist);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            sortedlist.add(new Song(resultSet.getInt(1),resultSet.getString(2),
                    resultSet.getString(3),resultSet.getString(4),resultSet.getString(5), resultSet.getString(6)));
        }
        return sortedlist;
    }
    public static List<Song>songListOnTheBasisOfAlbum(String song_album) throws SQLException, ClassNotFoundException {
        List<Song> sortedlist = new ArrayList<>();
        Connection connection = DbConnection.getConnection();
        String sql = "Select * from songs where song_album = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,song_album);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            sortedlist.add(new Song(resultSet.getInt(1),resultSet.getString(2),
                    resultSet.getString(3),resultSet.getString(4),resultSet.getString(5), resultSet.getString(6)));
        }
        return sortedlist;
    }

}
