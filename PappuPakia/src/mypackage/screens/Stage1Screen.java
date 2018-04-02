package mypackage.screens;

import mypackage.entities.Ground;
import mypackage.entities.Log;
import mypackage.entities.Obstacles;
import mypackage.entities.Pappu;
import mypackage.main.Game;
import mypackage.main.GamePanel;
import mypackage.resources.Resources;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Stage1Screen extends Screen {


    private java.util.List<Obstacles> blocks = new ArrayList<>();
    private java.util.List<Ground> ground = new ArrayList<>();
    private Pappu pappu;
    private Log log;

    public Stage1Screen(GamePanel panel) {
        super(panel);

        this.blocks.add(new Obstacles(1300, -340, Resources.invertedObstacle, 31, 581));
        this.blocks.add(new Obstacles(1600, 250, Resources.obstacle, 31, 517));
        this.blocks.add(new Obstacles(1900, -272, Resources.branch, 28, 490));
        this.blocks.add(new Obstacles(1900, 405, Resources.branch, 28, 490));
        this.blocks.add(new Obstacles(2500, -450, Resources.branch, 28, 490));
        this.blocks.add(new Obstacles(2500, 220, Resources.branch, 28, 490));
        this.blocks.add(new Obstacles(2200, 250, Resources.obstacle, 31, 517));
        this.blocks.add(new Obstacles(2800, -200, Resources.branch, 28, 490));

        this.pappu = new Pappu(54, 301);
        this.log = new Log(60, 341);

        this.ground.add(new Ground(0, 0));
        this.ground.add(new Ground(1000, 0));

        this.entities.add(this.log);
        this.entities.addAll(this.blocks);
        this.entities.addAll(this.ground);
        this.entities.add(this.pappu);

    }

    @Override
    public void update() {
        super.update();

        if (this.pappu.y < -30 || this.pappu.y > 500) {
            this.gPanel.gameOver = true;
            this.gPanel.gameOn = false;
            this.gPanel.finalScore = this.gPanel.score;
            this.gPanel.score = 0;
            this.gPanel.displayScore = true;
            this.gPanel.currentScreen = new WelcomeScreen(this.gPanel);
        }

        if (this.log.x < 0){
            this.log.isVisible = false;
        }

        for (Ground grass : ground) {
            if (grass.x <= -990) {
                grass.x = 1000;
                grass.isVisible = true;
            }
        }

        for (Obstacles obstacle : blocks) {
            if (obstacle.x < 0) {
                obstacle.x = 2500;
                obstacle.isVisible = true;
            }

            if (obstacle.isColliding(this.pappu)) {
                this.gPanel.gameOver = true;
                this.gPanel.gameOn = false;
                this.gPanel.displayScore = true;
                this.gPanel.finalScore = this.gPanel.score;
                this.gPanel.score = 0;
                this.gPanel.currentScreen = new WelcomeScreen(this.gPanel);
            }
        }
    }



    public void draw(Graphics g) {
        g.clearRect(0, 0, 1000, 500);
        g.drawImage(Resources.background, 0, 0, null);
        super.draw(g);
    }



    @Override
    public void onKeyPress(int keyCode) {
        super.onKeyPress(keyCode);
        if (keyCode == KeyEvent.VK_SPACE) {
            this.pappu.fly();
        }
    }

    @Override
    public void onMousePress(int xCord, int yCord) {
        super.onMousePress(xCord, yCord);
//        this.pappu.pappuisFalling = false;
        this.pappu.fly();
    }

}