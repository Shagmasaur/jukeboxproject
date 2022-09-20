package main.coding.Data;

public class PlayList
{
    private int playListId;
    private String PlayListName;

    public PlayList(int playListId, String playListName) {
        this.playListId = playListId;
        PlayListName = playListName;
    }

    public int getPlayListId() {
        return playListId;
    }

    public void setPlayListId(int playListId) {
        this.playListId = playListId;
    }

    public String getPlayListName() {
        return PlayListName;
    }

    public void setPlayListName(String playListName) {
        PlayListName = playListName;
    }

    @Override
    public String toString() {
        return "PlayList{" +
                "playListId=" + playListId +
                ", PlayListName='" + PlayListName + '\'' +
                '}';
    }
}
