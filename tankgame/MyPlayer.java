package sample;

import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;


import java.util.LinkedList;
public class MyPlayer {
    private LinkedList<KeyCode> list;
    KeyCode keyCode;
    private Pane pane;
    private Tank tank;
    private int x;
    private int y;
    private Barrier barrier;
    private Bullet bullet;
    private Direction direction;

    public MyPlayer(LinkedList<KeyCode> list) {
        this.list = list;
    }

    public void addPane(Pane pane) {
        this.pane = pane;
    }

    public void addBarrier(Barrier barrier) {
        this.barrier = barrier;
    }

    public void addTank(Tank tank, int x, int y) {
        this.x = x;
        this.y = y;
        this.tank = tank;

        pane.getChildren().add(tank.appear(this.x, this.y));
    }

    public void fireBullet() {
        this.bullet = new Bullet(direction,barrier);
        tank.fire(bullet);
    }

    public void move() {
        int i = 2;
        while (i-- > 0) {
            if (list.getLast() == KeyCode.UP) {
                tank.move(Direction.UP, x, y);
                if (barrier.checkTankfaced(x, y, tank.getWidth(), tank.getHeight())) {
                    tank.move(Direction.UP, x, y++);
                    break;
                }
                tank.move(Direction.UP, x, y--);

            }
            if (list.getLast() == KeyCode.DOWN) {
                tank.move(Direction.DOWN, x, y);
                if (barrier.checkTankfaced(x, y, tank.getWidth(), tank.getHeight())) {
                    tank.move(Direction.DOWN, x, y--);
                    break;
                }

                tank.move(Direction.DOWN, x, y++);
            }
            if (list.getLast() == KeyCode.LEFT) {
                tank.move(Direction.LEFT, x, y);
                if (barrier.checkTankfaced(x, y, tank.getWidth(), tank.getHeight())) {
                    tank.move(Direction.LEFT, x++, y);
                    break;
                }
                tank.move(Direction.LEFT, x--, y);
            }

            if (list.getLast() == KeyCode.RIGHT) {
                tank.move(Direction.RIGHT, x, y);
                if (barrier.checkTankfaced(x, y, tank.getWidth(), tank.getHeight())) {
                    tank.move(Direction.UP, x--, y);
                    break;
                }
                tank.move(Direction.RIGHT, x++, y);

            }
        }
    }

}
