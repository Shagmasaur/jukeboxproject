package main.coding.Main;

import main.coding.DAO.PlayListDao;
import main.coding.Data.PlayList;
import main.coding.Utility.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayListIMPL implements PlayListDao
{
    Scanner scanner=new Scanner(System.in);

    @Override
    public List<PlayList> insertIntoPlaylist(String PLAYLIST_NAME, int SONG_ID ) {
        List<PlayList> playLists = new ArrayList<>();
        try {
            Connection connection = DbConnection.getConnection();
            String sql = "INSERT INTO RISHAV_PLAY_LIST(PLAYLIST_NAME,SONG_ID) VALUES(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, PLAYLIST_NAME);
            preparedStatement.setInt(2, SONG_ID);
            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                System.out.println("Playlist  Inserted Successfully");
            } else {
                System.out.println("Playlist Insertion Failed");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return playLists;
    }


    @Override
    public List<PlayList> searchPlayListByName(String playListName) {
        List<PlayList> playLists = new ArrayList<>();
        try {
            Connection connection = DbConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM RISHAV_PLAY_LIST WHERE PLAYLIST_NAME ='" + playListName + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println(" SONG_ID--------PLAYLIST_NAME");
            System.out.println(" =================================================================================================================");
            while (resultSet.next()) {
                System.out.format("%-20s%-20s", resultSet.getString(1),
                        resultSet.getString(2));
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return playLists;
    }

    @Override
    public List<PlayList> showAllPlayList() {
        List<PlayList> playLists = new ArrayList<>();
        try {
            Connection connection = DbConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM JUCKBOX.RISHAV_PLAY_LIST";
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println(" SONG_ID--------PLAYLIST_NAME");
            System.out.println(" =================================================================================================================");
            while (resultSet.next()) {
                System.out.format("%-20s%-20s", resultSet.getString(1),
                        resultSet.getString(2));
                System.out.println();
                //System.out.format(resultSet.getString(1)+"\t\t"+resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return playLists;
    }

    @Override
    public List<PlayList> searchPlayListById(int SONG_ID) {
        List<PlayList> playLists = new ArrayList<>();
        try {
            Connection connection = DbConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM RISHAV_PLAY_LIST WHERE  SONG_ID ='" + SONG_ID + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println(" SONG_ID--------PLAYLIST_NAME");
            System.out.println(" =================================================================================================================");
            while (resultSet.next()) {
                System.out.format("%-20s%-20s", resultSet.getString(1),
                        resultSet.getString(2));
                System.out.println();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return playLists;
    }




}
