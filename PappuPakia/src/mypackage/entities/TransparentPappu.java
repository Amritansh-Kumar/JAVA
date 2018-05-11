package mypackage.entities;

import mypackage.resources.Resources;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TransparentPappu extends Entity {

    public List<Image> allTransparentImages = new ArrayList<>();
    public int transImageIndex = 0;
    private boolean collided = false;
//    public boolean pappuisFalling = true;

    public TransparentPappu(int x, int y) {
        super(x, y);

        this.width = 60;
        this.height = 60;
        this.yAcc = 1;
        this.isVisible = false;

        this.allTransparentImages.add(Resources.pappuTrans1);
        this.allTransparentImages.add(Resources.pappuTrans2);
        this.allTransparentImages.add(Resources.pappuTrans3);
        this.allTransparentImages.add(Resources.pappuTrans4);
        this.allTransparentImages.add(Resources.pappuTrans5);
        this.allTransparentImages.add(Resources.pappuTrans6);
        this.allTransparentImages.add(Resources.pappuTrans7);
        this.allTransparentImages.add(Resources.pappuTrans8);
    }



    public void update() {
        super.update();

        this.transImageIndex++;
        this.transImageIndex %= 8;
        this.image = this.allTransparentImages.get(this.transImageIndex);
    }

    public void transfly(){
        Resources.flapAudio.play();
        if(!collided) {
            this.yVel = -12;
            this.yAcc = 2;
        }
    }

}
