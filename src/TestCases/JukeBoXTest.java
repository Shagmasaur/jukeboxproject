package TestCases;

import main.coding.Data.MainOperations;
import main.coding.Data.PlayList;
import main.coding.Data.PlaySongs;
import main.coding.Data.Song;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class JukeBoXTestTest
{
    MainOperations mainOperations;
    PlaySongs playSongs;
    PlayList playList;
    Song song;

    @BeforeEach
    void setup()
    {
        mainOperations=new MainOperations();
        playSongs=new PlaySongs();
        song =new Song();
        playList=new PlayList();

    }

    @AfterEach
    void tearDown()
    {
        mainOperations=null;
        playSongs=null;
        song=null;
    }

    @Test
    void displaySongTable() throws SQLException, ClassNotFoundException {
        List<Song> songsList = mainOperations.getAllSongs();
        assertEquals(7,songsList.size());
        List<Song> songsList1 = mainOperations.getAllSongs();
        assertNotEquals(20,songsList.size());
    }
    @Test
    void searchBySongName() throws SQLException, ClassNotFoundException {
        String songName = "d";
        List<Song> songsList = mainOperations.searchBySongName(songName);
        assertEquals(2,songsList.size());
        List<Song> songsList1 = mainOperations.searchBySongName(songName);
        assertNotEquals(5,songsList.size());

    }

    @Test
    void searchByArtistName() throws SQLException, ClassNotFoundException {
        String artistName = "s";
        List<Song> songsList = mainOperations.searchByArtist(artistName);
        assertEquals(5,songsList.size());
        List<Song> songsList1 = mainOperations.searchByArtist(artistName);
        assertNotEquals(3,songsList.size());
    }

    @Test
    void searchByGenreType() throws SQLException, ClassNotFoundException {

        String genreType = "Ambience";
        List<Song> songsList = mainOperations.searchByGenre(genreType);
        assertEquals(4,songsList.size());
        List<Song> songsList1 = mainOperations.searchByGenre(genreType);
        assertNotEquals(5,songsList.size());
    }


}
