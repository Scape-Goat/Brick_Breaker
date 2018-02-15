import java.awt.*;

public class Paddle {

  final int HEIGHT = 10;
  int x, y, dx = 5, width=100;

  Board board;
  Game game;

  public Paddle(Board board, Game game){
    x = 0;
    y= 0;

    this.board = board;
    this.game = game;
  }

  public void move(){
      if(game.isaPressed() && x > 0)
          x -= dx;
      else if (game.isdPressed() && x+width<board.getWidth())
          x += dx;
  }

  public void move2nd(){
        if(game.isLeftPressed() && x > 0)
            x -= dx;
        else if (game.isRightPressed() && x+width<board.getWidth())
            x += dx;

  }
  public Rectangle getBounds(){
      return new Rectangle(x,y,width, HEIGHT);
  }

  public void setPosition(int x, int y){
    this.x = x - width/2;
    this.y = y - HEIGHT/2;
  }

  public void paint(Graphics g) {
    g.fillRect(x,y,width,HEIGHT);
  }

    public int getY() {
        return y;
    }
}

