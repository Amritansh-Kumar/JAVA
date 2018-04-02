package mypackage.entities;

import mypackage.resources.Resources;

public class Log extends Entity {

    public Log(int x, int y) {
        super(x, y);
        this.width = 71;
        this.height = 119;
        this.image = Resources.log;
        this.xVel = -11;
    }
}
