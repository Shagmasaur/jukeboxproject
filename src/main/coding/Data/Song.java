package main.coding.Data;

import main.coding.Utility.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Song
{
    private int songId;
    private String songName;
    private String artist;
    private String duration;;
    private String album;
    private String genre;
    private String filepath;


    public Song(int songId, String songName, String artist, String duration, String album, String genre, String filepath) {
        this.songId = songId;
        this.songName = songName;
        this.artist = artist;
        this.duration = duration;
        this.album = album;
        this.genre = genre;
        this.filepath = filepath;
    }

    public Song()
    {

    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String returnPath(int songId) throws SQLException, ClassNotFoundException {
        String path = "";
        Connection connection = DbConnection.getConnection();
        String queryyy = "Select filepath from songs where songId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(queryyy);
        preparedStatement.setInt(1,songId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            path = resultSet.getString(1);
        }
        return path;
    }
}
