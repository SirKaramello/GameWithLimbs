package model;

import akkgframework.model.fundamental.GraphicalObject;
import akkgframework.view.DrawTool;

import java.awt.image.BufferedImage;

public class Background extends GraphicalObject {

    private String mode;

    private BufferedImage[] images;
    private Body player;

    public Background(Body player){
        mode="fight";
        this.player=player;
        images=new BufferedImage[2];
        images[0]= createNewImage("assets/images/wip.png");
        images[1]=createNewImage("assets/images/menue.png");
    }

    @Override
    public void draw(DrawTool drawTool) {
        if(mode.equals("fight")) {
            drawTool.camera(-player.getX()/7,-player.getY()/7);
            drawTool.drawImage(images[0], -100, -450);
        }
    }

    @Override
    public void keyPressed(int key) {
        //if(key== KeyEvent.VK_ESCAPE){
         //   mode="menue";
        //}

    }
}
