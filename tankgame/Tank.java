package sample;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;


import java.io.File;

public class Tank {
    //    Extends the MyPlayer class;
//    Adds all the necessary graphical elements to make it appear like a tank;
//    Can fire a Bullet (see below) at a certain speed and frequency (on pressing space bar);
//    Has a limited number of lives (to be used later in Project-3);
    private Pane pane;
    private int x;
    private int y;
    private int width=50,height=50;
    private Image image = new Image(new File("src/Images/tanks.png").toURI().toString());
    private  int startX;
    private  int startY;
    private Rectangle tank = new Rectangle(width,height);
    private Bullet bullet;
    private Direction direction;
    public Tank (Pane pane){
        this.pane = pane;

    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

    public void move(Direction direction,int x,int y){
        this.x=x;
        this.y=y;
        this.direction = direction;

        if(direction==Direction.UP)

            tank.setRotate(0);

        if(direction==Direction.DOWN)

            tank.setRotate(180);

        if(direction==Direction.LEFT)

            tank.setRotate(270);

        if(direction==Direction.RIGHT)

            tank.setRotate(90);

        tank.setX(x);
        tank.setY(y);
    }

    public Rectangle appear(int x, int y){

        tank.setFill(new ImagePattern(image));
        tank.setX(x*40);
        tank.setY(y*40);
        return tank;
    }


    public void fire(Bullet bullet) {
        this.bullet = bullet;

        if (direction == Direction.UP) {
            startX = x+(width/2);
            startY = y;
        }
        if(direction==Direction.DOWN){
            startX=x+(width/2);
            startY=y;
        }
        if(direction==Direction.LEFT){
            startX=x;
            startY=y+(width/2);
        }
        if(direction==Direction.RIGHT){
            startX=x;
            startY=y-(width/2);
        }
        bullet.move(startX,startY,pane);
    }


}

