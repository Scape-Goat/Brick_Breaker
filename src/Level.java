import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;



public class Level {
  Brick[][] level;
  int levelNum;


  int rank = 1;

  public Level(int levelNum,Board board) {
      level = new Brick[levelNum][1];
      this.levelNum = levelNum;
      for(int column = 0; column<level[0].length; column++){
        for(int row = 0; row<levelNum; row++){
          level[row][column] = new Brick((20*(column+1))+(100*column),(20*(row))+(20*row), levelNum);
        }
      }

    }



  public void paint(Graphics g) {
    for(int column = 0; column<level[0].length; column++){
      for(int row = 0; row<levelNum; row++){
        level[row][column].paint(g);
      }
    }
  }
}