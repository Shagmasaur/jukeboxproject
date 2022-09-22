package main.coding.Main;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AudioPlayer {
    static int repeat = 0, id = 0;
    Connection connection;
    Clip clip;


    public void audioPlaying(Connection con) throws UnsupportedAudioFileException, IOException, LineUnavailableException, SQLException, ClassNotFoundException {

        Scanner scan = new Scanner(System.in);
        if (repeat == 0) {
            System.out.println("ENTER SONG_ID TO PLAY THE SONG");
            id = scan.nextInt();
        }

        String SQL = "SELECT PATH_LOCATION FROM SONG_LIST WHERE SONG_ID=?";
        PreparedStatement preparedStatement = con.prepareStatement(SQL);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        String PATH_LOCATION = "";

        while (resultSet.next()) {
            PATH_LOCATION = resultSet.getString(1);

        }
        Scanner sc = new Scanner(System.in);
        File file = new File(PATH_LOCATION);
        Clip clip = AudioSystem.getClip();
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        clip.open(audioStream);
        clip.start();
        long duration = clip.getMicrosecondLength();
        duration = clip.getMicrosecondLength();
        long finalDuration = (duration / 1000000)*1000;
        final Timer t = new Timer(1000, new ActionListener() {
            private long time = finalDuration ;
            public void actionPerformed(ActionEvent e) {
                if (time >= 0) {
                    long s = ((time / 1000) % 60);
                    long m = (((time / 1000) / 60) % 60);
                    long h = ((((time / 1000) / 60) / 60) % 60);
                    System.out.print("\r"+h + " hours, " + m + " minutes " + s + " seconds");
                    time -= 1000;
                }
            }
        });
        t.start();

        System.out.println();
        int input;
        int flag = 0;
        long clipPos = 0;

        while (flag == 0) {
            System.out.println("\nEnter Your Choice\n=====\nPRESS 1 TO PLAY\nPRESS 2 TO PAUSE\nPRESS 3 TO RESUME\nPRESS 4 TO NEXT\nPRESS 5 TO RESTART\nPRESS 6 TO FORWARD\nPRESS 7 TO BACKWARD\nPRESS 8 TO EXIT");
            input = sc.nextInt();
            switch (input) {
                case 1:
                    clip.start();
                    System.out.println("|*Playing Song*|");
                    break;
                case 2:
                    clipPos = clip.getMicrosecondPosition();
                    clip.stop();
                    t.stop();
                    System.out.println("|*Song Paused*|");
                    break;
                case 3:
                    clip.setMicrosecondPosition(clipPos);
                    clip.start();
                    t.start();
                    System.out.println("|*Song Resumed*|");
                    break;

                case 4:
                    System.out.println("|*NEXT*|");
                    id++;
                    repeat++;
                    clip.stop();
                    t.stop();
                    audioPlaying(con);
                    break;
                case 5:
                    clip.setMicrosecondPosition(0);
                    clip.start();
                    System.out.println("|*Song Restarted*|");
                    break;
                case 6:
                    System.out.println("|*Forwarding by 70s*|");
                    clip.setMicrosecondPosition(clip.getMicrosecondPosition() + 7000000);
                    break;
                case 7:
                    System.out.println("|*Backward by 70s*|");
                    clip.setMicrosecondPosition(clip.getMicrosecondPosition() - 7000000);
                    break;

                case 8:
                    clip.stop();
                    t.stop();
                    flag = 1;

                    break;
                default:
                    System.out.println("invalid Input");
            }
        }
    }
}
