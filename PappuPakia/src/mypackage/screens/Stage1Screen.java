package mypackage.screens;

import mypackage.Utils.RandomGenerator;
import mypackage.entities.*;
import mypackage.main.Game;
import mypackage.main.GamePanel;
import mypackage.resources.Resources;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Stage1Screen extends Screen {


    private java.util.List<Obstacles> blocks = new ArrayList<>();
    private java.util.List<Ground> ground = new ArrayList<>();
    private java.util.List<Powers> powers = new ArrayList<>();
    private PoweredPappu poweredPappu1;
    private PoweredPappu poweredPappu2;
    private java.util.List<FlyingObstacles> flyingObstacles = new ArrayList<>();
    private Pappu pappu;
    private int timer = 100;
    private boolean transparent = false;
    private TransparentPappu transparentPappu;
    private RandomGenerator randomGenerator = new RandomGenerator();
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

        // adding obstacles giving powers
        this.powers.add(new Powers(randomGenerator.getmRandomX(), 550, Resources.star, 41, 39));
        this.powers.add(new Powers(randomGenerator.getmRandomX(), 550, Resources.apple, 33, 32));

        // adding flying obstacles giving powers
        this.flyingObstacles.add(new FlyingObstacles(randomGenerator.getmRandomFlyX(), 550, Resources.angryPappu, 41, 39));
        this.flyingObstacles.add(new FlyingObstacles(randomGenerator.getmRandomFlyX(), 550, Resources.happyPappu, 33, 32));
        this.flyingObstacles.add(new FlyingObstacles(randomGenerator.getmRandomFlyX(), 550, Resources.sadPappu, 33, 32));

        this.pappu = new Pappu(54, 301);
        poweredPappu1 = new PoweredPappu(90, 101);
        poweredPappu2 = new PoweredPappu(90, 381);
        this.transparentPappu = new TransparentPappu(54, 301);
        this.log = new Log(60, 341);

        // adding ground to the frame
        this.ground.add(new Ground(0, 0));
        this.ground.add(new Ground(1000, 0));

        // adding all the entities on the frame
        this.entities.add(this.log);
        this.entities.addAll(this.blocks);
        this.entities.addAll(this.ground);
        this.entities.addAll(this.powers);
        this.entities.addAll(this.flyingObstacles);
        this.entities.add(this.poweredPappu1);
        this.entities.add(this.poweredPappu2);
        this.entities.add(this.pappu);
        this.entities.add(this.transparentPappu);

    }

    @Override
    public void update() {
        super.update();

        if (transparent) {
            System.out.println(timer);
            timer--;
        }


        if (this.pappu.y < -30 || this.pappu.y > 500) {
            goTOWelcomeScreen();
        }

        if (this.log.x < 0) {
            this.log.isVisible = false;
        }

        for (Ground grass : ground) {
            if (grass.x <= -990) {
                grass.x = 1000;
                grass.isVisible = true;
            }
        }

        for (FlyingObstacles flyingObstacle : flyingObstacles) {

            if (flyingObstacle.x < 550 && flyingObstacle.x >= 120) {
                flyingObstacle.xVel = -20;
                flyingObstacle.fly(-17, 2);
            } else if (flyingObstacle.x < 120 && flyingObstacle.x >= 0 && flyingObstacle.y < 250) {
                flyingObstacle.fly(8, 1);
            } else if (flyingObstacle.x <= 0) {
                flyingObstacle.x = randomGenerator.getmRandomFlyX();
                flyingObstacle.y = 550;
                flyingObstacle.fly(0, 0);
                flyingObstacle.isVisible = true;
            }

            if (flyingObstacle.isColliding(this.pappu) && this.pappu.isVisible) {
                flyingObstacle.isVisible = false;
                if (flyingObstacle.image == Resources.angryPappu) {
                    goTOWelcomeScreen();
                } else if (flyingObstacle.image == Resources.happyPappu) {
                    this.gPanel.score += 20;
                } else if (flyingObstacle.image == Resources.sadPappu) {
                    pappu.x -= 14;
                }

            }
        }

        for (Obstacles obstacle : blocks) {
            if (obstacle.x < 0) {
                obstacle.x = 2500;
                obstacle.isVisible = true;
            }

            if (obstacle.isColliding(this.pappu) && this.pappu.isVisible == true && obstacle.isVisible) {
                goTOWelcomeScreen();
            }

            if (poweredPappu1.isVisible && poweredPappu2.isVisible) {
                if (obstacle.isColliding(poweredPappu1) || obstacle.isColliding(poweredPappu2))
                    obstacle.isVisible = false;
            }

        }

        for (Powers power : powers) {
            if (power.x < 0) {
                power.x = randomGenerator.getmRandomX();
                power.y = randomGenerator.getmRandomY();
                power.isVisible = true;
            }

            if (power.isColliding(this.pappu) || power.isColliding(transparentPappu)) {
                if (power.image == Resources.star) {
                    transparent = true;
                    timer = 100;
                    this.pappu.isVisible = false;
                    this.transparentPappu.isVisible = true;
                } else if (power.image == Resources.apple) {
                    poweredPappu1.isVisible = true;
                    poweredPappu2.isVisible = true;
                    poweredPappu1.xVel = 15;
                    poweredPappu2.xVel = 15;
                }
            }
        }

        if (poweredPappu1.x > 1000 || poweredPappu2.x > 1000){
            poweredPappu1.x = 90;
            poweredPappu2.x = 90;
            poweredPappu1.y = 101;
            poweredPappu2.y = 381;
            poweredPappu1.isVisible = false;
            poweredPappu2.isVisible = false;
        }

        if (timer < 0) {
            transparent = false;
            timer = 100;
            this.pappu.isVisible = true;
            this.transparentPappu.isVisible = false;
        }

    }


    public void draw(Graphics g) {
        g.clearRect(0, 0, 1000, 500);
        g.drawImage(Resources.background, 0, 0, null);
        if (transparent == true) {
            g.setColor(new Color(66, 244, 167));
            g.setFont(new Font("Ravie", Font.BOLD, 20));
            g.drawString("POWER MODE: " + timer, 400, 30);
        }
        super.draw(g);
    }


    @Override
    public void onKeyPress(int keyCode) {
        super.onKeyPress(keyCode);
        if (keyCode == KeyEvent.VK_SPACE || keyCode == KeyEvent.VK_UP) {
            this.pappu.fly();
            this.transparentPappu.transfly();
        }
    }

    @Override
    public void onMousePress(int xCord, int yCord) {
        super.onMousePress(xCord, yCord);
        this.pappu.fly();
        this.transparentPappu.transfly();
    }

    private void goTOWelcomeScreen() {
        this.gPanel.gameOver = true;
        this.gPanel.gameOn = false;
        this.gPanel.displayScore = true;
        this.gPanel.finalScore = this.gPanel.score;
        this.gPanel.score = 0;
        this.gPanel.currentScreen = new WelcomeScreen(this.gPanel);
    }

}