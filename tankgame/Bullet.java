package sample;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;


import java.io.File;

//    Can be fired by a Tank;
//    Moves along a straight line (horizontal/vertical);
//    Moves at a certain speed;
//    Stops when hits an obstacle;
//    Can be implemented as a JavaFX animation (for now)
public  class  Bullet{
    private Pane pane;
    private int x,y;
    private Direction direction;
    private Barrier barrier;
    private Paint paint;
    private boolean faced=false;
    private int radius=5;
    private int width,height;
    private Circle circle;
    private int speed;
    private double dx = 1, dy = 1;
    private Timeline animation;
    public Bullet(Direction direction, Barrier barrier) {
        this.direction=direction;
        this.barrier =  barrier;

    }

    public void move(int startX, int startY, Pane pane) {
        this.pane=pane;
        this.x=startX;
        this.y = startY;

        Circle circle = new Circle(this.x,this.y,radius);
        this.circle = circle;
        circle.setFill(Color.YELLOW);
        pane.getChildren().add(circle);
       /* AnimationTimer animationTimer = new AnimationTimer() {

            @Override
            public void handle(long now) {
                if(!faced){
                    update();
                }
            }
        };
          animationTimer.start();
    }


               private void update() {
               circle.setOpacity(1);
               if(direction == Direction.UP){
                   y-=speed;
               }
               if(direction==Direction.DOWN){
                   y+=speed;
               }
               if(direction==Direction.LEFT){
                   x-=speed;
               }
               if(direction==Direction.RIGHT){
                    x+=speed;
               }
               circle.setCenterX(x);
               circle.setCenterY(y);*/

        Timeline animation = new Timeline(new KeyFrame(Duration.millis(100), e -> moveBall()));
        animation.setCycleCount(5);

        animation.play();
    }

    public void play() {
        animation.play();
    }

    public void pause() {
        animation.pause();
    }

    protected void moveBall() {

        if (direction==Direction.UP) {
            circle.getTranslateY();
            circle.setTranslateY(y*width-(width/2));
        }
        if(direction==Direction.DOWN){
            circle.getTranslateY();
            circle.setTranslateY(y*width+(width/2));
        }
        if(direction==Direction.LEFT){
            circle.getTranslateY();
            circle.setTranslateY(x*width-(width/2));
        }
        if(direction==Direction.DOWN){
            circle.getTranslateY();
            circle.setTranslateY(x*width+(width/2));
        }


        x+=dx;
        y+=dy;

        circle.setCenterX(x);
        circle.setCenterY(y);







    }



}

