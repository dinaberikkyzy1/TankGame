package sample;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.io.IOException;


import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Map extends Pane {
    //    Map class should be used as before to load map details from a txt file;
//    New characters:
//    S: Steel wall
//    B: Brick wall
//    W: Water
//    T: Trees
//    P: Player (as before)
//    A custom pane can be created to include a Map instance and add the graphical elements on top of it;
    private Barrier barrier;
    private Scanner scanner;
    private ArrayList <String> rows;
    private int sizeX,sizeY;
    private Rectangle object;
    private MyPlayer myPlayer;

    public Map (MyPlayer myPlayer) throws Exception{
        this.setStyle("-fx-background-color:lightgreen");
        this.myPlayer = myPlayer;
        getFile();
        loadMap();
    }

    private void loadMap() throws Exception{

        this.barrier = new Barrier(this,sizeX,sizeY);

        for (int i = 0; i < sizeY; i++) {
            String row = rows.get(i);

            for (int j = 0; j < sizeX; j++) {

                if(row.charAt(j)=='S')
                    barrier.appear(Object.Steel,j,i);

                if(row.charAt(j)=='B')
                    barrier.appear(Object.Brick,j,i);

                if(row.charAt(j)=='W')
                    barrier.appear(Object.Water,j,i);

                if(row.charAt(j)=='T')
                    barrier.appear(Object.Tree,j,i);
                if(row.charAt(j)=='P'){
                    myPlayer.addPane(this);
                    myPlayer.addTank(new Tank(this), j, i);
                    myPlayer.addBarrier(barrier);
                }
            }
        }
    }


    private void getFile()throws Exception{
        String a = "D:\\MyTank\\src\\Map.txt";
       File path = new File(a);
        try {
            this.scanner = new Scanner(path);
        } catch (Exception e) {}
        rows = new ArrayList<>();
        int i = 0;
        while (scanner.hasNextLine()){
            String row = scanner.nextLine();
            rows.add(row);
            System.out.println(rows.get(i));
            sizeX = row.length();
            sizeY = rows.size();
            i++;
        }

    }



}