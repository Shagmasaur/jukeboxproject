package main.coding.Data;

public class PlaylistDetails
{
    private int Playlist_Id;
    private String song_name;

    public PlaylistDetails(int playlist_Id, String song_name) {
        Playlist_Id = playlist_Id;
        this.song_name = song_name;
    }

    public int getPlaylist_Id() {
        return Playlist_Id;
    }

    public void setPlaylist_Id(int playlist_Id) {
        Playlist_Id = playlist_Id;
    }

    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    @Override
    public String toString() {
        return "PlaylistDetails{" +
                "Playlist_Id=" + Playlist_Id +
                ", song_name='" + song_name + '\'' +
                '}';
    }
}
