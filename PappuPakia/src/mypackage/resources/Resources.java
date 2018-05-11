package mypackage.resources;

import javax.imageio.ImageIO;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.io.IOException;

public class Resources {

    public static Image pappu1, pappu2, pappu3, pappu4, pappu5, pappu6, pappu7, pappu8;
    public static Image pappuTrans1, pappuTrans2, pappuTrans3, pappuTrans4, pappuTrans5, pappuTrans6, pappuTrans7, pappuTrans8;
    public static Image fallingPappu, background, log, obstacle, invertedObstacle, forkHandle, branch, stand,
                        star, apple, plankTop, plankMiddle, ground;
    public static Image sadPappu, angryPappu, happyPappu;
    public static AudioClip flapAudio, pappuPakiaAudio, pappuPakiaGameplayAudio;

    public static void load() {

        try {
            // pappu images
            pappu1 = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/pappu1.png"));
            pappu2 = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/pappu2.png"));
            pappu3 = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/pappu3.png"));
            pappu4 = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/pappu4.png"));
            pappu5 = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/pappu5.png"));
            pappu6 = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/pappu6.png"));
            pappu7 = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/pappu7.png"));
            pappu8 = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/pappu8.png"));

            // pappu transparent images
            pappuTrans1 = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/pappu-trans1.png"));
            pappuTrans2 = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/pappu-trans2.png"));
            pappuTrans3 = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/pappu-trans3.png"));
            pappuTrans4 = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/pappu-trans4.png"));
            pappuTrans5 = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/pappu-trans5.png"));
            pappuTrans6 = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/pappu-trans6.png"));
            pappuTrans7 = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/pappu-trans7.png"));
            pappuTrans8 = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/pappu-trans8.png"));

            // flying obstacles
            angryPappu = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/angry_pakia.png"));
            sadPappu = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/sad_pakia.png"));
            happyPappu = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/happy_pakia.png"));

            // obstacles images
            fallingPappu = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/falling_pappu.png"));
            background = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/bg_combined.png"));
            log = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/log.png"));
            obstacle = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/obstacle.png"));
            invertedObstacle = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/inverted_obstacle.png"));
            forkHandle = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/fork_handle.png"));
            branch = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/branch.png"));
            star = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/star.png"));
            apple = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/apple.png"));
            stand = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/stand.png"));
            plankTop = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/plank_top.png"));
            plankMiddle = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/plank_mid.png"));
            ground = ImageIO.read(Resources.class.getClassLoader().getResourceAsStream("mypackage/resources/images/ground.png"));

            // audio files
            pappuPakiaAudio = Applet.newAudioClip(Resources.class.getClassLoader().getResource("mypackage/resources/audios/gametheme.wav"));
            pappuPakiaGameplayAudio = Applet.newAudioClip(Resources.class.getClassLoader().getResource("mypackage/resources/audios/pappu-pakia-gameplay.wav"));
            flapAudio = Applet.newAudioClip(Resources.class.getClassLoader().getResource("mypackage/resources/audios/wingsflip.wav"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}