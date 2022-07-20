package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import java.util.LinkedList;

public class Game1 extends Application {
    private Map map;
    private MyPlayer myPlayer;

    private Boolean move;
    private LinkedList<KeyCode> list = new LinkedList<>();


    public Game1 () throws Exception {
        this.myPlayer = new MyPlayer(list);
        this.map = new Map(myPlayer);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        pane.getChildren().add(map);
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tanks");
        primaryStage.show();
        primaryStage.setResizable(true);
        pane.requestFocus();
        pane.setOnKeyPressed(event -> {
            list.add(event.getCode());
            move = true;

        });
        pane.setOnKeyReleased(event -> {
            move = false;
            if(event.getCode() == KeyCode.SPACE)
                myPlayer.fireBullet();
        });
        AnimationTimer timer =  new AnimationTimer() {
            @Override
            public void handle(long now) {try {
                if (move) {
                    myPlayer.move();
                }
            } catch (Exception e){}}
        };
        timer.start();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }

}
