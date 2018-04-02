package mypackage.entities;

import mypackage.resources.Resources;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Pappu extends Entity {



    public List<Image> allImages = new ArrayList<>();
    public int imageIndex = 0;
    private boolean collided = false;
//    public boolean pappuisFalling = true;


    public Pappu(int x, int y) {
        super(x, y);

        this.width = 60;
        this.height = 60;
        this.yAcc = 1;

        this.allImages.add(Resources.pappu1);
        this.allImages.add(Resources.pappu2);
        this.allImages.add(Resources.pappu3);
        this.allImages.add(Resources.pappu4);
        this.allImages.add(Resources.pappu5);
        this.allImages.add(Resources.pappu6);
        this.allImages.add(Resources.pappu7);
        this.allImages.add(Resources.pappu8);
    }


    public void update() {
        super.update();

//        if(this.pappuisFalling) {
//            this.image = Resources.fallingPappu;
////            this.pappuisFalling = true;
//        } else {
            this.imageIndex++;
            this.imageIndex %= 8;
            this.image = this.allImages.get(this.imageIndex);
//        }
    }

    public void fly(){
        Resources.flapAudio.play();
        if(!collided) {
            this.yVel = -12;
            this.yAcc = 2;
        }
    }

}
