package mypackage.entities;

import mypackage.resources.Resources;

import java.awt.*;

public class FlyingObstacles extends Entity {

    private boolean collided = false;

    public FlyingObstacles(int x, int y, Image image, int width, int height) {
        super(x, y);

        this.height = height;
        this.width = width;
        this.image = image;
        this.xVel = -11;

    }

    public void fly(int yvel, int yacc){
        this.yVel = yvel;
        this.yAcc = yacc;
    }
}
