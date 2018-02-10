import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;



public class Level {
  Brick[][] level;
  int levelNum;

  int maxLevel =30;
final int EDGESPACE = 13;

  public Level(int levelNum,Board board) {
      level = new Brick[30][15];
      this.levelNum = levelNum;
      for(int column = 0; column<level[0].length; column++){
        for(int row = 0; row<level.length; row++){
          level[row][column] = new Brick(EDGESPACE+(3*(column+1))+(Brick.getWidth()*column),(3*(row))+(Brick.getHeight()*row), levelNum);
        }
      }

  }

  public void checkCollision(Ball ball){
    for(int column = 0; column<level[0].length; column++){
      for(int row = 0; row<level.length; row++){
        level[row][column].checkCollision(ball);
      }
    }
  }



  public void paint(Graphics g) {
    for(int column = 0; column<level[0].length; column++){
      for(int row = 0; row<level.length; row++){
        level[row][column].paint(g);
      }
    }
  }
}