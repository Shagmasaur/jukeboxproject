package main.coding.Data;

public class SongLists
{
    private String SONG_NAME;
    private String ARTIST_NAME;
    private String ALBUM_NAME;
    private String GENRE;
    private String DURATION;
    private String PATH_LOCATION;

    public SongLists(String string, String resultSetString, String setString, String s, String string1) {
    }

    public SongLists(String SONG_NAME, String ARTIST_NAME, String ALBUM_NAME, String GENRE, String DURATION, String PATH_LOCATION) {
        this.SONG_NAME = SONG_NAME;
        this.ARTIST_NAME = ARTIST_NAME;
        this.ALBUM_NAME = ALBUM_NAME;
        this.GENRE = GENRE;
        this.DURATION = DURATION;
        this.PATH_LOCATION = PATH_LOCATION;
    }

    public String getSONG_NAME() {
        return SONG_NAME;
    }

    public void setSONG_NAME(String SONG_NAME) {
        this.SONG_NAME = SONG_NAME;
    }

    public String getARTIST_NAME() {
        return ARTIST_NAME;
    }

    public void setARTIST_NAME(String ARTIST_NAME) {
        this.ARTIST_NAME = ARTIST_NAME;
    }

    public String getALBUM_NAME() {
        return ALBUM_NAME;
    }

    public void setALBUM_NAME(String ALBUM_NAME) {
        this.ALBUM_NAME = ALBUM_NAME;
    }

    public String getGENRE() {
        return GENRE;
    }

    public void setGENRE(String GENRE) {
        this.GENRE = GENRE;
    }

    public String getDURATION() {
        return DURATION;
    }

    public void setDURATION(String DURATION) {
        this.DURATION = DURATION;
    }

    public String getPATH_LOCATION() {
        return PATH_LOCATION;
    }

    public void setPATH_LOCATION(String PATH_LOCATION) {
        this.PATH_LOCATION = PATH_LOCATION;
    }

    @Override
    public String toString() {
        return "SongLists{" +
                "SONG_NAME='" + SONG_NAME + '\'' +
                ", ARTIST_NAME='" + ARTIST_NAME + '\'' +
                ", ALBUM_NAME='" + ALBUM_NAME + '\'' +
                ", GENRE='" + GENRE + '\'' +
                ", DURATION='" + DURATION + '\'' +
                ", PATH_LOCATION='" + PATH_LOCATION + '\'' +
                '}';
    }
}
