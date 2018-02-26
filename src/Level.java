import java.awt.Graphics;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class Level {
  Brick[][] level;
  Board board;
final  int brickGap = 1;
int levelNum;
  int numInRow = 10;
  int numInColumn =27;
  int brickWidth;

  public Level(int levelNum,Board board) {
    this.board = board;
this.levelNum = levelNum;


      level = new Brick[numInColumn][numInRow];
      brickWidth = (600-(2*brickGap))/numInRow;

    for(int column = 0; column<level[0].length; column++) {
      for (int row = 0; row < level.length; row++) {
        level[row][column] = new Brick(brickGap * (column) + (brickWidth * column), (-brickGap * (row)) - (Brick.getHeight() * row), levelNum, brickWidth, Brick.getHeight(), this);
      }
    }
  }

    public int getBrickGap() {
        return brickGap;
    }

    public void paint(Graphics g) {
    for(int column = 0; column<level[0].length; column++){
      for(int row = 0; row<level.length; row++) {
        level[row][column].paint(g);
      }
    }
  }

  public void reset(boolean didWin){
    if(didWin)
      levelNum+=1;
    else
      levelNum = 1;

      for (int column = 0; column < level[0].length; column++) {
        for (int row = 0; row < level.length; row++) {
          level[row][column] = new Brick(brickGap * (column) + (brickWidth * column), (-brickGap * (row)) - (Brick.getHeight() * row), levelNum, brickWidth, Brick.getHeight(), this);
        }
      }

  }



}