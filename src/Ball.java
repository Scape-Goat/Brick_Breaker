import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball {
    int x, y, dx=3, dy=3, diameter = 25;

    Board board;
    public Ball(Board board){
        x = 0;
        y = 0;

        this.board = board;
    }

    public void move(){
        if(x<0 || x+diameter>board.getWidth())
            dx*=-1;
        if(y<0 || y+diameter>board.getHeight())
          dy*=-1;

        x += dx;
        y+=dy;
    }

    public void setPosition(int x, int y){
      this.x = x-diameter/2;
      this.y = y-diameter/2;
    }

  public void paint(Graphics g){
    g.fillOval(x, y, diameter, diameter);
  }
  public Rectangle getBounds(){return new Rectangle(x,y,diameter,diameter);}

}
