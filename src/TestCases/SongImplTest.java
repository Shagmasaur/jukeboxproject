package TestCases;

import main.coding.Data.SongLists;
import main.coding.Main.SongImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SongImplTest {
    SongImpl songImpl = null;
    SongLists songLists;



    @BeforeEach
    void setUp() {
        songImpl= new SongImpl();
        songLists = new SongLists("SONG_NAME","ARTIST_NAME","GENRE","DURATION","PATH_LOCATION");

    }

    @AfterEach
    void tearDown() {
        songImpl = null;
        songLists = null;
    }

    @Test
    void searchBySongName() throws SQLException {
        List<SongLists> output = songImpl.searchBySongName("Wav_Files_24mb.wav");
        assertEquals(0,output.size());
    }

    @Test
    void searchByArtistName() {
        List<SongLists> output = songImpl.searchByArtistName("Pooja");
        assertEquals(0,output.size());
    }

    @Test
    void searchByGenre() {
        List<SongLists> output = songImpl.searchByGenre("Pop");
        assertEquals(0,output.size());

    }

    @Test
    void getAllSong() {
        List<SongLists> output =songImpl.getAllSong();
        assertEquals(0,output.size());
    }
}
