package main.coding.Data;

public class PlayList
{
    private String PLAYLIST_NAME;
    private int USER_ID;

    public PlayList(String string, String resultSetString, String rsString, String s, String string1) {
    }

    public PlayList(String PLAYLIST_NAME, int USER_ID) {
        this.PLAYLIST_NAME = PLAYLIST_NAME;
        this.USER_ID = USER_ID;
    }

    public String getPLAYLIST_NAME() {
        return PLAYLIST_NAME;
    }

    public void setPLAYLIST_NAME(String PLAYLIST_NAME) {
        this.PLAYLIST_NAME = PLAYLIST_NAME;
    }

    public int getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(int USER_ID) {
        this.USER_ID = USER_ID;
    }

    @Override
    public String toString() {
        return "PlayList{" +
                "PLAYLIST_NAME='" + PLAYLIST_NAME + '\'' +
                ", USER_ID=" + USER_ID +
                '}';
    }
}
