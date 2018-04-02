package mypackage.entities;

import java.awt.*;

public class Obstacles extends Entity {

    public Obstacles(int x, int y, Image image, int width, int height) {
        super(x, y);

        this.height = height;
        this.width = width;
        this.image = image;
        this.xVel = -11;
    }
}
