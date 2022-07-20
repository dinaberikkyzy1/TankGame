package sample;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class Barrier {
//    Various barriers that appear on the map;
//    Can be implemented as related classes via Inheritance;
//    Four types of obstacles:

    private Pane pane;
    private int max_width;
    private int max_height;
    private Paint paint;
    private ArrayList<Rectangle> trees;
    private ArrayList<Rectangle> bricks;
    private ArrayList<Rectangle> water;
    private ArrayList<Rectangle> steels;
    private int x;
    private int y;
    private Image[] images = {
            new Image(new File("src/Images/trees.png").toURI().toString()),
            new Image(new File("src/Images/brick.png").toURI().toString()),
            new Image(new File("src/Images/water.png").toURI().toString()),
            new Image(new File("src/Images/steel.png").toURI().toString())
    };


    public Barrier(Pane pane,int max_width,int max_height){
        this.pane = pane;
        this.max_width=max_width;
        this.max_height=max_height;
        this.trees=new ArrayList<>();
        this.bricks=new ArrayList<>();
        this.water=new ArrayList<>();
        this.steels=new ArrayList<>();

    }

    public void appear(Object object,int x,int y){
        Rectangle rec = new Rectangle(40,40);

        if(object==Object.Tree){
            paint=new ImagePattern(images[0]);
            trees.add(rec);
        }
        if(object==Object.Brick){
            paint=new ImagePattern(images[1]);
            bricks.add(rec);
        }
        if(object==Object.Water){
            paint=new ImagePattern(images[2]);
            water.add(rec);
        }
        if(object==Object.Steel){
            paint=new ImagePattern(images[3]);
            steels.add(rec);
        }
        rec.setFill(paint);
        rec.setX(this.x=x*40);
        rec.setY(this.y=y*40);
        pane.getChildren().add(rec);

    }

    public boolean checkTankfaced(int x,int y,int width,int height){
        boolean tankfaced = false;
        for(Rectangle object:water){
            if(new Rectangle(x,y,width,height).intersects(object.getX(),object.getY(),object.getWidth(),object.getHeight())){
                tankfaced=true;
                break;
            }
        }
        for(Rectangle object:bricks){
            if(new Rectangle(x,y,width,height).intersects(object.getX(),object.getY(),object.getWidth(),object.getHeight())){
                tankfaced=true;
                break;
            }
        }
        for(Rectangle object:steels){
            if(new Rectangle(x,y,width,height).intersects(object.getX(),object.getY(),object.getWidth(),object.getHeight())){
                tankfaced=true;
                break;
            }
        }

        return tankfaced;
    }








}