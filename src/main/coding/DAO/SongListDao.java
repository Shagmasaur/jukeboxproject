package main.coding.DAO;

import main.coding.Data.SongLists;

import java.sql.SQLException;
import java.util.List;

public interface SongListDao
{
    List<SongLists> searchBySongName(String songName) throws SQLException;
    List<SongLists> searchByArtistName(String artistName);
    List<SongLists> searchByGenre (String genre);
    List<SongLists> getAllSong ();
}
