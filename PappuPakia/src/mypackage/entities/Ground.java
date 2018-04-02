package mypackage.entities;

import mypackage.resources.Resources;

public class Ground extends Entity {

    public Ground(int x, int y) {
        super(x, y);
        this.width = 1000;
        this.height = 500;
        this.image = Resources.ground;
        this.xVel = -11;
    }
}
