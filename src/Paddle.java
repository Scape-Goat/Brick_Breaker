import java.awt.*;

public class Paddle {

  final int HEIGHT = 10;
  int x, y, dx = 5, width=100;

  Board board;
  Game game;
  Ball p2Ball;

  public Paddle(Board board, Game game){
    x = 0;
    y= 0;

    this.board = board;
    this.game = game;
    this.p2Ball = p2Ball;
  }

  public void move(){
      if(game.isaPressed() && x > 0)
          x -= dx;
      else if (game.isdPressed() && x+width<board.getWidth())
          x += dx;
  }

  public void move2nd(){
        if(game.isaPressed() && x > 0)
            x -= dx;
        else if (game.isdPressed() && x+width<board.getWidth())
            x += dx;

  }
  public Rectangle getBounds(){
      return new Rectangle(x,y,width, HEIGHT);
  }

}

