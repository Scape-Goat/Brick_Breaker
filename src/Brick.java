import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Brick {
boolean paint = true;


  //region Colors
  Color red = new Color(255,0,0);
  Color orange = new Color(255,127,0);
  Color yellow = new Color(255,255,0);
  Color lime = new Color(127,255,0);
  Color green = new Color(0,255,0);
  Color teal = new Color(0,255,127);
  Color cyan = new Color(0,255,255);
  Color lightBlue = new Color(0,127,255);
  Color blue = new Color(0,0,255);
  Color[] colors = {red,orange,yellow,lime,green,teal,cyan, lightBlue,blue};
  //endregion

  int x, y, rank;
   static int width = 50;
   static int height = 20;

  public Brick(int x, int y, int rank, int width, int height){
    this.width = width;
    this.height = height;
    this.x = x;
    this.y=y;
    this.rank = rank-1;
  }

  public void decreaseRank(){
    rank-=1;
    if(rank<0)
      paint = false;

  }

  public void paint(Graphics g){
    if(paint) {
      g.setColor(colors[rank]);
      g.fillOval(x, y, width, height);
    }
  }

  public static int getWidth() {
    return width;
  }

  public static int getHeight() {
    return height;
  }

  public Rectangle getBounds(){
    return new Rectangle(x , y, width, height);
  }

  public void checkCollision(Ball ball){
      if(getBounds().intersects(ball.getBounds()))
        decreaseRank();



    }


}
