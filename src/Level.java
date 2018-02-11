import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;


public class Level {
  Brick[][] level;
  int levelNum;

  Board board;

  int maxLevel =15;
final int EDGESPACE = 13;
final  int brickGap = 6;

  int numInRow, numInColumn;


  public Level(int levelNum,Board board) {
    this.board = board;
    System.out.println("");
    numInRow = 15 ;
    numInColumn =200;
    int brickWidth = ((600-brickGap*(numInRow-1))/numInRow);
   // int brickHeight = ((800-brickGap*(numInColumn-1))/numInColumn);
     //brickWidth = (brickWidth-1)/numInRow;


    System.out.println(numInRow);
      level = new Brick[numInColumn][numInRow];
      this.levelNum = levelNum;
      for(int column = 0; column<level[0].length; column++){
        for(int row = 0; row<level.length; row++){
          level[row][column] = new Brick( brickGap*(column)+(brickWidth*column),(-brickGap*(row))-(Brick.getHeight()*row), levelNum, brickWidth, Brick.getHeight());
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



  public void paint(Graphics g) {
    for(int column = 0; column<level[0].length; column++){
      for(int row = 0; row<level.length; row++){
        level[row][column].paint(g);
      }
    }
  }


}