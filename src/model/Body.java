package model;

import akkgframework.control.fundamental.UIController;
import akkgframework.model.fundamental.GraphicalObject;
import akkgframework.model.fundamental.Tileset;
import akkgframework.view.DrawTool;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Body extends GraphicalObject {

    private double speed , time,mode;
    private int[] stats  ;

    private Limb[] legs ,arms;
    private Tileset body , fight;
    private UIController uic;
    private BufferedImage[] bars;

    public Body(UIController uiController){
        uic=uiController;
        stats=new int[3];
        stats[2]=300;
        width=20;height=width*2;
        body=new Tileset("assets/images/runningb.png",256,360);
        fight=new Tileset("assets/images/fighting.png",256,360);
        bars=new BufferedImage[2];
        bars[0]=createNewImage("assets/images/layout/hpbar.png");
        bars[1]=createNewImage("assets/images/layout/stbar.png");
        for(int i=0;i<stats.length-1;i++){
            stats[i]=bars[i].getWidth();
        }
        mode=5;
    }

    @Override
    public void draw(DrawTool drawTool) {
        for(int i=0;i<bars[0].getWidth();i+=32){
            drawTool.setCurrentColor(0,70,100,255);
            drawTool.drawFilledRectangle(10+i,10,32,32);
        }
        for(int i=0;i<bars[1].getWidth();i+=32){
            drawTool.setCurrentColor(0,125,100,255);
            drawTool.drawFilledRectangle(10+i,52,32,32);
        }
        drawTool.drawImage(bars[0],10,10);
        drawTool.drawImage(bars[1],10,52);
        if(mode==0) {
            drawTool.drawImage(body.getTile((int) time, 0), x, y);
        }
        if(mode==1) {
            drawTool.flipImage(body.getTile((int) (time),0),x,y,-256,360);
        }
        if(mode==2) {
            drawTool.drawImage(body.getTile((int) time, 2), x, y);
        }
        if(mode==3) {
            drawTool.drawImage(body.getTile((int) time, 1), x, y);
        }
        if(mode==4) {
            drawTool.drawImage(fight.getTile((int) time, 0), x, y);
        }
        if(mode==5) {
            drawTool.drawImage(fight.getTile((int) time, 1), x, y);
        }
    }

    @Override
    public void update(double dt) {
        time+=10*dt;
        System.out.println(mode);
        if(uic.isKeyDown(KeyEvent.VK_S)){
            y+=stats[2]*dt;
            mode=3;
        }
        if(uic.isKeyDown(KeyEvent.VK_W)){
            y-=stats[2]*dt;
            mode=2;
        }
        if(uic.isKeyDown(KeyEvent.VK_A)){
            x-=stats[2]*dt;
            mode=1;
        }
        if(uic.isKeyDown(KeyEvent.VK_D)){
            x+=stats[2]*dt;
            mode=0;
        }
        if(time>=8){
            time=0;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton()==1){
            mode=4;
        }
        if(e.getButton()==3){
            mode=5;
        }
    }

    private class Limb{
        private double x,y;
        private int hp;

        private Tileset limb;

        public Limb(double x , double y , int hp){
            this.x=x;
            this.y=y;
            this.hp=hp;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }



    }

    public int getHP(){
        return stats[0];
    }

    public int getStamina(){
        return stats[1];
    }
    public int getSpeed(){
        return stats[2];
    }

    public void setHP(int hp){
        stats[0] = hp;
    }

    public void setStamina(int stamina){
        stats[1] = stamina;
    }

    public void setSpeed(int speed){
        stats[2] = speed;
    }



}
