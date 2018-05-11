package mypackage.screens;

import mypackage.entities.Pappu;
import mypackage.main.Game;
import mypackage.main.GamePanel;
import mypackage.resources.Resources;

import java.awt.*;
import java.awt.event.KeyEvent;

public class WelcomeScreen extends Screen {


    public WelcomeScreen(GamePanel panel) {
        super(panel);
//        Resources.pappuPakiaAudio.loop();
    }

    private Pappu mPappu = new Pappu(54, 301);

    public void update() {

//        Resources.pappuPakiaAudio.play();
    }

    public void draw(Graphics g) {
       g.clearRect(0, 0, 1000, 500);
       g.drawImage(Resources.background, 0, 0, null);
       g.drawImage(Resources.log, 60, 341, null);
       g.drawImage(Resources.ground, 0, 0, null);
       g.drawImage(Resources.stand, 741, 205, null);
       g.drawImage(Resources.plankTop, 664, 240, null);
       g.drawImage(Resources.plankMiddle, 664, 340, null);

        // displaying the current score
        g.setColor(Color.black);
        g.setFont(new Font("Ravie", Font.BOLD, 50));
        g.drawString(this.gPanel.score+"", 20, 50);


        // displaying the final score
        if (this.gPanel.displayScore){
            g.setColor(Color.black);
            g.setFont(new Font("Ravie", Font.BOLD, 50));
            g.drawString("Your Score: "+this.gPanel.finalScore, 235, 180);
        }

        // displaying the starting screen
       g.setColor(new Color(91, 31, 51));
       g.setFont(new Font("Ravie", Font.BOLD, 70));
       g.drawString("PAPPU PAKIA", 180, 100);

        g.setColor(new Color(76, 67, 71));
       g.setFont(new Font("Ravie", Font.BOLD, 20));
       g.drawString("settings", 730, 375);


       if (this.gPanel.gameOver) {
//           this.gPanel.gameOn = false;
           g.setFont(new Font("Ravie", Font.BOLD, 20));
           g.drawString("restart", 715, 280);
       }else {
//           this.gPanel.gameOn = false;
            g.setFont(new Font("Ravie", Font.BOLD, 20));
            g.drawString("start", 720, 280);
        }



       // code for flickering of pappu
        g.drawImage(mPappu.allImages.get(mPappu.imageIndex), 54, 301, null);
        mPappu.imageIndex++;
        mPappu.imageIndex %= 8;


    }


    // starting the game or going to the settings screen
    @Override
    public void onMousePress(int xCord, int yCord) {
        Rectangle startRect = new Rectangle(664, 240, 213, 70);
        Rectangle settingsRect = new Rectangle(664, 340, 213, 70);

        // optimize this code
        if (startRect.contains(xCord, yCord)){
            this.gPanel.gameOn = true;
            this.gPanel.score = 0;
            this.gPanel.displayScore = false;
            this.gPanel.currentScreen = new Stage1Screen(this.gPanel);
        }
        if (settingsRect.contains(xCord, yCord)){
            this.gPanel.gameOn = true;
            this.gPanel.score = 0;
            this.gPanel.displayScore = false;
            this.gPanel.currentScreen = new SettingsScreen(this.gPanel);
        }

    }

    // starting the game
    @Override
    public void onKeyPress(int keyCode) {
        super.onKeyPress(keyCode);
        if (keyCode == KeyEvent.VK_ENTER){
            this.gPanel.gameOn = true;
            this.gPanel.score = 0;
            this.gPanel.displayScore = false;
            this.gPanel.currentScreen = new Stage1Screen(this.gPanel);
        }
    }
}