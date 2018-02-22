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
      if(game.isLeft() && x > 0)
          x -= dx;
      if (game.isRight() && x+width<board.getWidth())
          x += dx;
  }

  public void sizeGrow(){
    width = 150;
  }
  public void sizeShrink(){
    width = 50;
  }
  public void sizeReset(){ width = 100; }

  public String getSizeStatus(){
    switch(width){
      case 50: return "Short";
      case 100: return  "Normal";
      case 150: return "Long";
      default: return "It broke";
    }
  }

  public void speedUp(){ dx = 6; }
  public void slowDown(){ dx = 4; }
  public void speedReset(){ dx=5; }

  public String getSpeedStatus(){
    switch(dx){
      case 4: return "Slow";
      case 5: return  "Normal";
      case 6: return "Fast";
      default: return "It broke";
    }
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

