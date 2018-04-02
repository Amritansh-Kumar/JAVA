package mypackage.resources;

import javax.imageio.ImageIO;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.io.IOException;

public class Resources {

    public static Image pappu1;
    public static Image pappu2;
    public static Image pappu3;
    public static Image pappu4;
    public static Image pappu5;
    public static Image pappu6;
    public static Image pappu7;
    public static Image pappu8;
    public static Image fallingPappu;
    public static Image background;
    public static Image log;
    public static Image obstacle;
    public static Image invertedObstacle;
    public static Image forkHandle;
    public static Image branch;
    public static Image stand;
    public static Image plankTop;
    public static Image plankMiddle;
    public static Image ground;
    public static AudioClip flapAudio;
    public static AudioClip pappuPakiaAudio;

    public static void load() {

        try {
            pappu1 = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/pappu1.png"));
            pappu2 = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/pappu2.png"));
            pappu3 = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/pappu3.png"));
            pappu4 = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/pappu4.png"));
            pappu5 = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/pappu5.png"));
            pappu6 = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/pappu6.png"));
            pappu7 = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/pappu7.png"));
            pappu8 = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/pappu8.png"));
            fallingPappu = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/falling_pappu.png"));
            background = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/bg_combined.png"));
            log = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/log.png"));
            obstacle = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/obstacle.png"));
            invertedObstacle = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/inverted_obstacle.png"));
            forkHandle = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/fork_handle.png"));
            branch = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/branch.png"));
            stand = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/stand.png"));
            plankTop = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/plank_top.png"));
            plankMiddle = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/plank_mid.png"));
            ground = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/ground.png"));
            pappuPakiaAudio = Applet.newAudioClip(Resources.class.getClassLoader().getResource("mypackage/resources/audios/gametheme.wav"));
            flapAudio = Applet.newAudioClip(Resources.class.getClassLoader().getResource("mypackage/resources/audios/wingsflip.wav"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}