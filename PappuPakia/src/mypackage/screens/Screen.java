package mypackage.screens;

import mypackage.entities.Entity;
import mypackage.main.GamePanel;

import java.awt.*;
import java.util.ArrayList;

abstract public class Screen {

    protected GamePanel gPanel;
    protected java.util.List<Entity> entities = new ArrayList<>();
//    protected boolean displayScore = false;

    public Screen(GamePanel p) {
        super();
        this.gPanel = p;
    }

    public void update() {
        for(Entity e: this.entities) {
            e.update();
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.setFont(new Font("Ravie", Font.BOLD, 50));
        g.drawString(this.gPanel.score+"", 20, 50);

        for(Entity e: entities) {
            if(e.isVisible) {
                g.drawImage(e.image, e.x, e.y, null);
            }
        }
    }

    public void onMousePress(int xCord, int yCord) {

    }

    public void onKeyPress(int keyCode) {

    }

}