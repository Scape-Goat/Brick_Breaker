import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;


public class Level {
  Brick[][] level;


  Board board;

  int maxLevel =15;
final int EDGESPACE = 13;
final  int brickGap = 1;


  int numInRow = 10 ;
  int numInColumn =200;
  int brickWidth = ((600-brickGap*(numInRow-2))/numInRow);


  public Level(int levelNum,Board board) {
    this.board = board;

   // int brickHeight = ((800-brickGap*(numInColumn-1))/numInColumn);
     //brickWidth = (brickWidth-1)/numInRow;


      level = new Brick[numInColumn][numInRow];

    for(int column = 0; column<level[0].length; column++){
      for(int row = 0; row<level.length; row++){
        level[row][column] = new Brick(brickGap*(column)+(brickWidth*column),(-brickGap*(row))-(Brick.getHeight()*row), levelNum, brickWidth, Brick.getHeight(), this);
      }
    }

  }

  public int getNumInRow() {
    return numInRow;
  }

  public int getNumInColumn() {
    return numInColumn;
  }

  public void checkCollision(Ball ball){

  }

    public int getBrickGap() {
        return brickGap;
    }

    public void paint(Graphics g) {
    for(int column = 0; column<level[0].length; column++){
      for(int row = 0; row<level.length; row++){
        level[row][column].paint(g);
      }
    }
  }

  public void reset(){
    for(int column = 0; column<level[0].length; column++){
      for(int row = 0; row<level.length; row++){
        level[row][column] = new Brick(brickGap*(column)+(brickWidth*column),(-brickGap*(row))-(Brick.getHeight()*row), 1, brickWidth, Brick.getHeight(), this);
      }
    }
  }


}