package mypackage.entities;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Powers extends Entity {

    public Powers(int x, int y, Image image, int width, int height) {
        super(x, y);

        this.height = height;
        this.width = width;
        this.image = image;
        this.xVel = -11;
    }

    @Override
    public boolean isColliding(Entity other) {
        return super.isColliding(other);

    }
}
