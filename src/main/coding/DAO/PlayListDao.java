package main.coding.DAO;

import main.coding.Data.PlayList;
import main.coding.Utility.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayListDao
{
    public List<PlayList> getAllPlaylist() throws SQLException, ClassNotFoundException {
        List<PlayList> playLists = new ArrayList<>();
        Connection connection = new DbConnection().getConnection();
        Scanner scanner = new Scanner(System.in);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from playlist");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                playLists.add(new PlayList(resultSet.getInt(1), resultSet.getString(2)));
            }
            System.out.format("%-10s %-20s\n", "PlayListId", "PlayListName");
            for (PlayList sortedlist : playLists){
                System.out.format("%-10s %-20s\n", sortedlist.getPlayListId(), sortedlist.getPlayListName());
            }
        }
        catch (SQLException e){
            System.out.println("e = " + e);
        }
        return playLists;
    }

    public boolean deletePlaylistByID(int id) throws SQLException, ClassNotFoundException {
        Connection connection = new DbConnection().getConnection();
        try{
            PreparedStatement preparedStatement=connection.prepareStatement("delete from playlist where p_id=?");
            preparedStatement.setInt(1,id);
            int rows=preparedStatement.executeUpdate();
            if(rows>0){
                System.out.println("\nPlaylist removed");
                return true;
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return false;

    }

    public void deletePlaylistByName(String name) throws SQLException, ClassNotFoundException {
        Connection connection=new DbConnection().getConnection();
        try{
            PreparedStatement preparedStatement=connection.prepareStatement("delete from playlist where playlist_name=?");
            preparedStatement.setString(1,name);
            int rows=preparedStatement.executeUpdate();
            if(rows>0){
                System.out.println("Playlist removed");
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }

    public void addPlaylist(PlayList playList) throws SQLException, ClassNotFoundException {
        Connection connection=new DbConnection().getConnection();
        try{
            PreparedStatement prs=connection.prepareStatement("insert into playlist values(?,?)");
            prs.setInt(1, playList.getPlayListId());
            prs.setString(2, playList.getPlayListName());
            int rows=prs.executeUpdate();
            if(rows>0){
                System.out.println("\nPlaylist created");
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }

}
